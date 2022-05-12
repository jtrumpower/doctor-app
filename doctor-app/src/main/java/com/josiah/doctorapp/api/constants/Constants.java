package com.josiah.doctorapp.api.constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Constants {

  @UtilityClass
  public class Column {
    public static final String RECORD_NUMBER = "record_number";
    public static final String CHANGE_TYPE = "change_type";
    public static final String COVERED_RECIPIENT_TYPE = "covered_recipient_type";
    public static final String TEACHING_HOSPITAL_CCN = "teaching_hospital_ccn";
    public static final String TEACHING_HOSPITAL_ID = "teaching_hospital_id";
    public static final String TEACHING_HOSPITAL_NAME = "teaching_hospital_name";
    public static final String PHYSICIAN_PROFILE_ID = "physician_profile_id";
    public static final String PHYSICIAN_FIRST_NAME = "physician_first_name";
    public static final String PHYSICIAN_MIDDLE_NAME = "physician_middle_name";
    public static final String PHYSICIAN_LAST_NAME = "physician_last_name";
    public static final String PHYSICIAN_NAME_SUFFIX = "physician_name_suffix";
    public static final String RECIPIENT_PRIMARY_BUSINESS_STREET_1 = "recipient_primary_business_street_address_line1";
    public static final String RECIPIENT_PRIMARY_BUSINESS_STREET_2 = "recipient_primary_business_street_address_line2";
    public static final String RECIPIENT_CITY = "recipient_city";
    public static final String RECIPIENT_STATE = "recipient_state";
    public static final String RECIPIENT_ZIP_CODE = "recipient_zip_code";
    public static final String RECIPIENT_COUNTRY = "recipient_country";
    public static final String RECIPIENT_PROVINCE = "recipient_province";
    public static final String RECIPIENT_POSTAL_CODE = "recipient_postal_code";
    public static final String PHYSICIAN_PRIMARY_TYPE = "physician_primary_type";
    public static final String PHYSICIAN_SPECIALTY = "physician_specialty";
    public static final String PHYSICIAN_LICENSE_STATE_CODE_1 = "physician_license_state_code1";
    public static final String PHYSICIAN_LICENSE_STATE_CODE_2 = "physician_license_state_code2";
    public static final String PHYSICIAN_LICENSE_STATE_CODE_3 = "physician_license_state_code3";
    public static final String PHYSICIAN_LICENSE_STATE_CODE_4 = "physician_license_state_code4";
    public static final String PHYSICIAN_LICENSE_STATE_CODE_5 = "physician_license_state_code5";
    public static final String SUBMITTING_APPLICABLE_MAN_OR_GPO_NAME = "submitting_applicable_manufacturer_or_applicable_gpo_name";
    public static final String APPLICABLE_MAN_OR_GPO_PAYMENT_ID = "applicable_manufacturer_or_applicable_gpo_making_payment_id";
    public static final String APPLICABLE_MAN_OR_GPO_PAYMENT_NAME = "applicable_manufacturer_or_applicable_gpo_making_payment_name";
    public static final String APPLICABLE_MAN_OR_GPO_PAYMENT_STATE = "applicable_manufacturer_or_applicable_gpo_making_payment_state";
    public static final String APPLICABLE_MAN_OR_GPO_PAYMENT_COUNTRY = "applicable_manufacturer_or_applicable_gpo_making_payment_country";
    public static final String TOTAL_PAYMENT_DOLLARS = "total_amount_of_payment_usdollars";
    public static final String DATE_OF_PAYMENT = "date_of_payment";
    public static final String NUMBER_OF_PAYMENTS_IN_TOTAL = "number_of_payments_included_in_total_amount";
    public static final String FORM_OF_PAYMENT = "form_of_payment_or_transfer_of_value";
    public static final String NATURE_OF_PAYMENT = "nature_of_payment_or_transfer_of_value";
    public static final String CITY_OF_TRAVEL = "city_of_travel";
    public static final String STATE_OF_TRAVEL = "state_of_travel";
    public static final String COUNTRY_OF_TRAVEL = "country_of_travel";
    public static final String PHYSICIAN_OWNERSHIP_INDICATOR = "physician_ownership_indicator";
    public static final String THIRD_PARTY_PAYMENT_RECIPIENT_IND = "third_party_payment_recipient_indicator";
    public static final String NAME_OF_ENTITY_RECEIVING_PAYMENT = "name_of_third_party_entity_receiving_payment_or_transfer_of_ccfc";
    public static final String CHARITY_INDICATOR = "charity_indicator";
    public static final String THIRD_PARTY_EQUALS_COVERED_RECIPIENT_IND = "third_party_equals_covered_recipient_indicator";
    public static final String CONTEXTUAL_INFORMATION = "contextual_information";
    public static final String DELAY_IN_PUBLICATION_IND = "delay_in_publication_indicator";
    public static final String RECORD_ID = "record_id";
    public static final String DISPUTE_STATUS_FOR_PUBLICATION = "dispute_status_for_publication";
    public static final String PRODUCT_INDICATOR = "product_indicator";
    public static final String NAME_OF_ASSOCIATED_DRUG_OR_BIO_1 = "name_of_associated_covered_drug_or_biological1";
    public static final String NAME_OF_ASSOCIATED_DRUG_OR_BIO_2 = "name_of_associated_covered_drug_or_biological2";
    public static final String NAME_OF_ASSOCIATED_DRUG_OR_BIO_3 = "name_of_associated_covered_drug_or_biological3";
    public static final String NAME_OF_ASSOCIATED_DRUG_OR_BIO_4 = "name_of_associated_covered_drug_or_biological4";
    public static final String NAME_OF_ASSOCIATED_DRUG_OR_BIO_5 = "name_of_associated_covered_drug_or_biological5";
    public static final String NDC_OF_ASSOCIATED_DRUG_OR_BIO_1 = "ndc_of_associated_covered_drug_or_biological1";
    public static final String NDC_OF_ASSOCIATED_DRUG_OR_BIO_2 = "ndc_of_associated_covered_drug_or_biological2";
    public static final String NDC_OF_ASSOCIATED_DRUG_OR_BIO_3 = "ndc_of_associated_covered_drug_or_biological3";
    public static final String NDC_OF_ASSOCIATED_DRUG_OR_BIO_4 = "ndc_of_associated_covered_drug_or_biological4";
    public static final String NDC_OF_ASSOCIATED_DRUG_OR_BIO_5 = "ndc_of_associated_covered_drug_or_biological5";
    public static final String NAME_OF_ASSOCIATED_DEVICE_OR_SUPPLY_1 = "name_of_associated_covered_device_or_medical_supply1";
    public static final String NAME_OF_ASSOCIATED_DEVICE_OR_SUPPLY_2 = "name_of_associated_covered_device_or_medical_supply2";
    public static final String NAME_OF_ASSOCIATED_DEVICE_OR_SUPPLY_3 = "name_of_associated_covered_device_or_medical_supply3";
    public static final String NAME_OF_ASSOCIATED_DEVICE_OR_SUPPLY_4 = "name_of_associated_covered_device_or_medical_supply4";
    public static final String NAME_OF_ASSOCIATED_DEVICE_OR_SUPPLY_5 = "name_of_associated_covered_device_or_medical_supply5";
    public static final String PROGRAM_YEAR = "program_year";
    public static final String PAYMENT_PUBLICATION_DATE = "payment_publication_date";
  }

  @UtilityClass
  public class CsvColumn {
    public static final String RECORD_NUMBER = "recordNumber";
    public static final String CHANGE_TYPE = "changeType";
    public static final String COVERED_RECIPIENT_TYPE = "coveredRecipientType";
    public static final String TEACHING_HOSPITAL_CCN = "teachingHospitalCCN";
    public static final String TEACHING_HOSPITAL_ID = "teachingHospitalId";
    public static final String TEACHING_HOSPITAL_NAME = "teachingHospitalName";
    public static final String PHYSICIAN_PROFILE_ID = "physicianProfileId";
    public static final String PHYSICIAN_FIRST_NAME = "physicianFirstName";
    public static final String PHYSICIAN_MIDDLE_NAME = "physicianMiddleName";
    public static final String PHYSICIAN_LAST_NAME = "physicianLastName";
    public static final String PHYSICIAN_NAME_SUFFIX = "physicianNameSuffix";
    public static final String RECIPIENT_PRIMARY_BUSINESS_STREET_1 = "recipientPrimaryBusinessStreet1";
    public static final String RECIPIENT_PRIMARY_BUSINESS_STREET_2 = "recipientPrimaryBusinessStreet2";
    public static final String RECIPIENT_CITY = "recipientCity";
    public static final String RECIPIENT_STATE = "recipientState";
    public static final String RECIPIENT_ZIP_CODE = "recipientZipCode";
    public static final String RECIPIENT_COUNTRY = "recipientCountry";
    public static final String RECIPIENT_PROVINCE = "recipientProvince";
    public static final String RECIPIENT_POSTAL_CODE = "recipientPostalCode";
    public static final String PHYSICIAN_PRIMARY_TYPE = "physicianPrimaryType";
    public static final String PHYSICIAN_SPECIALTY = "physicianSpecialty";
    public static final String PHYSICIAN_LICENSE_STATE_CODE_1 = "physicianLicenseStateCode1";
    public static final String PHYSICIAN_LICENSE_STATE_CODE_2 = "physicianLicenseStateCode2";
    public static final String PHYSICIAN_LICENSE_STATE_CODE_3 = "physicianLicenseStateCode3";
    public static final String PHYSICIAN_LICENSE_STATE_CODE_4 = "physicianLicenseStateCode4";
    public static final String PHYSICIAN_LICENSE_STATE_CODE_5 = "physicianLicenseStateCode5";
    public static final String SUBMITTING_APPLICABLE_MAN_OR_GPO_NAME = "submittingApplicableManufacturerOrGpoName";
    public static final String APPLICABLE_MAN_OR_GPO_PAYMENT_ID = "applicableManufacturerOrGpoPaymentId";
    public static final String APPLICABLE_MAN_OR_GPO_PAYMENT_NAME = "applicableManufacturerOrGpoPaymentName";
    public static final String APPLICABLE_MAN_OR_GPO_PAYMENT_STATE = "applicableManufacturerOrGpoPaymentState";
    public static final String APPLICABLE_MAN_OR_GPO_PAYMENT_COUNTRY = "applicableManufacturerOrGpoPaymentCountry";
    public static final String TOTAL_PAYMENT_DOLLARS = "totalAmountOfPaymentUsDollars";
    public static final String DATE_OF_PAYMENT = "dateOfPayment";
    public static final String NUMBER_OF_PAYMENTS_IN_TOTAL = "numberOfPaymentsInTotalAmount";
    public static final String FORM_OF_PAYMENT = "formOfPaymentOrTransferOfValue";
    public static final String NATURE_OF_PAYMENT = "natureOfPaymentOrTransferOfValue";
    public static final String CITY_OF_TRAVEL = "cityOfTravel";
    public static final String STATE_OF_TRAVEL = "stateOfTravel";
    public static final String COUNTRY_OF_TRAVEL = "countryOfTravel";
    public static final String PHYSICIAN_OWNERSHIP_INDICATOR = "physicianOwnershipIndicator";
    public static final String THIRD_PARTY_PAYMENT_RECIPIENT_IND = "thirdPartyPaymentRecipientIndicator";
    public static final String NAME_OF_ENTITY_RECEIVING_PAYMENT = "nameOfEntityReceivingPaymentOrTransferOfValue";
    public static final String CHARITY_INDICATOR = "charityIndicator";
    public static final String THIRD_PARTY_EQUALS_COVERED_RECIPIENT_IND = "thirdPartyEqualsCoveredRecipientIndicator";
    public static final String CONTEXTUAL_INFORMATION = "contextualInformation";
    public static final String DELAY_IN_PUBLICATION_IND = "delayInPublicationIndicator";
    public static final String RECORD_ID = "recordId";
    public static final String DISPUTE_STATUS_FOR_PUBLICATION = "disputeStatusForPublication";
    public static final String PRODUCT_INDICATOR = "productIndicator";
    public static final String NAME_OF_ASSOCIATED_DRUG_OR_BIO_1 = "nameOfAssociatedCoveredDrugOrBiological1";
    public static final String NAME_OF_ASSOCIATED_DRUG_OR_BIO_2 = "nameOfAssociatedCoveredDrugOrBiological2";
    public static final String NAME_OF_ASSOCIATED_DRUG_OR_BIO_3 = "nameOfAssociatedCoveredDrugOrBiological3";
    public static final String NAME_OF_ASSOCIATED_DRUG_OR_BIO_4 = "nameOfAssociatedCoveredDrugOrBiological4";
    public static final String NAME_OF_ASSOCIATED_DRUG_OR_BIO_5 = "nameOfAssociatedCoveredDrugOrBiological5";
    public static final String NDC_OF_ASSOCIATED_DRUG_OR_BIO_1 = "ndcOfAssociatedCoveredDrugOrBiological1";
    public static final String NDC_OF_ASSOCIATED_DRUG_OR_BIO_2 = "ndcOfAssociatedCoveredDrugOrBiological2";
    public static final String NDC_OF_ASSOCIATED_DRUG_OR_BIO_3 = "ndcOfAssociatedCoveredDrugOrBiological3";
    public static final String NDC_OF_ASSOCIATED_DRUG_OR_BIO_4 = "ndcOfAssociatedCoveredDrugOrBiological4";
    public static final String NDC_OF_ASSOCIATED_DRUG_OR_BIO_5 = "ndcOfAssociatedCoveredDrugOrBiological5";
    public static final String NAME_OF_ASSOCIATED_DEVICE_OR_SUPPLY_1 = "nameOfAssociatedCoveredDeviceOrMedicalSupply1";
    public static final String NAME_OF_ASSOCIATED_DEVICE_OR_SUPPLY_2 = "nameOfAssociatedCoveredDeviceOrMedicalSupply2";
    public static final String NAME_OF_ASSOCIATED_DEVICE_OR_SUPPLY_3 = "nameOfAssociatedCoveredDeviceOrMedicalSupply3";
    public static final String NAME_OF_ASSOCIATED_DEVICE_OR_SUPPLY_4 = "nameOfAssociatedCoveredDeviceOrMedicalSupply4";
    public static final String NAME_OF_ASSOCIATED_DEVICE_OR_SUPPLY_5 = "nameOfAssociatedCoveredDeviceOrMedicalSupply5";
    public static final String PROGRAM_YEAR = "programYear";
    public static final String PAYMENT_PUBLICATION_DATE = "paymentPublicationDate";
  }


  public static final String[] CSV_ROW_ORDER = {
      Column.RECORD_NUMBER,
      Column.CHANGE_TYPE,
      Column.COVERED_RECIPIENT_TYPE,
      Column.TEACHING_HOSPITAL_CCN,
      Column.TEACHING_HOSPITAL_ID,
      Column.TEACHING_HOSPITAL_NAME,
      Column.PHYSICIAN_PROFILE_ID,
      Column.PHYSICIAN_FIRST_NAME,
      Column.PHYSICIAN_MIDDLE_NAME,
      Column.PHYSICIAN_LAST_NAME,
      Column.PHYSICIAN_NAME_SUFFIX,
      Column.RECIPIENT_PRIMARY_BUSINESS_STREET_1,
      Column.RECIPIENT_PRIMARY_BUSINESS_STREET_2,
      Column.RECIPIENT_CITY,
      Column.RECIPIENT_STATE,
      Column.RECIPIENT_ZIP_CODE,
      Column.RECIPIENT_COUNTRY,
      Column.RECIPIENT_PROVINCE,
      Column.RECIPIENT_POSTAL_CODE,
      Column.PHYSICIAN_PRIMARY_TYPE,
      Column.PHYSICIAN_SPECIALTY,
      Column.PHYSICIAN_LICENSE_STATE_CODE_1,
      Column.PHYSICIAN_LICENSE_STATE_CODE_2,
      Column.PHYSICIAN_LICENSE_STATE_CODE_3,
      Column.PHYSICIAN_LICENSE_STATE_CODE_4,
      Column.PHYSICIAN_LICENSE_STATE_CODE_5,
      Column.SUBMITTING_APPLICABLE_MAN_OR_GPO_NAME,
      Column.APPLICABLE_MAN_OR_GPO_PAYMENT_ID,
      Column.APPLICABLE_MAN_OR_GPO_PAYMENT_NAME,
      Column.APPLICABLE_MAN_OR_GPO_PAYMENT_STATE,
      Column.APPLICABLE_MAN_OR_GPO_PAYMENT_COUNTRY,
      Column.TOTAL_PAYMENT_DOLLARS,
      Column.DATE_OF_PAYMENT,
      Column.NUMBER_OF_PAYMENTS_IN_TOTAL,
      Column.FORM_OF_PAYMENT,
      Column.NATURE_OF_PAYMENT,
      Column.CITY_OF_TRAVEL,
      Column.STATE_OF_TRAVEL,
      Column.COUNTRY_OF_TRAVEL,
      Column.PHYSICIAN_OWNERSHIP_INDICATOR,
      Column.THIRD_PARTY_PAYMENT_RECIPIENT_IND,
      Column.NAME_OF_ENTITY_RECEIVING_PAYMENT,
      Column.CHARITY_INDICATOR,
      Column.THIRD_PARTY_EQUALS_COVERED_RECIPIENT_IND,
      Column.CONTEXTUAL_INFORMATION,
      Column.DELAY_IN_PUBLICATION_IND,
      Column.RECORD_ID,
      Column.DISPUTE_STATUS_FOR_PUBLICATION,
      Column.PRODUCT_INDICATOR,
      Column.NAME_OF_ASSOCIATED_DRUG_OR_BIO_1,
      Column.NAME_OF_ASSOCIATED_DRUG_OR_BIO_2,
      Column.NAME_OF_ASSOCIATED_DRUG_OR_BIO_3,
      Column.NAME_OF_ASSOCIATED_DRUG_OR_BIO_4,
      Column.NAME_OF_ASSOCIATED_DRUG_OR_BIO_5,
      Column.NDC_OF_ASSOCIATED_DRUG_OR_BIO_1,
      Column.NDC_OF_ASSOCIATED_DRUG_OR_BIO_2,
      Column.NDC_OF_ASSOCIATED_DRUG_OR_BIO_3,
      Column.NDC_OF_ASSOCIATED_DRUG_OR_BIO_4,
      Column.NDC_OF_ASSOCIATED_DRUG_OR_BIO_5,
      Column.NAME_OF_ASSOCIATED_DEVICE_OR_SUPPLY_1,
      Column.NAME_OF_ASSOCIATED_DEVICE_OR_SUPPLY_2,
      Column.NAME_OF_ASSOCIATED_DEVICE_OR_SUPPLY_3,
      Column.NAME_OF_ASSOCIATED_DEVICE_OR_SUPPLY_4,
      Column.NAME_OF_ASSOCIATED_DEVICE_OR_SUPPLY_5,
      Column.PROGRAM_YEAR,
      Column.PAYMENT_PUBLICATION_DATE
  };
}
