package com.example.kmrad.e_kartaciazy;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import android.graphics.ColorSpace;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kmrad on 20.12.2018.
 */

public class BadaniaDbHandler  extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "badaniaDB.db";
    public static final String TABLE_NAME = "Badania";
    public static final String COLUMN_ID = "id_badania";
    public static final String COLUMN_DATA_BADANIA = "data_badania";
    public static final String COLUMN_TERMIN_NW = "termin_nw";
    public static final String COLUMN_UWAGI = "uwagi";
    public static final String COLUMN_WAGA = "waga";
    public static final String COLUMN_ZYLAKI = "zylaki";
    public static final String COLUMN_BADANIA_KRWI = "badania_krwi";
    public static final String COLUMN_RBC = "rbc";
    public static final String COLUMN_HCT = "hct";
    public static final String COLUMN_HB = "hb";
    public static final String COLUMN_WBC = "wbc";
    public static final String COLUMN_PLT = "plt";
    public static final String COLUMN_BADANIA_MOCZU = "badania_moczu";
    public static final String COLUMN_CW = "cw";
    public static final String COLUMN_BIALKO = "bialko";
    public static final String COLUMN_GLUKOZA = "glukoza";
    public static final String COLUMN_E = "e";
    public static final String COLUMN_L = "l";
    public static final String COLUMN_BAKTERIE = "bakterie";

    public BadaniaDbHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + COLUMN_ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_DATA_BADANIA + " TEXT," + COLUMN_TERMIN_NW + " TEXT, " + COLUMN_UWAGI + " TEXT, "
                + COLUMN_WAGA + " TEXT, "+ COLUMN_ZYLAKI + " TEXT, "+ COLUMN_BADANIA_KRWI + " TEXT, "+
                COLUMN_RBC + " TEXT, " + COLUMN_HCT + " TEXT, " + COLUMN_HB + " TEXT, "+ COLUMN_WBC + " TEXT, "+ COLUMN_PLT +
                " TEXT, "+ COLUMN_BADANIA_MOCZU + " TEXT, "+  COLUMN_CW + " TEXT, "+ COLUMN_BIALKO + " TEXT, "+ COLUMN_GLUKOZA + " TEXT, "+
                COLUMN_E +" TEXT, "+ COLUMN_L +" TEXT, "+ COLUMN_BAKTERIE + " TEXT )";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addBadanieHandler(ModelBadania badanie) {
        SQLiteDatabase db = this.getWritableDatabase(); //tu sypie
        ContentValues values = new ContentValues();
        values.put(COLUMN_DATA_BADANIA, badanie.getDataBadania());
        values.put(COLUMN_TERMIN_NW, badanie.getTerminNW());
        values.put(COLUMN_UWAGI, badanie.getUwagiLekarza());
        values.put(COLUMN_WAGA, badanie.getObecnaWaga());
        values.put(COLUMN_ZYLAKI, badanie.getCzySaZylaki());
        values.put(COLUMN_BADANIA_KRWI, badanie.getBadaniaKrwi());
        values.put(COLUMN_RBC, badanie.getRBC());
        values.put(COLUMN_HCT, badanie.getHCT());
        values.put(COLUMN_HB, badanie.getHB());
        values.put(COLUMN_WBC, badanie.getWBC());
        values.put(COLUMN_PLT, badanie.getPLT());
        values.put(COLUMN_BADANIA_MOCZU, badanie.getBadaniaMoczu());
        values.put(COLUMN_CW, badanie.getCW());
        values.put(COLUMN_BIALKO, badanie.getBialko());
        values.put(COLUMN_GLUKOZA, badanie.getGlukoza());
        values.put(COLUMN_E, badanie.getE());
        values.put(COLUMN_L, badanie.getL());
        values.put(COLUMN_BAKTERIE, badanie.getBakterie());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public ArrayList<ListaBadan> getListaBadan(ArrayList<ListaBadan> listaBadan){
        String query = "Select " + COLUMN_ID + " , " + COLUMN_DATA_BADANIA + " FROM " + TABLE_NAME  + " ORDER BY " + COLUMN_DATA_BADANIA + " DESC";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String data = cursor.getString(1);
            listaBadan.add(new ListaBadan(id, data));
        }
        return listaBadan;
    }

    public ModelBadania findBadanieHandler(int id) {
        String query = "Select * FROM " + TABLE_NAME + " WHERE " + COLUMN_ID + " = " + id;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        ModelBadania badanie = new ModelBadania();
        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            badanie.setID(Integer.parseInt(cursor.getString(0)));
            badanie.setDataBadania(cursor.getString(1));
            badanie.setTerminNW(cursor.getString(2));
            badanie.setUwagiLekarza(cursor.getString(3));
            badanie.setObecnaWaga(cursor.getString(4));
            badanie.setCzySaZylaki(cursor.getString(5));
            badanie.setBadaniaKrwi(cursor.getString(6));
            badanie.setRBC(cursor.getString(7));
            badanie.setHCT(cursor.getString(8));
            badanie.setHB(cursor.getString(9));
            badanie.setWBC(cursor.getString(10));
            badanie.setPLT(cursor.getString(11));
            badanie.setBadaniaMoczu(cursor.getString(12));
            badanie.setCW(cursor.getString(13));
            badanie.setBialko(cursor.getString(14));
            badanie.setGlukoza(cursor.getString(15));
            badanie.setE(cursor.getString(16));
            badanie.setL(cursor.getString(17));
            badanie.setBakterie(cursor.getString(18));
            cursor.close();
        } else {
            badanie = null;
        }
        db.close();
        return badanie;
    }


}
