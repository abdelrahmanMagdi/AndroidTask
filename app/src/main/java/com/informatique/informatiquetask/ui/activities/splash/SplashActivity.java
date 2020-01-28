package com.informatique.informatiquetask.ui.activities.splash;



import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.informatique.informatiquetask.R;
import com.informatique.informatiquetask.data.SharedPreference;
import com.informatique.informatiquetask.databinding.ActivitySplashBinding;
import com.informatique.informatiquetask.ui.activities.base.BaseActivity;
import com.informatique.informatiquetask.ui.activities.home.HomeActivity;
import com.informatique.informatiquetask.utilities.ConstantsUrls;
import com.informatique.informatiquetask.utilities.Utils;

public class SplashActivity extends BaseActivity<ActivitySplashBinding> implements View.OnClickListener {

    private static final String TAG = "SplashActivity";

    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);
        SplashScreenConfig();
        dataBinding.arabicTV.setOnClickListener(this);
        dataBinding.englishTV.setOnClickListener(this);
    }

    private void SplashScreenConfig() {
        Animation bounceAnimation = AnimationUtils.loadAnimation(this, R.anim.heart_pulse);
        dataBinding.splashLogoIV.startAnimation(bounceAnimation);

        // check if it's first time to enter and setup language
        if (TextUtils.isEmpty(SharedPreference.getLanguageFirstTime())) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    dataBinding.languageLL.setVisibility(View.VISIBLE);
                }
            }, 2000);
        } else {
            // entered before
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    redirect();
                }
            }, 2000);
        }

    }
    // first entrance to save suitable language for user
    private void firstAttemptForLang(String language) {
        Utils.changeLanguage(language, this);
        SharedPreference.setLanguageFirstTime(language);
        redirect();
    }

    private void redirect() {
        //Dev environment
        SharedPreference.setMyBasicURL(ConstantsUrls.BasicURLDev);
        startActivity(new Intent(SplashActivity.this, HomeActivity.class));
        finish();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.arabicTV: {
                firstAttemptForLang(Utils.arabicLang);
                break;
            }
            case R.id.englishTV: {
                firstAttemptForLang(Utils.englishLang);
                break;
            }
            default:
                break;
        }
    }
    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_splash;
    }

    @Override
    public void onPermissionsGranted(int requestCode) {

    }
}
