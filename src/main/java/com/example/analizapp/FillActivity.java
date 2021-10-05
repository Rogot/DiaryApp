package com.example.analizapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.text.format.Time;

import com.example.analizapp.model.BloodPress;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class FillActivity extends Activity {

    private SharedPreferences pref;

    private Button writeData_button;
    private EditText diastolic_edit;
    private EditText systolic_edit;
    private TextView res_edit;
    private BloodPress bloodPress;

    private ArrayList<BloodPress> bloodPressArray;
    private int size = 0;
    Time today = new Time(Time.getCurrentTimezone());


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fill_diary);


        writeData_button = (Button) findViewById(R.id.writeButton);
        diastolic_edit = (EditText) findViewById(R.id.diastolicEdit);
        systolic_edit = (EditText) findViewById(R.id.systolicEdit);
        res_edit = (TextView) findViewById(R.id.resTest_2);
        bloodPress = new BloodPress(0,0);

        pref = getSharedPreferences("DIARY", MODE_PRIVATE);

        size = pref.getInt("DataSize", 0);
        diastolic_edit.setText(String.valueOf(pref.getInt("DisVal" + size, 0)));
        systolic_edit.setText(String.valueOf(pref.getInt("SysVal" + size, 0)));
        res_edit.setText(String.valueOf(pref.getInt("ResVal" + size, 0)));

        today.setToNow();
    }

    //Function for button which let save data
    public void writeData(View view) {
        if (diastolic_edit.getText().toString().trim().equals("") || systolic_edit.getText().toString().trim().equals("")) {
            Toast.makeText(FillActivity.this, R.string.no_user_input, Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(FillActivity.this, R.string.success, Toast.LENGTH_LONG).show();
            int Sys = Integer.parseInt(systolic_edit.getText().toString());
            int Dias = Integer.parseInt(diastolic_edit.getText().toString());
            bloodPress.setSystolicValue(Sys);
            bloodPress.setDiastolicValue(Dias);
            bloodPress.setResValue(Sys - Dias);

            bloodPress.setDayValue(today.monthDay);
            bloodPress.setMonthValue(today.month + 1);
            bloodPress.setYearValue(today.year);
            bloodPress.setHourValue(today.hour);
            bloodPress.setMinuteValue(today.minute);

            res_edit.setText(String.valueOf(Sys - Dias));

            saveData(bloodPress, size);

            Intent fillIntent = new Intent(FillActivity.this, MainActivity.class);
            startActivity(fillIntent);
        }
    }

    //Data saving function in permanent memory
    private void saveData(BloodPress dataToSave, int arraySize) {
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("SysVal" + Integer.toString(arraySize), dataToSave.getSystolicValue());
        editor.putInt("DisVal" + Integer.toString(arraySize), dataToSave.getDiastolicValue());
        editor.putInt("ResVal" + Integer.toString(arraySize), dataToSave.getResValue());
        arraySize = arraySize + 1;
        editor.putInt("DataSize", arraySize);
        editor.putInt("Day" + Integer.toString(arraySize), dataToSave.getDayValue());
        editor.putInt("Month" + Integer.toString(arraySize), dataToSave.getMonthValue());
        editor.putInt("Year" + Integer.toString(arraySize), dataToSave.getYearValue());
        editor.putInt("Hour" + Integer.toString(arraySize), dataToSave.getHourValue());
        editor.putInt("Minute" + Integer.toString(arraySize), dataToSave.getMinuteValue());
        editor.apply();
    }

}
