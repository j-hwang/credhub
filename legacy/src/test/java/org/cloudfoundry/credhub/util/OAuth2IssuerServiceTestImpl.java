package org.cloudfoundry.credhub.util;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import org.cloudfoundry.credhub.auth.OAuth2IssuerService;

@Primary
@Component
public class OAuth2IssuerServiceTestImpl implements OAuth2IssuerService {
  @Override
  public String getIssuer() {
    return "https://example.com:8443/oauth/token";
  }
}
