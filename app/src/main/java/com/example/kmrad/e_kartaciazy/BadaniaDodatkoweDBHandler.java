package com.example.kmrad.e_kartaciazy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kmrad on 04.01.2019.
 */

public class BadaniaDodatkoweDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "BadaniaDodatkoweDB.db";
    public static final String TABLE_NAME = "Badania_dodatkowe";
    public static final String COLUMN_GLUKOZA = "glukoza";
    public static final String COLUMN_GLUKOZA_DATA = "glukoza_data";
    public static final String COLUMN_TSH = "tsh";
    public static final String COLUMN_TSH_DATA = "tsh_data";
    public static final String COLUMN_ANTY_TPO = "tpo";
    public static final String COLUMN_ANTY_TPO_DATA = "tpo_data";
    public static final String COLUMN_WR = "wr";
    public static final String COLUMN_WR_DATA = "wr_data";
    public static final String COLUMN_HBS = "hbs";
    public static final String COLUMN_HBS_DATA = "hbs_data";
    public static final String COLUMN_HCV = "hcv";
    public static final String COLUMN_HCV_DATA = "hcv_data";
    public static final String COLUMN_HIV = "hiv";
    public static final String COLUMN_HIV_DATA = "hiv_data";
    public static final String COLUMN_TOKSO = "toksoplazmoza";
    public static final String COLUMN_TOKSO_DATA = "toksoplazmoza_data";
    public static final String COLUMN_CYTO = "cytomegalia";
    public static final String COLUMN_CYTO_DATA = "cytomegalia_data";
    public static final String COLUMN_ROZYCZKA = "rozyczka";
    public static final String COLUMN_ROZYCZKA_DATA = "rozyczka_data";
    public static final String COLUMN_TOKSO_IGM = "toksoplazmoza_igm";
    public static final String COLUMN_TOKSO_DATA_IGM = "toksoplazmoza_data_igm";



    public BadaniaDodatkoweDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + COLUMN_GLUKOZA + " TEXT," +  COLUMN_GLUKOZA_DATA + " TEXT, " +
                COLUMN_TSH + " TEXT, " + COLUMN_TSH_DATA + " TEXT, " + COLUMN_ANTY_TPO + " TEXT, " +
                COLUMN_ANTY_TPO_DATA + " TEXT, " + COLUMN_WR + " TEXT, " + COLUMN_WR_DATA + " TEXT, " +
                COLUMN_HBS + " TEXT, " + COLUMN_HBS_DATA + " TEXT, " + COLUMN_HCV + " TEXT, " +
                COLUMN_HCV_DATA + " TEXT, " + COLUMN_HIV + " TEXT, " + COLUMN_HIV_DATA + " TEXT, " +
                COLUMN_TOKSO + " TEXT, " + COLUMN_TOKSO_DATA + " TEXT, " + COLUMN_CYTO + " TEXT, " +
                COLUMN_CYTO_DATA + " TEXT, " + COLUMN_ROZYCZKA + " TEXT, " + COLUMN_ROZYCZKA_DATA + " TEXT, " +
                COLUMN_TOKSO_IGM + " TEXT, " + COLUMN_TOKSO_DATA_IGM + " TEXT)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addBadaniaDodatkoweHandler(ModelBadaniaDodatkowe badaniaDodatkowe){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_GLUKOZA, badaniaDodatkowe.getGlukozaNaCzczo());
        values.put(COLUMN_GLUKOZA_DATA, badaniaDodatkowe.getGlukozaNaCzczoData());
        values.put(COLUMN_TSH, badaniaDodatkowe.getTSH());
        values.put(COLUMN_TSH_DATA, badaniaDodatkowe.getTSHData());
        values.put(COLUMN_ANTY_TPO, badaniaDodatkowe.getAntyTPO());
        values.put(COLUMN_ANTY_TPO_DATA, badaniaDodatkowe.getAntyTpoData());
        values.put(COLUMN_WR, badaniaDodatkowe.getWR());
        values.put(COLUMN_WR_DATA, badaniaDodatkowe.getWRData());
        values.put(COLUMN_HBS, badaniaDodatkowe.getHBs());
        values.put(COLUMN_HBS_DATA, badaniaDodatkowe.getHBSData());
        values.put(COLUMN_HCV, badaniaDodatkowe.getHCV());
        values.put(COLUMN_HCV_DATA, badaniaDodatkowe.getHCVData());
        values.put(COLUMN_HIV, badaniaDodatkowe.getHIV());
        values.put(COLUMN_HIV_DATA, badaniaDodatkowe.getHIVData());
        values.put(COLUMN_TOKSO, badaniaDodatkowe.getToksoplazmoza());
        values.put(COLUMN_TOKSO_DATA, badaniaDodatkowe.getToksoplazmozaData());
        values.put(COLUMN_CYTO, badaniaDodatkowe.getCytomegalia());
        values.put(COLUMN_CYTO_DATA, badaniaDodatkowe.getCytomegaliaData());
        values.put(COLUMN_ROZYCZKA, badaniaDodatkowe.getRozyczka());
        values.put(COLUMN_ROZYCZKA_DATA, badaniaDodatkowe.getRozyczkaData());
        values.put(COLUMN_TOKSO_IGM, badaniaDodatkowe.getToksoplazmozaIGM());
        values.put(COLUMN_TOKSO_DATA_IGM, badaniaDodatkowe.getToksoplazmozaIGMData());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public void updateBadaniaDodatkoweHandler(ModelBadaniaDodatkowe badaniaDodatkowe){
        SQLiteDatabase db = this.getWritableDatabase();
        String DELETE_FROM = "Delete from " + TABLE_NAME;
        db.execSQL(DELETE_FROM);
        ContentValues values = new ContentValues();
        values.put(COLUMN_GLUKOZA, badaniaDodatkowe.getGlukozaNaCzczo());
        values.put(COLUMN_GLUKOZA_DATA, badaniaDodatkowe.getGlukozaNaCzczoData());
        values.put(COLUMN_TSH, badaniaDodatkowe.getTSH());
        values.put(COLUMN_TSH_DATA, badaniaDodatkowe.getTSHData());
        values.put(COLUMN_ANTY_TPO, badaniaDodatkowe.getAntyTPO());
        values.put(COLUMN_ANTY_TPO_DATA, badaniaDodatkowe.getAntyTpoData());
        values.put(COLUMN_WR, badaniaDodatkowe.getWR());
        values.put(COLUMN_WR_DATA, badaniaDodatkowe.getWRData());
        values.put(COLUMN_HBS, badaniaDodatkowe.getHBs());
        values.put(COLUMN_HBS_DATA, badaniaDodatkowe.getHBSData());
        values.put(COLUMN_HCV, badaniaDodatkowe.getHCV());
        values.put(COLUMN_HCV_DATA, badaniaDodatkowe.getHCVData());
        values.put(COLUMN_HIV, badaniaDodatkowe.getHIV());
        values.put(COLUMN_HIV_DATA, badaniaDodatkowe.getHIVData());
        values.put(COLUMN_TOKSO, badaniaDodatkowe.getToksoplazmoza());
        values.put(COLUMN_TOKSO_DATA, badaniaDodatkowe.getToksoplazmozaData());
        values.put(COLUMN_CYTO, badaniaDodatkowe.getCytomegalia());
        values.put(COLUMN_CYTO_DATA, badaniaDodatkowe.getCytomegaliaData());
        values.put(COLUMN_ROZYCZKA, badaniaDodatkowe.getRozyczka());
        values.put(COLUMN_ROZYCZKA_DATA, badaniaDodatkowe.getRozyczkaData());
        values.put(COLUMN_TOKSO_IGM, badaniaDodatkowe.getToksoplazmozaIGM());
        values.put(COLUMN_TOKSO_DATA_IGM, badaniaDodatkowe.getToksoplazmozaIGMData());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public ModelBadaniaDodatkowe getBadaniaDodatkoweHandler(){
        String query = "Select * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        ModelBadaniaDodatkowe badaniaDodatkowe = new ModelBadaniaDodatkowe();
        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            badaniaDodatkowe.setGlukozaNaCzczo(cursor.getString(0));
            badaniaDodatkowe.setGlukozaNaCzczoData(cursor.getString(1));
            badaniaDodatkowe.setTSH(cursor.getString(2));
            badaniaDodatkowe.setTSHData(cursor.getString(3));
            badaniaDodatkowe.setAntyTPO(cursor.getString(4));
            badaniaDodatkowe.setAntyTpoData(cursor.getString(5));
            badaniaDodatkowe.setWR(cursor.getString(6));
            badaniaDodatkowe.setWRData(cursor.getString(7));
            badaniaDodatkowe.setHBs(cursor.getString(8));
            badaniaDodatkowe.setHBSData(cursor.getString(9));
            badaniaDodatkowe.setHCV(cursor.getString(10));
            badaniaDodatkowe.setHCVData(cursor.getString(11));
            badaniaDodatkowe.setHIV(cursor.getString(12));
            badaniaDodatkowe.setHIVData(cursor.getString(13));
            badaniaDodatkowe.setToksoplazmoza(cursor.getString(14));
            badaniaDodatkowe.setToksoplazmozaData(cursor.getString(15));
            badaniaDodatkowe.setCytomegalia(cursor.getString(16));
            badaniaDodatkowe.setCytomegaliaData(cursor.getString(17));
            badaniaDodatkowe.setRozyczka(cursor.getString(18));
            badaniaDodatkowe.setRozyczkaData(cursor.getString(19));
            badaniaDodatkowe.setToksoplazmozaIGM(cursor.getString(20));
            badaniaDodatkowe.setToksoplazmozaIGMData(cursor.getString(21));
            cursor.close();
        } else {
            badaniaDodatkowe = null;
        }
        db.close();
        return badaniaDodatkowe;
    }

}
