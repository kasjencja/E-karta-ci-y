package com.example.kmrad.e_kartaciazy;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PrzegladBadan extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent intent = new Intent(PrzegladBadan.this, MainActivity.class);
                    startActivity(intent);
                    break;
                case R.id.navigation_dashboard:
                    Intent intentWybor = new Intent(PrzegladBadan.this, WyborBadan.class);
                    startActivity(intentWybor);
                    break;
            }
            return false;
        }
    };

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

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.navigation_dashboard);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        przegladBadanRecycler.setLayoutManager(layoutManager);

        ArrayList<ListaBadan> listaBadan = new ArrayList<>();
        BadaniaDbHandler dbHandler = new BadaniaDbHandler(this, null,null,1);
        listaBadan = dbHandler.getListaBadan(listaBadan);

        BadaniaAdapter badaniaAdapter = new BadaniaAdapter(listaBadan);
        przegladBadanRecycler.setAdapter(badaniaAdapter);
    }
}
