package com.dpdev.beautifulgirl.activities.favorite;

import android.os.Bundle;

import com.dpdev.beautifulgirl.R;
import com.dpdev.beautifulgirl.activities.BaseActivity;
import com.dpdev.beautifulgirl.views.BeautyBaseView;

/**
 * Created by nhdangit on 1/8/18.
 */

public class FavoriteActivity extends BaseActivity {

    private BeautyBaseView beautyBaseView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        beautyBaseView = setBeautyContentView(R.layout.activity_favorite);
        beautyBaseView.setCurrentMenuId(BeautyBaseView.MENU_ID_FAVORITE);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

}
