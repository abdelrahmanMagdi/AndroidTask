package com.informatique.informatiquetask.ui.activities.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.informatique.informatiquetask.R;
import com.informatique.informatiquetask.data.SharedPreference;
import com.informatique.informatiquetask.data.models.HumanPartnerObjectPOJO;
import com.informatique.informatiquetask.data.models.ResultObjectPOJO;
import com.informatique.informatiquetask.data.models.ResultResponsePOJO;
import com.informatique.informatiquetask.data.network.MainAPIS;
import com.informatique.informatiquetask.data.network.apiInterfaces.onGetCommercialData;
import com.informatique.informatiquetask.databinding.ActivityHomeBinding;
import com.informatique.informatiquetask.ui.activities.base.BaseActivity;
import com.informatique.informatiquetask.ui.adapter.HumanPartnersAdapter;
import com.informatique.informatiquetask.utilities.ConstantsUrls;
import com.informatique.informatiquetask.utilities.Utils;

import java.util.ArrayList;

import static com.informatique.informatiquetask.utilities.Utils.hideKeyboard;

public class HomeActivity extends BaseActivity<ActivityHomeBinding> implements View.OnClickListener {

    private static final String TAG = "HomeActivity";
    private String registrationNumber;
    private ArrayList<HumanPartnerObjectPOJO> humanPartnerObjectPOJOArrayList;
    private boolean dataChangedOfEditText = false;

    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent) {
        super.onViewReady(savedInstanceState, intent);

        clearFocus(dataBinding.parentLL);
        getDataFromEditText();
        dataBinding.humanPartnersBT.setOnClickListener(this);
        dataBinding.registrationNumberET.setOnClickListener(this);


    }

    // used to listen and get data from edit text
    private void getDataFromEditText() {
        // used for key send in keyboard and take action
        dataBinding.registrationNumberET.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_NEXT) {
                    getRequest();
                    return true;
                }
                return false;
            }
        });
        // used for any change with edit text and make request if there change
        dataBinding.registrationNumberET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (registrationNumber != null) {
                    if (s.length() != registrationNumber.length()) {
                        Log.d(TAG, "addTextChangedListener: " + "not equal");
                        dataChangedOfEditText = false;
                    } else {
                        Log.d(TAG, "addTextChangedListener: " + " equal");
                        dataChangedOfEditText = true;

                    }
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }

    // used to send request after getting national number form above function
    private void getRequest() {
        registrationNumber = dataBinding.registrationNumberET.getText().toString();
        dataBinding.registrationNumberET.clearFocus();
        dataBinding.registrationNumberTI.setError(null);

        if (!TextUtils.isEmpty(registrationNumber)) {
            dataBinding.swipeDataRefreshLayout.setEnabled(true);
            MainAPIS.getRequestGeneric(ConstantsUrls.commercialRegistration + "?cr=" + registrationNumber, HomeActivity.this, ConstantsUrls.commercialRegistration);
            dataBinding.swipeDataRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    MainAPIS.getRequestGeneric(ConstantsUrls.commercialRegistration + "?cr=" + registrationNumber, HomeActivity.this, ConstantsUrls.commercialRegistration);
                    dataBinding.swipeDataRefreshLayout.setRefreshing(false);


                }
            });
            MainAPIS.APIBindGetCommercialDataFinished(new onGetCommercialData() {
                @Override
                public void getCommercialDataFinished(ResultResponsePOJO resultResponsePOJO) {
                    setData(resultResponsePOJO.getResult());

                }
            });
        } else {
            dataBinding.registrationNumberTI.setError(this.getResources().getText(R.string.error_Empty));
            dataBinding.swipeDataRefreshLayout.setEnabled(false);

        }
    }

    // used to set data to widgets text Views and initialize arrayList for recycler view
    private void setData(ResultObjectPOJO result) {

        String[] expiryDate = result.getExpiryDate().split("T");
        dataBinding.expiryDateTV.setText(expiryDate[0]);
        Log.d(TAG, "setData: " + expiryDate[0]);

        dataBinding.commercialNameTV.setText(result.getArabicCommercialName());
        humanPartnerObjectPOJOArrayList = new ArrayList<>();
        humanPartnerObjectPOJOArrayList = result.getHumanPartners();
        setUpHumanPartnerData();
    }

    // used to set data for adapter , bind adapter to recycler view
    private void setUpHumanPartnerData() {
        dataBinding.dataCL.setVisibility(View.VISIBLE);
        HumanPartnersAdapter partnersAdapter = new HumanPartnersAdapter(humanPartnerObjectPOJOArrayList);
        dataBinding.commercialDataRV.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        dataBinding.commercialDataRV.setAdapter(partnersAdapter);
        dataBinding.commercialDataRV.setNestedScrollingEnabled(true);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, RecyclerView.VERTICAL);
        dataBinding.commercialDataRV.addItemDecoration(itemDecoration);

    }


    private void changeLanguage() {
        if (SharedPreference.getUserLanguage().equals(Utils.englishLang)) {
            Utils.changeLanguage(Utils.arabicLang, this);
            finish();
        } else if (SharedPreference.getUserLanguage().equals(Utils.arabicLang)) {
            Utils.changeLanguage(Utils.englishLang, this);
            finish();
        }


    }

    public void onClickHumanPartnersButton() {
        if (dataBinding.nestedScrollView.getVisibility() == View.GONE) {
            dataBinding.nestedScrollView.setVisibility(View.VISIBLE);
            dataBinding.humanPartnersBT.setText(this.getResources().getString(R.string.hideList));
        } else {
            dataBinding.nestedScrollView.setVisibility(View.GONE);
            dataBinding.humanPartnersBT.setText(this.getResources().getString(R.string.humanPartnersSTR));

        }
    }

    // used parent view to iterate on views and clear focus and use recursion for iterating

    public void clearFocus(final View view) {
        if (!(view instanceof EditText)) {
            view.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    if (!dataChangedOfEditText) {
                        getRequest();
                        dataChangedOfEditText = true;
                    }
                    hideKeyboard(view);
                    dataBinding.registrationNumberET.clearFocus();
                    dataBinding.registrationNumberTI.clearFocus();
                    return false;
                }
            });
        }
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                View innerView = ((ViewGroup) view).getChildAt(i);
                clearFocus(innerView);
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.changeLanguage) {
            changeLanguage();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == dataBinding.humanPartnersBT.getId()) onClickHumanPartnersButton();
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_home;
    }

    @Override
    public void onPermissionsGranted(int requestCode) {
    }


}
