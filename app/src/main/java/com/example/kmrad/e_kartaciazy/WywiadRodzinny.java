package com.example.kmrad.e_kartaciazy;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WywiadRodzinny extends AppCompatActivity {

    @BindView(R.id.spinner_choroby_neurologiczne)
    Spinner chorobyNeurologiczne;

    @BindView(R.id.spinner_cukrzyca)
    Spinner cukrzyca;

    @BindView(R.id.spinner_HIV)
    Spinner hiv;

    @BindView(R.id.spinner_nerek)
    Spinner chorobyNerek;

    @BindView(R.id.spinner_pluca)
    Spinner chorobyPluc;

    @BindView(R.id.spinner_tarczyca)
    Spinner chorobyTarczycy;

    @BindView(R.id.spinner_trombofilia)
    Spinner trombofilia;

    @BindView(R.id.spinner_watroba)
    Spinner chorobyWatroby;

    @BindView(R.id.spinner_uklad_krazenia)
    Spinner chorobyUkladuKrazenia;

    @BindView(R.id.spinner_zoladek)
    Spinner chorobyZoladka;

    @BindView(R.id.spinner_grupa_krwi_matki)
    Spinner krewMatki;

    @BindView(R.id.spinner_grupa_krwi_ojca)
    Spinner krewOjca;

    @BindView(R.id.stosowane_w_ciazy_tak)
    RadioButton regulacjaStosowanaWCiazy;

    @BindView(R.id.stosowane_w_ciazy_nie)
    RadioButton regulacjaNieStosowanaWCiazy;

    @BindView(R.id.regulacja_mechaniczna)
    RadioButton regulacjaMechaniczna;

    @BindView(R.id.regulacja_chormonalna)
    RadioButton regulacjaHormonalna;

    @BindView(R.id.regulacja_inna)
    RadioButton regulacjaInna;

    @BindView(R.id.nieplodnosc_kobieta_check)
    RadioButton nieplodnoscKobieta;

    @BindView(R.id.nieplodnosc_mezczyzna_check)
    RadioButton nieplodnoscMezczyzna;

    @OnClick(R.id.zapisz_wywiad_rodzinny)
    void onClickZapisz(){
        zapiszWywiad();
    }

    private static boolean czyBylWczesniejZapis;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent intent = new Intent(WywiadRodzinny.this, MainActivity.class);
                    startActivity(intent);
                    break;
                case R.id.navigation_dashboard:
                    Intent intentWybor = new Intent(WywiadRodzinny.this, WyborBadan.class);
                    startActivity(intentWybor);
                    break;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wywiad_rodzinny);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.navigation_dashboard);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        ButterKnife.bind(this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.nie_tak, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        chorobyNeurologiczne.setAdapter(adapter);
        hiv.setAdapter(adapter);
        chorobyNerek.setAdapter(adapter);
        chorobyPluc.setAdapter(adapter);
        chorobyTarczycy.setAdapter(adapter);
        trombofilia.setAdapter(adapter);
        chorobyUkladuKrazenia.setAdapter(adapter);
        chorobyWatroby.setAdapter(adapter);
        chorobyZoladka.setAdapter(adapter);

        adapter = ArrayAdapter.createFromResource(this,
                R.array.cukrzyca, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cukrzyca.setAdapter(adapter);

        adapter = ArrayAdapter.createFromResource(this,
                R.array.grupy_krwi, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        krewMatki.setAdapter(adapter);
        krewOjca.setAdapter(adapter);

        WywiadRodzinnyDbHandler dbHandler = new WywiadRodzinnyDbHandler(this, null, null,1);
        ModelWywiadRodzinny wywiadRodzinny = dbHandler.getWywiadRodzinnyHandler();
        if(wywiadRodzinny!=null){
            czyBylWczesniejZapis=true;
            switch (wywiadRodzinny.getKrewMatki()){
                case "brak informacji":
                    break;
                case "0 Rh plus":
                    krewMatki.setSelection(1);
                    krewMatki.setEnabled(false);
                    break;
                case "0 Rh minus":
                    krewMatki.setSelection(2);
                    krewMatki.setEnabled(false);
                    break;
                case "A Rh plus":
                    krewMatki.setSelection(3);
                    krewMatki.setEnabled(false);
                    break;
                case "A Rh minus":
                    krewMatki.setSelection(4);
                    krewMatki.setEnabled(false);
                    break;
                case "B Rh plus":
                    krewMatki.setSelection(5);
                    krewMatki.setEnabled(false);
                    break;
                case "B Rh minus":
                    krewMatki.setSelection(6);
                    krewMatki.setEnabled(false);
                    break;
                case "AB Rh plus":
                    krewMatki.setSelection(7);
                    krewMatki.setEnabled(false);
                    break;
                case "AB Rh minus":
                    krewMatki.setSelection(8);
                    krewMatki.setEnabled(false);
                    break;
            }
            switch (wywiadRodzinny.getKrewOjca()) {
                case "brak informacji":
                    break;
                case "0 Rh plus":
                    krewOjca.setSelection(1);
                    krewOjca.setEnabled(false);
                    break;
                case "0 Rh minus":
                    krewOjca.setSelection(2);
                    krewOjca.setEnabled(false);
                    break;
                case "A Rh plus":
                    krewOjca.setSelection(3);
                    krewOjca.setEnabled(false);
                    break;
                case "A Rh minus":
                    krewOjca.setSelection(4);
                    krewOjca.setEnabled(false);
                    break;
                case "B Rh plus":
                    krewOjca.setSelection(5);
                    krewOjca.setEnabled(false);
                    break;
                case "B Rh minus":
                    krewOjca.setSelection(6);
                    krewOjca.setEnabled(false);
                    break;
                case "AB Rh plus":
                    krewOjca.setSelection(7);
                    krewOjca.setEnabled(false);
                    break;
                case "AB Rh minus":
                    krewOjca.setSelection(8);
                    krewOjca.setEnabled(false);
                    break;
            }
            switch (wywiadRodzinny.getChorobyKrazenia()){
                case "Nie":
                    chorobyUkladuKrazenia.setSelection(0);
                    chorobyUkladuKrazenia.setEnabled(false);
                    break;
                case "Tak":
                    chorobyUkladuKrazenia.setSelection(1);
                    chorobyUkladuKrazenia.setEnabled(false);
                    break;
            }
            switch (wywiadRodzinny.getChorobyNerek()){
                case "Nie":
                    chorobyNerek.setSelection(0);
                    chorobyNerek.setEnabled(false);
                    break;
                case "Tak":
                    chorobyNerek.setSelection(1);
                    chorobyNerek.setEnabled(false);
                    break;
            }
            switch (wywiadRodzinny.getChorobyNeurologiczne()){
                case "Nie":
                    chorobyNeurologiczne.setSelection(0);
                    chorobyNeurologiczne.setEnabled(false);
                    break;
                case "Tak":
                    chorobyNeurologiczne.setSelection(1);
                    chorobyNeurologiczne.setEnabled(false);
                    break;
            }
            switch (wywiadRodzinny.getChorobyWatroby()){
                case "Nie":
                    chorobyWatroby.setSelection(0);
                    chorobyWatroby.setEnabled(false);
                    break;
                case "Tak":
                    chorobyWatroby.setSelection(1);
                    chorobyWatroby.setEnabled(false);
                    break;
            }
            switch (wywiadRodzinny.getChorobyZoladka()){
                case "Nie":
                    chorobyZoladka.setSelection(0);
                    chorobyZoladka.setEnabled(false);
                    break;
                case "Tak":
                    chorobyZoladka.setSelection(1);
                    chorobyZoladka.setEnabled(false);
                    break;
            }
            switch (wywiadRodzinny.getChorobyPluc()){
                case "Nie":
                    chorobyPluc.setSelection(0);
                    chorobyPluc.setEnabled(false);
                    break;
                case "Tak":
                    chorobyPluc.setSelection(1);
                    chorobyPluc.setEnabled(false);
                    break;
            }
            switch (wywiadRodzinny.getChorobyTarczycy()){
                case "Nie":
                    chorobyTarczycy.setSelection(0);
                    chorobyTarczycy.setEnabled(false);
                    break;
                case "Tak":
                    chorobyTarczycy.setSelection(1);
                    chorobyTarczycy.setEnabled(false);
                    break;
            }
            switch (wywiadRodzinny.getCukrzyca()){
                case "Brak":
                    cukrzyca.setSelection(0);
                    cukrzyca.setEnabled(false);
                    break;
                case "Typu 1 - insulinozależna":
                    cukrzyca.setSelection(1);
                    cukrzyca.setEnabled(false);
                    break;
                case "Typu 2 - insulinoniezależna":
                    cukrzyca.setSelection(2);
                    cukrzyca.setEnabled(false);
                    break;
                case "Typu 3 - wtórna":
                    cukrzyca.setSelection(3);
                    cukrzyca.setEnabled(false);
                    break;
                case "Cukrzyca ciążowa":
                    cukrzyca.setSelection(4);
                    cukrzyca.setEnabled(false);
                    break;
            }
            switch (wywiadRodzinny.getTrombofilia()){
                case "Nie":
                    trombofilia.setSelection(0);
                    trombofilia.setEnabled(false);
                    break;
                case "Tak":
                    trombofilia.setSelection(1);
                    trombofilia.setEnabled(false);
                    break;
            }
            switch (wywiadRodzinny.getHIV()){
                case "Nie":
                    hiv.setSelection(0);
                    hiv.setEnabled(false);
                    break;
                case "Tak":
                    hiv.setSelection(1);
                    hiv.setEnabled(false);
                    break;
            }
            switch (wywiadRodzinny.getNieplodnosciMezczyzna()){
                case "Nie":
                    nieplodnoscMezczyzna.setChecked(false);
                    nieplodnoscMezczyzna.setEnabled(false);
                    break;
                case "Tak":
                    nieplodnoscMezczyzna.setChecked(true);
                    nieplodnoscMezczyzna.setEnabled(false);
                    break;
            }
            switch (wywiadRodzinny.getNieplodnosciKobieta()){
                case "Nie":
                    nieplodnoscKobieta.setChecked(false);
                    nieplodnoscKobieta.setEnabled(false);
                    break;
                case "Tak":
                    nieplodnoscKobieta.setChecked(true);
                    nieplodnoscKobieta.setEnabled(false);
                    break;
            }
            switch (wywiadRodzinny.getRegulacjaPlodnosciMechaniczna()){
                case "Nie":
                    regulacjaMechaniczna.setChecked(false);
                    regulacjaMechaniczna.setEnabled(false);
                    break;
                case "Tak":
                    regulacjaMechaniczna.setChecked(true);
                    regulacjaMechaniczna.setEnabled(false);
                    break;
            }
            switch (wywiadRodzinny.getRegulacjaPlodnosciHormonalna()){
                case "Nie":
                    regulacjaHormonalna.setChecked(false);
                    regulacjaHormonalna.setEnabled(false);
                    break;
                case "Tak":
                    regulacjaHormonalna.setChecked(true);
                    regulacjaHormonalna.setEnabled(false);
                    break;
            }
            switch (wywiadRodzinny.getRegulacjaPlodnosciInna()){
                case "Nie":
                    regulacjaInna.setChecked(false);
                    regulacjaInna.setEnabled(false);
                    break;
                case "Tak":
                    regulacjaInna.setChecked(true);
                    regulacjaInna.setEnabled(false);
                    break;
            }
            switch (wywiadRodzinny.getRegulacjeStosowaneWCiazy()){
                case "Brak informacji":
                    break;
                case "Nie":
                    regulacjaNieStosowanaWCiazy.setChecked(true);
                    regulacjaNieStosowanaWCiazy.setEnabled(false);
                    regulacjaStosowanaWCiazy.setChecked(false);
                    regulacjaStosowanaWCiazy.setEnabled(false);
                    break;
                case "Tak":
                    regulacjaNieStosowanaWCiazy.setChecked(false);
                    regulacjaNieStosowanaWCiazy.setEnabled(false);
                    regulacjaStosowanaWCiazy.setChecked(true);
                    regulacjaStosowanaWCiazy.setEnabled(false);
                    break;
            }
        } else {czyBylWczesniejZapis=false;}

    }

    void zapiszWywiad(){
        ModelWywiadRodzinny wywiadRodzinny = new ModelWywiadRodzinny();

        wywiadRodzinny.setKrewMatki(krewMatki.getSelectedItem().toString());
        wywiadRodzinny.setKrewOjca(krewOjca.getSelectedItem().toString());
        wywiadRodzinny.setChorobyKrazenia(chorobyUkladuKrazenia.getSelectedItem().toString());
        wywiadRodzinny.setChorobyNerek(chorobyNerek.getSelectedItem().toString());
        wywiadRodzinny.setChorobyNeurologiczne(chorobyNeurologiczne.getSelectedItem().toString());
        wywiadRodzinny.setChorobyWatroby(chorobyWatroby.getSelectedItem().toString());
        wywiadRodzinny.setChorobyZoladka(chorobyZoladka.getSelectedItem().toString());
        wywiadRodzinny.setChorobyPluc(chorobyPluc.getSelectedItem().toString());
        wywiadRodzinny.setChorobyTarczycy(chorobyTarczycy.getSelectedItem().toString());
        wywiadRodzinny.setCukrzyca(cukrzyca.getSelectedItem().toString());
        wywiadRodzinny.setTrombofilia(trombofilia.getSelectedItem().toString());
        wywiadRodzinny.setHIV(hiv.getSelectedItem().toString());
        if (nieplodnoscKobieta.isChecked()){
            wywiadRodzinny.setNieplodnosciKobieta("Tak");
        } else {wywiadRodzinny.setNieplodnosciKobieta("Nie");}
        if (nieplodnoscMezczyzna.isChecked()){
            wywiadRodzinny.setNieplodnosciMezczyzna("Tak");
        } else {wywiadRodzinny.setNieplodnosciMezczyzna("Nie");}
        if (regulacjaMechaniczna.isChecked()){
            wywiadRodzinny.setRegulacjaPlodnosciMechaniczna("Tak");
        } else {wywiadRodzinny.setRegulacjaPlodnosciMechaniczna("Nie");}
        if (regulacjaHormonalna.isChecked()){
            wywiadRodzinny.setRegulacjaPlodnosciHormonalna("Tak");
        } else {wywiadRodzinny.setRegulacjaPlodnosciHormonalna("Nie");}
        if (regulacjaInna.isChecked()){
            wywiadRodzinny.setRegulacjaPlodnosciInna("Tak");
        } else {wywiadRodzinny.setRegulacjaPlodnosciInna("Nie");}
        if (regulacjaStosowanaWCiazy.isChecked()){
            wywiadRodzinny.setRegulacjeStosowaneWCiazy("Tak");
        } else if (regulacjaNieStosowanaWCiazy.isChecked()) {wywiadRodzinny.setRegulacjeStosowaneWCiazy("Nie");
        } else {wywiadRodzinny.setRegulacjeStosowaneWCiazy("Brak informacji");}

        if(czyBylWczesniejZapis){
            WywiadRodzinnyDbHandler dbHandler = new WywiadRodzinnyDbHandler(this, null, null, 1);
            dbHandler.updateWywiadRodzinnyHandler(wywiadRodzinny);
        } else {
            WywiadRodzinnyDbHandler dbHandler = new WywiadRodzinnyDbHandler(this, null, null, 1);
            dbHandler.addWywiadRodzinnyHandler(wywiadRodzinny);
        }



        Intent intent = new Intent(WywiadRodzinny.this, PrzegladBadan.class);
        startActivity(intent);

    }
}
