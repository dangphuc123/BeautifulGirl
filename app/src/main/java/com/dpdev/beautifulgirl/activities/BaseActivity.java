package com.dpdev.beautifulgirl.activities;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import com.dpdev.beautifulgirl.controllers.DpdevController;
import com.dpdev.beautifulgirl.views.BeautyBaseView;

/**
 * Created by nhdangit on 1/8/18.
 */

public class BaseActivity extends AppCompatActivity {

    private final DpdevController dpdevController = new DpdevController(this);

    private boolean allowBackPressed = false;

    BeautyBaseView beautyBaseView;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    public void enableBackButton() {
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void disableBackButton() {
        getSupportActionBar().setHomeButtonEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    protected BeautyBaseView setBeautyContentView(final int layoutResID) {
        beautyBaseView = dpdevController.setBeautyContentView(layoutResID);
        return beautyBaseView;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        allowBackPressed = false;
    }

    @Override
    protected void onStart() {
        super.onStart();
        allowBackPressed = true;
    }

    @Override
    public void onBackPressed() {
        if (!allowBackPressed) {
            finish();
            return;
        }
        super.onBackPressed();
    }
}
