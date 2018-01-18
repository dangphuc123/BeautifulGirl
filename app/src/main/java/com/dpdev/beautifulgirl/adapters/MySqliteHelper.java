package com.dpdev.beautifulgirl.adapters;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.dpdev.beautifulgirl.models.ImageFavorite;

import java.util.ArrayList;

/**
 * Created by User on 1/18/2018.
 */

public class MySqliteHelper extends SQLiteOpenHelper {


    private static final String TAG = "SQLite";
    // Phiên bản
    private static final int DATABASE_VERSION = 1;
    // Tên cơ sở dữ liệu.
    private static final String DATABASE_NAME = "Note_Manager";
    // Tên bảng
    private static final String TABLE_IMAGE = "Images";

    private static final String COLUMN_NOTE_ID ="Note_Id";
    private static final String COLUMN_IMAGE ="Note_Image";

    public MySqliteHelper(Context context)  {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String script = "CREATE TABLE " + TABLE_IMAGE + "("
                + COLUMN_NOTE_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_IMAGE +" TEXT"+")";
        sqLiteDatabase.execSQL(script);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_IMAGE);
        onCreate(sqLiteDatabase);
    }

    public void addImages(ImageFavorite image) {
        SQLiteDatabase db = this.getWritableDatabase();//mở database de co the doc vai chinh sua
        ContentValues values = new ContentValues();//de put all gia tri cua table vao
        values.put(COLUMN_IMAGE, image.getImage());
        db.insert(TABLE_IMAGE, null, values);
        db.close();
    }

    public ArrayList<ImageFavorite> getallImage(){
        ArrayList<ImageFavorite> mList= new ArrayList<>();
        String selectQuery="SELECT * FROM "+TABLE_IMAGE;//cau truy van
        SQLiteDatabase db = this.getWritableDatabase();//mở database de co the doc vai chinh sua
        Cursor cursor = db.rawQuery(selectQuery,null);
        if(cursor.moveToFirst())//kq tra ve co it nhat 1 gia tri
        {
            do{
                ImageFavorite imageFavorite = new ImageFavorite();
                imageFavorite.setId(cursor.getInt(0));
                imageFavorite.setImage(cursor.getString(1));
                mList.add(imageFavorite);
            }
            while(cursor.moveToNext());
        }
        db.close();
        return mList;
    }

    public int deleteImagebyid(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_IMAGE,COLUMN_NOTE_ID+"=?",new String[]{String.valueOf(id)});
    }

    public int deleteImagebylink(String image){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_IMAGE,COLUMN_IMAGE+"=?",new String[]{String.valueOf(image)});
    }

    public void deleteallImage(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_IMAGE,null,null);
    }
}
