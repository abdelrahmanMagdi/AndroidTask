package com.informatique.informatiquetask.data.network;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.informatique.informatiquetask.R;
import com.informatique.informatiquetask.data.SharedPreference;
import com.informatique.informatiquetask.data.models.ResultResponsePOJO;
import com.informatique.informatiquetask.data.network.apiInterfaces.onGetCommercialData;
import com.informatique.informatiquetask.ui.customViews.CustomToast;
import com.informatique.informatiquetask.ui.customViews.Dialogs;
import com.informatique.informatiquetask.utilities.ConstantsUrls;

import org.json.JSONObject;

import static com.informatique.informatiquetask.utilities.Utils.isConnected;

/**
 * Created by abdelrahman on 28/01/20.
 */

// this class for handling requests , response , error from back end

public class MainAPIS {

    private static onGetCommercialData onGetCommercialDataListener;

    //get generic request
    public static void getRequestGeneric(String URL, final Context context, final String ExtraKey) {
        String deviceID = SharedPreference.getUserDeviceID();
        String currentLang = SharedPreference.getUserLanguage();

        Log.d("getRequestDataResURL", URL);

        if (!isConnected(context)) {
            CustomToast.Show_Error_Toast(context, context.getResources().getString(R.string.noInternetSTR));
        } else {
            final Dialog loadingDialog = Dialogs.LoadingDialog(context);
            loadingDialog.show();
            AndroidNetworking.get(URL)
                    .addHeaders("Accept", "application/json")
                    .addHeaders("device-id", deviceID)
                    .addHeaders("Accept-Language", currentLang)
                    .addHeaders("device-type", "android")
                    .addHeaders("Content-Type", "application/json")
                    .setPriority(Priority.HIGH)
                    .build()
                    .getAsJSONObject(new JSONObjectRequestListener() {
                        @Override
                        public void onResponse(JSONObject response) {
                            loadingDialog.dismiss();
                            Log.d("getRequestDataRes", response.toString());

                            if (ExtraKey.equals(ConstantsUrls.commercialRegistration)) {
                                //get data request
                                Log.d("getData", response.toString());
                                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                                ResultResponsePOJO responsePOJO = gson.fromJson(response.toString(), ResultResponsePOJO.class);
                                onGetCommercialDataListener.getCommercialDataFinished(responsePOJO);

                            }
                        }

                        @Override
                        public void onError(ANError anError) {
                            if (loadingDialog.isShowing())
                                loadingDialog.dismiss();
                            Log.d("getRequestDataERR", anError.getErrorCode() + "");
                            Log.d("getRequestDataERR", anError.getErrorBody() + "");
                            handleError(context, anError.getErrorBody(), anError.getErrorCode());


                        }
                    });


        }
    }

    //handling error response
    private static void handleError(Context context, String errorRes, int errorStatusCode) {

        switch (errorStatusCode) {
            case 404: {
                //not found
                Log.d("ErrorRes", errorRes + " : " + errorStatusCode + ":");
                CustomToast.Show_Error_Toast(context, context.getResources().getString(R.string.error_notFound));
                break;
            }
            case 500: {
                //internal server
                Log.d("ErrorRes", errorRes + " : " + errorStatusCode + ":");
                CustomToast.Show_Error_Toast(context, context.getResources().getString(R.string.error_internalServer));

                break;
            }
            case 504: {
                //gateway timeout
                Log.d("ErrorRes", errorRes + " : " + errorStatusCode + ":");
                CustomToast.Show_Error_Toast(context, context.getResources().getString(R.string.error_timeOut));
                break;
            }
            default:
                CustomToast.Show_Error_Toast(context, context.getResources().getString(R.string.error_linkDown));
                break;
        }

    }

    //handle implementation
    public static void APIBindGetCommercialDataFinished(onGetCommercialData listener) { onGetCommercialDataListener = listener; }



}
