package com.example.kmrad.e_kartaciazy;

import android.app.DatePickerDialog;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WywiadGinekologiczny extends AppCompatActivity {

    public static String data;
    Calendar c = Calendar.getInstance();
    int curRok = c.get(Calendar.YEAR);
    int curMiesiac = c.get(Calendar.MONTH);
    int curDzien = c.get(Calendar.DAY_OF_MONTH);

    @BindView(R.id.text_data_OM)
    TextView dataOM;

    @OnClick(R.id.button_data_OM)
    void OnClickDataOM() {
        setDataOM(this.getCurrentFocus());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wywiad_ginekologiczny);

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
    }

    public void setDataOM(View v) {

        final DatePickerDialog datePickerDialog = new DatePickerDialog(WywiadGinekologiczny.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        month = month + 1;
                        data = day + "/" + month + "/" + year;
                        dataOM.setText((data));
                    }
                }, curRok, curMiesiac, curDzien);
        datePickerDialog.show();
    }
}
