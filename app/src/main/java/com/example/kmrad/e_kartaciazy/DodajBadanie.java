package com.example.kmrad.e_kartaciazy;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemSelected;

public class DodajBadanie extends AppCompatActivity {

    public static String data;
    Calendar c = Calendar.getInstance();
    int curRok = c.get(Calendar.YEAR);
    int curMiesiac = c.get(Calendar.MONTH);
    int curDzien = c.get(Calendar.DAY_OF_MONTH);

    @OnItemSelected(R.id.spinner_badania_krwi)
    void selectedItemChangedSpinnerBadaniaKrwi(){
        if(badaniaKrwiSpinner.getSelectedItemId()==0){
            RbcSpinner.setEnabled(false);
            HctSpinner.setEnabled(false);
            HbSpinner.setEnabled(false);
            WbcSpinner.setEnabled(false);
            PltSpinner.setEnabled(false);
        } else {
            RbcSpinner.setEnabled(true);
            HctSpinner.setEnabled(true);
            HbSpinner.setEnabled(true);
            WbcSpinner.setEnabled(true);
            PltSpinner.setEnabled(true);
        }
    }

    @OnItemSelected(R.id.spinner_badania_moczu)
    void selectedItemChangedSpinnerBadaniaMoczu(){
        if(badaniaMoczuSpinner.getSelectedItemId()==0){
            bialkoSpinner.setEnabled(false);
            glukozaSpinner.setEnabled(false);
            ESpinner.setEnabled(false);
            LSpinner.setEnabled(false);
            bakterieSpinner.setEnabled(false);
        } else {
            bialkoSpinner.setEnabled(true);
            glukozaSpinner.setEnabled(true);
            ESpinner.setEnabled(true);
            LSpinner.setEnabled(true);
            bakterieSpinner.setEnabled(true);
        }
    }

    @OnItemSelected(R.id.spinner_uwagi_lekarza)
    void selectedItemChangedSpinnerUwagiLekarza(){
        if(uwagiLekarzaSpinner.getSelectedItemId()==0){
            uwagiLekarzaText.setEnabled(false);
        } else {
            uwagiLekarzaText.setEnabled(true);
        }
    }

    @OnClick(R.id.button_data_NW)
    void onClickTerminNW(){setTerminNW(this.getCurrentFocus());}

    @OnClick(R.id.button_zapisz_badanie)
    void onClickZapiszBadanie(){ zapiszBadanie(); }

    @BindView(R.id.text_data_NW)
    TextView terminNastepnejWizyty;

    @BindView(R.id.spinner_uwagi_lekarza)
    Spinner uwagiLekarzaSpinner;

    @BindView(R.id.edit_text_uwagi_lekarza)
    EditText uwagiLekarzaText;

    @BindView(R.id.edit_text_waga)
    EditText waga;

    @BindView(R.id.spinner_zylaki)
    Spinner zylakiSpinner;

    @BindView(R.id.spinner_badania_krwi)
    Spinner badaniaKrwiSpinner;

    @BindView(R.id.spinner_RBC)
    Spinner RbcSpinner;

    @BindView(R.id.spinner_HCT)
    Spinner HctSpinner;

    @BindView(R.id.spinner_HB)
    Spinner HbSpinner;

    @BindView(R.id.spinner_WBC)
    Spinner WbcSpinner;

    @BindView(R.id.spinner_PLT)
    Spinner PltSpinner;

    @BindView(R.id.spinner_badania_moczu)
    Spinner badaniaMoczuSpinner;

    @BindView(R.id.edit_text_CW)
    EditText CW;

    @BindView(R.id.spinner_bialko)
    Spinner bialkoSpinner;

    @BindView(R.id.spinner_glukoza)
    Spinner glukozaSpinner;

    @BindView(R.id.spinner_E)
    Spinner ESpinner;

    @BindView(R.id.spinner_L)
    Spinner LSpinner;

    @BindView(R.id.spinner_bakterie)
    Spinner bakterieSpinner;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dodaj_badanie);
        ButterKnife.bind(this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.prawidlowe_nieprawidlowe, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        badaniaKrwiSpinner.setAdapter(adapter);
        badaniaMoczuSpinner.setAdapter(adapter);

        adapter = ArrayAdapter.createFromResource(this,
                R.array.nie_tak, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        zylakiSpinner.setAdapter(adapter);
        uwagiLekarzaSpinner.setAdapter(adapter);

        adapter = ArrayAdapter.createFromResource(this,
                R.array.podwyzszone_obnizone, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        RbcSpinner.setAdapter(adapter);
        HctSpinner.setAdapter(adapter);
        HbSpinner.setAdapter(adapter);
        WbcSpinner.setAdapter(adapter);
        PltSpinner.setAdapter(adapter);
        LSpinner.setAdapter(adapter);
        ESpinner.setAdapter(adapter);

        adapter = ArrayAdapter.createFromResource(this,
                R.array.nieobecne_obecne, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bakterieSpinner.setAdapter(adapter);
        glukozaSpinner.setAdapter(adapter);
        bialkoSpinner.setAdapter(adapter);

    }

    public void setTerminNW(View v) {

        final DatePickerDialog datePickerDialog = new DatePickerDialog(DodajBadanie.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        month = month + 1;
                        data = day + "/" + month + "/" + year;
                        terminNastepnejWizyty.setText((data));
                    }
                }, curRok, curMiesiac, curDzien);
        datePickerDialog.show();
    }

    public void zapiszBadanie(){
        ModelBadania badanie= new ModelBadania();
        badanie.setDataBadania(new SimpleDateFormat("yyyy.MM.dd").format(new Date()));
        badanie.setTerminNW(terminNastepnejWizyty.getText().toString());
        badanie.setUwagiLekarza(uwagiLekarzaText.getText().toString());
        badanie.setObecnaWaga(waga.getText().toString());
        badanie.setCzySaZylaki(zylakiSpinner.getSelectedItem().toString());
        badanie.setBadaniaKrwi(badaniaKrwiSpinner.getSelectedItem().toString());
        badanie.setRBC(RbcSpinner.getSelectedItem().toString());
        badanie.setHCT(HctSpinner.getSelectedItem().toString());
        badanie.setHB(HbSpinner.getSelectedItem().toString());
        badanie.setWBC(WbcSpinner.getSelectedItem().toString());
        badanie.setPLT(PltSpinner.getSelectedItem().toString());
        badanie.setBadaniaMoczu(badaniaMoczuSpinner.getSelectedItem().toString());
        badanie.setCW(CW.getText().toString());
        badanie.setBialko(bialkoSpinner.getSelectedItem().toString());
        badanie.setGlukoza(glukozaSpinner.getSelectedItem().toString());
        badanie.setE(ESpinner.getSelectedItem().toString());
        badanie.setL(LSpinner.getSelectedItem().toString());
        badanie.setBakterie(bakterieSpinner.getSelectedItem().toString());

        BadaniaDbHandler dbHandler = new BadaniaDbHandler(this, null,null,1);
        dbHandler.addBadanieHandler(badanie);

        Intent intent = new Intent(DodajBadanie.this, PrzegladBadan.class);
        startActivity(intent);
    }
}
