package com.example.turking;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class notveritabani extends SQLiteOpenHelper {
    public notveritabani(Context context) {
        super(context, "not", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table notdefteri (id INTEGER PRIMARY KEY ," +
                "note TEXT," +
                "trk TEXT ," +
                "ing TEXT," +
                "tarih TEXT," +
                "saat TEXT);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists notdefteri ");
        this.onCreate(db);

    }


}
