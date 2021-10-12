package com.example.analizapp;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
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

    private EditText diastolic_edit;
    private EditText systolic_edit;
    private TextView pls_text;
    private TextView date_text;
    private TextView time_text;
    private TextView checkBox_text_large;
    private TextView checkBox_text_small;
    private EditText day_edit;
    private EditText month_edit;
    private EditText year_edit;
    private EditText hour_edit;
    private EditText minute_edit;
    private CheckBox checkBox;

    private BloodPress bloodPress;

    private ArrayList<BloodPress> bloodPressArray = new ArrayList<BloodPress>();
    private int size;
    Time today = new Time(Time.getCurrentTimezone());


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fill_diary);

        diastolic_edit = (EditText) findViewById(R.id.diastolicEdit);
        systolic_edit = (EditText) findViewById(R.id.systolicEdit);
        pls_text = (TextView) findViewById(R.id.plsText_2);
        date_text = (TextView) findViewById(R.id.textDate);
        time_text = (TextView) findViewById(R.id.textTime);
        checkBox_text_large = (TextView) findViewById(R.id.checkboxTextLarge);
        checkBox_text_small = (TextView) findViewById(R.id.checkboxTextSmall);
        day_edit = (EditText) findViewById(R.id.editDay);
        month_edit = (EditText) findViewById(R.id.editMonth);
        year_edit = (EditText) findViewById(R.id.editYear);
        hour_edit = (EditText) findViewById(R.id.editHour);
        minute_edit = (EditText) findViewById(R.id.editMinute);
        checkBox = (CheckBox) findViewById(R.id.checkbox);

        setPermissionToEnter(false);

        bloodPress = new BloodPress(0,0);

        today.setToNow();
    }

    //Checkbox handler
    public void onClickCheckBox (View view) {
        if (checkBox.isChecked()) {
            date_text.setTextColor(getResources().getColor(R.color.secColor));
            time_text.setTextColor(getResources().getColor(R.color.secColor));
            checkBox_text_large.setTextColor(getResources().getColor(R.color.secColor));
            checkBox_text_small.setTextColor(getResources().getColor(R.color.secColor));
            setPermissionToEnter(true);
        }
        else {
            date_text.setTextColor(getResources().getColor(R.color.inactiveColor));
            time_text.setTextColor(getResources().getColor(R.color.inactiveColor));
            checkBox_text_large.setTextColor(getResources().getColor(R.color.inactiveColor));
            checkBox_text_small.setTextColor(getResources().getColor(R.color.inactiveColor));
            setPermissionToEnter(false);
        }
    }

    //Function for button which let save data
    public void onClickWriteData(View view) {
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

            if (checkBox.isChecked()) {
                bloodPress.setDayValue(Integer.parseInt(day_edit.getText().toString()));
                bloodPress.setMonthValue(Integer.parseInt(month_edit.getText().toString()));
                bloodPress.setYearValue(Integer.parseInt(year_edit.getText().toString()));
                bloodPress.setHourValue(Integer.parseInt(hour_edit.getText().toString()));
                bloodPress.setMinuteValue(Integer.parseInt(minute_edit.getText().toString()));
            } else {
                bloodPress.setDayValue(today.monthDay);
                bloodPress.setMonthValue(today.month + 1);
                bloodPress.setYearValue(today.year);
                bloodPress.setHourValue(today.hour);
                bloodPress.setMinuteValue(today.minute);
            }

            pls_text.setText(String.valueOf(Sys - Dias));

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

    private void setPermissionToEnter(boolean permission) {
        day_edit.setEnabled(permission);
        month_edit.setEnabled(permission);
        year_edit.setEnabled(permission);
        hour_edit.setEnabled(permission);
        minute_edit.setEnabled(permission);
    }

}
