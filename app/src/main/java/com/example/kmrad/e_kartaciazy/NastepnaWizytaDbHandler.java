package com.example.kmrad.e_kartaciazy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kmrad on 01.01.2019.
 */

public class NastepnaWizytaDbHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "NastepnaWizytaDB.db";
    public static final String TABLE_NAME = "NastepnaWizyta";
    public static final String COLUMN_TERMIN = "data";

    public NastepnaWizytaDbHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ( " + COLUMN_TERMIN + " TEXT)" ;
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addNastepnaWizytaHandler(ModelNastepnaWizyta nastepnaWizyta){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TERMIN, nastepnaWizyta.getTerminNastepnejWizyty());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public ModelNastepnaWizyta getNastepnaWizytaHandler(){
        String query = "Select * FROM " + TABLE_NAME + " ORDER BY " + COLUMN_TERMIN + " DESC LIMIT 1";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        ModelNastepnaWizyta nastepnaWizyta = new ModelNastepnaWizyta();
        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            nastepnaWizyta.setTerminNastepnejWizyty(cursor.getString(0));
            cursor.close();
        } else {
            nastepnaWizyta = null;
        }
        db.close();
        return nastepnaWizyta;
    }

}