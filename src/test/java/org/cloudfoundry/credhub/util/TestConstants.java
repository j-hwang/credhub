package org.cloudfoundry.credhub.util;

final public class TestConstants {

  private TestConstants() {
    super();
  }

  public static final String INVALID_PRIVATE_KEY;
  static {
    INVALID_PRIVATE_KEY =
      "-----BEGIN RSA PRIVATE KEY----- fake\n" +
        "MIIEpQIBAAKCAQEAwqIrV8HpCuPyuJ6VvyG7gVhYJGAOX4zhclxkTAKT5rkE4Lfj\n" +
        "048GZsDghK+pHs+tVotfyrJzYGJoEBTn9Wy7kP5pQmLRF54imDztep15OlyoJmLZ\n" +
        "fRgct/8Kyxkjgg3PKVw68IiNhnTlYaw4CAyZ/13mvw2cWIYlag9LV5R2ifcyubaY\n" +
        "llxJhdWSXrcbYxrts1kRsUQTo99jJzKu71meLigMryaMry8xvjv1X8Yjq3s3Lud6\n" +
        "gWZ6BuaaaVVIjI9clGgR1MkgKJgVkWjNzDRiCxYnq1LHCho9bgKgiY4p604zPk9M\n" +
        "w4FhtCbOim6HOsHTimONZXfDNmfsJ9wJefA0UwIDAQABAoIBAEwsTcxFvuAdQFRS\n" +
        "9IZePFUt7yklUtrAd0dbs4EwDRRiWu9b6NVWh4nVeMlVOlotq0hQucfJuXACc3m/\n" +
        "xNx/lpTzjNyHcg/NOvrb9ZFkahqWQtTrIPVdZ3f3YBEGoKf4oZgtWX/j4Ye63j8w\n" +
        "uKklzWttI66oNAVNUv1ESRdYql/p5/BVSJaVK4bdkXqYHX2j3PrPd30ICwxz0bGd\n" +
        "41UdMiKMJhlkhIESsB8bcdRAEaMS2OaFKmBYIQF4RuY3syvFizJDtp/QEYfjy9tT\n" +
        "Xokd3Wzs6dncn/yyfvT0+yCDjYsNAgFvBmfHNBorywxILdtgJHuc9oO2EOeg58VK\n" +
        "Vt4eugECgYEA/wxb29pVamwxF71gKx/msBa5kwxV5N7NhTLdYyHwhQVErQlwn7Dg\n" +
        "J8qLfZqmn231yoGpKLZsu2mxdRvpd9nvOiW+ZF+fsrS8SEs5dMEqhojALm8rur+Y\n" +
        "5M0/Sk/A0lCbSmV+X7vmqaGzyNdgH7tYVIxXjAo4sEYN6GevjUB1JQECgYEAw1wZ\n" +
        "BhhsIvW9gfbuCdiTGlezUuIO3oxjvSSTNUaGAB7GUqB26toBnXi6oQi5iGu/dCYU\n" +
        "3CILOkV7kTX//2njOfWLp/kP+5nVKDgHoA/0gL609sgrdgkQ0KdZ3iuurimeqvDm\n" +
        "U5hpPrNcwz7yPJ/M081ve84pHq3wzVKpi1dMNVMCgYEA4e5JxTTg63hR+MyqTylg\n" +
        "SmanF2sa/7aa6r6HPRTIop1rG7m8Cco+lyEmdiq0JZDb5fr8JXOMWGylZa9HHwNw\n" +
        "ltrukK3gowbVr1jr2dBv4mNrkvaqDzFAuJZU1XhWwDfliH7l9tpV17jFsUmQ/isQ\n" +
        "cT0tJIG9e/Fiyphm+8K4wwECgYEAwXbCHUQwSoq7aiokX0HHo624G1tcyE2VNCk1\n" +
        "UuwNJa9UTV01hqvwL4bwoyqluZCin55ayAk6vzEyBoLIiqLM8IfXDrhaeJpF+jdK\n" +
        "bdt/EcRKJ53hVFnz+f3QxHDT4wu6YqSAI8bqarprIbuDXkAOMq3eOmfWVtiAgITc\n" +
        "++2uvZsCgYEAmpN2RfHxO3huEWFoE7LTy9WTv4DDHI+g8PeCUpP2pN/UmczInyQ4\n" +
        "OlKeNTSxn9AkyYx9PJ8i1TIx6GyFIX4pkJczLEu+XINm82MKSBGuRL1EUvkVddx3\n" +
        "6clZk5BLDXjmCtCr5DGZ01EbT0wsbsBM1GtoCS4+vUQkJVHb0r6/ZdXX=\n" +
        "-----END RSA PRIVATE KEY-----";
  }

