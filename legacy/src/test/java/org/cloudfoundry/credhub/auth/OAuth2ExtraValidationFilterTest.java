package org.cloudfoundry.credhub.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import org.cloudfoundry.credhub.repository.CredentialVersionRepository;
import org.cloudfoundry.credhub.util.AuthConstants;
import org.cloudfoundry.credhub.util.DatabaseProfileResolver;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ActiveProfiles(value = "unit-test", resolver = DatabaseProfileResolver.class)
@SpringBootTest(classes = CredhubTestApp.class)
@Transactional
public class OAuth2ExtraValidationFilterTest {

  private final static String ERROR_MESSAGE = "The request token identity zone does not match the UAA server authorized by CredHub. Please validate that your request token was issued by the UAA server authorized by CredHub and retry your request.";
  @Autowired
  private WebApplicationContext webApplicationContext;
  @SpyBean
  private OAuth2IssuerService oAuth2IssuerService;
  @Autowired
  private CredentialVersionRepository credentialVersionRepository;
  private MockMvc mockMvc;

  @Before
  public void beforeEach() throws Exception {
    mockMvc = MockMvcBuilders
      .webAppContextSetup(webApplicationContext)
      .apply(springSecurity())
      .build();
    when(oAuth2IssuerService.getIssuer()).thenReturn("https://example.com:8443/uaa/oauth/token");
  }

  @Test
  public void whenGivenValidIssuer_returns200() throws Exception {
    when(oAuth2IssuerService.getIssuer()).thenReturn("https://valid-uaa:8443/uaa/oauth/token");

    this.mockMvc.perform(post("/api/v1/data")
      .header("Authorization", "Bearer " + AuthConstants.VALID_ISSUER_JWT)
      .accept(APPLICATION_JSON)
      .contentType(APPLICATION_JSON)
      .content("{  " +
        "\"name\": \"/picard\", \n" +
        "  \"type\": \"password\" \n" +
        "}"))
      .andExpect(status().isOk());
  }

  @Test
  public void whenGivenInvalidIssuer_returns401() throws Exception {
    final MockHttpServletRequestBuilder request = post("/api/v1/data?name=/picard")
      .header("Authorization", "Bearer " + AuthConstants.INVALID_ISSUER_JWT)
      .accept(APPLICATION_JSON)
      .contentType(APPLICATION_JSON)
      .content(
        "{  " +
          "  \"name\": \"/picard\", \n" +
          "  \"type\": \"password\" \n" +
          "}"
      );

    this.mockMvc.perform(request)
      .andExpect(status().isUnauthorized())
      .andExpect(jsonPath("$.error_description").value(ERROR_MESSAGE));
  }

  @Test
  public void whenGivenInvalidIssuer_onlyReturnsIntendedResponse() throws Exception {
    final MockHttpServletRequestBuilder request = post("/api/v1/data?name=/picard")
      .header("Authorization", "Bearer " + AuthConstants.INVALID_ISSUER_JWT)
      .accept(APPLICATION_JSON)
      .contentType(APPLICATION_JSON)
      .content(
        "{  " +
          "  \"name\": \"/picard\", \n" +
          "  \"type\": \"password\" \n" +
          "}"
      );

    final String response = this.mockMvc.perform(request)
      .andExpect(status().isUnauthorized())
      .andExpect(jsonPath("$.error_description").value(ERROR_MESSAGE))
      .andReturn()
      .getResponse()
      .getContentAsString();

    // The response originally concatenated the error and the credential.
    final String expectedResponse = "{\"error\":\"invalid_token\",\"error_description\":\"The request token identity zone does not match the UAA server authorized by CredHub. Please validate that your request token was issued by the UAA server authorized by CredHub and retry your request.\"}";

    assertThat(response, equalTo(expectedResponse));
    assertThat(credentialVersionRepository.count(), equalTo(0L));
  }

  @Test
  public void whenGivenMalformedToken_onlyReturnsIntendedResponse() throws Exception {
    final MockHttpServletRequestBuilder request = post("/api/v1/data?name=/picard")
      .header("Authorization", "Bearer " + AuthConstants.MALFORMED_TOKEN)
      .accept(APPLICATION_JSON)
      .contentType(APPLICATION_JSON)
      .content(
        "{  " +
          "  \"name\": \"/picard\", \n" +
          "  \"type\": \"password\" \n" +
          "}"
      );

    final String response = this.mockMvc.perform(request)
      .andExpect(status().isUnauthorized())
      .andExpect(jsonPath("$.error_description").value("The request token is malformed. Please validate that your request token was issued by the UAA server authorized by CredHub."))
      .andReturn()
      .getResponse()
      .getContentAsString();

    // The response originally concatenated the error and the credential.
    final String expectedResponse = "{\"error\":\"invalid_token\",\"error_description\":\"The request token is malformed. Please validate that your request token was issued by the UAA server authorized by CredHub.\"}";

    assertThat(response, equalTo(expectedResponse));
    assertThat(credentialVersionRepository.count(), equalTo(0L));
  }

  @Test
  public void whenGivenValidTokenDoesNotMatchJWTSignature_onlyReturnsIntendedResponse() throws Exception {
    final MockHttpServletRequestBuilder request = post("/api/v1/data?name=/picard")
      .header("Authorization", "Bearer " + AuthConstants.INVALID_SIGNATURE_JWT)
      .accept(APPLICATION_JSON)
      .contentType(APPLICATION_JSON)
      .content(
        "{  " +
          "  \"name\": \"/picard\", \n" +
          "  \"type\": \"password\" \n" +
          "}"
      );

    final String response = this.mockMvc.perform(request)
      .andExpect(status().isUnauthorized())
      .andExpect(jsonPath("$.error_description").value("The request token signature could not be verified. Please validate that your request token was issued by the UAA server authorized by CredHub."))
      .andReturn()
      .getResponse()
      .getContentAsString();

    // The response originally concatenated the error and the credential.
    final String expectedResponse = "{\"error\":\"invalid_token\",\"error_description\":\"The request token signature could not be verified. Please validate that your request token was issued by the UAA server authorized by CredHub.\"}";

    assertThat(response, equalTo(expectedResponse));
    assertThat(credentialVersionRepository.count(), equalTo(0L));
  }

  @Test
  public void whenGivenNullIssuer_returns401() throws Exception {
    this.mockMvc.perform(post("/api/v1/data?name=/picard")
      .header("Authorization", "Bearer " + AuthConstants.NULL_ISSUER_JWT)
      .accept(APPLICATION_JSON)
      .contentType(APPLICATION_JSON))
      .andExpect(status().isUnauthorized())
      .andExpect(jsonPath("$.error_description").value(ERROR_MESSAGE));
  }

  @Test
  public void whenEmptyIssuerSpecified_returns401() throws Exception {
    this.mockMvc.perform(post("/api/v1/data?name=/picard")
      .header("Authorization", "Bearer " + AuthConstants.EMPTY_ISSUER_JWT)
      .accept(APPLICATION_JSON)
      .contentType(APPLICATION_JSON))
      .andExpect(status().isUnauthorized())
      .andExpect(jsonPath("$.error_description").value(ERROR_MESSAGE));
  }
}
