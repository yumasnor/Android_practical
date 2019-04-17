package com.example.april17;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView datepicker;
    Button b1;
    Calendar calendar;
    int day, month, year;
    DatePickerDialog datePickerDialog;
    DatePickerDialog.OnDateSetListener listener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datepicker = findViewById(R.id.tv1);
        b1 = findViewById(R.id.btn1);
        b1.setOnClickListener(this);

        calendar = Calendar.getInstance();

        day=calendar.get(Calendar.DAY_OF_MONTH);
        month=calendar.get(Calendar.MONTH);
        year=calendar.get(Calendar.YEAR);
        setDate(year,month+1,day);

        listener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                setDate(year, month+1,dayOfMonth);
            }
        };

        datePickerDialog = new DatePickerDialog(this,listener,year,month+1,day);
    }

    public void setDate(int year, int month, int day){
        datepicker.setText(day +"-"+ month +"-"+ year);
        }

    @Override
    public void onClick(View v) {
    datePickerDialog.show();
    }
}
