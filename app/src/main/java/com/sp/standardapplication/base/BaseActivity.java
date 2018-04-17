package com.sp.standardapplication.base;

/**
 * Copyright (c) 2015-2016 Sailfin Technologies, Pvt. Ltd.  All Rights Reserved.
 * This software is the confidential and proprietary information
 * (Confidential Information) of Sailfin Technologies, Pvt. Ltd.  You shall not
 * disclose or use Confidential Information without the express written
 * agreement of Sailfin Technologies, Pvt. Ltd.
 */

import android.annotation.TargetApi;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.sp.standardapplication.R;
import com.sp.standardapplication.helper.StandLog;
import com.sp.standardapplication.views.CustomProgressDialog;

/**
 * Created by nikhil.vadoliya on 31-08-2017.
 */


public abstract class BaseActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView mToolbarTitle;

    String message;

    private CustomProgressDialog mProgressDialog;

    protected void onCreate(@Nullable Bundle savedInstanceState, int layout) {
        super.onCreate(savedInstanceState);
        setContentView(layout);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbarTitle = (TextView) findViewById(R.id.toolbar_title);

        setSupportActionBar(toolbar);
        // Remove default title text
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //set statusbar color
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }

        mProgressDialog = new CustomProgressDialog(this);
        initializeData();
        setListeners();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void setToolBarTitle(String title) {
        mToolbarTitle.setText(title);
    }

    public void showToast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    public void showToast(int errorcode) {

        switch (errorcode) {
            case 1:
                message = getString(R.string.msg_api_error_timeout);
                break;
            case 2:
                message = getString(R.string.msg_api_error_unknown_host);
                break;

            default:
                message = getString(R.string.msg_api_error_something_want_wrong);

        }
        showToast(message);
    }

    public void showProgress() {
        try {
            if (mProgressDialog != null) {
                if (mProgressDialog.isShowing())
                    hideProgress();
                mProgressDialog.show("");
            }
        } catch (Exception e) {
            StandLog.e("show progress - ", e.getMessage());
        }
    }

    public void hideProgress() {
        try {
            if (mProgressDialog != null) {
                mProgressDialog.dismiss("");
                mProgressDialog.dismiss();
                mProgressDialog.hide("");
                mProgressDialog.hide();
            }
        } catch (Exception e) {
            StandLog.e("hide progress - ", e.getMessage());
        }
    }

    protected abstract void initializeData();

    protected abstract void setListeners();


}
