package com.example.kmrad.e_kartaciazy;

import android.content.Intent;
import android.icu.util.Calendar;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BadaniaDodatkowe extends AppCompatActivity {

    static boolean czyBylWczesniejZapisDod;
    Calendar c = Calendar.getInstance();
    int curRok = c.get(Calendar.YEAR);
    int curMiesiac = c.get(Calendar.MONTH);
    int curDzien = c.get(Calendar.DAY_OF_MONTH);

    @BindView(R.id.et_glukoza_na_czczo)
    EditText glukozaNaCzczo;

    @BindView(R.id.glukoza_na_czczo_data)
    TextView glukozaNaCzczoData;

    @BindView(R.id.tsh)
    EditText tsh;

    @BindView(R.id.tsh_data)
    TextView tshData;

    @BindView(R.id.anty_tpo)
    EditText tpo;

    @BindView(R.id.anty_tpo_data)
    TextView tpoData;

    @BindView(R.id.wr)
    EditText wr;

    @BindView(R.id.wr_data)
    TextView wrData;

    @BindView(R.id.hbs)
    EditText hbs;

    @BindView(R.id.hbs_data)
    TextView hbsData;

    @BindView(R.id.hcv)
    EditText hcv;

    @BindView(R.id.hcv_data)
    TextView hcvData;

    @BindView(R.id.dod_hiv)
    EditText hiv;

    @BindView(R.id.dod_hiv_data)
    TextView hivData;

    @BindView(R.id.toksoplazmoza_igg)
    EditText toksoplazmoza;

    @BindView(R.id.toksoplazmoza_data_igg)
    TextView toksoplazmozaData;

    @BindView(R.id.cytomegalia_igg)
    EditText cytomegalia;

    @BindView(R.id.cytomegalia_data_igg)
    TextView cytomegaliaData;

    @BindView(R.id.rozyczka)
    EditText rozyczka;

    @BindView(R.id.rozyczka_data)
    TextView rozyczkaData;

    @OnClick(R.id.dodatkowe_button_zapisz)
    void onClickDodatkoweZapisz(){
        zapiszBadanieDodatkowe();
    }



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent intent = new Intent(BadaniaDodatkowe.this, MainActivity.class);
                    startActivity(intent);
                    break;
                case R.id.navigation_dashboard:
                    Intent intentWybor = new Intent(BadaniaDodatkowe.this, WyborBadan.class);
                    startActivity(intentWybor);
                    break;
                case R.id.navigation_notifications:
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_badania_dodatkowe);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.navigation_dashboard);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        ButterKnife.bind(this);

        BadaniaDodatkoweDBHandler dbHandler = new BadaniaDodatkoweDBHandler(this, null, null, 1);
        ModelBadaniaDodatkowe badaniaDodatkowe = dbHandler.getBadaniaDodatkoweHandler();
        if (badaniaDodatkowe!=null){
            czyBylWczesniejZapisDod=true;
            if (!badaniaDodatkowe.getGlukozaNaCzczo().equals("brak")){
                glukozaNaCzczo.setText(badaniaDodatkowe.getGlukozaNaCzczo());
                glukozaNaCzczo.setEnabled(false);
            }
            if (!badaniaDodatkowe.getGlukozaNaCzczoData().equals("brak")){
                glukozaNaCzczoData.setText(badaniaDodatkowe.getGlukozaNaCzczoData());
                glukozaNaCzczoData.setEnabled(false);
            }
            if (!badaniaDodatkowe.getTSH().equals("brak")){
                tsh.setText(badaniaDodatkowe.getTSH());
                tsh.setEnabled(false);
            }
            if (!badaniaDodatkowe.getTSHData().equals("brak")){
                tshData.setText(badaniaDodatkowe.getTSHData());
                tshData.setEnabled(false);
            }
            if (!badaniaDodatkowe.getAntyTPO().equals("brak")){
                tpo.setText(badaniaDodatkowe.getAntyTPO());
                tpo.setEnabled(false);
            }
            if (!badaniaDodatkowe.getAntyTpoData().equals("brak")){
                tpoData.setText(badaniaDodatkowe.getAntyTpoData());
                tpoData.setEnabled(false);
            }
            if (!badaniaDodatkowe.getWR().equals("brak")){
                wr.setText(badaniaDodatkowe.getWR());
                wr.setEnabled(false);
            }
            if (!badaniaDodatkowe.getWRData().equals("brak")){
                wrData.setText(badaniaDodatkowe.getWRData());
                wrData.setEnabled(false);
            }
            if (!badaniaDodatkowe.getHBs().equals("brak")){
                hbs.setText(badaniaDodatkowe.getHBs());
                hbs.setEnabled(false);
            }
            if (!badaniaDodatkowe.getHBSData().equals("brak")){
                hbsData.setText(badaniaDodatkowe.getHBSData());
                hbsData.setEnabled(false);
            }
            if (!badaniaDodatkowe.getHCV().equals("brak")){
                hcv.setText(badaniaDodatkowe.getHCV());
            }
            if (!badaniaDodatkowe.getHCVData().equals("brak")){
                hcvData.setText(badaniaDodatkowe.getHCVData());
            }
            if (!badaniaDodatkowe.getHIV().equals("brak")){
                hiv.setText(badaniaDodatkowe.getHIV());
            }
            if (!badaniaDodatkowe.getHIVData().equals("brak")){
                hivData.setText(badaniaDodatkowe.getHIVData());
            }
            if (!badaniaDodatkowe.getToksoplazmoza().equals("brak")){
                toksoplazmoza.setText(badaniaDodatkowe.getToksoplazmoza());
            }
            if (!badaniaDodatkowe.getToksoplazmozaData().equals("brak")){
                toksoplazmozaData.setText(badaniaDodatkowe.getToksoplazmozaData());
            }
            if (!badaniaDodatkowe.getCytomegalia().equals("brak")){
                cytomegalia.setText(badaniaDodatkowe.getCytomegalia());
            }
            if (!badaniaDodatkowe.getCytomegaliaData().equals("brak")){
                cytomegaliaData.setText(badaniaDodatkowe.getCytomegaliaData());
            }
            if (!badaniaDodatkowe.getRozyczka().equals("brak")){
                rozyczka.setText(badaniaDodatkowe.getRozyczka());
            }
            if (!badaniaDodatkowe.getRozyczkaData().equals("brak")){
                rozyczkaData.setText(badaniaDodatkowe.getRozyczkaData());
            }
        } else {czyBylWczesniejZapisDod=false;}

    }

    public void zapiszBadanieDodatkowe(){
        ModelBadaniaDodatkowe badaniaDodatkowe = new ModelBadaniaDodatkowe();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String currentDateandTime = sdf.format(new Date());


        if (!glukozaNaCzczo.getText().toString().isEmpty()){
            badaniaDodatkowe.setGlukozaNaCzczo(glukozaNaCzczo.getText().toString());
            badaniaDodatkowe.setGlukozaNaCzczoData(currentDateandTime);
        } else {badaniaDodatkowe.setGlukozaNaCzczo("brak");
            badaniaDodatkowe.setGlukozaNaCzczoData("brak");}

        if (!tsh.getText().toString().isEmpty()){
            badaniaDodatkowe.setTSH(tsh.getText().toString());
            badaniaDodatkowe.setTSHData(currentDateandTime);
        } else {badaniaDodatkowe.setTSH("brak");
            badaniaDodatkowe.setTSHData("brak");}

        if (!tpo.getText().toString().isEmpty()){
            badaniaDodatkowe.setAntyTPO(tpo.getText().toString());
            badaniaDodatkowe.setAntyTpoData(currentDateandTime);
        } else {badaniaDodatkowe.setAntyTPO("brak");
            badaniaDodatkowe.setAntyTpoData("brak");}

        if (!wr.getText().toString().isEmpty()){
            badaniaDodatkowe.setWR(wr.getText().toString());
            badaniaDodatkowe.setWRData(currentDateandTime);
        } else {badaniaDodatkowe.setWR("brak");
            badaniaDodatkowe.setWRData("brak");}

        if (!hbs.getText().toString().isEmpty()){
            badaniaDodatkowe.setHBs(hbs.getText().toString());
            badaniaDodatkowe.setHBSData(currentDateandTime);
        } else {badaniaDodatkowe.setHBs("brak");
            badaniaDodatkowe.setHBSData("brak");}

        if (!hcv.getText().toString().isEmpty()){
            badaniaDodatkowe.setHCV(hcv.getText().toString());
            badaniaDodatkowe.setHCVData(currentDateandTime);
        } else {badaniaDodatkowe.setHCV("brak");
            badaniaDodatkowe.setHCVData("brak");}

        if (!hiv.getText().toString().isEmpty()){
            badaniaDodatkowe.setHIV(hiv.getText().toString());
            badaniaDodatkowe.setHIVData(currentDateandTime);
        } else {badaniaDodatkowe.setHIV("brak");
            badaniaDodatkowe.setHIVData("brak");}

        if (!toksoplazmoza.getText().toString().isEmpty()){
            badaniaDodatkowe.setToksoplazmoza(toksoplazmoza.getText().toString());
            badaniaDodatkowe.setToksoplazmozaData(currentDateandTime);
        } else {badaniaDodatkowe.setToksoplazmoza("brak");
            badaniaDodatkowe.setToksoplazmozaData("brak");}

        if (!cytomegalia.getText().toString().isEmpty()){
            badaniaDodatkowe.setCytomegalia(cytomegalia.getText().toString());
            badaniaDodatkowe.setCytomegaliaData(currentDateandTime);
        } else {badaniaDodatkowe.setCytomegalia("brak");
            badaniaDodatkowe.setCytomegaliaData("brak");}

        if (!rozyczka.getText().toString().isEmpty()){
            badaniaDodatkowe.setRozyczka(rozyczka.getText().toString());
            badaniaDodatkowe.setRozyczkaData(currentDateandTime);
        } else {badaniaDodatkowe.setRozyczka("brak");
            badaniaDodatkowe.setRozyczkaData("brak");}


        if (!czyBylWczesniejZapisDod){
            BadaniaDodatkoweDBHandler dbHandler = new BadaniaDodatkoweDBHandler(this, null,null,1);
            dbHandler.addBadaniaDodatkoweHandler(badaniaDodatkowe);

            Intent intent = new Intent(BadaniaDodatkowe.this, WyborBadan.class);
            startActivity(intent);
        } else {
            BadaniaDodatkoweDBHandler dbHandler = new BadaniaDodatkoweDBHandler(this, null, null, 1);
            dbHandler.updateBadaniaDodatkoweHandler(badaniaDodatkowe);

            Intent intent = new Intent(BadaniaDodatkowe.this, WyborBadan.class);
            startActivity(intent);
        }
    }
}
