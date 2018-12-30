package com.example.kmrad.e_kartaciazy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PrzegladBadan extends AppCompatActivity {

    @BindView(R.id.recycler_przeglad_badan)
    RecyclerView przegladBadanRecycler;

    @OnClick(R.id.dodaj_badanie)
    void OnClickDodajBadanie(){
        Intent intent = new Intent(PrzegladBadan.this, DodajBadanie.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_przeglad_badan);
        ButterKnife.bind(this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        przegladBadanRecycler.setLayoutManager(layoutManager);

        ArrayList<ListaBadan> listaBadan = new ArrayList<>();
        BadaniaDbHandler dbHandler = new BadaniaDbHandler(this, null,null,1);
        listaBadan = dbHandler.getListaBadan(listaBadan);

        BadaniaAdapter badaniaAdapter = new BadaniaAdapter(listaBadan);
        przegladBadanRecycler.setAdapter(badaniaAdapter);
    }
}
