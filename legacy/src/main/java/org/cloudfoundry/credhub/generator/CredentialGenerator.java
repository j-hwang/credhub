package org.cloudfoundry.credhub.generator;

import org.cloudfoundry.credhub.credential.CredentialValue;
import org.cloudfoundry.credhub.requests.GenerationParameters;

public interface CredentialGenerator<R extends CredentialValue> {
  R generateCredential(GenerationParameters parameters);
}
