package com.dpdev.beautifulgirl.activities.profile;

import android.os.Bundle;

import com.dpdev.beautifulgirl.R;
import com.dpdev.beautifulgirl.activities.BaseActivity;
import com.dpdev.beautifulgirl.views.BeautyBaseView;

/**
 * Created by nhdangit on 1/8/18.
 */

public class ProfileActivity extends BaseActivity {

    private BeautyBaseView beautyBaseView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        beautyBaseView = setBeautyContentView(R.layout.activity_profile);
        beautyBaseView.setCurrentMenuId(BeautyBaseView.MENU_ID_PROFILE);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

}
