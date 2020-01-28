package com.informatique.informatiquetask.ui.customViews;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

import com.valdesekamdem.library.mdtoast.MDToast;

/**
 * Created by abdelrahman on 28/01/20.
 */
//this class for handling toast
public class CustomToast {
    @SuppressLint("WrongConstant")
    public static void Show_Error_Toast(Context context, String error) {
        MDToast mdToast = MDToast.makeText(context, error, Toast.LENGTH_LONG, MDToast.TYPE_ERROR);
        mdToast.setGravity(Gravity.TOP | Gravity.CENTER, 0, 200);
        mdToast.show();
    }
    @SuppressLint("WrongConstant")
    public static void Show_Toast(Context context, String message) {

        MDToast mdToast = MDToast.makeText(context, message, Toast.LENGTH_LONG, MDToast.TYPE_SUCCESS);
        mdToast.setGravity(Gravity.TOP | Gravity.CENTER, 0, 0);
        mdToast.show();
    }
}
