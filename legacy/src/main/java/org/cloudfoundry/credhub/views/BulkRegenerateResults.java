package org.cloudfoundry.credhub.views;

import java.util.Set;

import org.codehaus.jackson.annotate.JsonAutoDetect;

@JsonAutoDetect
public class BulkRegenerateResults {
  private Set<String> regeneratedCredentials;

  public Set<String> getRegeneratedCredentials() {
    return regeneratedCredentials;
  }

  public void setRegeneratedCredentials(final Set<String> regeneratedCredentials) {
    this.regeneratedCredentials = regeneratedCredentials;
  }
}
