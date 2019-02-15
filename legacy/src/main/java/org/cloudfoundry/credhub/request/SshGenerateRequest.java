package org.cloudfoundry.credhub.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.cloudfoundry.credhub.requests.GenerationParameters;

public class SshGenerateRequest extends BaseCredentialGenerateRequest {
  @JsonProperty("parameters")
  private SshGenerationParameters generationParameters;

  @Override
  @JsonIgnore
  public GenerationParameters getGenerationParameters() {
    if (generationParameters == null) {
      generationParameters = new SshGenerationParameters();
    }
    return generationParameters;
  }

  public void setGenerationParameters(final SshGenerationParameters generationParameters) {
    this.generationParameters = generationParameters;
  }
}
