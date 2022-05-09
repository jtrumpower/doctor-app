package com.josiah.doctorapp.service.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({
    "changeType",
    "coveredRecipientType",
    "teachingHospitalCCN",
    "teachingHospitalId",
    "teachingHospitalName",
    "physicianProfileId",
    "physicianFirstName",
    "physicianMiddleName",
    "physicianLastName",
    "physicianNameSuffix",
    "recipientPrimaryBusinessStreet1",
    "recipientPrimaryBusinessStreet2",
    "recipientCity",
    "recipientState",
    "recipientZipCode",
    "recipientCountry",
    "recipientProvince",
    "recipientPostalCode",
    "physicianPrimaryType",
    "physicianSpecialty",
    "physicianLicenseStateCode1",
    "physicianLicenseStateCode2",
    "physicianLicenseStateCode3",
    "physicianLicenseStateCode4",
    "physicianLicenseStateCode5",
    "submittingApplicableManufacturerOrGpoName",
    "applicableManufacturerOrGpoPaymentId",
    "applicableManufacturerOrGpoPaymentName",
    "applicableManufacturerOrGpoPaymentState",
    "applicableManufacturerOrGpoPaymentCountry",
    "totalAmountOfPaymentUsDollars",
    "dateOfPayment",
    "numberOfPaymentsInTotalAmount",
    "formOfPaymentOrTransferOfValue",
    "natureOfPaymentOrTransferOfValue",
    "cityOfTravel",
    "stateOfTravel",
    "countryOfTravel",
    "physicianOwnershipIndicator",
    "thirdPartyPaymentRecipientIndicator",
    "nameOfEntityReceivingPaymentOrTransferOfValue",
    "charityIndicator",
    "thirdPartyEqualsCoveredRecipientIndicator",
    "contextualInformation",
    "delayInPublicationIndicator",
    "recordId",
    "disputeStatusForPublication",
    "productIndicator",
    "nameOfAssociatedCoveredDrugOrBiological1",
    "nameOfAssociatedCoveredDrugOrBiological2",
    "nameOfAssociatedCoveredDrugOrBiological3",
    "nameOfAssociatedCoveredDrugOrBiological4",
    "nameOfAssociatedCoveredDrugOrBiological5",
    "ndcOfAssociatedCoveredDrugOrBiological1",
    "ndcOfAssociatedCoveredDrugOrBiological2",
    "ndcOfAssociatedCoveredDrugOrBiological3",
    "ndcOfAssociatedCoveredDrugOrBiological4",
    "ndcOfAssociatedCoveredDrugOrBiological5",
    "nameOfAssociatedCoveredDeviceOrMedicalSupply1",
    "nameOfAssociatedCoveredDeviceOrMedicalSupply2",
    "nameOfAssociatedCoveredDeviceOrMedicalSupply3",
    "nameOfAssociatedCoveredDeviceOrMedicalSupply4",
    "nameOfAssociatedCoveredDeviceOrMedicalSupply5",
    "programYear",
    "paymentPublicationDate"
})
public class GeneralRow {
  @JsonProperty("change_type")
  private String changeType;
  @JsonProperty("covered_recipient_type")
  private String coveredRecipientType;
  @JsonProperty("teaching_hospital_ccn")
  private String teachingHospitalCCN;
  @JsonProperty("teaching_hospital_id")
  private String teachingHospitalId;
  @JsonProperty("teaching_hospital_name")
  private String teachingHospitalName;
  @JsonProperty("physician_profile_id")
  private String physicianProfileId;
  @JsonProperty("physician_first_name")
  private String physicianFirstName;
  @JsonProperty("physician_middle_name")
  private String physicianMiddleName;
  @JsonProperty("physician_last_name")
  private String physicianLastName;
  @JsonProperty("physician_name_suffix")
  private String physicianNameSuffix;
  @JsonProperty("recipient_primary_business_street_address_line1")
  private String recipientPrimaryBusinessStreet1;
  @JsonProperty("recipient_primary_business_street_address_line2")
  private String recipientPrimaryBusinessStreet2;
  @JsonProperty("recipient_city")
  private String recipientCity;
  @JsonProperty("recipient_state")
  private String recipientState;
  @JsonProperty("recipient_zip_code")
  private String recipientZipCode;
  @JsonProperty("recipient_country")
  private String recipientCountry;
  @JsonProperty("recipient_province")
  private String recipientProvince;
  @JsonProperty("recipient_postal_code")
  private String recipientPostalCode;
  @JsonProperty("physician_primary_type")
  private String physicianPrimaryType;
  @JsonProperty("physician_specialty")
  private String physicianSpecialty;
  @JsonProperty("physician_license_state_code1")
  private String physicianLicenseStateCode1;
  @JsonProperty("physician_license_state_code2")
  private String physicianLicenseStateCode2;
  @JsonProperty("physician_license_state_code3")
  private String physicianLicenseStateCode3;
  @JsonProperty("physician_license_state_code4")
  private String physicianLicenseStateCode4;
  @JsonProperty("physician_license_state_code5")
  private String physicianLicenseStateCode5;
  @JsonProperty("submitting_applicable_manufacturer_or_applicable_gpo_name")
  private String submittingApplicableManufacturerOrGpoName;
  @JsonProperty("applicable_manufacturer_or_applicable_gpo_making_payment_id")
  private String applicableManufacturerOrGpoPaymentId;
  @JsonProperty("applicable_manufacturer_or_applicable_gpo_making_payment_name")
  private String applicableManufacturerOrGpoPaymentName;
  @JsonProperty("applicable_manufacturer_or_applicable_gpo_making_payment_state")
  private String applicableManufacturerOrGpoPaymentState;
  @JsonProperty("applicable_manufacturer_or_applicable_gpo_making_payment_country")
  private String applicableManufacturerOrGpoPaymentCountry;
  @JsonProperty("total_amount_of_payment_usdollars")
  private double totalAmountOfPaymentUsDollars;
  @JsonProperty("date_of_payment")
  private String dateOfPayment;
  @JsonProperty("number_of_payments_included_in_total_amount")
  private int numberOfPaymentsInTotalAmount;
  @JsonProperty("form_of_payment_or_transfer_of_value")
  private String formOfPaymentOrTransferOfValue;
  @JsonProperty("nature_of_payment_or_transfer_of_value")
  private String natureOfPaymentOrTransferOfValue;
  @JsonProperty("city_of_travel")
  private String cityOfTravel;
  @JsonProperty("state_of_travel")
  private String stateOfTravel;
  @JsonProperty("country_of_travel")
  private String countryOfTravel;
  @JsonProperty("physician_ownership_indicator")
  private String physicianOwnershipIndicator;
  @JsonProperty("third_party_payment_recipient_indicator")
  private String thirdPartyPaymentRecipientIndicator;
  @JsonProperty("name_of_third_party_entity_receiving_payment_or_transfer_of_ccfc")
  private String nameOfEntityReceivingPaymentOrTransferOfValue;
  @JsonProperty("charity_indicator")
  private String charityIndicator;
  @JsonProperty("third_party_equals_covered_recipient_indicator")
  private String thirdPartyEqualsCoveredRecipientIndicator;
  @JsonProperty("contextual_information")
  private String contextualInformation;
  @JsonProperty("delay_in_publication_indicator")
  private String delayInPublicationIndicator;
  @JsonProperty("record_id")
  private long recordId;
  @JsonProperty("dispute_status_for_publication")
  private String disputeStatusForPublication;
  @JsonProperty("product_indicator")
  private String productIndicator;
  @JsonProperty("name_of_associated_covered_drug_or_biological1")
  private String nameOfAssociatedCoveredDrugOrBiological1;
  @JsonProperty("name_of_associated_covered_drug_or_biological2")
  private String nameOfAssociatedCoveredDrugOrBiological2;
  @JsonProperty("name_of_associated_covered_drug_or_biological3")
  private String nameOfAssociatedCoveredDrugOrBiological3;
  @JsonProperty("name_of_associated_covered_drug_or_biological4")
  private String nameOfAssociatedCoveredDrugOrBiological4;
  @JsonProperty("name_of_associated_covered_drug_or_biological5")
  private String nameOfAssociatedCoveredDrugOrBiological5;
  @JsonProperty("ndc_of_associated_covered_drug_or_biological1")
  private String ndcOfAssociatedCoveredDrugOrBiological1;
  @JsonProperty("ndc_of_associated_covered_drug_or_biological2")
  private String ndcOfAssociatedCoveredDrugOrBiological2;
  @JsonProperty("ndc_of_associated_covered_drug_or_biological3")
  private String ndcOfAssociatedCoveredDrugOrBiological3;
  @JsonProperty("ndc_of_associated_covered_drug_or_biological4")
  private String ndcOfAssociatedCoveredDrugOrBiological4;
  @JsonProperty("ndc_of_associated_covered_drug_or_biological5")
  private String ndcOfAssociatedCoveredDrugOrBiological5;
  @JsonProperty("name_of_associated_covered_device_or_medical_supply1")
  private String nameOfAssociatedCoveredDeviceOrMedicalSupply1;
  @JsonProperty("name_of_associated_covered_device_or_medical_supply2")
  private String nameOfAssociatedCoveredDeviceOrMedicalSupply2;
  @JsonProperty("name_of_associated_covered_device_or_medical_supply3")
  private String nameOfAssociatedCoveredDeviceOrMedicalSupply3;
  @JsonProperty("name_of_associated_covered_device_or_medical_supply4")
  private String nameOfAssociatedCoveredDeviceOrMedicalSupply4;
  @JsonProperty("name_of_associated_covered_device_or_medical_supply5")
  private String nameOfAssociatedCoveredDeviceOrMedicalSupply5;
  @JsonProperty("program_year")
  private String programYear;
  @JsonProperty("payment_publication_date")
  private String paymentPublicationDate;
}
