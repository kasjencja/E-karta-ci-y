package com.example.kmrad.e_kartaciazy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kmrad on 03.01.2019.
 */

public class WywiadRodzinnyDbHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "WywiadRodzinnyDB.db";
    public static final String TABLE_NAME = "Wywiad_rodzinny";
    public static final String COLUMN_KREW_MATKI = "krew_matki";
    public static final String COLUMN_KREW_OJCA = "krew_ojca";
    public static final String COLUMN_CHOROBY_KRAZENIA = "choroby_krazenia";
    public static final String COLUMN_CHOROBY_NEREK = "choroby_nerek";
    public static final String COLUMN_CHOROBY_NEUROLOGICZNE = "choroby_neurologiczne";
    public static final String COLUMN_CHOROBY_WATROBY = "choroby_watroby";
    public static final String COLUMN_CHOROBY_ZOLADKA = "choroby_zoladka";
    public static final String COLUMN_CHOROBY_PLUC = "choroby_pluc";
    public static final String COLUMN_CHOROBY_TARCZYCY = "choroby_tarczycy";
    public static final String COLUMN_CUKRZYCA = "cukrzyca";
    public static final String COLUMN_TROMBOFILIA = "trombofilia";
    public static final String COLUMN_HIV = "hiv";
    public static final String COLUMN_NIEPLODNOSC_K = "nieplodnosc_k";
    public static final String COLUMN_NIEPLODNOSC_M = "nieplodnosc_m";
    public static final String COLUMN_REGULACJA_PLODNOSCI_MECHANICZNA = "regulacja_mechaniczna";
    public static final String COLUMN_REGULACJA_PLODNOSCI_HORMONALNA = "regulacja_hormonalna";
    public static final String COLUMN_REGULACJA_PLODNOSCI_INNA = "regulacja_inna";
    public static final String COLUMN_REGULACJA_PLODNOSCI_W_CIAZY = "regulacja_ciaza";

    public WywiadRodzinnyDbHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + COLUMN_KREW_MATKI + " TEXT," +  COLUMN_KREW_OJCA + " TEXT, " +
                COLUMN_CHOROBY_KRAZENIA + " TEXT, " + COLUMN_CHOROBY_NEREK + " TEXT, " + COLUMN_CHOROBY_NEUROLOGICZNE + " TEXT, " +
                COLUMN_CHOROBY_WATROBY + " TEXT, " + COLUMN_CHOROBY_ZOLADKA + " TEXT, " + COLUMN_CHOROBY_PLUC + " TEXT, " +
                COLUMN_CHOROBY_TARCZYCY + " TEXT, " + COLUMN_CUKRZYCA + " TEXT, " + COLUMN_TROMBOFILIA + " TEXT, " +
                COLUMN_HIV + " TEXT, " + COLUMN_NIEPLODNOSC_K + " TEXT, " + COLUMN_NIEPLODNOSC_M + " TEXT, " +
                COLUMN_REGULACJA_PLODNOSCI_MECHANICZNA + " TEXT, " + COLUMN_REGULACJA_PLODNOSCI_HORMONALNA + " TEXT, " +
                COLUMN_REGULACJA_PLODNOSCI_INNA + " TEXT, " + COLUMN_REGULACJA_PLODNOSCI_W_CIAZY + " TEXT)";
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addWywiadRodzinnyHandler(ModelWywiadRodzinny wywiadRodzinny){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_KREW_MATKI, wywiadRodzinny.getKrewMatki());
        values.put(COLUMN_KREW_OJCA, wywiadRodzinny.getKrewOjca());
        values.put(COLUMN_CHOROBY_KRAZENIA, wywiadRodzinny.getChorobyKrazenia());
        values.put(COLUMN_CHOROBY_NEREK, wywiadRodzinny.getChorobyNerek());
        values.put(COLUMN_CHOROBY_NEUROLOGICZNE, wywiadRodzinny.getChorobyNeurologiczne());
        values.put(COLUMN_CHOROBY_WATROBY, wywiadRodzinny.getChorobyWatroby());
        values.put(COLUMN_CHOROBY_ZOLADKA, wywiadRodzinny.getChorobyZoladka());
        values.put(COLUMN_CHOROBY_PLUC, wywiadRodzinny.getChorobyPluc());
        values.put(COLUMN_CHOROBY_TARCZYCY, wywiadRodzinny.getChorobyTarczycy());
        values.put(COLUMN_CUKRZYCA, wywiadRodzinny.getCukrzyca());
        values.put(COLUMN_TROMBOFILIA, wywiadRodzinny.getTrombofilia());
        values.put(COLUMN_HIV, wywiadRodzinny.getHIV());
        values.put(COLUMN_NIEPLODNOSC_K, wywiadRodzinny.getNieplodnosciKobieta());
        values.put(COLUMN_NIEPLODNOSC_M, wywiadRodzinny.getNieplodnosciMezczyzna());
        values.put(COLUMN_REGULACJA_PLODNOSCI_MECHANICZNA, wywiadRodzinny.getRegulacjaPlodnosciMechaniczna());
        values.put(COLUMN_REGULACJA_PLODNOSCI_HORMONALNA, wywiadRodzinny.getRegulacjaPlodnosciHormonalna());
        values.put(COLUMN_REGULACJA_PLODNOSCI_INNA, wywiadRodzinny.getRegulacjaPlodnosciInna());
        values.put(COLUMN_REGULACJA_PLODNOSCI_W_CIAZY, wywiadRodzinny.getRegulacjeStosowaneWCiazy());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public void updateWywiadRodzinnyHandler(ModelWywiadRodzinny wywiadRodzinny){
        SQLiteDatabase db = this.getWritableDatabase();
        String DELETE_FROM = "Delete from " + TABLE_NAME;
        db.execSQL(DELETE_FROM);
        ContentValues values = new ContentValues();
        values.put(COLUMN_KREW_MATKI, wywiadRodzinny.getKrewMatki());
        values.put(COLUMN_KREW_OJCA, wywiadRodzinny.getKrewOjca());
        values.put(COLUMN_CHOROBY_KRAZENIA, wywiadRodzinny.getChorobyKrazenia());
        values.put(COLUMN_CHOROBY_NEREK, wywiadRodzinny.getChorobyNerek());
        values.put(COLUMN_CHOROBY_NEUROLOGICZNE, wywiadRodzinny.getChorobyNeurologiczne());
        values.put(COLUMN_CHOROBY_WATROBY, wywiadRodzinny.getChorobyWatroby());
        values.put(COLUMN_CHOROBY_ZOLADKA, wywiadRodzinny.getChorobyZoladka());
        values.put(COLUMN_CHOROBY_PLUC, wywiadRodzinny.getChorobyPluc());
        values.put(COLUMN_CHOROBY_TARCZYCY, wywiadRodzinny.getChorobyTarczycy());
        values.put(COLUMN_CUKRZYCA, wywiadRodzinny.getCukrzyca());
        values.put(COLUMN_TROMBOFILIA, wywiadRodzinny.getTrombofilia());
        values.put(COLUMN_HIV, wywiadRodzinny.getHIV());
        values.put(COLUMN_NIEPLODNOSC_K, wywiadRodzinny.getNieplodnosciKobieta());
        values.put(COLUMN_NIEPLODNOSC_M, wywiadRodzinny.getNieplodnosciMezczyzna());
        values.put(COLUMN_REGULACJA_PLODNOSCI_MECHANICZNA, wywiadRodzinny.getRegulacjaPlodnosciMechaniczna());
        values.put(COLUMN_REGULACJA_PLODNOSCI_HORMONALNA, wywiadRodzinny.getRegulacjaPlodnosciHormonalna());
        values.put(COLUMN_REGULACJA_PLODNOSCI_INNA, wywiadRodzinny.getRegulacjaPlodnosciInna());
        values.put(COLUMN_REGULACJA_PLODNOSCI_W_CIAZY, wywiadRodzinny.getRegulacjeStosowaneWCiazy());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public ModelWywiadRodzinny getWywiadRodzinnyHandler(){
        String query = "Select * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        ModelWywiadRodzinny wywiadRodzinny = new ModelWywiadRodzinny();
        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            wywiadRodzinny.setKrewMatki(cursor.getString(0));
            wywiadRodzinny.setKrewOjca(cursor.getString(1));
            wywiadRodzinny.setChorobyKrazenia(cursor.getString(2));
            wywiadRodzinny.setChorobyNerek(cursor.getString(3));
            wywiadRodzinny.setChorobyNeurologiczne(cursor.getString(4));
            wywiadRodzinny.setChorobyWatroby(cursor.getString(5));
            wywiadRodzinny.setChorobyZoladka(cursor.getString(6));
            wywiadRodzinny.setChorobyPluc(cursor.getString(7));
            wywiadRodzinny.setChorobyTarczycy(cursor.getString(8));
            wywiadRodzinny.setCukrzyca(cursor.getString(9));
            wywiadRodzinny.setTrombofilia(cursor.getString(10));
            wywiadRodzinny.setHIV(cursor.getString(11));
            wywiadRodzinny.setNieplodnosciKobieta(cursor.getString(12));
            wywiadRodzinny.setNieplodnosciMezczyzna(cursor.getString(13));
            wywiadRodzinny.setRegulacjaPlodnosciMechaniczna(cursor.getString(14));
            wywiadRodzinny.setRegulacjaPlodnosciHormonalna(cursor.getString(15));
            wywiadRodzinny.setRegulacjaPlodnosciInna(cursor.getString(16));
            wywiadRodzinny.setRegulacjeStosowaneWCiazy(cursor.getString(17));
            cursor.close();
        } else {
            wywiadRodzinny = null;
        }
        db.close();
        return wywiadRodzinny;
    }
}
