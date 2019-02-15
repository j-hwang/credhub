package org.cloudfoundry.credhub.request;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.cloudfoundry.credhub.credential.StringCredentialValue;
import org.cloudfoundry.credhub.requests.GenerationParameters;

public class ValueSetRequest extends BaseCredentialSetRequest<StringCredentialValue> {

  @NotNull(message = "error.missing_value")
  @Valid
  @JsonProperty("value")
  private StringCredentialValue value;

  public StringCredentialValue getValue() {
    return value;
  }

  public void setValue(final StringCredentialValue value) {
    this.value = value;
  }

  @Override
  public StringCredentialValue getCredentialValue() {
    return value;
  }

  @Override
  public GenerationParameters getGenerationParameters() {
    return null;
  }
}
