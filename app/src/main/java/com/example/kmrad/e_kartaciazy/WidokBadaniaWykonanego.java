package com.example.kmrad.e_kartaciazy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WidokBadaniaWykonanego extends AppCompatActivity {

    @BindView(R.id.przeglad_text_data_NW)
    TextView terminNW;

    @BindView(R.id.przeglad_edit_text_uwagi_lekarza)
    TextView uwagiLekarza;

    @BindView(R.id.przeglad_edit_text_waga)
    TextView waga;

    @BindView(R.id.przeglad_spinner_zylaki)
    TextView zylaki;

    @BindView(R.id.przeglad_spinner_RBC)
    TextView RBC;

    @BindView(R.id.przeglad_spinner_HCT)
    TextView HCT;

    @BindView(R.id.przeglad_spinner_Hb)
    TextView Hb;

    @BindView(R.id.przeglad_spinner_WBC)
    TextView WBC;

    @BindView(R.id.przeglad_spinner_PLT)
    TextView PLT;

    @BindView(R.id.przeglad_edit_cw)
    TextView CW;

    @BindView(R.id.przeglad_spinner_bialko)
    TextView bialko;

    @BindView(R.id.przeglad_spinner_glukoza)
    TextView glukoza;

    @BindView(R.id.przeglad_spinner_Er)
    TextView E;

    @BindView(R.id.przeglad_spinner_L)
    TextView L;

    @BindView(R.id.przeglad_spinner_bakterie)
    TextView bakterie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String idBadania = (String)getIntent().getSerializableExtra("idBadania");
        int IDBadania = Integer.parseInt(idBadania);
        setContentView(R.layout.activity_widok_badania_wykonanego);
        ButterKnife.bind(this);
        BadaniaDbHandler dbHandler = new BadaniaDbHandler(this, null,null,1);
        ModelBadania badanie = dbHandler.findBadanieHandler(IDBadania);

        terminNW.setText(badanie.getTerminNW());
        uwagiLekarza.setText(badanie.getUwagiLekarza());
        waga.setText(badanie.getObecnaWaga());
        zylaki.setText(badanie.getCzySaZylaki());
        RBC.setText(badanie.getRBC());
        HCT.setText(badanie.getHCT());
        Hb.setText(badanie.getHB());
        WBC.setText(badanie.getWBC());
        PLT.setText(badanie.getPLT());
        CW.setText(badanie.getCW());
        bialko.setText(badanie.getBialko());
        glukoza.setText(badanie.getGlukoza());
        E.setText(badanie.getE());
        L.setText(badanie.getL());
        bakterie.setText(badanie.getBakterie());    }
}
