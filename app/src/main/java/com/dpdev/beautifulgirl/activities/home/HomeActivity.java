package com.dpdev.beautifulgirl.activities.home;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.dpdev.beautifulgirl.R;
import com.dpdev.beautifulgirl.activities.BaseActivity;
import com.dpdev.beautifulgirl.adapters.ImageAdapter;
import com.dpdev.beautifulgirl.models.Images;
import com.dpdev.beautifulgirl.views.BeautyBaseView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nhdangit on 1/8/18.
 */

public class HomeActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener, ValueEventListener {

    private BeautyBaseView beautyBaseView;
    private SwipeRefreshLayout swipeLayout;
    private DatabaseReference mDatabaseRef;
    private RecyclerView mRecyclerView;
    private ImageAdapter imageAdapter;
    private ArrayList<Images> data;
    private static final String FB_DATABASE_PATH = "images";
    private String olderPostId = "";
    private static final int NUMBER_PAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        beautyBaseView = setBeautyContentView(R.layout.activity_home);
        beautyBaseView.setCurrentMenuId(BeautyBaseView.MENU_ID_HOME);


        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.srl_layout);
        data = new ArrayList<>();

        swipeLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        mDatabaseRef = FirebaseDatabase.getInstance().getReference(FB_DATABASE_PATH);

        swipeLayout.setOnRefreshListener(HomeActivity.this);

        mDatabaseRef.orderByKey().startAt(olderPostId).limitToFirst(NUMBER_PAGE + 1)
                .addListenerForSingleValueEvent(this);


        setupRecyclerView();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    private void setupRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        imageAdapter = new ImageAdapter(this, R.layout.item_image, data);
        mRecyclerView.setAdapter(imageAdapter);
    }

    @Override
    public void onRefresh() {
        swipeLayout.setRefreshing(true);
        if (!checkConnection()) {
            swipeLayout.setRefreshing(false);
        }
    }
    private boolean checkConnection() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.getSystemService(
                Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo == null) {
            Toast.makeText(this, "Network is disable ", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!networkInfo.isConnected()) {
            Toast.makeText(this, "Not connected", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!networkInfo.isAvailable()) {
            Toast.makeText(this, "Something is wrong", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        List<Images> tempList = new ArrayList<>();
        String currentPostId = "";
        for (DataSnapshot data : dataSnapshot.getChildren()) {
            currentPostId = data.getKey();
            Images funnyImageEntity = data.getValue(Images.class);
            tempList.add(funnyImageEntity);
        }

        data.addAll(tempList);

        imageAdapter.notifyDataSetChanged();
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }




}