  // generate with ./build/credhub n -t ssh -n foo -k 4096
  public static final String SSH_PUBLIC_KEY_4096;
  static {
    SSH_PUBLIC_KEY_4096 =
      "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAACAQDs8lQIdJ+tnc9jufX9wLzCPVS1utoTJ"
        + "wzQO2NS5F07OEWXnR94XtYY3KtBLu10LHjZzH5maxdWYkyb4GgYSwV+6ln+Txn7"
        + "9LQT8gStbK+mJBFWnGplHNU+loHdHkKckOVihBgDfjsW58s46X9HmKAiUetXBaz"
        + "QX2pVOhOKBETgEstVKB1CoN0fP98mbergW+THHxDpbtodep1EoWZePn/Qe/jly7"
        + "joL8HZuVAwzunmBsrrm0B1cRF3mG4/XZDdHqbz1humoz/8V8KMBuC899XhN1yZv"
        + "mdZqe3OhpENr8O3e26p7xxTyCyOs5kk2Myv7YqWOyr43obFIzGUcLLMj3p1SDuk"
        + "gzpxCHPmiZ72zO/hZ+HkB6319iZPsZgrR8vapQsJY5MfYJO9KPj0BKlFdi9y578"
        + "VCj1pw6OYz7fuRrSfu/W0S1l9FLI450aFsNSji5ZX7elJ5A0qDQaFblECAsmbMj"
        + "T9MCDyJDjZfmtb9UY4j/ywFeYP26RLqbdWMZBYgukVg+isCyxJczecaJKRWBnUr"
        + "yz5sSvbsOC38rdu7LAl/vxf8m2ZY6d/TZ2SgTEDgD4YxOG6WZEm2z2JGpgGtQcV"
        + "O4ulfSa/xqovvidLc/kTWR15dVts+r1Uv7Btaax7XqTKqBkrxjhbpXD2RVQAeZh"
        + "BOQ80pPbFtvUPN1pAdgc14w==";
  }

  public static final String SSH_PUBLIC_KEY_4096_WITH_COMMENT;
  static {
    SSH_PUBLIC_KEY_4096_WITH_COMMENT =
      "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAACAQDs8lQIdJ+tnc9jufX9wLzCPVS1utoTJ"
        + "wzQO2NS5F07OEWXnR94XtYY3KtBLu10LHjZzH5maxdWYkyb4GgYSwV+6ln+Txn7"
        + "9LQT8gStbK+mJBFWnGplHNU+loHdHkKckOVihBgDfjsW58s46X9HmKAiUetXBaz"
        + "QX2pVOhOKBETgEstVKB1CoN0fP98mbergW+THHxDpbtodep1EoWZePn/Qe/jly7"
        + "joL8HZuVAwzunmBsrrm0B1cRF3mG4/XZDdHqbz1humoz/8V8KMBuC899XhN1yZv"
        + "mdZqe3OhpENr8O3e26p7xxTyCyOs5kk2Myv7YqWOyr43obFIzGUcLLMj3p1SDuk"
        + "gzpxCHPmiZ72zO/hZ+HkB6319iZPsZgrR8vapQsJY5MfYJO9KPj0BKlFdi9y578"
        + "VCj1pw6OYz7fuRrSfu/W0S1l9FLI450aFsNSji5ZX7elJ5A0qDQaFblECAsmbMj"
        + "T9MCDyJDjZfmtb9UY4j/ywFeYP26RLqbdWMZBYgukVg+isCyxJczecaJKRWBnUr"
        + "yz5sSvbsOC38rdu7LAl/vxf8m2ZY6d/TZ2SgTEDgD4YxOG6WZEm2z2JGpgGtQcV"
        + "O4ulfSa/xqovvidLc/kTWR15dVts+r1Uv7Btaax7XqTKqBkrxjhbpXD2RVQAeZh"
        + "BOQ80pPbFtvUPN1pAdgc14w== dan@foo";
  }

