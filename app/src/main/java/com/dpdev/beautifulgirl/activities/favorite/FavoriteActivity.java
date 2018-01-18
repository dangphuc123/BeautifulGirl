package com.dpdev.beautifulgirl.activities.favorite;

import android.os.Bundle;
import android.widget.GridView;

import com.dpdev.beautifulgirl.R;
import com.dpdev.beautifulgirl.activities.BaseActivity;
import com.dpdev.beautifulgirl.adapters.FavoriteAdapter;
import com.dpdev.beautifulgirl.adapters.MySqliteHelper;
import com.dpdev.beautifulgirl.models.ImageFavorite;
import com.dpdev.beautifulgirl.views.BeautyBaseView;

import java.util.ArrayList;

/**
 * Created by nhdangit on 1/8/18.
 */

public class FavoriteActivity extends BaseActivity {

    private BeautyBaseView beautyBaseView;
    private FavoriteAdapter adapter=null;
    private ArrayList<ImageFavorite> list;

    @Override
    protected void onCreate(Bundle salvedInstanceState) {
        super.onCreate(salvedInstanceState);
        beautyBaseView = setBeautyContentView(R.layout.activity_favorite);
        beautyBaseView.setCurrentMenuId(BeautyBaseView.MENU_ID_FAVORITE);

        final GridView gridView = (GridView)findViewById(R.id.grid_view);

        MySqliteHelper mySqliteHelper = new MySqliteHelper(this);
        list = mySqliteHelper.getallImage();

        adapter=new FavoriteAdapter(this,R.layout.item_favorite,list);
        gridView.setAdapter(adapter);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

}
