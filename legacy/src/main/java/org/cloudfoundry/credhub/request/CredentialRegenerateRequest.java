package org.cloudfoundry.credhub.request;

import org.cloudfoundry.credhub.requests.GenerationParameters;

public class CredentialRegenerateRequest extends BaseCredentialRequest {
  @SuppressWarnings("unused")
  public void setRegenerate(final boolean regenerate) { }

  @Override
  public GenerationParameters getGenerationParameters() {
    return null;
  }
}
