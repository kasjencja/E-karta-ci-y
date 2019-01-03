package com.example.kmrad.e_kartaciazy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kmrad on 01.01.2019.
 */

public class WywiadGinekologicznyDbHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "WywiadGinekologicznyDB.db";
    public static final String TABLE_NAME = "Wywiad_ginekologiczny";
    public static final String COLUMN_DATA_OM = "data_om";
    public static final String COLUMN_CO_ILE_MIESIACZKA = "co_ile_miesiaczka";
    public static final String COLUMN_TERMIN_PORODU = "termin_porodu";
    public static final String COLUMN_PIERWSZA_MIESIACZKA = "pierwsza_miesiaczka";
    public static final String COLUMN_TRWANIE_MIESIACZKI = "trwanie_miesiaczki";
    public static final String COLUMN_CZY_MIESIACZKI_OBFITE = "czy_miesiaczki_obfite";
    public static final String COLUMN_CZY_MIESIACZKI_BOLESNE = "czy_miesiaczki_bolesne";
    public static final String COLUMN_CZY_ZABURZENIA_MIESIACZKOWANIA = "czy_zaburzenia_miesiaczkowania";
    public static final String COLUMN_PORONIENIA = "poronienia";
    public static final String COLUMN_PORODY = "porody";
    public static final String COLUMN_CIAZE_POZAMACICZNE = "ciaze_pozamaciczne";


    public WywiadGinekologicznyDbHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + COLUMN_DATA_OM + " TEXT," +  COLUMN_CO_ILE_MIESIACZKA + " TEXT, " +
                COLUMN_TERMIN_PORODU + " TEXT, " + COLUMN_PIERWSZA_MIESIACZKA + " TEXT, " + COLUMN_TRWANIE_MIESIACZKI + " TEXT, " +
                COLUMN_CZY_MIESIACZKI_OBFITE + " TEXT, " + COLUMN_CZY_MIESIACZKI_BOLESNE + " TEXT, " + COLUMN_CZY_ZABURZENIA_MIESIACZKOWANIA + " TEXT, " +
                COLUMN_PORONIENIA + " TEXT, " + COLUMN_PORODY + " TEXT, " + COLUMN_CIAZE_POZAMACICZNE + " TEXT)";
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addWywiadGinekologicznyHandler(ModelWywiadGinekologiczny wywiadGinekologiczny){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_DATA_OM, wywiadGinekologiczny.getDataOstatniejMiesiaczki());
        values.put(COLUMN_CO_ILE_MIESIACZKA, wywiadGinekologiczny.getCoIleWystepujeMiesiaczka());
        values.put(COLUMN_TERMIN_PORODU, wywiadGinekologiczny.getTerminPorodu());
        values.put(COLUMN_PIERWSZA_MIESIACZKA, wywiadGinekologiczny.getPierwszaMiesiaczka());
        values.put(COLUMN_TRWANIE_MIESIACZKI, wywiadGinekologiczny.getIleTrwaMiesiaczka());
        values.put(COLUMN_CZY_MIESIACZKI_OBFITE, wywiadGinekologiczny.getCzyMiesiaczkiObfite());
        values.put(COLUMN_CZY_MIESIACZKI_BOLESNE, wywiadGinekologiczny.getCzyMiesiaczkiBolesne());
        values.put(COLUMN_CZY_ZABURZENIA_MIESIACZKOWANIA, wywiadGinekologiczny.getCzyZaburzeniaMiesaiczkowania());
        values.put(COLUMN_PORONIENIA, wywiadGinekologiczny.getLiczbaPoronien());
        values.put(COLUMN_PORODY, wywiadGinekologiczny.getLiczbaPorodow());
        values.put(COLUMN_CIAZE_POZAMACICZNE, wywiadGinekologiczny.getLiczbaCiazPozamacicznych());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public ModelWywiadGinekologiczny getWywiadGinekologicznyHandler(){
        String query = "Select * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        ModelWywiadGinekologiczny wywiadGinekologiczny = new ModelWywiadGinekologiczny();
        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            wywiadGinekologiczny.setDataOstatniejMiesiaczki(cursor.getString(0));
            wywiadGinekologiczny.setCoIleWystepujeMiesiaczka(cursor.getString(1));
            wywiadGinekologiczny.setTerminPorodu(cursor.getString(2));
            wywiadGinekologiczny.setPierwszaMiesiaczka(cursor.getString(3));
            wywiadGinekologiczny.setIleTrwaMiesiaczka(cursor.getString(4));
            wywiadGinekologiczny.setCzyMiesiaczkiObfite(cursor.getString(5));
            wywiadGinekologiczny.setCzyMiesiaczkiBolesne(cursor.getString(6));
            wywiadGinekologiczny.setCzyZaburzeniaMiesaiczkowania(cursor.getString(7));
            wywiadGinekologiczny.setLiczbaPoronien(cursor.getString(8));
            wywiadGinekologiczny.setLiczbaPorodow(cursor.getString(9));
            wywiadGinekologiczny.setLiczbaCiazPozamacicznych(cursor.getString(10));
            cursor.close();
        } else {
            wywiadGinekologiczny = null;
        }
        db.close();
        return wywiadGinekologiczny;
    }

    public void updateWywiadGinekologicznyHandler(ModelWywiadGinekologiczny wywiadGinekologiczny){
        SQLiteDatabase db = this.getWritableDatabase();
        String DELETE_FROM = "Delete from " + TABLE_NAME;
        db.execSQL(DELETE_FROM);
        ContentValues values = new ContentValues();
        values.put(COLUMN_DATA_OM, wywiadGinekologiczny.getDataOstatniejMiesiaczki());
        values.put(COLUMN_CO_ILE_MIESIACZKA, wywiadGinekologiczny.getCoIleWystepujeMiesiaczka());
        values.put(COLUMN_TERMIN_PORODU, wywiadGinekologiczny.getTerminPorodu());
        values.put(COLUMN_PIERWSZA_MIESIACZKA, wywiadGinekologiczny.getPierwszaMiesiaczka());
        values.put(COLUMN_TRWANIE_MIESIACZKI, wywiadGinekologiczny.getIleTrwaMiesiaczka());
        values.put(COLUMN_CZY_MIESIACZKI_OBFITE, wywiadGinekologiczny.getCzyMiesiaczkiObfite());
        values.put(COLUMN_CZY_MIESIACZKI_BOLESNE, wywiadGinekologiczny.getCzyMiesiaczkiBolesne());
        values.put(COLUMN_CZY_ZABURZENIA_MIESIACZKOWANIA, wywiadGinekologiczny.getCzyZaburzeniaMiesaiczkowania());
        values.put(COLUMN_PORONIENIA, wywiadGinekologiczny.getLiczbaPoronien());
        values.put(COLUMN_PORODY, wywiadGinekologiczny.getLiczbaPorodow());
        values.put(COLUMN_CIAZE_POZAMACICZNE, wywiadGinekologiczny.getLiczbaCiazPozamacicznych());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

}
