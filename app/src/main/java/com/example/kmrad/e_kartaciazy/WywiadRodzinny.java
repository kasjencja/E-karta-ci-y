package com.example.kmrad.e_kartaciazy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import butterknife.ButterKnife;

public class WywiadRodzinny extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wywiad_rodzinny);

        //spinnery
        Spinner neurologiczny = (Spinner) findViewById(R.id.spinner_choroby_neurologiczne);
        Spinner cukrzyca = (Spinner) findViewById(R.id.spinner_cukrzyca);
        Spinner hiv = (Spinner) findViewById(R.id.spinner_HIV);
        Spinner nerki = (Spinner) findViewById(R.id.spinner_nerek);
        Spinner pluca = (Spinner) findViewById(R.id.spinner_pluca);
        Spinner tarczyca = (Spinner) findViewById(R.id.spinner_tarczyca);
        Spinner trombofilia = (Spinner) findViewById(R.id.spinner_trombofilia);
        Spinner ukladKrazenia = (Spinner) findViewById(R.id.spinner_uklad_krazenia);
        Spinner watroba = (Spinner) findViewById(R.id.spinner_watroba);
        Spinner zoladek = (Spinner) findViewById(R.id.spinner_zoladek);
        Spinner krewMatki = (Spinner) findViewById(R.id.spinner_grupa_krwi_matki);
        Spinner krewOjca = (Spinner) findViewById(R.id.spinner_grupa_krwi_ojca);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.nie_tak, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        neurologiczny.setAdapter(adapter);
        cukrzyca.setAdapter(adapter);
        hiv.setAdapter(adapter);
        nerki.setAdapter(adapter);
        pluca.setAdapter(adapter);
        tarczyca.setAdapter(adapter);
        trombofilia.setAdapter(adapter);
        ukladKrazenia.setAdapter(adapter);
        watroba.setAdapter(adapter);
        zoladek.setAdapter(adapter);

        adapter = ArrayAdapter.createFromResource(this,
                R.array.grupy_krwi, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        krewMatki.setAdapter(adapter);
        krewOjca.setAdapter(adapter);

        ButterKnife.bind(this);
    }
}
