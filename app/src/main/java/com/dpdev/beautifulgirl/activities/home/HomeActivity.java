package com.dpdev.beautifulgirl.activities.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.dpdev.beautifulgirl.R;
import com.dpdev.beautifulgirl.activities.BaseActivity;
import com.dpdev.beautifulgirl.views.BeautyBaseView;

/**
 * Created by nhdangit on 1/8/18.
 */

public class HomeActivity extends BaseActivity {

    private BeautyBaseView beautyBaseView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        beautyBaseView = setBeautyContentView(R.layout.activity_home);
        beautyBaseView.setCurrentMenuId(BeautyBaseView.MENU_ID_HOME);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

}
