package com.example.analizapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import com.example.analizapp.dialogFragments.ReminderTimeDialog;
import com.example.analizapp.Adapters.ReminderAdapter;
import com.example.analizapp.model.Time;

import java.util.ArrayList;

public class SettingActivity extends AppCompatActivity {

    private SharedPreferences pref;

    private ListView reminder_listView;
    private ReminderAdapter reminderAdapter;

    private static ArrayList<Time> timeArray = new ArrayList<Time>();

    private SwitchCompat dark_view_switchCombat;
    private SwitchCompat reminder_switchCombat;

    private Button plusHour_button;
    private Button minusHour_button;
    private Button plusMinute_button;
    private Button minusMinute_button;
    private TextView hour_text;
    private TextView minute_text;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_activity);

        //dark_view_switchCombat = (SwitchCompat) findViewById(R.id.dark_view_switchCombat);
        reminder_switchCombat = (SwitchCompat) findViewById(R.id.reminder_switchCombat);
        reminder_listView = (ListView) findViewById(R.id.list_view_reminder_list);

        timeArray.add(new Time(10,30));
        timeArray.add(new Time(17,00));

        plusHour_button = (Button) findViewById(R.id.plusHourButton);
        minusHour_button = (Button) findViewById(R.id.minusHourButton);
        plusMinute_button = (Button) findViewById(R.id.plusMinuteButton);
        minusMinute_button = (Button) findViewById(R.id.minusMinuteButton);
        hour_text = (TextView) findViewById(R.id.hourText);
        minute_text = (TextView) findViewById(R.id.minuteText);

        reminderAdapter = new ReminderAdapter(this, R.layout.activity_reminder_list, timeArray);
        reminder_listView.setAdapter(reminderAdapter);
    }

    public void addReminderListener(View view) {
        ReminderTimeDialog reminderTimeDialog = new ReminderTimeDialog();
        reminderTimeDialog.show(getSupportFragmentManager(), ReminderTimeDialog.TAG);
    }

    public void plusHourDialogListener(View view){
        String str = hour_text.getText().toString();
        hour_text.setText(String.valueOf(
                Integer.parseInt(hour_text.getText().toString()) + 1)
        );
    }

    public void minusHourDialogListener(View view){
        hour_text.setText(String.valueOf(
                Integer.parseInt(hour_text.getText().toString()) - 1)
        );
    }

    public void plusMinuteDialogListener(View view){
        hour_text.setText(String.valueOf(
                Integer.parseInt(minute_text.getText().toString()) + 1)
        );
    }

    public void minusMinuteDialogListener(View view){
        hour_text.setText(String.valueOf(
                Integer.parseInt(minute_text.getText().toString()) - 1)
        );
    }

    public void onClickConfDialogListener(View view) {

    }
}
