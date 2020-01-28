package com.informatique.informatiquetask.utilities;

import com.informatique.informatiquetask.data.SharedPreference;

/**
 * Created by abdelrahman on 28/01/20.
 */
public class ConstantsUrls {

    //http://41.65.11.49:888/commercialRegistration.ashx?cr=1234567
    //http://197.45.133.242:888/commercialRegistration.ashx?cr=1234567


    //dev environment
    public static final String BasicURLDev = "http://197.45.133.242:888";
    //another environment

    //query string
    public static final String commercialRegistration = SharedPreference.getMyBasicURL() + "/commercialRegistration.ashx";

}
