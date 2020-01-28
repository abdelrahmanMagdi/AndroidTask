package com.informatique.informatiquetask.ui.activities.base;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.informatique.informatiquetask.R;
import com.informatique.informatiquetask.data.SharedPreference;
import com.informatique.informatiquetask.utilities.Utils;

/**
 * Created by abdelrahman on 28/01/20.
 */
public abstract class BaseActivity<B extends ViewDataBinding> extends RuntimePermissionsActivity {
    protected B dataBinding;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Utils.setLanguage(SharedPreference.getUserLanguage(), this);
        Log.i("language", SharedPreference.getUserLanguage());
        if (SharedPreference.getUserLanguage().equals(Utils.englishLang)) {
            findViewById(android.R.id.content);
            getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
        } else {
            findViewById(android.R.id.content);
            getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        }

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.colorAccent));
        }
        setContentView(getLayoutResourceId());
        dataBinding = DataBindingUtil.setContentView(this, getLayoutResourceId());
        onViewReady(savedInstanceState, getIntent());

    }

    @CallSuper
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        //To be used by child activities
    }
    protected abstract int getLayoutResourceId();

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.language, menu);
        return true;
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void finish() {
        super.finish();
    }



}

