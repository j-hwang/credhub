package db.migration.common;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import org.apache.commons.codec.digest.DigestUtils;
import org.flywaydb.core.api.migration.spring.SpringJdbcMigration;

@SuppressWarnings("unused")
public class V47_2__insert_checksum_values_for_existing_credentials implements SpringJdbcMigration {

  @Override
  public void migrate(final JdbcTemplate jdbcTemplate) {

    final SqlRowSet credentials = jdbcTemplate.queryForRowSet("select * from credential");

    while (credentials.next()) {
      final String credentialName = credentials.getString("name");
      final String credentialValue = DigestUtils.sha256Hex(credentialName);

      jdbcTemplate.update("UPDATE credential SET checksum = ? WHERE name = ?", credentialValue, credentialName);

    }
  }
}
