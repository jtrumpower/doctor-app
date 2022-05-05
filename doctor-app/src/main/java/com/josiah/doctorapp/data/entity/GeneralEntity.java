package com.josiah.doctorapp.data.entity;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "general_data")
public class GeneralEntity {
  @Id
  @Column("record_number")
  private int recordNumber;
  @Column("change_type")
  private String changeType;
  @Column("covered_recipient_type")
  private String coveredRecipientType;
  @Column("teaching_hospital_ccn")
  private int teachingHospitalCCN;
  @Column("teaching_hospital_id")
  private int teachingHospitalId;
  @Column("teaching_hospital_name")
  private String teachingHospitalName;
  @Column("physician_profile_id")
  private int physicianProfileId;
  @Column("physician_first_name")
  private String physicianFirstName;
  @Column("physician_middle_name")
  private String physicianMiddleName;
  @Column("physician_last_name")
  private String physicianLastName;
  @Column("physician_name_suffix")
  private String physicianNameSuffix;
  @Column("recipient_primary_business_street_address_line1")
  private String recipientPrimaryBusinessStreet1;
  @Column("recipient_primary_business_street_address_line2")
  private String recipientPrimaryBusinessStreet2;
  @Column("recipient_city")
  private String recipientCity;
  @Column("recipient_state")
  private String recipientState;
  @Column("recipient_zip_code")
  private String recipientZipCode;
  @Column("recipient_country")
  private String recipientCountry;
  @Column("recipient_province")
  private String recipientProvince;
  @Column("recipient_postal_code")
  private String recipientPostalCode;
  @Column("physician_primary_type")
  private String physicianPrimaryType;
  @Column("physician_specialty")
  private String physicianSpecialty;
  @Column("physician_license_state_code1")
  private String physicianLicenseStateCode1;
  @Column("physician_license_state_code2")
  private String physicianLicenseStateCode2;
  @Column("physician_license_state_code3")
  private String physicianLicenseStateCode3;
  @Column("physician_license_state_code4")
  private String physicianLicenseStateCode4;
  @Column("physician_license_state_code5")
  private String physicianLicenseStateCode5;
  @Column("submitting_applicable_manufacturer_or_applicable_gpo_name")
  private String submittingApplicableManufacturerOrGpoName;
  @Column("applicable_manufacturer_or_applicable_gpo_making_payment_id")
  private long applicableManufacturerOrGpoPaymentId;
  @Column("applicable_manufacturer_or_applicable_gpo_making_payment_name")
  private String applicableManufacturerOrGpoPaymentName;
  @Column("applicable_manufacturer_or_applicable_gpo_making_payment_state")
  private String applicableManufacturerOrGpoPaymentState;
  @Column("applicable_manufacturer_or_applicable_gpo_making_payment_country")
  private String applicableManufacturerOrGpoPaymentCountry;
  @Column("total_amount_of_payment_usdollars")
  private double totalAmountOfPaymentUsDollars;
  @Column("date_of_payment")
  private Date dateOfPayment;
  @Column("number_of_payments_included_in_total_amount")
  private int numberOfPaymentsInTotalAmount;
  @Column("form_of_payment_or_transfer_of_value")
  private String formOfPaymentOrTransferOfValue;
  @Column("nature_of_payment_or_transfer_of_value")
  private String natureOfPaymentOrTransferOfValue;
  @Column("city_of_travel")
  private String cityOfTravel;
  @Column("state_of_travel")
  private String stateOfTravel;
  @Column("country_of_travel")
  private String countryOfTravel;
  @Column("physician_ownership_indicator")
  private String physicianOwnershipIndicator;
  @Column("third_party_payment_recipient_indicator")
  private String thirdPartyPaymentRecipientIndicator;
  @Column("name_of_third_party_entity_receiving_payment_or_transfer_of_ccfc")
  private String nameOfEntityReceivingPaymentOrTransferOfValue;
  @Column("charity_indicator")
  private String charityIndicator;
  @Column("third_party_equals_covered_recipient_indicator")
  private String thirdPartyEqualsCoveredRecipientIndicator;
  @Column("contextual_information")
  private String contextualInformation;
  @Column("delay_in_publication_indicator")
  private String delayInPublicationIndicator;
  @Column("record_id")
  private long recordId;
  @Column("dispute_status_for_publication")
  private String disputeStatusForPublication;
  @Column("product_indicator")
  private String productIndicator;
  @Column("name_of_associated_covered_drug_or_biological1")
  private String nameOfAssociatedCoveredDrugOrBiological1;
  @Column("name_of_associated_covered_drug_or_biological2")
  private String nameOfAssociatedCoveredDrugOrBiological2;
  @Column("name_of_associated_covered_drug_or_biological3")
  private String nameOfAssociatedCoveredDrugOrBiological3;
  @Column("name_of_associated_covered_drug_or_biological4")
  private String nameOfAssociatedCoveredDrugOrBiological4;
  @Column("name_of_associated_covered_drug_or_biological5")
  private String nameOfAssociatedCoveredDrugOrBiological5;
  @Column("ndc_of_associated_covered_drug_or_biological1")
  private String ndcOfAssociatedCoveredDrugOrBiological1;
  @Column("ndc_of_associated_covered_drug_or_biological2")
  private String ndcOfAssociatedCoveredDrugOrBiological2;
  @Column("ndc_of_associated_covered_drug_or_biological3")
  private String ndcOfAssociatedCoveredDrugOrBiological3;
  @Column("ndc_of_associated_covered_drug_or_biological4")
  private String ndcOfAssociatedCoveredDrugOrBiological4;
  @Column("ndc_of_associated_covered_drug_or_biological5")
  private String ndcOfAssociatedCoveredDrugOrBiological5;
  @Column("name_of_associated_covered_device_or_medical_supply1")
  private String nameOfAssociatedCoveredDeviceOrMedicalSupply1;
  @Column("name_of_associated_covered_device_or_medical_supply2")
  private String nameOfAssociatedCoveredDeviceOrMedicalSupply2;
  @Column("name_of_associated_covered_device_or_medical_supply3")
  private String nameOfAssociatedCoveredDeviceOrMedicalSupply3;
  @Column("name_of_associated_covered_device_or_medical_supply4")
  private String nameOfAssociatedCoveredDeviceOrMedicalSupply4;
  @Column("name_of_associated_covered_device_or_medical_supply5")
  private String nameOfAssociatedCoveredDeviceOrMedicalSupply5;
  @Column("program_year")
  private String programYear;
  @Column("payment_publication_date")
  private Date paymentPublicationDate;
}
