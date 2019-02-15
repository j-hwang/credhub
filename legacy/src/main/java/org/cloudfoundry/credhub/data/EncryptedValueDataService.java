package org.cloudfoundry.credhub.data;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import org.cloudfoundry.credhub.domain.DefaultEncryptor;
import org.cloudfoundry.credhub.entity.EncryptedValue;
import org.cloudfoundry.credhub.repository.EncryptedValueRepository;

import static org.cloudfoundry.credhub.repository.EncryptedValueRepository.BATCH_SIZE;

@Service
public class EncryptedValueDataService {

  private final EncryptedValueRepository encryptedValueRepository;
  private final DefaultEncryptor encryptor;

  @Autowired
  protected EncryptedValueDataService(
    final EncryptedValueRepository encryptedValueRepository,
    final DefaultEncryptor encryptor) {
    super();
    this.encryptedValueRepository = encryptedValueRepository;
    this.encryptor = encryptor;
  }

  public Long countAllByCanaryUuid(final UUID uuid) {
    return encryptedValueRepository.countByEncryptionKeyUuidNot(uuid);
  }

  public Slice<EncryptedValue> findByCanaryUuids(final List<UUID> canaryUuids) {
    return encryptedValueRepository
      .findByEncryptionKeyUuidIn(canaryUuids,
        PageRequest.of(0, BATCH_SIZE)
      );
  }

  public void rotate(final EncryptedValue encryptedValue) {
    final String decryptedValue = encryptor.decrypt(encryptedValue);
    final EncryptedValue newEncryptedValue = encryptor.encrypt(decryptedValue);
    newEncryptedValue.setUuid(encryptedValue.getUuid());
    encryptedValueRepository.saveAndFlush(newEncryptedValue);
  }
}
