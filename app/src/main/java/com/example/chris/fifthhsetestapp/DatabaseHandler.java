package com.example.chris.fifthhsetestapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.icu.text.SimpleDateFormat;
import android.widget.OverScroller;

import java.util.Date;
import java.util.Locale;

/**
 * Created by chris on 5/1/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DatabaseVersion = 1;
    private static final String DatabaseName = "db_testSql";
    private static final String CreateTable_TenantInfo = " Create Table TenantInfo(ID Integer Primary Key AutoIncrement, TenantName Text, Address Text, City Text, State Text, Mobile Text, CreateOn  DateTime)";

    private static DatabaseHandler mInstance = null;
    public static DatabaseHandler getmInstance(Context context){
        if(mInstance == null){
            mInstance = new DatabaseHandler((context.getApplicationContext()));
        }
        return mInstance;
    }

    public DatabaseHandler(Context context){
        super(context, DatabaseName, null, DatabaseVersion);
    }
    @Override
    public void onCreate(SQLiteDatabase database){
        database.execSQL(CreateTable_TenantInfo);

    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion){
        onCreate(database);
    }

    //To Get Current DateTime
    //private String  getDateTime() {
      //  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        //Date date = new Date();
        //return dateFormat.format(date);
    //}

    //Insert Record in TenantInfo Table
    //TenantInfo(ID Integer Primary Key AutoIncrement, TenantName Text, Address Text, City Text, State Text, Mobile Integer, CreateOn  DateTime)
    public long insertIntoTenantInfo(String TenantName, String Address, String City, String State, String Mobile){

        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("TenantName", TenantName);
        values.put("Address", Address);
        values.put("City", City);
        values.put("State", State);
        values.put("Mobile", Mobile);
      //  values.put("CreatedOn",getDateTime());

        long id = database.insert("TenantInfo", null, values);

        return id;
    }

}
