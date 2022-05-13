package com.josiah.doctorapp.service.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.josiah.doctorapp.api.constants.Constants.Column;
import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GeneralRow {
  @JsonProperty(Column.CHANGE_TYPE)
  @CsvBindByName(column = Column.CHANGE_TYPE)
  private String changeType;

  @JsonProperty(Column.COVERED_RECIPIENT_TYPE)
  @CsvBindByName(column = Column.COVERED_RECIPIENT_TYPE)
  private String coveredRecipientType;

  @JsonProperty(Column.TEACHING_HOSPITAL_CCN)
  @CsvBindByName(column = Column.TEACHING_HOSPITAL_CCN)
  private String teachingHospitalCcn;

  @JsonProperty(Column.TEACHING_HOSPITAL_ID)
  @CsvBindByName(column = Column.TEACHING_HOSPITAL_ID)
  private String teachingHospitalId;

  @JsonProperty(Column.TEACHING_HOSPITAL_NAME)
  @CsvBindByName(column = Column.TEACHING_HOSPITAL_NAME)
  private String teachingHospitalName;

  @JsonProperty(Column.PHYSICIAN_PROFILE_ID)
  @CsvBindByName(column = Column.PHYSICIAN_PROFILE_ID)
  private String physicianProfileId;

  @JsonProperty(Column.PHYSICIAN_FIRST_NAME)
  @CsvBindByName(column = Column.PHYSICIAN_FIRST_NAME)
  private String physicianFirstName;

  @JsonProperty(Column.PHYSICIAN_MIDDLE_NAME)
  @CsvBindByName(column = Column.PHYSICIAN_MIDDLE_NAME)
  private String physicianMiddleName;

  @JsonProperty(Column.PHYSICIAN_LAST_NAME)
  @CsvBindByName(column = Column.PHYSICIAN_LAST_NAME)
  private String physicianLastName;

  @JsonProperty(Column.PHYSICIAN_NAME_SUFFIX)
  @CsvBindByName(column = Column.PHYSICIAN_NAME_SUFFIX)
  private String physicianNameSuffix;

  @JsonProperty(Column.RECIPIENT_PRIMARY_BUSINESS_STREET_1)
  @CsvBindByName(column = Column.RECIPIENT_PRIMARY_BUSINESS_STREET_1)
  private String recipientPrimaryBusinessStreet1;

  @JsonProperty(Column.RECIPIENT_PRIMARY_BUSINESS_STREET_2)
  @CsvBindByName(column = Column.RECIPIENT_PRIMARY_BUSINESS_STREET_2)
  private String recipientPrimaryBusinessStreet2;

  @JsonProperty(Column.RECIPIENT_CITY)
  @CsvBindByName(column = Column.RECIPIENT_CITY)
  private String recipientCity;

  @JsonProperty(Column.RECIPIENT_STATE)
  @CsvBindByName(column = Column.RECIPIENT_STATE)
  private String recipientState;

  @JsonProperty(Column.RECIPIENT_ZIP_CODE)
  @CsvBindByName(column = Column.RECIPIENT_ZIP_CODE)
  private String recipientZipCode;

  @JsonProperty(Column.RECIPIENT_COUNTRY)
  @CsvBindByName(column = Column.RECIPIENT_COUNTRY)
  private String recipientCountry;

  @JsonProperty(Column.RECIPIENT_PROVINCE)
  @CsvBindByName(column = Column.RECIPIENT_PROVINCE)
  private String recipientProvince;

  @JsonProperty(Column.RECIPIENT_POSTAL_CODE)
  @CsvBindByName(column = Column.RECIPIENT_POSTAL_CODE)
  private String recipientPostalCode;

  @JsonProperty(Column.PHYSICIAN_PRIMARY_TYPE)
  @CsvBindByName(column = Column.PHYSICIAN_PRIMARY_TYPE)
  private String physicianPrimaryType;

  @JsonProperty(Column.PHYSICIAN_SPECIALTY)
  @CsvBindByName(column = Column.PHYSICIAN_SPECIALTY)
  private String physicianSpecialty;

  @JsonProperty(Column.PHYSICIAN_LICENSE_STATE_CODE_1)
  @CsvBindByName(column = Column.PHYSICIAN_LICENSE_STATE_CODE_1)
  private String physicianLicenseStateCode1;

  @JsonProperty(Column.PHYSICIAN_LICENSE_STATE_CODE_2)
  @CsvBindByName(column = Column.PHYSICIAN_LICENSE_STATE_CODE_2)
  private String physicianLicenseStateCode2;

  @JsonProperty(Column.PHYSICIAN_LICENSE_STATE_CODE_3)
  @CsvBindByName(column = Column.PHYSICIAN_LICENSE_STATE_CODE_3)
  private String physicianLicenseStateCode3;

  @JsonProperty(Column.PHYSICIAN_LICENSE_STATE_CODE_4)
  @CsvBindByName(column = Column.PHYSICIAN_LICENSE_STATE_CODE_4)
  private String physicianLicenseStateCode4;

  @JsonProperty(Column.PHYSICIAN_LICENSE_STATE_CODE_5)
  @CsvBindByName(column = Column.PHYSICIAN_LICENSE_STATE_CODE_5)
  private String physicianLicenseStateCode5;

  @JsonProperty(Column.SUBMITTING_APPLICABLE_MAN_OR_GPO_NAME)
  @CsvBindByName(column = Column.SUBMITTING_APPLICABLE_MAN_OR_GPO_NAME)
  private String submittingApplicableManufacturerOrApplicableGpoName;

  @JsonProperty(Column.APPLICABLE_MAN_OR_GPO_PAYMENT_ID)
  @CsvBindByName(column = Column.APPLICABLE_MAN_OR_GPO_PAYMENT_ID)
  private String applicableManufacturerOrApplicableGpoMakingPaymentId;

  @JsonProperty(Column.APPLICABLE_MAN_OR_GPO_PAYMENT_NAME)
  @CsvBindByName(column = Column.APPLICABLE_MAN_OR_GPO_PAYMENT_NAME)
  private String applicableManufacturerOrApplicableGpoMakingPaymentName;

  @JsonProperty(Column.APPLICABLE_MAN_OR_GPO_PAYMENT_STATE)
  @CsvBindByName(column = Column.APPLICABLE_MAN_OR_GPO_PAYMENT_STATE)
  private String applicableManufacturerOrApplicableGpoMakingPaymentState;

  @JsonProperty(Column.APPLICABLE_MAN_OR_GPO_PAYMENT_COUNTRY)
  @CsvBindByName(column = Column.APPLICABLE_MAN_OR_GPO_PAYMENT_COUNTRY)
  private String applicableManufacturerOrApplicableGpoMakingPaymentCountry;

  @JsonProperty(Column.TOTAL_PAYMENT_DOLLARS)
  @CsvBindByName(column = Column.TOTAL_PAYMENT_DOLLARS)
  private double totalAmountOfPaymentUsdollars;

  @JsonProperty(Column.DATE_OF_PAYMENT)
  @CsvBindByName(column = Column.DATE_OF_PAYMENT)
  private String dateOfPayment;

  @JsonProperty(Column.NUMBER_OF_PAYMENTS_IN_TOTAL)
  @CsvBindByName(column = Column.NUMBER_OF_PAYMENTS_IN_TOTAL)
  private int numberOfPaymentsIncludedInTotalAmount;

  @JsonProperty(Column.FORM_OF_PAYMENT)
  @CsvBindByName(column = Column.FORM_OF_PAYMENT)
  private String formOfPaymentOrTransferOfValue;

  @JsonProperty(Column.NATURE_OF_PAYMENT)
  @CsvBindByName(column = Column.NATURE_OF_PAYMENT)
  private String natureOfPaymentOrTransferOfValue;

  @JsonProperty(Column.CITY_OF_TRAVEL)
  @CsvBindByName(column = Column.CITY_OF_TRAVEL)
  private String cityOfTravel;

  @JsonProperty(Column.STATE_OF_TRAVEL)
  @CsvBindByName(column = Column.STATE_OF_TRAVEL)
  private String stateOfTravel;

  @JsonProperty(Column.COUNTRY_OF_TRAVEL)
  @CsvBindByName(column = Column.COUNTRY_OF_TRAVEL)
  private String countryOfTravel;

  @JsonProperty(Column.PHYSICIAN_OWNERSHIP_INDICATOR)
  @CsvBindByName(column = Column.PHYSICIAN_OWNERSHIP_INDICATOR)
  private String physicianOwnershipIndicator;

  @JsonProperty(Column.THIRD_PARTY_PAYMENT_RECIPIENT_IND)
  @CsvBindByName(column = Column.THIRD_PARTY_PAYMENT_RECIPIENT_IND)
  private String thirdPartyPaymentRecipientIndicator;

  @JsonProperty(Column.NAME_OF_ENTITY_RECEIVING_PAYMENT)
  @CsvBindByName(column = "name_of_third_party_entity_receiving_payment_or_transfer_of_value")
  private String nameOfThirdPartyEntityReceivingPaymentOrTransferOfCcfc;

  @JsonProperty(Column.CHARITY_INDICATOR)
  @CsvBindByName(column = Column.CHARITY_INDICATOR)
  private String charityIndicator;

  @JsonProperty(Column.THIRD_PARTY_EQUALS_COVERED_RECIPIENT_IND)
  @CsvBindByName(column = Column.THIRD_PARTY_EQUALS_COVERED_RECIPIENT_IND)
  private String thirdPartyEqualsCoveredRecipientIndicator;

  @JsonProperty(Column.CONTEXTUAL_INFORMATION)
  @CsvBindByName(column = Column.CONTEXTUAL_INFORMATION)
  private String contextualInformation;

  @JsonProperty(Column.DELAY_IN_PUBLICATION_IND)
  @CsvBindByName(column = Column.DELAY_IN_PUBLICATION_IND)
  private String delayInPublicationIndicator;

  @JsonProperty(Column.RECORD_ID)
  @CsvBindByName(column = Column.RECORD_ID)
  private long recordId;

  @JsonProperty(Column.DISPUTE_STATUS_FOR_PUBLICATION)
  @CsvBindByName(column = Column.DISPUTE_STATUS_FOR_PUBLICATION)
  private String disputeStatusForPublication;

  @JsonProperty(Column.PRODUCT_INDICATOR)
  @CsvBindByName(column = Column.PRODUCT_INDICATOR)
  private String productIndicator;

  @JsonProperty(Column.NAME_OF_ASSOCIATED_DRUG_OR_BIO_1)
  @CsvBindByName(column = Column.NAME_OF_ASSOCIATED_DRUG_OR_BIO_1)
  private String nameOfAssociatedCoveredDrugOrBiological1;

  @JsonProperty(Column.NAME_OF_ASSOCIATED_DRUG_OR_BIO_2)
  @CsvBindByName(column = Column.NAME_OF_ASSOCIATED_DRUG_OR_BIO_2)
  private String nameOfAssociatedCoveredDrugOrBiological2;

  @JsonProperty(Column.NAME_OF_ASSOCIATED_DRUG_OR_BIO_3)
  @CsvBindByName(column = Column.NAME_OF_ASSOCIATED_DRUG_OR_BIO_3)
  private String nameOfAssociatedCoveredDrugOrBiological3;

  @JsonProperty(Column.NAME_OF_ASSOCIATED_DRUG_OR_BIO_4)
  @CsvBindByName(column = Column.NAME_OF_ASSOCIATED_DRUG_OR_BIO_4)
  private String nameOfAssociatedCoveredDrugOrBiological4;

  @JsonProperty(Column.NAME_OF_ASSOCIATED_DRUG_OR_BIO_5)
  @CsvBindByName(column = Column.NAME_OF_ASSOCIATED_DRUG_OR_BIO_5)
  private String nameOfAssociatedCoveredDrugOrBiological5;

  @JsonProperty(Column.NDC_OF_ASSOCIATED_DRUG_OR_BIO_1)
  @CsvBindByName(column = Column.NDC_OF_ASSOCIATED_DRUG_OR_BIO_1)
  private String ndcOfAssociatedCoveredDrugOrBiological1;

  @JsonProperty(Column.NDC_OF_ASSOCIATED_DRUG_OR_BIO_2)
  @CsvBindByName(column = Column.NDC_OF_ASSOCIATED_DRUG_OR_BIO_2)
  private String ndcOfAssociatedCoveredDrugOrBiological2;

  @JsonProperty(Column.NDC_OF_ASSOCIATED_DRUG_OR_BIO_3)
  @CsvBindByName(column = Column.NDC_OF_ASSOCIATED_DRUG_OR_BIO_3)
  private String ndcOfAssociatedCoveredDrugOrBiological3;

  @JsonProperty(Column.NDC_OF_ASSOCIATED_DRUG_OR_BIO_4)
  @CsvBindByName(column = Column.NDC_OF_ASSOCIATED_DRUG_OR_BIO_4)
  private String ndcOfAssociatedCoveredDrugOrBiological4;

  @JsonProperty(Column.NDC_OF_ASSOCIATED_DRUG_OR_BIO_5)
  @CsvBindByName(column = Column.NDC_OF_ASSOCIATED_DRUG_OR_BIO_5)
  private String ndcOfAssociatedCoveredDrugOrBiological5;

  @JsonProperty(Column.NAME_OF_ASSOCIATED_DEVICE_OR_SUPPLY_1)
  @CsvBindByName(column = Column.NAME_OF_ASSOCIATED_DEVICE_OR_SUPPLY_1)
  private String nameOfAssociatedCoveredDeviceOrMedicalSupply1;

  @JsonProperty(Column.NAME_OF_ASSOCIATED_DEVICE_OR_SUPPLY_2)
  @CsvBindByName(column = Column.NAME_OF_ASSOCIATED_DEVICE_OR_SUPPLY_2)
  private String nameOfAssociatedCoveredDeviceOrMedicalSupply2;

  @JsonProperty(Column.NAME_OF_ASSOCIATED_DEVICE_OR_SUPPLY_3)
  @CsvBindByName(column = Column.NAME_OF_ASSOCIATED_DEVICE_OR_SUPPLY_3)
  private String nameOfAssociatedCoveredDeviceOrMedicalSupply3;

  @JsonProperty(Column.NAME_OF_ASSOCIATED_DEVICE_OR_SUPPLY_4)
  @CsvBindByName(column = Column.NAME_OF_ASSOCIATED_DEVICE_OR_SUPPLY_4)
  private String nameOfAssociatedCoveredDeviceOrMedicalSupply4;

  @JsonProperty(Column.NAME_OF_ASSOCIATED_DEVICE_OR_SUPPLY_5)
  @CsvBindByName(column = Column.NAME_OF_ASSOCIATED_DEVICE_OR_SUPPLY_5)
  private String nameOfAssociatedCoveredDeviceOrMedicalSupply5;

  @JsonProperty(Column.PROGRAM_YEAR)
  @CsvBindByName(column = Column.PROGRAM_YEAR)
  private String programYear;

  @JsonProperty(Column.PAYMENT_PUBLICATION_DATE)
  @CsvBindByName(column = Column.PAYMENT_PUBLICATION_DATE)
  private String paymentPublicationDate;
}
