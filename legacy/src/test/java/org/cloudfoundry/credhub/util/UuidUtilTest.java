package org.cloudfoundry.credhub.util;

import java.nio.ByteBuffer;
import java.util.UUID;

import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class UuidUtilTest {

  @Test
  public void roundtripUuid() throws Exception {
    final UUID originalUuid = UUID.randomUUID();

    final byte[] translatedUuid = UuidUtil.uuidToByteArray(originalUuid);

    final ByteBuffer buffer = ByteBuffer.wrap(translatedUuid);
    assertThat(new UUID(buffer.getLong(), buffer.getLong()), equalTo(originalUuid));
  }
}
