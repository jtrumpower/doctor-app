package com.josiah.doctorapp.api.constants;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import lombok.experimental.UtilityClass;

public class Constants {

  public static class Column {
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
    public static final String NAME_OF_ENTITY_RECEIVING_PAYMENT_ACTUAL = "name_of_third_party_entity_receiving_payment_or_transfer_of_value";
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

  public static final List<String> WHITELIST = new ArrayList<>();

  static {
    Class<Column> columnClass = Column.class;
    for (Field field : columnClass.getDeclaredFields()) {
      try {
        WHITELIST.add((String) field.get(columnClass));
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      }
    }
  }

}
