package org.cloudfoundry.credhub.service.regeneratables;

import org.cloudfoundry.credhub.domain.CredentialVersion;
import org.cloudfoundry.credhub.domain.UserCredentialVersion;
import org.cloudfoundry.credhub.exceptions.ParameterizedValidationException;
import org.cloudfoundry.credhub.request.BaseCredentialGenerateRequest;
import org.cloudfoundry.credhub.request.StringGenerationParameters;
import org.cloudfoundry.credhub.request.UserGenerateRequest;

public class UserCredentialRegeneratable implements Regeneratable {

  @Override
  public BaseCredentialGenerateRequest createGenerateRequest(final CredentialVersion credentialVersion) {
    final UserCredentialVersion userCredential = (UserCredentialVersion) credentialVersion;
    final UserGenerateRequest generateRequest = new UserGenerateRequest();

    generateRequest.setName(userCredential.getName());
    generateRequest.setType(userCredential.getCredentialType());

    generateRequest.setOverwrite(true);
    final StringGenerationParameters generationParameters;
    generationParameters = userCredential.getGenerationParameters();

    if (generationParameters == null) {
      throw new ParameterizedValidationException(
        "error.cannot_regenerate_non_generated_user");
    }

    generationParameters.setUsername(userCredential.getUsername());
    generateRequest.setGenerationParameters(generationParameters);

    return generateRequest;
  }
}
