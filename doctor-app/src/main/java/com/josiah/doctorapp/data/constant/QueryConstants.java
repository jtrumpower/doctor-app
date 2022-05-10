package com.josiah.doctorapp.data.constant;

import lombok.experimental.UtilityClass;

@UtilityClass
public class QueryConstants {
  public static final String WHERE_NAME = "where lower(physician_first_name) like concat('%',lower(:val),'%') "
      + "or lower(physician_middle_name) like concat('%',lower(:val),'%') "
      + "or lower(physician_last_name) like concat('%',lower(:val),'%')";
}
