package com.josiah.doctorapp.service.model;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
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
  private String changeType;
  private String coveredRecipientType;
  private String teachingHospitalCCN;
  private String teachingHospitalId;
  private String teachingHospitalName;
  private String physicianProfileId;
  private String physicianFirstName;
  private String physicianMiddleName;
  private String physicianLastName;
  private String physicianNameSuffix;
  private String recipientPrimaryBusinessStreet1;
  private String recipientPrimaryBusinessStreet2;
  private String recipientCity;
  private String recipientState;
  private String recipientZipCode;
  private String recipientCountry;
  private String recipientProvince;
  private String recipientPostalCode;
  private String physicianPrimaryType;
  private String physicianSpecialty;
  private String physicianLicenseStateCode1;
  private String physicianLicenseStateCode2;
  private String physicianLicenseStateCode3;
  private String physicianLicenseStateCode4;
  private String physicianLicenseStateCode5;
  private String submittingApplicableManufacturerOrGpoName;
  private String applicableManufacturerOrGpoPaymentId;
  private String applicableManufacturerOrGpoPaymentName;
  private String applicableManufacturerOrGpoPaymentState;
  private String applicableManufacturerOrGpoPaymentCountry;
  private double totalAmountOfPaymentUsDollars;
  private String dateOfPayment;
  private int numberOfPaymentsInTotalAmount;
  private String formOfPaymentOrTransferOfValue;
  private String natureOfPaymentOrTransferOfValue;
  private String cityOfTravel;
  private String stateOfTravel;
  private String countryOfTravel;
  private String physicianOwnershipIndicator;
  private String thirdPartyPaymentRecipientIndicator;
  private String nameOfEntityReceivingPaymentOrTransferOfValue;
  private String charityIndicator;
  private String thirdPartyEqualsCoveredRecipientIndicator;
  private String contextualInformation;
  private String delayInPublicationIndicator;
  private long recordId;
  private String disputeStatusForPublication;
  private String productIndicator;
  private String nameOfAssociatedCoveredDrugOrBiological1;
  private String nameOfAssociatedCoveredDrugOrBiological2;
  private String nameOfAssociatedCoveredDrugOrBiological3;
  private String nameOfAssociatedCoveredDrugOrBiological4;
  private String nameOfAssociatedCoveredDrugOrBiological5;
  private String ndcOfAssociatedCoveredDrugOrBiological1;
  private String ndcOfAssociatedCoveredDrugOrBiological2;
  private String ndcOfAssociatedCoveredDrugOrBiological3;
  private String ndcOfAssociatedCoveredDrugOrBiological4;
  private String ndcOfAssociatedCoveredDrugOrBiological5;
  private String nameOfAssociatedCoveredDeviceOrMedicalSupply1;
  private String nameOfAssociatedCoveredDeviceOrMedicalSupply2;
  private String nameOfAssociatedCoveredDeviceOrMedicalSupply3;
  private String nameOfAssociatedCoveredDeviceOrMedicalSupply4;
  private String nameOfAssociatedCoveredDeviceOrMedicalSupply5;
  private String programYear;
  private String paymentPublicationDate;
}