  public static final String RSA_PUBLIC_KEY_4096;
  static {
    RSA_PUBLIC_KEY_4096 =
      "-----BEGIN PUBLIC KEY-----\n"
      + "MIICIjANBgkqhkiG9w0BAQEFAAOCAg8AMIICCgKCAgEA7PJUCHSfrZ3PY7n1/cC8\n"
      + "wj1UtbraEycM0DtjUuRdOzhFl50feF7WGNyrQS7tdCx42cx+ZmsXVmJMm+BoGEsF\n"
      + "fupZ/k8Z+/S0E/IErWyvpiQRVpxqZRzVPpaB3R5CnJDlYoQYA347FufLOOl/R5ig\n"
      + "IlHrVwWs0F9qVToTigRE4BLLVSgdQqDdHz/fJm3q4Fvkxx8Q6W7aHXqdRKFmXj5/\n"
      + "0Hv45cu46C/B2blQMM7p5gbK65tAdXERd5huP12Q3R6m89YbpqM//FfCjAbgvPfV\n"
      + "4Tdcmb5nWantzoaRDa/Dt3tuqe8cU8gsjrOZJNjMr+2Kljsq+N6GxSMxlHCyzI96\n"
      + "dUg7pIM6cQhz5ome9szv4Wfh5Aet9fYmT7GYK0fL2qULCWOTH2CTvSj49ASpRXYv\n"
      + "cue/FQo9acOjmM+37ka0n7v1tEtZfRSyOOdGhbDUo4uWV+3pSeQNKg0GhW5RAgLJ\n"
      + "mzI0/TAg8iQ42X5rW/VGOI/8sBXmD9ukS6m3VjGQWILpFYPorAssSXM3nGiSkVgZ\n"
      + "1K8s+bEr27Dgt/K3buywJf78X/JtmWOnf02dkoExA4A+GMThulmRJts9iRqYBrUH\n"
      + "FTuLpX0mv8aqL74nS3P5E1kdeXVbbPq9VL+wbWmse16kyqgZK8Y4W6Vw9kVUAHmY\n"
      + "QTkPNKT2xbb1DzdaQHYHNeMCAwEAAQ==\n"
      + "-----END PUBLIC KEY-----";
  }
  public static final String PRIVATE_KEY_4096;
  static {
    PRIVATE_KEY_4096 =
      "-----BEGIN RSA PRIVATE KEY----- fake\n"
    + "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\n"
    + "-----END RSA PRIVATE KEY-----";
  }

  public static final String TEST_CA;
  static {
    TEST_CA =
      "-----BEGIN CERTIFICATE-----\n" +
    "MIIDTTCCAjWgAwIBAgIULxxoB3zfye0MzzRQGtKtw8CC2p4wDQYJKoZIhvcNAQEL\n" +
    "BQAwGjEYMBYGA1UEAwwPZm9vX2NlcnRpZmljYXRlMB4XDTE3MTEyMTE2MjQ1NFoX\n" +
    "DTE4MTEyMTE2MjQ1NFowGjEYMBYGA1UEAwwPZm9vX2NlcnRpZmljYXRlMIIBIjAN\n" +
    "BgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvgmVFC08CaGlp2ENKc5mym9BkcEL\n" +
    "E2030VXTJJSiLH1Py3s79rbJL4F/loxAMSbQCuKIADZZ4Wu7Xp8bFY92u0nNrAuG\n" +
    "Xw1omhfF5UTi1vewRG8inxdJZs9vxsiXZWI6WzUpvJZeCMvvKlkhA/C+GwjpIdRg\n" +
    "3fVZ44JvdZOx4cDUagRkDRcsHABp/ip19xhfZGLwFuJw1wd5kxZmZKCreoel+b/5\n" +
    "BaQyFD0L9OkSfq1Y/nMqOdIbXEnpeg8sawhQan0s7G98MTsvDF14jnucCECLO1fg\n" +
    "1YpxoBTDkNlrIPq4G8UO4+GNz5FJEIBGOsiRmEn0VjFEpZ3k+t/Nkf/b6wIDAQAB\n" +
    "o4GKMIGHMB0GA1UdDgQWBBQ3ZlJJaG9Brzf3IM6tWsMJce6YIDBVBgNVHSMETjBM\n" +
    "gBQ3ZlJJaG9Brzf3IM6tWsMJce6YIKEepBwwGjEYMBYGA1UEAwwPZm9vX2NlcnRp\n" +
    "ZmljYXRlghQvHGgHfN/J7QzPNFAa0q3DwILanjAPBgNVHRMBAf8EBTADAQH/MA0G\n" +
    "CSqGSIb3DQEBCwUAA4IBAQAlbxUF4Eaz0tXSo7oM02Mt3YqhuP7XZpZE5KYpn5qE\n" +
    "utYzJdSJeMsfUpZcmv1pbZ4uepxgBxQKssKRmglzEMX2wxl9WyEPxKkyLTX+XCX9\n" +
    "Vd6IBi5Pft6v2u94bKlGZKigNojGfbzXDYuSU6SAud5GD77RM1vx/pPAa2eG8qSX\n" +
    "OcGQAtHrcSAvl58IqXAmci3akNKN4G5PxNoze5lQ25umQbHTlwvOMwFgPSXseYvm\n" +
    "/f98b+Q6lIdklw6g3XWUCmTkscRM+5mvb+1FKHWU8KiXN7CM+ONXjudO8Ixyyion\n" +
    "pBumFgiA2FQXUpunDCv38dccPb8y/EyhRSQyx+olXqo+\n" +
    "-----END CERTIFICATE-----";
  }

