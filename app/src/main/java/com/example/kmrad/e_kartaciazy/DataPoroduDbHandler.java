package com.example.kmrad.e_kartaciazy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kmrad on 30.12.2018.
 */

public class DataPoroduDbHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "DataPoroduDB.db";
    public static final String TABLE_NAME = "TerminPorodu";
    public static final String COLUMN_TERMIN = "data";

    public DataPoroduDbHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
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

    public void addDataPoroduHandler(ModelDataPorodu dataPorodu){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TERMIN, dataPorodu.getDataPorodu());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public ModelDataPorodu getDataPoroduHandler(){
        String query = "Select * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        ModelDataPorodu dataPorodu = new ModelDataPorodu();
        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            dataPorodu.setDataPorodu(cursor.getString(0));
            cursor.close();
        } else {
            dataPorodu = null;
        }
        db.close();
        return dataPorodu;
    }
}
