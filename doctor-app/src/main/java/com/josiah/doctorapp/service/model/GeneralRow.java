package com.josiah.doctorapp.service.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({

})
public class GeneralRow {
  private String recordNumber;
  private String changeType;
  private String coveredRecipientType;
  private int teachingHospitalCCN;
  private int teachingHospitalId;
  private String teachingHospitalName;
  private int physicianProfileId;
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
  private long applicableManufacturerOrGpoPaymentId;
  private String applicableManufacturerOrGpoPaymentName;
  private String applicableManufacturerOrGpoPaymentState;
  private String applicableManufacturerOrGpoPaymentCountry;
  private double totalAmountOfPaymentUsDollars;
  private Date dateOfPayment;
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
  private Date paymentPublicationDate;
}
