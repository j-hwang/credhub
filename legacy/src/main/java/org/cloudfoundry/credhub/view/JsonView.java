package org.cloudfoundry.credhub.view;

import org.cloudfoundry.credhub.credential.JsonCredentialValue;
import org.cloudfoundry.credhub.domain.JsonCredentialVersion;

@SuppressWarnings("unused")
public class JsonView extends CredentialView {

  JsonView() {
    super();  /* Jackson */
  }

  JsonView(final JsonCredentialVersion jsonCredential) {
    super(
      jsonCredential.getVersionCreatedAt(),
      jsonCredential.getUuid(),
      jsonCredential.getName(),
      jsonCredential.getCredentialType(),
      new JsonCredentialValue(jsonCredential.getValue())
    );
  }
}
