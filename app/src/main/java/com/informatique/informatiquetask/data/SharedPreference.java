package com.informatique.informatiquetask.data;

import android.content.Context;

import com.informatique.informatiquetask.utilities.ConstantsUrls;
import com.informatique.informatiquetask.utilities.Utils;

import java.util.Locale;

/**
 * Created by abdelrahman on 28/01/20.
 */
//this class is used for set and save user language, userDeviceId , base url

public class SharedPreference {

    private final static String mySharedPreferenceName = "informatique";
    private final static String mySharedPreference_userLanguage = "userLanguage";
    private static Context mAppContext = null;
    private final static String PREFERENCE_KEY_USERDEVICEID = "userDeviceID";
    private static final String PREFERENCE_KEY_basicURL = "myBasicURL";
    private static final String FIRST_ATTEMPT = "firstTime";


    private SharedPreference() {
    }

    public static void init(Context appContext) {
        mAppContext = appContext;
    }

    private static android.content.SharedPreferences getSharedPreferences() {
        return mAppContext.getSharedPreferences(mySharedPreferenceName, Context.MODE_PRIVATE);
    }

    public static void setUserLanguage(String userLang) {
        android.content.SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putString(mySharedPreference_userLanguage, userLang).apply();
    }

    public static String getUserLanguage() {
        if (Locale.getDefault().getDisplayLanguage().equals("العربية"))
            return getSharedPreferences().getString(mySharedPreference_userLanguage, Utils.arabicLang);
        else
            return getSharedPreferences().getString(mySharedPreference_userLanguage, Utils.englishLang);
    }

    public static void setUserDeviceID(String userDeviceID) {
        android.content.SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putString(PREFERENCE_KEY_USERDEVICEID, userDeviceID).apply();
    }

    public static String getUserDeviceID() {
        return getSharedPreferences().getString(PREFERENCE_KEY_USERDEVICEID, "");

    }

    public static String getMyBasicURL() {
        return getSharedPreferences().getString(PREFERENCE_KEY_basicURL, ConstantsUrls.BasicURLDev);
    }

    public static void setMyBasicURL(String myBasicURL) {
        android.content.SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putString(PREFERENCE_KEY_basicURL, myBasicURL).apply();
    }

    public static void setLanguageFirstTime(String langugae) {
        android.content.SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putString(FIRST_ATTEMPT, langugae).apply();
    }

    public static String getLanguageFirstTime() {
        return getSharedPreferences().getString(FIRST_ATTEMPT,"");
    }
}
