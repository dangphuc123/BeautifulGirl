package com.dpdev.beautifulgirl.adapters;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.dpdev.beautifulgirl.R;
import com.dpdev.beautifulgirl.models.ImageFavorite;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by User on 1/18/2018.
 */

public class FavoriteAdapter extends ArrayAdapter<ImageFavorite> {
    private Activity activity;
    private int idLayout;
    private ArrayList<ImageFavorite> list;

    public FavoriteAdapter(Activity activity, int idLayout, ArrayList<ImageFavorite> list) {
        super(activity, idLayout, list);
        this.activity = activity;
        this.idLayout = idLayout;
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final ImageFavorite imageFavorite = getItem(position);
        LayoutInflater inflater = activity.getLayoutInflater();
        convertView = inflater.inflate(idLayout,null);
         ImageView imageView =(ImageView) convertView.findViewById(R.id.img_favorite);
        Picasso.with(activity).load(imageFavorite.getImage()).into(imageView);
        return convertView;
    }
}
