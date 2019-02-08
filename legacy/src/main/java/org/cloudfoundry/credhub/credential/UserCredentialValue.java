package org.cloudfoundry.credhub.credential;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.apache.commons.codec.digest.Crypt;
import org.cloudfoundry.credhub.util.EmptyStringToNull;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.READ_ONLY;

public class UserCredentialValue implements CredentialValue {
  @JsonDeserialize(using = EmptyStringToNull.class)
  private String username;
  @NotEmpty(message = "error.missing_password")
  private String password;
  private String salt;

  public UserCredentialValue() {
    super();
  }

  public UserCredentialValue(final String username, final String password, final String salt) {
    super();
    this.username = username;
    this.password = password;
    this.salt = salt;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(final String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(final String password) {
    this.password = password;
  }

  @JsonIgnore
  public String getSalt() {
    if (salt == null) {
      salt = new CryptSaltFactory().generateSalt(password);
    }

    return salt;
  }

  @JsonProperty(value = "password_hash", access = READ_ONLY)
  @SuppressWarnings("unused")
  public String getPasswordHash() {
    return Crypt.crypt(getPassword(), getSalt());
  }
}
