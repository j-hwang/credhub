package org.cloudfoundry.credhub.domain;

import java.util.List;
import java.util.Objects;

import javax.security.auth.x500.X500Principal;

import org.springframework.util.StringUtils;

import com.google.common.net.InetAddresses;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.ExtendedKeyUsage;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.GeneralNames;
import org.bouncycastle.asn1.x509.GeneralNamesBuilder;
import org.bouncycastle.asn1.x509.KeyPurposeId;
import org.bouncycastle.asn1.x509.KeyUsage;
import org.cloudfoundry.credhub.exceptions.ParameterizedValidationException;
import org.cloudfoundry.credhub.request.CertificateGenerationRequestParameters;
import org.cloudfoundry.credhub.requests.GenerationParameters;
import org.cloudfoundry.credhub.util.CertificateReader;

import static com.google.common.collect.Lists.newArrayList;
import static org.apache.commons.lang3.StringUtils.join;
import static org.apache.commons.lang3.StringUtils.prependIfMissing;
import static org.cloudfoundry.credhub.request.CertificateGenerationRequestParameters.CLIENT_AUTH;
import static org.cloudfoundry.credhub.request.CertificateGenerationRequestParameters.CODE_SIGNING;
import static org.cloudfoundry.credhub.request.CertificateGenerationRequestParameters.CRL_SIGN;
import static org.cloudfoundry.credhub.request.CertificateGenerationRequestParameters.DATA_ENCIPHERMENT;
import static org.cloudfoundry.credhub.request.CertificateGenerationRequestParameters.DECIPHER_ONLY;
import static org.cloudfoundry.credhub.request.CertificateGenerationRequestParameters.DIGITAL_SIGNATURE;
import static org.cloudfoundry.credhub.request.CertificateGenerationRequestParameters.EMAIL_PROTECTION;
import static org.cloudfoundry.credhub.request.CertificateGenerationRequestParameters.ENCIPHER_ONLY;
import static org.cloudfoundry.credhub.request.CertificateGenerationRequestParameters.KEY_AGREEMENT;
import static org.cloudfoundry.credhub.request.CertificateGenerationRequestParameters.KEY_CERT_SIGN;
import static org.cloudfoundry.credhub.request.CertificateGenerationRequestParameters.KEY_ENCIPHERMENT;
import static org.cloudfoundry.credhub.request.CertificateGenerationRequestParameters.NON_REPUDIATION;
import static org.cloudfoundry.credhub.request.CertificateGenerationRequestParameters.SERVER_AUTH;
import static org.cloudfoundry.credhub.request.CertificateGenerationRequestParameters.TIMESTAMPING;

public class CertificateGenerationParameters extends GenerationParameters {

  private final int keyLength;
  private final int duration;
  private final boolean selfSigned;
  private final String caName;
  private final boolean isCa;

  private final X500Principal x500Principal;
  private final GeneralNames alternativeNames;

  private final ExtendedKeyUsage extendedKeyUsage;

  private final KeyUsage keyUsage;

  public CertificateGenerationParameters(final CertificateGenerationRequestParameters generationParameters) {
    super();

    this.keyUsage = buildKeyUsage(generationParameters);
    this.x500Principal = buildDn(generationParameters);
    this.alternativeNames = buildAlternativeNames(generationParameters);
    this.extendedKeyUsage = buildExtendedKeyUsage(generationParameters);
    this.caName = generationParameters.getCaName() != null ? prependIfMissing(generationParameters.getCaName(), "/") : null;
    this.selfSigned = generationParameters.isSelfSigned();
    this.duration = generationParameters.getDuration();
    this.keyLength = generationParameters.getKeyLength();
    this.isCa = generationParameters.isCa();
  }

  public CertificateGenerationParameters(final CertificateReader certificateReader, final String caName) {
    super();

    this.keyUsage = certificateReader.getKeyUsage();
    this.x500Principal = certificateReader.getSubjectName();
    this.alternativeNames = certificateReader.getAlternativeNames();
    this.extendedKeyUsage = certificateReader.getExtendedKeyUsage();
    this.caName = caName;
    this.selfSigned = certificateReader.isSelfSigned();
    this.duration = certificateReader.getDurationDays();
    this.keyLength = certificateReader.getKeyLength();
    this.isCa = certificateReader.isCa();
  }

