package com.informatique.informatiquetask.ui.customViews;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;

import com.informatique.informatiquetask.R;

/**
 * Created by abdelrahman on 28/01/20.
 */
public class Dialogs {

    public static Dialog LoadingDialog(final Context myContext) {
        final Dialog dialog = new Dialog(myContext);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.dialog_loading);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        final RelativeLayout loadingDialog_rl = dialog.findViewById(R.id.loadingDialog_rl);
        loadingDialog_rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        return dialog;
    }
}
