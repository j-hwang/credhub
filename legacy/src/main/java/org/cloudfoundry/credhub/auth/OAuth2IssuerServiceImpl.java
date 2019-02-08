package org.cloudfoundry.credhub.auth;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.cloudfoundry.credhub.config.OAuthProperties;
import org.cloudfoundry.credhub.util.RestTemplateFactory;

@Component
@ConditionalOnProperty("security.oauth2.enabled")
@Profile({
  "prod",
  "dev",
})
public class OAuth2IssuerServiceImpl implements OAuth2IssuerService {

  private final URI authServerUri;
  private final RestTemplate restTemplate;

  private String issuer;

  @Autowired
  OAuth2IssuerServiceImpl(
    final RestTemplateFactory restTemplateFactory,
    final OAuthProperties oAuthProperties
  ) throws URISyntaxException, CertificateException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException, IOException {
    super();
    this.authServerUri = oAuthProperties.getIssuerPath();
    this.restTemplate = restTemplateFactory
      .createRestTemplate(oAuthProperties.getTrustStore(), oAuthProperties.getTrustStorePassword());
  }

  @Override
  public String getIssuer() {
    return issuer != null ? issuer : fetchIssuer();
  }

  @SuppressFBWarnings(
    value = "NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE",
    justification = "Let this return null if necessary"
  )
  @SuppressWarnings("PMD.LooseCoupling")
  protected String fetchIssuer() {
    issuer = (String) restTemplate
      .getForEntity(authServerUri, HashMap.class)
      .getBody()
      .get("issuer");

    return issuer;
  }
}
