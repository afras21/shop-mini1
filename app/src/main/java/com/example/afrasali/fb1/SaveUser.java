package com.example.afrasali.fb1;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Afras Ali on 6/5/2017.
 */

public class SaveUser extends SQLiteOpenHelper {

    public SaveUser(Context context) {
        super(context, "db", null,12);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       db.execSQL("create table admin (pname text, pprice text)");
       db.execSQL("create table minu (pname text, pprice text)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists admin");
        db.execSQL("drop table if exists minu");

        onCreate(db);
    }
}
