package com.example.kmrad.e_kartaciazy;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class WyborBadan extends AppCompatActivity {

    private TextView mTextMessage;

    @OnClick(R.id.wybor_badan_polozniczy)
    void OnClickPolozniczy(){
        Intent intent = new Intent(WyborBadan.this, WywiadGinekologiczny.class);
        startActivity(intent);
    }

    @OnClick(R.id.wybor_badan_rodzinny)
    void OnClickRodzinny(){
        Intent intent = new Intent(WyborBadan.this, WywiadRodzinny.class);
        startActivity(intent);
    }

    @OnClick(R.id.wybor_badan_biezace)
    void OnClickBadania(){
        Intent intent = new Intent(WyborBadan.this, PrzegladBadan.class);
        startActivity(intent);
    }

    @OnClick(R.id.wybor_badan_dodatkowe)
    void OnClickDodatkowe(){
        Intent intent = new Intent(WyborBadan.this, BadaniaDodatkowe.class);
        startActivity(intent);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent intent = new Intent(WyborBadan.this, MainActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_dashboard:
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wybor_badan);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.navigation_dashboard);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        ButterKnife.bind(this);
    }

}