  public static final String TEST_CERTIFICATE;
    static {
      TEST_CERTIFICATE =
        "-----BEGIN CERTIFICATE-----\n" +
    "MIIDSjCCAjKgAwIBAgIUdpQ3G/AnIilrPAsvMz3Zf9VnvWgwDQYJKoZIhvcNAQEL\n" +
    "BQAwGjEYMBYGA1UEAwwPZm9vX2NlcnRpZmljYXRlMB4XDTE3MTEyMTE2MjUyMFoX\n" +
    "DTE4MTEyMTE2MjUyMFowGjEYMBYGA1UEAwwPZm9vX2NlcnRpZmljYXRlMIIBIjAN\n" +
    "BgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwqIrV8HpCuPyuJ6VvyG7gVhYJGAO\n" +
    "X4zhclxkTAKT5rkE4Lfj048GZsDghK+pHs+tVotfyrJzYGJoEBTn9Wy7kP5pQmLR\n" +
    "F54imDztep15OlyoJmLZfRgct/8Kyxkjgg3PKVw68IiNhnTlYaw4CAyZ/13mvw2c\n" +
    "WIYlag9LV5R2ifcyubaYllxJhdWSXrcbYxrts1kRsUQTo99jJzKu71meLigMryaM\n" +
    "ry8xvjv1X8Yjq3s3Lud6gWZ6BuaaaVVIjI9clGgR1MkgKJgVkWjNzDRiCxYnq1LH\n" +
    "Cho9bgKgiY4p604zPk9Mw4FhtCbOim6HOsHTimONZXfDNmfsJ9wJefA0UwIDAQAB\n" +
    "o4GHMIGEMB0GA1UdDgQWBBTyAOrrFMy88bGgEBVI4PRGD4b02jBVBgNVHSMETjBM\n" +
    "gBQ3ZlJJaG9Brzf3IM6tWsMJce6YIKEepBwwGjEYMBYGA1UEAwwPZm9vX2NlcnRp\n" +
    "ZmljYXRlghQvHGgHfN/J7QzPNFAa0q3DwILanjAMBgNVHRMBAf8EAjAAMA0GCSqG\n" +
    "SIb3DQEBCwUAA4IBAQBC1x2+E35y+iX3Mu+SWD1I3RNTGE3qKdUqj+O+QeavqCRQ\n" +
    "01nolxFaSvrM/4znAlWukfp9lCOHl8foD3vHQ+meW+PlLIH9HlBjn9T3c6h4p8EQ\n" +
    "iYV93tyCmUlPdtzW7k4Onl3IroNNHem9Uj+OSZxGtw35YU84T+hM1kaDKtZeS1je\n" +
    "FWF1W8DCORxD2rFXFwe2nJd6SSeF3KWzuKAKDqJ7CmbdRb1TtgjUym6X55SQfW2a\n" +
    "dwNE+9ztMBQm4ERhwMU/NMx14UjsOPvNjF1VVei52qQ2ce7c1vgW1RI2cYFgV8q8\n" +
    "oFjMdJePy7eLbGRaW7Jpdy9MOiEZOj513lT5MBGk\n" +
    "-----END CERTIFICATE-----";
  }
  public static final String TEST_PRIVATE_KEY;
    static {
      TEST_PRIVATE_KEY =
        "-----BEGIN RSA PRIVATE KEY----- fake\n" +
    "MIIEpQIBAAKCAQEAwqIrV8HpCuPyuJ6VvyG7gVhYJGAOX4zhclxkTAKT5rkE4Lfj\n" +
    "048GZsDghK+pHs+tVotfyrJzYGJoEBTn9Wy7kP5pQmLRF54imDztep15OlyoJmLZ\n" +
    "fRgct/8Kyxkjgg3PKVw68IiNhnTlYaw4CAyZ/13mvw2cWIYlag9LV5R2ifcyubaY\n" +
    "llxJhdWSXrcbYxrts1kRsUQTo99jJzKu71meLigMryaMry8xvjv1X8Yjq3s3Lud6\n" +
    "gWZ6BuaaaVVIjI9clGgR1MkgKJgVkWjNzDRiCxYnq1LHCho9bgKgiY4p604zPk9M\n" +
    "w4FhtCbOim6HOsHTimONZXfDNmfsJ9wJefA0UwIDAQABAoIBAEwsTcxFvuAdQFRS\n" +
    "9IZePFUt7yklUtrAd0dbs4EwDRRiWu9b6NVWh4nVeMlVOlotq0hQucfJuXACc3m/\n" +
    "xNx/lpTzjNyHcg/NOvrb9ZFkahqWQtTrIPVdZ3f3YBEGoKf4oZgtWX/j4Ye63j8w\n" +
    "uKklzWttI66oNAVNUv1ESRdYql/p5/BVSJaVK4bdkXqYHX2j3PrPd30ICwxz0bGd\n" +
    "41UdMiKMJhlkhIESsB8bcdRAEaMS2OaFKmBYIQF4RuY3syvFizJDtp/QEYfjy9tT\n" +
    "Xokd3Wzs6dncn/yyfvT0+yCDjYsNAgFvBmfHNBorywxILdtgJHuc9oO2EOeg58VK\n" +
    "Vt4eugECgYEA/wxb29pVamwxF71gKx/msBa5kwxV5N7NhTLdYyHwhQVErQlwn7Dg\n" +
    "J8qLfZqmn231yoGpKLZsu2mxdRvpd9nvOiW+ZF+fsrS8SEs5dMEqhojALm8rur+Y\n" +
    "5M0/Sk/A0lCbSmV+X7vmqaGzyNdgH7tYVIxXjAo4sEYN6GevjUB1JQECgYEAw1wZ\n" +
    "BhhsIvW9gfbuCdiTGlezUuIO3oxjvSSTNUaGAB7GUqB26toBnXi6oQi5iGu/dCYU\n" +
    "3CILOkV7kTX//2njOfWLp/kP+5nVKDgHoA/0gL609sgrdgkQ0KdZ3iuurimeqvDm\n" +
    "U5hpPrNcwz7yPJ/M081ve84pHq3wzVKpi1dMNVMCgYEA4e5JxTTg63hR+MyqTylg\n" +
    "SmanF2sa/7aa6r6HPRTIop1rG7m8Cco+lyEmdiq0JZDb5fr8JXOMWGylZa9HHwNw\n" +
    "ltrukK3gowbVr1jr2dBv4mNrkvaqDzFAuJZU1XhWwDfliH7l9tpV17jFsUmQ/isQ\n" +
    "cT0tJIG9e/Fiyphm+8K4wwECgYEAwXbCHUQwSoq7aiokX0HHo624G1tcyE2VNCk1\n" +
    "UuwNJa9UTV01hqvwL4bwoyqluZCin55ayAk6vzEyBoLIiqLM8IfXDrhaeJpF+jdK\n" +
    "bdt/EcRKJ53hVFnz+f3QxHDT4wu6YqSAI8bqarprIbuDXkAOMq3eOmfWVtiAgITc\n" +
    "++2uvZsCgYEAmpN2RfHxO3huEWFoE7LTy9WTv4DDHI+g8PeCUpP2pN/UmczInyQ4\n" +
    "OlKeNTSxn9AkyYx9PJ8i1TIx6GyFIX4pkJczLEu+XINm82MKSBGuRL1EUvkVddx3\n" +
    "6clZk5BLDXjmCtCr5DGZ01EbT0wsbsBM1GtoCS4+vUQkJVHb0r6/ZdM=\n" +
    "-----END RSA PRIVATE KEY-----";
    }

