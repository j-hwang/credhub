package org.cloudfoundry.credhub.service.regeneratables;

import org.cloudfoundry.credhub.domain.CredentialVersion;
import org.cloudfoundry.credhub.domain.SshCredentialVersion;
import org.cloudfoundry.credhub.request.BaseCredentialGenerateRequest;
import org.cloudfoundry.credhub.request.SshGenerateRequest;
import org.cloudfoundry.credhub.request.SshGenerationParameters;

public class SshCredentialRegeneratable implements Regeneratable {

  @Override
  public BaseCredentialGenerateRequest createGenerateRequest(final CredentialVersion credentialVersion) {
    final SshCredentialVersion sshCredential = (SshCredentialVersion) credentialVersion;
    final SshGenerateRequest generateRequest = new SshGenerateRequest();

    generateRequest.setName(sshCredential.getName());
    generateRequest.setType(sshCredential.getCredentialType());
    final SshGenerationParameters generationParameters = new SshGenerationParameters();
    generationParameters.setSshComment(sshCredential.getComment());
    generateRequest.setGenerationParameters(generationParameters);
    generateRequest.setOverwrite(true);
    return generateRequest;
  }
}
