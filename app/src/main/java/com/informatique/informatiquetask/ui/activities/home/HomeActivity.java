package com.informatique.informatiquetask.ui.activities.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.informatique.informatiquetask.R;
import com.informatique.informatiquetask.databinding.ActivityHomeBinding;
import com.informatique.informatiquetask.ui.activities.base.BaseActivity;

public class HomeActivity extends BaseActivity<ActivityHomeBinding> implements View.OnClickListener {


    @Override
    public void onClick(View v) {

    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_home;
    }

    @Override
    public void onPermissionsGranted(int requestCode) {

    }
}
