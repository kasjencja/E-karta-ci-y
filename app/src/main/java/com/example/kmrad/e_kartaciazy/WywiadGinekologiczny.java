package com.example.kmrad.e_kartaciazy;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;

public class WywiadGinekologiczny extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent intent = new Intent(WywiadGinekologiczny.this, MainActivity.class);
                    startActivity(intent);
                    break;
                case R.id.navigation_dashboard:
                    Intent intentWybor = new Intent(WywiadGinekologiczny.this, WyborBadan.class);
                    startActivity(intentWybor);
                    break;
                case R.id.navigation_notifications:
                    return true;
            }
            return false;
        }
    };

    public static String data, dataPorodu;
    public static Boolean czyJestWczesniejszyZapis;
    Calendar c = Calendar.getInstance();
    int curRok = c.get(Calendar.YEAR);
    int curMiesiac = c.get(Calendar.MONTH);
    int curDzien = c.get(Calendar.DAY_OF_MONTH);

    @BindView(R.id.tv_TP)
    EditText terminPorodu;

    @BindView(R.id.text_data_OM)
    EditText dataOM;

    @BindView(R.id.ginekologiczny_dlugosc_cyklu)
    TextView dlugoscCyklu;

    @BindView(R.id.ginekologiczny_pierwsza_miesiaczka)
    EditText pierwszaMiesiaczka;

    @BindView(R.id.ginekologiczny_czas_trwania_miesiaczki)
    EditText czasTrwaniaMiesiaczki;

    @BindView(R.id.spinner_obfitosc)
    Spinner obfitoscMiesiaczki;

    @BindView(R.id.spinner_bolesnosc)
    Spinner bolesnoscMiesiaczki;

    @BindView(R.id.ginekologiczny_zaburzenia_nie)
    RadioButton zaburzeniaMiesiaczkowaniaNie;

    @BindView(R.id.ginekologiczny_zaburzenia_tak)
    RadioButton getZaburzeniaMiesiaczkowaniaTak;

    @BindView(R.id.ginekologiczny_liczba_poronien)
    EditText liczbaPoronien;

    @BindView(R.id.ginekologiczny_liczba_porodow)
    EditText liczbaPorodow;

    @BindView(R.id.liczba_ciazy_pozamacicznych)
    EditText liczbaCiazyPozamacicznych;

    @BindView(R.id.button_data_OM)
    ImageView buttonDataOM;

    @OnClick(R.id.ginekologiczny_button_zapisz)
    void OnClickButtonZapisz(){
       zapiszBadanie();
    }

    @OnClick(R.id.button_data_OM)
    void OnClickDataOM() {
        setDataOM(this.getCurrentFocus());
    }

    @OnTextChanged(R.id.ginekologiczny_dlugosc_cyklu)
    void OnTextDlugoscCykluChanged(){
        setDataPorodu();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wywiad_ginekologiczny);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.navigation_dashboard);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //spinner obfitosc miesiaczki
        Spinner spinnerObfitosc = (Spinner) findViewById(R.id.spinner_obfitosc);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.obfitosc_miesiaczki, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerObfitosc.setAdapter(adapter);

        //spinner bolesnosc
        Spinner spinnerBolesnosc = (Spinner) findViewById(R.id.spinner_bolesnosc);
        adapter = ArrayAdapter.createFromResource(this,
                R.array.bolesnosc_miesiaczki, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBolesnosc.setAdapter(adapter);

        ButterKnife.bind(this);

        //ładowanie widoku
        WywiadGinekologicznyDbHandler dbHandler = new WywiadGinekologicznyDbHandler(this, null, null,1);
        ModelWywiadGinekologiczny wywiadGinekologiczny = dbHandler.getWywiadGinekologicznyHandler();
        if (wywiadGinekologiczny!=null){
            czyJestWczesniejszyZapis = true;
            if (!wywiadGinekologiczny.getDataOstatniejMiesiaczki().equals("Brak informacji")){
                dataOM.setText(wywiadGinekologiczny.getDataOstatniejMiesiaczki());
                buttonDataOM.setEnabled(false);
            }
            if (!wywiadGinekologiczny.getCoIleWystepujeMiesiaczka().equals("Brak informacji")){
                dlugoscCyklu.setText(wywiadGinekologiczny.getCoIleWystepujeMiesiaczka());
                dlugoscCyklu.setEnabled(false);
            }
            if (!wywiadGinekologiczny.getTerminPorodu().equals("Brak informacji")){
                terminPorodu.setText(wywiadGinekologiczny.getTerminPorodu());
            }
            if (!wywiadGinekologiczny.getPierwszaMiesiaczka().equals("Brak informacji")){
                pierwszaMiesiaczka.setText(wywiadGinekologiczny.getPierwszaMiesiaczka());
                pierwszaMiesiaczka.setEnabled(false);
            }
            if (!wywiadGinekologiczny.getIleTrwaMiesiaczka().equals("Brak informacji")){
                czasTrwaniaMiesiaczki.setText(wywiadGinekologiczny.getIleTrwaMiesiaczka());
                czasTrwaniaMiesiaczki.setEnabled(false);
            }
            if (!wywiadGinekologiczny.getCzyMiesiaczkiObfite().equals("Brak informacji")){
                switch (wywiadGinekologiczny.getCzyMiesiaczkiObfite()) {
                    case "Obfite":
                        obfitoscMiesiaczki.setSelection(1);
                        obfitoscMiesiaczki.setEnabled(false);
                        break;
                    case "Mierne":
                        obfitoscMiesiaczki.setSelection(2);
                        obfitoscMiesiaczki.setEnabled(false);
                        break;
                    case "Skąpe":
                        obfitoscMiesiaczki.setSelection(3);
                        obfitoscMiesiaczki.setEnabled(false);
                        break;
                }
            }
            if (!wywiadGinekologiczny.getCzyMiesiaczkiBolesne().equals("Brak informacji")){
                switch (wywiadGinekologiczny.getCzyMiesiaczkiBolesne()) {
                    case "Bolesne":
                        bolesnoscMiesiaczki.setSelection(1);
                        bolesnoscMiesiaczki.setEnabled(false);
                        break;
                    case "Niebolesne":
                        bolesnoscMiesiaczki.setSelection(2);
                        bolesnoscMiesiaczki.setEnabled(false);
                        break;
                }
            }
            if (!wywiadGinekologiczny.getCzyZaburzeniaMiesaiczkowania().equals("Brak informacji")){
                if (wywiadGinekologiczny.getCzyZaburzeniaMiesaiczkowania().equals("Tak")) {
                    getZaburzeniaMiesiaczkowaniaTak.setChecked(true);
                    zaburzeniaMiesiaczkowaniaNie.setChecked(false);
                    getZaburzeniaMiesiaczkowaniaTak.setEnabled(false);
                    zaburzeniaMiesiaczkowaniaNie.setEnabled(false);
                } else {
                    getZaburzeniaMiesiaczkowaniaTak.setChecked(false);
                    zaburzeniaMiesiaczkowaniaNie.setChecked(true);
                    getZaburzeniaMiesiaczkowaniaTak.setEnabled(false);
                    zaburzeniaMiesiaczkowaniaNie.setEnabled(false);
                }
            }
            if (!wywiadGinekologiczny.getLiczbaPoronien().equals("Brak informacji")){
                liczbaPoronien.setText(wywiadGinekologiczny.getLiczbaPoronien());
                liczbaPoronien.setEnabled(false);
            }
            if (!wywiadGinekologiczny.getLiczbaPorodow().equals("Brak informacji")){
                liczbaPorodow.setText(wywiadGinekologiczny.getLiczbaPorodow());
                liczbaPorodow.setEnabled(false);
            }
            if (!wywiadGinekologiczny.getLiczbaCiazPozamacicznych().equals("Brak informacji")){
                liczbaCiazyPozamacicznych.setText(wywiadGinekologiczny.getLiczbaCiazPozamacicznych());
                liczbaCiazyPozamacicznych.setEnabled(false);
            }
        } else {czyJestWczesniejszyZapis = false;}

    }

    public void setDataPorodu(){

        if (data != null && !dlugoscCyklu.getText().toString().isEmpty()){
            int dniCyklu = Integer.parseInt(dlugoscCyklu.getText().toString());
            SimpleDateFormat formatDaty = new SimpleDateFormat("dd/MM/yyyy");
            Date terminPoroduWyliczony = formatDaty.parse(data, new ParsePosition(0));
            c.setTime(terminPoroduWyliczony);
            c.add(Calendar.DATE, 7);
            c.add(Calendar.MONTH, -3);
            c.add(Calendar.DATE, (dniCyklu-28));
            terminPoroduWyliczony = c.getTime();
            dataPorodu = formatDaty.format(terminPoroduWyliczony);
            terminPorodu.setText(dataPorodu);
            if (terminPoroduWyliczony.toString() == "01/01/2018") {
                String halo;
            }

        }
    }

    public void setDataOM(View v) {

        final DatePickerDialog datePickerDialog = new DatePickerDialog(WywiadGinekologiczny.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        String miesiac = String.valueOf(month);
                        switch(month){
                            case 0:
                                miesiac="01";
                                break;
                            case 1:
                                miesiac="02";
                                break;
                            case 2:
                                miesiac="03";
                                break;
                            case 3:
                                miesiac="04";
                                break;
                            case 4:
                                miesiac="05";
                                break;
                            case 5:
                                miesiac="06";
                                break;
                            case 6:
                                miesiac="07";
                                break;
                            case 7:
                                miesiac="08";
                                break;
                            case 8:
                                miesiac="09";
                                break;
                            case 9:
                            case 10:
                            case 11:
                                miesiac = String.valueOf(month+1);
                                break;
                        }

                        month = month + 1;
                        data = day + "/" + miesiac + "/" + year;
                        dataOM.setText(data);
                        setDataPorodu();
                    }
                }, curRok, curMiesiac, curDzien);
        datePickerDialog.show();
    }

    void zapiszBadanie(){
        ModelWywiadGinekologiczny wywiadGinekologiczny = new ModelWywiadGinekologiczny();

        if (!dataOM.getText().toString().isEmpty()){
            wywiadGinekologiczny.setDataOstatniejMiesiaczki(dataOM.getText().toString());
        } else {wywiadGinekologiczny.setDataOstatniejMiesiaczki("Brak informacji");}

        if (!dlugoscCyklu.getText().toString().isEmpty()){
            wywiadGinekologiczny.setCoIleWystepujeMiesiaczka(dlugoscCyklu.getText().toString());
        } else {wywiadGinekologiczny.setCoIleWystepujeMiesiaczka("Brak informacji");}

        if (!terminPorodu.getText().toString().isEmpty()){
            wywiadGinekologiczny.setTerminPorodu(terminPorodu.getText().toString());
            DataPoroduDbHandler dbPorodHandler = new DataPoroduDbHandler(this, null,null,1);
            ModelDataPorodu modelDataPorodu = dbPorodHandler.getDataPoroduHandler();
            if (modelDataPorodu==null){
                modelDataPorodu = new ModelDataPorodu(terminPorodu.getText().toString());
                dbPorodHandler.addDataPoroduHandler(modelDataPorodu);
            }
        } else {wywiadGinekologiczny.setTerminPorodu("Brak informacji");}

        if (!pierwszaMiesiaczka.getText().toString().isEmpty()){
            wywiadGinekologiczny.setPierwszaMiesiaczka(pierwszaMiesiaczka.getText().toString());
        } else {wywiadGinekologiczny.setPierwszaMiesiaczka("Brak informacji");}

        if (!czasTrwaniaMiesiaczki.getText().toString().isEmpty()){
            wywiadGinekologiczny.setIleTrwaMiesiaczka(czasTrwaniaMiesiaczki.getText().toString());
        } else {wywiadGinekologiczny.setIleTrwaMiesiaczka("Brak informacji");}

        wywiadGinekologiczny.setCzyMiesiaczkiBolesne(bolesnoscMiesiaczki.getSelectedItem().toString());

        wywiadGinekologiczny.setCzyMiesiaczkiObfite(obfitoscMiesiaczki.getSelectedItem().toString());

        if (zaburzeniaMiesiaczkowaniaNie.isChecked()){
            wywiadGinekologiczny.setCzyZaburzeniaMiesaiczkowania("Nie");
        } else if (getZaburzeniaMiesiaczkowaniaTak.isChecked()){
            wywiadGinekologiczny.setCzyZaburzeniaMiesaiczkowania("Tak");
        } else { wywiadGinekologiczny.setCzyZaburzeniaMiesaiczkowania("Brak informacji"); }

        if (!liczbaPoronien.getText().toString().isEmpty()){
            wywiadGinekologiczny.setLiczbaPoronien(liczbaPoronien.getText().toString());
        } else {wywiadGinekologiczny.setLiczbaPoronien("Brak informacji");}

        if (!liczbaPorodow.getText().toString().isEmpty()){
            wywiadGinekologiczny.setLiczbaPorodow(liczbaPorodow.getText().toString());
        } else {wywiadGinekologiczny.setLiczbaPorodow("Brak informacji");}

        if (!liczbaCiazyPozamacicznych.getText().toString().isEmpty()){
            wywiadGinekologiczny.setLiczbaCiazPozamacicznych(liczbaCiazyPozamacicznych.getText().toString());
        } else {wywiadGinekologiczny.setLiczbaCiazPozamacicznych("Brak informacji");}

        if (!czyJestWczesniejszyZapis){
            WywiadGinekologicznyDbHandler dbHandler = new WywiadGinekologicznyDbHandler(this, null,null,1);
            dbHandler.addWywiadGinekologicznyHandler(wywiadGinekologiczny);

            Intent intent = new Intent(WywiadGinekologiczny.this, WyborBadan.class);
            startActivity(intent);
        } else {
            WywiadGinekologicznyDbHandler dbHandler = new WywiadGinekologicznyDbHandler(this, null,null,1);
            dbHandler.updateWywiadGinekologicznyHandler(wywiadGinekologiczny);

            Intent intent = new Intent(WywiadGinekologiczny.this, WyborBadan.class);
            startActivity(intent);
        }

    }
}
