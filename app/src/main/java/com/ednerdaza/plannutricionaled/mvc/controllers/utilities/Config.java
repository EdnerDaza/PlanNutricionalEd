package com.ednerdaza.plannutricionaled.mvc.controllers.utilities;

/**
 * Created by ednerdaza on 30/06/16.
 */
public class Config  {

    public static final String APP_LOG = "APP_LOG";
    public static final int SPINNER_DEFAULT = -1;
    public static String dateCalendar="";
    public static String getDateCalendar() {
        return dateCalendar;
    }
    public static void setDateCalendar(String dateCalendar) {
        Config.dateCalendar = dateCalendar;
    }
}