  @Override
  public void validate() { }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }

    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    final CertificateGenerationParameters that = (CertificateGenerationParameters) o;
    return keyLength == that.keyLength &&
      duration == that.duration &&
      selfSigned == that.selfSigned &&
      isCa == that.isCa &&
      (Objects.equals(caName, that.caName) || caName == null || that.caName == null) &&
      new X500Name(that.x500Principal.getName()).equals(new X500Name(this.x500Principal.getName())) &&
      Objects.equals(alternativeNames, that.alternativeNames) &&
      Objects.equals(extendedKeyUsage, that.extendedKeyUsage) &&
      Objects.equals(keyUsage, that.keyUsage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(keyLength, duration, selfSigned, caName, isCa, x500Principal, alternativeNames, extendedKeyUsage, keyUsage);
  }

  public int getKeyLength() {
    return keyLength;
  }

  public int getDuration() {
    return duration;
  }

  public String getCaName() {
    return caName;
  }

  public boolean isSelfSigned() {
    return selfSigned;
  }

  public boolean isCa() {
    return isCa;
  }

  public X500Principal getX500Principal() {
    return x500Principal;
  }

  public GeneralNames getAlternativeNames() {
    return alternativeNames;
  }

  public ExtendedKeyUsage getExtendedKeyUsage() {
    return extendedKeyUsage;
  }

  public KeyUsage getKeyUsage() {
    return keyUsage;
  }

  private KeyUsage buildKeyUsage(final CertificateGenerationRequestParameters keyUsageList) {
    if (keyUsageList.getKeyUsage() == null) {
      return null;
    }
    int bitmask = 0;
    for (final String keyUsage : keyUsageList.getKeyUsage()) {
      switch (keyUsage) {
        case DIGITAL_SIGNATURE:
          bitmask |= KeyUsage.digitalSignature;
          break;
        case NON_REPUDIATION:
          bitmask |= KeyUsage.nonRepudiation;
          break;
        case KEY_ENCIPHERMENT:
          bitmask |= KeyUsage.keyEncipherment;
          break;
        case DATA_ENCIPHERMENT:
          bitmask |= KeyUsage.dataEncipherment;
          break;
        case KEY_AGREEMENT:
          bitmask |= KeyUsage.keyAgreement;
          break;
        case KEY_CERT_SIGN:
          bitmask |= KeyUsage.keyCertSign;
          break;
        case CRL_SIGN:
          bitmask |= KeyUsage.cRLSign;
          break;
        case ENCIPHER_ONLY:
          bitmask |= KeyUsage.encipherOnly;
          break;
        case DECIPHER_ONLY:
          bitmask |= KeyUsage.decipherOnly;
          break;
        default:
          throw new ParameterizedValidationException("error.invalid_key_usage", keyUsage);
      }
    }
    return new KeyUsage(bitmask);
  }

  private X500Principal buildDn(final CertificateGenerationRequestParameters params) {
    if (this.x500Principal != null) {
      return this.x500Principal;
    }

    final List<String> rdns = newArrayList();

    if (!StringUtils.isEmpty(params.getLocality())) {
      rdns.add("L=" + params.getLocality());
    }
    if (!StringUtils.isEmpty(params.getOrganization())) {
      rdns.add("O=" + params.getOrganization());
    }
    if (!StringUtils.isEmpty(params.getState())) {
      rdns.add("ST=" + params.getState());
    }
    if (!StringUtils.isEmpty(params.getCountry())) {
      rdns.add("C=" + params.getCountry());
    }
    if (!StringUtils.isEmpty(params.getOrganizationUnit())) {
      rdns.add("OU=" + params.getOrganizationUnit());
    }
    if (!StringUtils.isEmpty(params.getCommonName())) {
      rdns.add("CN=" + params.getCommonName());
    }
    return new X500Principal(join(rdns, ","));
  }

  private GeneralNames buildAlternativeNames(final CertificateGenerationRequestParameters params) {
    final String[] alternativeNamesList = params.getAlternativeNames();
    if (alternativeNamesList == null) {
      return null;
    }
    final GeneralNamesBuilder builder = new GeneralNamesBuilder();

    for (final String name : alternativeNamesList) {
      if (InetAddresses.isInetAddress(name)) {
        builder.addName(new GeneralName(GeneralName.iPAddress, name));
      } else {
        builder.addName(new GeneralName(GeneralName.dNSName, name));
      }
    }
    return builder.build();
  }

  private ExtendedKeyUsage buildExtendedKeyUsage(final CertificateGenerationRequestParameters params) {
    final String[] extendedKeyUsageList = params.getExtendedKeyUsage();
    if (extendedKeyUsageList == null) {
      return null;
    }
    final KeyPurposeId[] keyPurposeIds = new KeyPurposeId[extendedKeyUsageList.length];
    for (int i = 0; i < extendedKeyUsageList.length; i++) {
      switch (extendedKeyUsageList[i]) {
        case SERVER_AUTH:
          keyPurposeIds[i] = KeyPurposeId.id_kp_serverAuth;
          break;
        case CLIENT_AUTH:
          keyPurposeIds[i] = KeyPurposeId.id_kp_clientAuth;
          break;
        case CODE_SIGNING:
          keyPurposeIds[i] = KeyPurposeId.id_kp_codeSigning;
          break;
        case EMAIL_PROTECTION:
          keyPurposeIds[i] = KeyPurposeId.id_kp_emailProtection;
          break;
        case TIMESTAMPING:
          keyPurposeIds[i] = KeyPurposeId.id_kp_timeStamping;
          break;
        default:
          throw new ParameterizedValidationException("error.invalid_extended_key_usage", extendedKeyUsageList[i]);
      }
    }
    return new ExtendedKeyUsage(keyPurposeIds);
  }

}
