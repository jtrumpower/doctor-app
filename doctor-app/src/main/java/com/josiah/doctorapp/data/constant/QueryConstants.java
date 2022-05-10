package com.josiah.doctorapp.data.constant;

import lombok.experimental.UtilityClass;

@UtilityClass
public class QueryConstants {
  public static final String WHERE_NAME = "where lower(physician_first_name) like concat('%',lower(:val),'%') "
      + "or lower(physician_middle_name) like concat('%',lower(:val),'%') "
      + "or lower(physician_last_name) like concat('%',lower(:val),'%')";
  public static final String WHERE_NATURE_OF_PAYMENT = "where lower(nature_of_payment_or_transfer_of_value) like concat('%',lower(:val),'%')";
  public static final String WHERE_FORM_OF_PAYMENT = "where lower(form_of_payment_or_transfer_of_value) like concat('%',lower(:val),'%')";
  public static final String WHERE_TEACHING_HOSPITAL_NAME = "where lower(teaching_hospital_name) like concat('%',lower(:val),'%')";
}
