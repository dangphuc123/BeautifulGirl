package com.dpdev.beautifulgirl.activities.settings;

import android.os.Bundle;

import com.dpdev.beautifulgirl.R;
import com.dpdev.beautifulgirl.activities.BaseActivity;
import com.dpdev.beautifulgirl.views.BeautyBaseView;

/**
 * Created by nhdangit on 1/8/18.
 */

public class SettingsActivity extends BaseActivity {

    private BeautyBaseView beautyBaseView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        beautyBaseView = setBeautyContentView(R.layout.activity_settings);
        beautyBaseView.setCurrentMenuId(BeautyBaseView.MENU_ID_SETTINGS);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

}
