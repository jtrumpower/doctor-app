export const COLUMNS = {
  changeType: "change_type",
  charityIndicator: "charity_indicator",
  cityOfTravel: "city_of_travel",
  contextualInformation: "contextual_information",
  countryOfTravel: "country_of_travel",
  coveredRecipientType: "covered_recipient_type",
  dateOfPayment: "date_of_payment",
  delayInPublicationIndicator: "delay_in_publication_indicator",
  disputeStatusForPublication: "dispute_status_for_publication",
  formOfPaymentOrTransferOfValue: "form_of_payment_or_transfer_of_value",
  applicableManufacturerOrGpoPaymentCountry: "applicable_manufacturer_or_applicable_gpo_making_payment_country",
  applicableManufacturerOrGpoPaymentId: "applicable_manufacturer_or_applicable_gpo_making_payment_id",
  applicableManufacturerOrGpoPaymentName: "applicable_manufacturer_or_applicable_gpo_making_payment_name",
  applicableManufacturerOrGpoPaymentState: "applicable_manufacturer_or_applicable_gpo_making_payment_state",
  nameOfAssociatedCoveredDeviceOrMedicalSupply1: "name_of_associated_covered_device_or_medical_supply1",
  nameOfAssociatedCoveredDeviceOrMedicalSupply2: "name_of_associated_covered_device_or_medical_supply2",
  nameOfAssociatedCoveredDeviceOrMedicalSupply3: "name_of_associated_covered_device_or_medical_supply3",
  nameOfAssociatedCoveredDeviceOrMedicalSupply4: "name_of_associated_covered_device_or_medical_supply4",
  nameOfAssociatedCoveredDeviceOrMedicalSupply5: "name_of_associated_covered_device_or_medical_supply5",
  nameOfAssociatedCoveredDrugOrBiological1: "name_of_associated_covered_drug_or_biological1",
  nameOfAssociatedCoveredDrugOrBiological2: "name_of_associated_covered_drug_or_biological2",
  nameOfAssociatedCoveredDrugOrBiological3: "name_of_associated_covered_drug_or_biological3",
  nameOfAssociatedCoveredDrugOrBiological4: "name_of_associated_covered_drug_or_biological4",
  nameOfAssociatedCoveredDrugOrBiological5: "name_of_associated_covered_drug_or_biological5",
  nameOfEntityReceivingPaymentOrTransferOfValue: "name_of_third_party_entity_receiving_payment_or_transfer_of_ccfc",
  natureOfPaymentOrTransferOfValue: "nature_of_payment_or_transfer_of_value",
  ndcOfAssociatedCoveredDrugOrBiological1: "ndc_of_associated_covered_drug_or_biological1",
  ndcOfAssociatedCoveredDrugOrBiological2: "ndc_of_associated_covered_drug_or_biological2",
  ndcOfAssociatedCoveredDrugOrBiological3: "ndc_of_associated_covered_drug_or_biological3",
  ndcOfAssociatedCoveredDrugOrBiological4: "ndc_of_associated_covered_drug_or_biological4",
  ndcOfAssociatedCoveredDrugOrBiological5: "ndc_of_associated_covered_drug_or_biological5",
  numberOfPaymentsInTotalAmount: "number_of_payments_included_in_total_amount",
  paymentPublicationDate: "payment_publication_date",
  physicianFirstName: "physician_first_name",
  physicianLastName: "physician_last_name",
  physicianLicenseStateCode1: "physician_license_state_code1",
  physicianLicenseStateCode2: "physician_license_state_code2",
  physicianLicenseStateCode3: "physician_license_state_code3",
  physicianLicenseStateCode4: "physician_license_state_code4",
  physicianLicenseStateCode5: "physician_license_state_code5",
  physicianMiddleName: "physician_middle_name",
  physicianNameSuffix: "physician_name_suffix",
  physicianOwnershipIndicator: "physician_ownership_indicator",
  physicianPrimaryType: "physician_primary_type",
  physicianProfileId: "physician_profile_id",
  physicianSpecialty: "physician_specialty",
  productIndicator: "product_indicator",
  programYear: "program_year",
  recipientCity: "recipient_city",
  recipientCountry: "recipient_country",
  recipientPostalCode: "recipient_postal_code",
  recipientPrimaryBusinessStreet1: "recipient_primary_business_street_address_line1",
  recipientPrimaryBusinessStreet2: "recipient_primary_business_street_address_line2",
  recipientProvince: "recipient_province",
  recipientState: "recipient_state",
  recipientZipCode: "recipient_zip_code",
  recordId: "record_id",
  stateOfTravel: "state_of_travel",
  submittingApplicableManufacturerOrGpoName: "submitting_applicable_manufacturer_or_applicable_gpo_name",
  teachingHospitalCCN: "teaching_hospital_ccn",
  teachingHospitalId: "teaching_hospital_id",
  teachingHospitalName: "teaching_hospital_name",
  thirdPartyEqualsCoveredRecipientIndicator: "third_party_equals_covered_recipient_indicator",
  thirdPartyPaymentRecipientIndicator: "third_party_payment_recipient_indicator",
  totalAmountOfPaymentUsDollars: "total_amount_of_payment_usdollars",
}

export const SEARCH_TYPE_DEFAULT = { value: `${COLUMNS.physicianFirstName}|${COLUMNS.physicianLastName}`, text: "First or last name" };

export const SEARCH_TYPES = [
  SEARCH_TYPE_DEFAULT,
  { value: COLUMNS.natureOfPaymentOrTransferOfValue, text: "Nature of payment"},
  { value: COLUMNS.formOfPaymentOrTransferOfValue, text: "Form of payment"},
  { value: COLUMNS.teachingHospitalName, text: "Teaching Hospital Name"},
]