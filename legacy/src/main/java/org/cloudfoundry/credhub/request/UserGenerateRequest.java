package org.cloudfoundry.credhub.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.cloudfoundry.credhub.requests.GenerationParameters;

public class UserGenerateRequest extends BaseCredentialGenerateRequest {
  @JsonProperty("parameters")
  private StringGenerationParameters passwordGenerationParameters = new StringGenerationParameters();

  @JsonProperty("value")
  private UsernameValue value = new UsernameValue();

  @Override
  @JsonIgnore
  public GenerationParameters getGenerationParameters() {
    if (value.getUsername() != null) {
      passwordGenerationParameters.setUsername(value.getUsername());
    }
    return passwordGenerationParameters;
  }

  public void setGenerationParameters(final StringGenerationParameters generationParameters) {
    passwordGenerationParameters = generationParameters;
  }

  public String getUserName() {
    if (passwordGenerationParameters != null && passwordGenerationParameters.getUsername() != null) {
      return passwordGenerationParameters.getUsername();
    }
    return value.getUsername();
  }

  public void setValue(final UsernameValue value) {
    this.value = value;
  }
}