  public static final String TEST_PRIVATE_KEY_PKCS8;
    static {
      TEST_PRIVATE_KEY_PKCS8 =
        "-----BEGIN PRIVATE KEY----- fake\n" +
    "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDCoitXwekK4/K4\n" +
    "npW/IbuBWFgkYA5fjOFyXGRMApPmuQTgt+PTjwZmwOCEr6kez61Wi1/KsnNgYmgQ\n" +
    "FOf1bLuQ/mlCYtEXniKYPO16nXk6XKgmYtl9GBy3/wrLGSOCDc8pXDrwiI2GdOVh\n" +
    "rDgIDJn/Xea/DZxYhiVqD0tXlHaJ9zK5tpiWXEmF1ZJetxtjGu2zWRGxRBOj32Mn\n" +
    "Mq7vWZ4uKAyvJoyvLzG+O/VfxiOrezcu53qBZnoG5pppVUiMj1yUaBHUySAomBWR\n" +
    "aM3MNGILFierUscKGj1uAqCJjinrTjM+T0zDgWG0Js6Kboc6wdOKY41ld8M2Z+wn\n" +
    "3Al58DRTAgMBAAECggEATCxNzEW+4B1AVFL0hl48VS3vKSVS2sB3R1uzgTANFGJa\n" +
    "71vo1VaHidV4yVU6Wi2rSFC5x8m5cAJzeb/E3H+WlPOM3IdyD806+tv1kWRqGpZC\n" +
    "1Osg9V1nd/dgEQagp/ihmC1Zf+Phh7rePzC4qSXNa20jrqg0BU1S/URJF1iqX+nn\n" +
    "8FVIlpUrht2RepgdfaPc+s93fQgLDHPRsZ3jVR0yIowmGWSEgRKwHxtx1EARoxLY\n" +
    "5oUqYFghAXhG5jezK8WLMkO2n9ARh+PL21NeiR3dbOzp2dyf/LJ+9PT7IIONiw0C\n" +
    "AW8GZ8c0GivLDEgt22Ake5z2g7YQ56DnxUpW3h66AQKBgQD/DFvb2lVqbDEXvWAr\n" +
    "H+awFrmTDFXk3s2FMt1jIfCFBUStCXCfsOAnyot9mqafbfXKgakotmy7abF1G+l3\n" +
    "2e86Jb5kX5+ytLxISzl0wSqGiMAubyu6v5jkzT9KT8DSUJtKZX5fu+apobPI12Af\n" +
    "u1hUjFeMCjiwRg3oZ6+NQHUlAQKBgQDDXBkGGGwi9b2B9u4J2JMaV7NS4g7ejGO9\n" +
    "JJM1RoYAHsZSoHbq2gGdeLqhCLmIa790JhTcIgs6RXuRNf//aeM59Yun+Q/7mdUo\n" +
    "OAegD/SAvrT2yCt2CRDQp1neK66uKZ6q8OZTmGk+s1zDPvI8n8zTzW97zikerfDN\n" +
    "UqmLV0w1UwKBgQDh7knFNODreFH4zKpPKWBKZqcXaxr/tprqvoc9FMiinWsbubwJ\n" +
    "yj6XISZ2KrQlkNvl+vwlc4xYbKVlr0cfA3CW2u6QreCjBtWvWOvZ0G/iY2uS9qoP\n" +
    "MUC4llTVeFbAN+WIfuX22lXXuMWxSZD+KxBxPS0kgb178WLKmGb7wrjDAQKBgQDB\n" +
    "dsIdRDBKirtqKiRfQcejrbgbW1zITZU0KTVS7A0lr1RNXTWGq/AvhvCjKqW5kKKf\n" +
    "nlrICTq/MTIGgsiKoszwh9cOuFp4mkX6N0pt238RxEonneFUWfP5/dDEcNPjC7pi\n" +
    "pIAjxupqumshu4NeQA4yrd46Z9ZW2ICAhNz77a69mwKBgQCak3ZF8fE7eG4RYWgT\n" +
    "stPL1ZO/gMMcj6Dw94JSk/ak39SZzMifJDg6Up41NLGf0CTJjH08nyLVMjHobIUh\n" +
    "fimQlzMsS75cg2bzYwpIEa5EvURS+RV13HfpyVmTkEsNeOYK0KvkMZnTURtPTCxu\n" +
    "wEzUa2gJLj69RCQlUdvSvr9l0w==\n" +
    "-----END PRIVATE KEY-----";
    }
}
