package com.example.anurag_pc.shreyafinalproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Anurag-PC on 7/8/2017.
 */

public class ImageHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="abhi.db";
    private static final int SCHEMA_VERSION=1;

    public ImageHelper(Context context) {
        super(context, DATABASE_NAME, null, SCHEMA_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Image(_id INTEGER PRIMARY KEY AUTOINCREMENT,imageblob BLOB);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public Cursor getAll() {
        return(getReadableDatabase().rawQuery("SELECT imageblob FROM Image",null));
    }
    public void insert(byte[] bytes)
    {
        ContentValues cv=new ContentValues();

        cv.put("imageblob",bytes);
        Log.e("inserted", "inserted");
        getWritableDatabase().insert("Image","imageblob",cv);

    }
    public byte[] getImage(Cursor c)
    {
        return(c.getBlob(1));
    }
}
