package com.example.analizapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.text.format.Time;

import com.example.analizapp.model.BloodPress;

import androidx.annotation.Nullable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FillActivity extends Activity {

    private static final File PATH = Environment.getExternalStoragePublicDirectory(
            Environment.DIRECTORY_DOCUMENTS);
    private static final String fileName = "bloodPressData.ser";
    private static final File FILE = new File(PATH, "/" + fileName);

    private Button writeData_button;
    private EditText diastolic_edit;
    private EditText systolic_edit;
    private TextView res_edit;
    private BloodPress bloodPress;

    private ArrayList<BloodPress> bloodPressArray = new ArrayList<BloodPress>();
    private int size;
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

        diastolic_edit.setText(String.valueOf(0));
        systolic_edit.setText(String.valueOf(0));
        res_edit.setText(String.valueOf(0));

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
            bloodPress.setPulseValue(Sys - Dias);

            bloodPress.setDayValue(today.monthDay);
            bloodPress.setMonthValue(today.month + 1);
            bloodPress.setYearValue(today.year);
            bloodPress.setHourValue(today.hour);
            bloodPress.setMinuteValue(today.minute);

            res_edit.setText(String.valueOf(Sys - Dias));

            saveData(bloodPress, size);
        }
    }

    //Data saving function in permanent memory
    private void saveData(BloodPress dataToSave, int arraySize)
    {
        try {

            FileInputStream fis = new FileInputStream(FILE);
            ObjectInputStream ois = new ObjectInputStream(fis);

            bloodPressArray = (ArrayList<BloodPress>) ois.readObject();
            bloodPressArray.add(dataToSave);

            FileOutputStream fos = new FileOutputStream(FILE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(bloodPressArray);
            oos.close();
            fos.close();
            ois.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
