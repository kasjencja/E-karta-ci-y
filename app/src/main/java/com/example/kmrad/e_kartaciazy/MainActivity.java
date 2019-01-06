package com.example.kmrad.e_kartaciazy;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.start_nastepna_wizyta)
    TextView nastepnaWizytaTV;

    @BindView(R.id.start_termin_porodu)
    TextView terminPoroduTV;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    return true;
                case R.id.navigation_dashboard:
                    Intent intent = new Intent(MainActivity.this, WyborBadan.class);
                    startActivity(intent);
                    break;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.navigation_home);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        ButterKnife.bind(this);

        NastepnaWizytaDbHandler dbHandlerWizyta = new NastepnaWizytaDbHandler(this, null,null,1);
        ModelNastepnaWizyta nastepnaWizyta = dbHandlerWizyta.getNastepnaWizytaHandler();
        if(nastepnaWizyta!=null) {
            String wizyta= "Termin najbliższej wizyty:  " + nastepnaWizyta.getTerminNastepnejWizyty();
            nastepnaWizytaTV.setText(wizyta);
        }

        DataPoroduDbHandler dbHandlerPorod = new DataPoroduDbHandler(this, null, null, 1);
        ModelDataPorodu dataPorodu = dbHandlerPorod.getDataPoroduHandler();
        if(dataPorodu!=null){
            String porod = "Termin porodu:" + dataPorodu.getDataPorodu();
            terminPoroduTV.setText(porod);
        }


    }

}
