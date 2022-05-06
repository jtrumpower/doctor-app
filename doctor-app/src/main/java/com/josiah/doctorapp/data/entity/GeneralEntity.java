package com.josiah.doctorapp.data.entity;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "general_data")
public class GeneralEntity {
  @Id
  @Column(name = "record_number")
  private long recordNumber;
  @Column(name = "change_type")
  private String changeType;
  @Column(name = "covered_recipient_type")
  private String coveredRecipientType;
  @Column(name = "teaching_hospital_ccn")
  private String teachingHospitalCCN;
  @Column(name = "teaching_hospital_id")
  private String teachingHospitalId;
  @Column(name = "teaching_hospital_name")
  private String teachingHospitalName;
  @Column(name = "physician_profile_id")
  private String physicianProfileId;
  @Column(name = "physician_first_name")
  private String physicianFirstName;
  @Column(name = "physician_middle_name")
  private String physicianMiddleName;
  @Column(name = "physician_last_name")
  private String physicianLastName;
  @Column(name = "physician_name_suffix")
  private String physicianNameSuffix;
  @Column(name = "recipient_primary_business_street_address_line1")
  private String recipientPrimaryBusinessStreet1;
  @Column(name = "recipient_primary_business_street_address_line2")
  private String recipientPrimaryBusinessStreet2;
  @Column(name = "recipient_city")
  private String recipientCity;
  @Column(name = "recipient_state")
  private String recipientState;
  @Column(name = "recipient_zip_code")
  private String recipientZipCode;
  @Column(name = "recipient_country")
  private String recipientCountry;
  @Column(name = "recipient_province")
  private String recipientProvince;
  @Column(name = "recipient_postal_code")
  private String recipientPostalCode;
  @Column(name = "physician_primary_type")
  private String physicianPrimaryType;
  @Column(name = "physician_specialty")
  private String physicianSpecialty;
  @Column(name = "physician_license_state_code1")
  private String physicianLicenseStateCode1;
  @Column(name = "physician_license_state_code2")
  private String physicianLicenseStateCode2;
  @Column(name = "physician_license_state_code3")
  private String physicianLicenseStateCode3;
  @Column(name = "physician_license_state_code4")
  private String physicianLicenseStateCode4;
  @Column(name = "physician_license_state_code5")
  private String physicianLicenseStateCode5;
  @Column(name = "submitting_applicable_manufacturer_or_applicable_gpo_name")
  private String submittingApplicableManufacturerOrGpoName;
  @Column(name = "applicable_manufacturer_or_applicable_gpo_making_payment_id")
  private long applicableManufacturerOrGpoPaymentId;
  @Column(name = "applicable_manufacturer_or_applicable_gpo_making_payment_name")
  private String applicableManufacturerOrGpoPaymentName;
  @Column(name = "applicable_manufacturer_or_applicable_gpo_making_payment_state")
  private String applicableManufacturerOrGpoPaymentState;
  @Column(name = "applicable_manufacturer_or_applicable_gpo_making_payment_country")
  private String applicableManufacturerOrGpoPaymentCountry;
  @Column(name = "total_amount_of_payment_usdollars")
  private double totalAmountOfPaymentUsDollars;
  @Column(name = "date_of_payment")
  private String dateOfPayment;
  @Column(name = "number_of_payments_included_in_total_amount")
  private int numberOfPaymentsInTotalAmount;
  @Column(name = "form_of_payment_or_transfer_of_value")
  private String formOfPaymentOrTransferOfValue;
  @Column(name = "nature_of_payment_or_transfer_of_value")
  private String natureOfPaymentOrTransferOfValue;
  @Column(name = "city_of_travel")
  private String cityOfTravel;
  @Column(name = "state_of_travel")
  private String stateOfTravel;
  @Column(name = "country_of_travel")
  private String countryOfTravel;
  @Column(name = "physician_ownership_indicator")
  private String physicianOwnershipIndicator;
  @Column(name = "third_party_payment_recipient_indicator")
  private String thirdPartyPaymentRecipientIndicator;
  @Column(name = "name_of_third_party_entity_receiving_payment_or_transfer_of_ccfc")
  private String nameOfEntityReceivingPaymentOrTransferOfValue;
  @Column(name = "charity_indicator")
  private String charityIndicator;
  @Column(name = "third_party_equals_covered_recipient_indicator")
  private String thirdPartyEqualsCoveredRecipientIndicator;
  @Column(name = "contextual_information")
  private String contextualInformation;
  @Column(name = "delay_in_publication_indicator")
  private String delayInPublicationIndicator;
  @Column(name = "record_id")
  private long recordId;
  @Column(name = "dispute_status_for_publication")
  private String disputeStatusForPublication;
  @Column(name = "product_indicator")
  private String productIndicator;
  @Column(name = "name_of_associated_covered_drug_or_biological1")
  private String nameOfAssociatedCoveredDrugOrBiological1;
  @Column(name = "name_of_associated_covered_drug_or_biological2")
  private String nameOfAssociatedCoveredDrugOrBiological2;
  @Column(name = "name_of_associated_covered_drug_or_biological3")
  private String nameOfAssociatedCoveredDrugOrBiological3;
  @Column(name = "name_of_associated_covered_drug_or_biological4")
  private String nameOfAssociatedCoveredDrugOrBiological4;
  @Column(name = "name_of_associated_covered_drug_or_biological5")
  private String nameOfAssociatedCoveredDrugOrBiological5;
  @Column(name = "ndc_of_associated_covered_drug_or_biological1")
  private String ndcOfAssociatedCoveredDrugOrBiological1;
  @Column(name = "ndc_of_associated_covered_drug_or_biological2")
  private String ndcOfAssociatedCoveredDrugOrBiological2;
  @Column(name = "ndc_of_associated_covered_drug_or_biological3")
  private String ndcOfAssociatedCoveredDrugOrBiological3;
  @Column(name = "ndc_of_associated_covered_drug_or_biological4")
  private String ndcOfAssociatedCoveredDrugOrBiological4;
  @Column(name = "ndc_of_associated_covered_drug_or_biological5")
  private String ndcOfAssociatedCoveredDrugOrBiological5;
  @Column(name = "name_of_associated_covered_device_or_medical_supply1")
  private String nameOfAssociatedCoveredDeviceOrMedicalSupply1;
  @Column(name = "name_of_associated_covered_device_or_medical_supply2")
  private String nameOfAssociatedCoveredDeviceOrMedicalSupply2;
  @Column(name = "name_of_associated_covered_device_or_medical_supply3")
  private String nameOfAssociatedCoveredDeviceOrMedicalSupply3;
  @Column(name = "name_of_associated_covered_device_or_medical_supply4")
  private String nameOfAssociatedCoveredDeviceOrMedicalSupply4;
  @Column(name = "name_of_associated_covered_device_or_medical_supply5")
  private String nameOfAssociatedCoveredDeviceOrMedicalSupply5;
  @Column(name = "program_year")
  private String programYear;
  @Column(name = "payment_publication_date")
  private String paymentPublicationDate;
}
