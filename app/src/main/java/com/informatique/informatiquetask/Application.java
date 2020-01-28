package com.informatique.informatiquetask;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.StrictMode;
import android.provider.Settings;
import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.informatique.informatiquetask.data.SharedPreference;

import java.lang.reflect.Method;

/**
 * Created by abdelrahman on 28/01/20.
 */
public class Application extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();

        //SharedPreference
        setSharedPreferences();

        //Android Fast Networking
        setAFN();

        //set main values
        setMainValues();
    }
    //init SharedPreference
    private void setSharedPreferences() {
        Log.d("init", "init SharedPreference");
        SharedPreference.init(getApplicationContext());

        if(Build.VERSION.SDK_INT>=24){
            try{
                Method m = StrictMode.class.getMethod("disableDeathOnFileUriExposure");
                m.invoke(null);
            }catch(Exception e){
                e.printStackTrace();
            }
        }


    }

    //set main values
    @SuppressLint("HardwareIds")
    private void setMainValues(){
        SharedPreference.setUserDeviceID(Settings.Secure.getString(getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID));
    }


    //init Android fast networking
    private void setAFN() {
        AndroidNetworking.initialize(this);
    }
    @Override
    public void onTerminate() {
        super.onTerminate();
    }

}
