package org.cloudfoundry.credhub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.cloudfoundry.credhub.auth.UserContextHolder;
import org.cloudfoundry.credhub.data.CertificateVersionDataService;
import org.cloudfoundry.credhub.domain.CertificateCredentialVersion;
import org.cloudfoundry.credhub.domain.CredentialVersion;
import org.cloudfoundry.credhub.exceptions.EntryNotFoundException;
import org.cloudfoundry.credhub.request.PermissionOperation;

@Service
public class CertificateService {

  private final CertificateVersionDataService certificateVersionDataService;
  private final UserContextHolder userContextHolder;
  private final PermissionCheckingService permissionCheckingService;

  @Autowired
  public CertificateService(
    final CertificateVersionDataService certificateVersionDataService,
    final PermissionCheckingService permissionCheckingService,
    final UserContextHolder userContextHolder) {
    super();
    this.certificateVersionDataService = certificateVersionDataService;
    this.permissionCheckingService = permissionCheckingService;
    this.userContextHolder = userContextHolder;
  }

  public CertificateCredentialVersion findByCredentialUuid(final String uuid) {
    final CredentialVersion credentialVersion = this.certificateVersionDataService
      .findByCredentialUUID(uuid);

    if (!(credentialVersion instanceof CertificateCredentialVersion)) {
      throw new EntryNotFoundException("error.credential.invalid_access");
    }
    final CertificateCredentialVersion certificate = (CertificateCredentialVersion) credentialVersion;
    if (!permissionCheckingService.hasPermission(userContextHolder.getUserContext().getActor(), certificate.getName(), PermissionOperation.READ)) {
      throw new EntryNotFoundException("error.credential.invalid_access");
    }
    return certificate;
  }
}
