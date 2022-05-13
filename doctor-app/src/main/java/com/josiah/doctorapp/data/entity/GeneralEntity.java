package com.josiah.doctorapp.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
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
@Table(name = "general_data",
    indexes = {
        @Index(name = "record_id_idx", columnList = "record_id", unique = true),
        @Index(name = "change_type_idx", columnList = "change_type"),
        @Index(name = "nature_idx", columnList = "nature_of_payment_or_transfer_of_value"),
        @Index(name = "form_idx", columnList = "form_of_payment_or_transfer_of_value"),
        @Index(name = "first_name_idx", columnList = "physician_first_name"),
        @Index(name = "last_name_idx", columnList = "physician_last_name"),
        @Index(name = "primary_type_idx", columnList = "physician_primary_type"),
    })
public class GeneralEntity {

  @Id
  @Column(name = "record_id", columnDefinition = "bigint not null")
  private long recordId;
  @Column(name = "change_type", columnDefinition = "varchar(20)")
  private String changeType;
  @Column(name = "covered_recipient_type", columnDefinition = "varchar(50)")
  private String coveredRecipientType;
  @Column(name = "teaching_hospital_ccn", columnDefinition = "varchar(255)")
  private String teachingHospitalCcn;
  @Column(name = "teaching_hospital_id", columnDefinition = "varchar(255)")
  private String teachingHospitalId;
  @Column(name = "teaching_hospital_name", columnDefinition = "varchar(50)")
  private String teachingHospitalName;
  @Column(name = "physician_profile_id", columnDefinition = "varchar(255)")
  private String physicianProfileId;
  @Column(name = "physician_first_name", columnDefinition = "varchar(50)")
  private String physicianFirstName;
  @Column(name = "physician_middle_name", columnDefinition = "varchar(50)")
  private String physicianMiddleName;
  @Column(name = "physician_last_name", columnDefinition = "varchar(50)")
  private String physicianLastName;
  @Column(name = "physician_name_suffix", columnDefinition = "varchar(6)")
  private String physicianNameSuffix;
  @Column(name = "recipient_primary_business_street_address_line1", columnDefinition = "varchar(70)")
  private String recipientPrimaryBusinessStreet1;
  @Column(name = "recipient_primary_business_street_address_line2", columnDefinition = "varchar(70)")
  private String recipientPrimaryBusinessStreet2;
  @Column(name = "recipient_city", columnDefinition = "varchar(50)")
  private String recipientCity;
  @Column(name = "recipient_state", columnDefinition = "varchar(5)")
  private String recipientState;
  @Column(name = "recipient_zip_code", columnDefinition = "varchar(12)")
  private String recipientZipCode;
  @Column(name = "recipient_country", columnDefinition = "varchar(50)")
  private String recipientCountry;
  @Column(name = "recipient_province", columnDefinition = "varchar(30)")
  private String recipientProvince;
  @Column(name = "recipient_postal_code", columnDefinition = "varchar(12)")
  private String recipientPostalCode;
  @Column(name = "physician_primary_type", columnDefinition = "varchar(30)")
  private String physicianPrimaryType;
  @Column(name = "physician_specialty", columnDefinition = "varchar(255)")
  private String physicianSpecialty;
  @Column(name = "physician_license_state_code1", columnDefinition = "varchar(5)")
  private String physicianLicenseStateCode1;
  @Column(name = "physician_license_state_code2", columnDefinition = "varchar(5)")
  private String physicianLicenseStateCode2;
  @Column(name = "physician_license_state_code3", columnDefinition = "varchar(5)")
  private String physicianLicenseStateCode3;
  @Column(name = "physician_license_state_code4", columnDefinition = "varchar(5)")
  private String physicianLicenseStateCode4;
  @Column(name = "physician_license_state_code5", columnDefinition = "varchar(5)")
  private String physicianLicenseStateCode5;
  @Column(name = "submitting_applicable_manufacturer_or_applicable_gpo_name", columnDefinition = "varchar(255)")
  private String submittingApplicableManufacturerOrApplicableGpoName;
  @Column(name = "applicable_manufacturer_or_applicable_gpo_making_payment_id", columnDefinition = "varchar(255)")
  private long applicableManufacturerOrApplicableGpoMakingPaymentId;
  @Column(name = "applicable_manufacturer_or_applicable_gpo_making_payment_name", columnDefinition = "varchar(100)")
  private String applicableManufacturerOrApplicableGpoMakingPaymentName;
  @Column(name = "applicable_manufacturer_or_applicable_gpo_making_payment_state", columnDefinition = "varchar(5)")
  private String applicableManufacturerOrApplicableGpoMakingPaymentState;
  @Column(name = "applicable_manufacturer_or_applicable_gpo_making_payment_country", columnDefinition = "varchar(50)")
  private String applicableManufacturerOrApplicableGpoMakingPaymentCountry;
  @Column(name = "total_amount_of_payment_usdollars", columnDefinition = "double")
  private double totalAmountOfPaymentUsdollars;
  @Column(name = "date_of_payment", columnDefinition = "varchar(15)")
  private String dateOfPayment;
  @Column(name = "number_of_payments_included_in_total_amount", columnDefinition = "int")
  private int numberOfPaymentsIncludedInTotalAmount;
  @Column(name = "form_of_payment_or_transfer_of_value", columnDefinition = "varchar(255)")
  private String formOfPaymentOrTransferOfValue;
  @Column(name = "nature_of_payment_or_transfer_of_value", columnDefinition = "varchar(255)")
  private String natureOfPaymentOrTransferOfValue;
  @Column(name = "city_of_travel", columnDefinition = "varchar(50)")
  private String cityOfTravel;
  @Column(name = "state_of_travel", columnDefinition = "varchar(5)")
  private String stateOfTravel;
  @Column(name = "country_of_travel", columnDefinition = "varchar(50)")
  private String countryOfTravel;
  @Column(name = "physician_ownership_indicator", columnDefinition = "varchar(3)")
  private String physicianOwnershipIndicator;
  @Column(name = "third_party_payment_recipient_indicator", columnDefinition = "varchar(255)")
  private String thirdPartyPaymentRecipientIndicator;
  @Column(name = "name_of_third_party_entity_receiving_payment_or_transfer_of_ccfc", columnDefinition = "varchar(50)")
  private String nameOfThirdPartyEntityReceivingPaymentOrTransferOfCcfc;
  @Column(name = "charity_indicator", columnDefinition = "varchar(3)")
  private String charityIndicator;
  @Column(name = "third_party_equals_covered_recipient_indicator", columnDefinition = "varchar(3)")
  private String thirdPartyEqualsCoveredRecipientIndicator;
  @Column(name = "contextual_information", columnDefinition = "mediumtext")
  private String contextualInformation;
  @Column(name = "delay_in_publication_indicator", columnDefinition = "varchar(3)")
  private String delayInPublicationIndicator;
  @Column(name = "dispute_status_for_publication", columnDefinition = "varchar(3)")
  private String disputeStatusForPublication;
  @Column(name = "product_indicator", columnDefinition = "varchar(15)")
  private String productIndicator;
  @Column(name = "name_of_associated_covered_drug_or_biological1", columnDefinition = "varchar(255)")
  private String nameOfAssociatedCoveredDrugOrBiological1;
  @Column(name = "name_of_associated_covered_drug_or_biological2", columnDefinition = "varchar(255)")
  private String nameOfAssociatedCoveredDrugOrBiological2;
  @Column(name = "name_of_associated_covered_drug_or_biological3", columnDefinition = "varchar(255)")
  private String nameOfAssociatedCoveredDrugOrBiological3;
  @Column(name = "name_of_associated_covered_drug_or_biological4", columnDefinition = "varchar(255)")
  private String nameOfAssociatedCoveredDrugOrBiological4;
  @Column(name = "name_of_associated_covered_drug_or_biological5", columnDefinition = "varchar(255)")
  private String nameOfAssociatedCoveredDrugOrBiological5;
  @Column(name = "ndc_of_associated_covered_drug_or_biological1", columnDefinition = "varchar(255)")
  private String ndcOfAssociatedCoveredDrugOrBiological1;
  @Column(name = "ndc_of_associated_covered_drug_or_biological2", columnDefinition = "varchar(255)")
  private String ndcOfAssociatedCoveredDrugOrBiological2;
  @Column(name = "ndc_of_associated_covered_drug_or_biological3", columnDefinition = "varchar(255)")
  private String ndcOfAssociatedCoveredDrugOrBiological3;
  @Column(name = "ndc_of_associated_covered_drug_or_biological4", columnDefinition = "varchar(255)")
  private String ndcOfAssociatedCoveredDrugOrBiological4;
  @Column(name = "ndc_of_associated_covered_drug_or_biological5", columnDefinition = "varchar(255)")
  private String ndcOfAssociatedCoveredDrugOrBiological5;
  @Column(name = "name_of_associated_covered_device_or_medical_supply1", columnDefinition = "varchar(255)")
  private String nameOfAssociatedCoveredDeviceOrMedicalSupply1;
  @Column(name = "name_of_associated_covered_device_or_medical_supply2", columnDefinition = "varchar(255)")
  private String nameOfAssociatedCoveredDeviceOrMedicalSupply2;
  @Column(name = "name_of_associated_covered_device_or_medical_supply3", columnDefinition = "varchar(255)")
  private String nameOfAssociatedCoveredDeviceOrMedicalSupply3;
  @Column(name = "name_of_associated_covered_device_or_medical_supply4", columnDefinition = "varchar(255)")
  private String nameOfAssociatedCoveredDeviceOrMedicalSupply4;
  @Column(name = "name_of_associated_covered_device_or_medical_supply5", columnDefinition = "varchar(255)")
  private String nameOfAssociatedCoveredDeviceOrMedicalSupply5;
  @Column(name = "program_year", columnDefinition = "varchar(4)")
  private String programYear;
  @Column(name = "payment_publication_date", columnDefinition = "varchar(15)")
  private String paymentPublicationDate;
}
