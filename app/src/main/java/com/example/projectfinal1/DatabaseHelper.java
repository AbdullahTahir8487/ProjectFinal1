package com.example.projectfinal1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="Personal.db";
    public static final String TABLE_NAME="CitizenRecord";
    public static final String CITIZEN_NATIONAL_ID="ID";
    public static final String CITIZEN_F_NAME="FIRSTNAME";
    public static final String CITIZEN_L_NAME="LASTNAME";
    public static final String CITIZEN_PROFESSION="PROF";
    public static final String CITIZEN_STATUS="STATUS";
    public static final String CITIZEN_DOB="DOB";
    public static final String CITIZEN_GENDER="GENDER";
    public static final String CITIZEN_PARENT_NAME="PARENT";


    public DatabaseHelper(@Nullable Context context ) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase myDB) {

        myDB.execSQL(
                "CREATE TABLE "+TABLE_NAME +"("
                        + CITIZEN_NATIONAL_ID + " INTEGER PRIMARY KEY, "
                        + CITIZEN_F_NAME + " TEXT NOT NULL,"
                        + CITIZEN_L_NAME + " TEXT NOT NULL,"
                        + CITIZEN_PROFESSION + " TEXT NOT NULL,"
                        + CITIZEN_STATUS + " TEXT NOT NULL,"
                        + CITIZEN_DOB + " TEXT NOT NULL,"
                        + CITIZEN_GENDER + " TEXT NOT NULL,"

                        + CITIZEN_PARENT_NAME + " TEXT NOT NULL )");


    }

    public void AddCitizen(String ID,String FNAME,String LNAME,String PROFESSION,String STATUS,String DOB,String GENDER,String PARENTNAME){
        SQLiteDatabase myDB=this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(CITIZEN_NATIONAL_ID,ID);
        values.put(CITIZEN_F_NAME,FNAME);
        values.put(CITIZEN_L_NAME,LNAME);
        values.put(CITIZEN_PROFESSION,PROFESSION);
        values.put(CITIZEN_STATUS,STATUS);
        values.put(CITIZEN_DOB,DOB);
        values.put(CITIZEN_GENDER,GENDER);
        values.put(CITIZEN_PARENT_NAME,PARENTNAME);

        myDB.insert(TABLE_NAME,null,values);
    }
    public Cursor ViewCitizen(){
        SQLiteDatabase myDB=this.getWritableDatabase();
        Cursor X=myDB.rawQuery("SELECT * FROM  "+TABLE_NAME,null);
        return X;
    }

    public Integer DeleteCitizen(String ID){
        SQLiteDatabase myDBPersonal=this.getWritableDatabase();
        return myDBPersonal.delete(TABLE_NAME,"ID=?", new String []{ID});


    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
