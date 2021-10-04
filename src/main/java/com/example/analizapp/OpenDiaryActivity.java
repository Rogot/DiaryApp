package com.example.analizapp;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.example.analizapp.model.BloodPress;
import com.example.analizapp.model.BloodPressAdapter;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class OpenDiaryActivity extends Activity {

    private SharedPreferences pref;

    private ListView diary_list;
    private BloodPress  bloodPress = new BloodPress(0,0);;
    private ArrayList<BloodPress> bloodPressArray = new ArrayList<BloodPress>();;
    private int size = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.open_diary);


        pref = getSharedPreferences("DIARY", MODE_PRIVATE);
        size = pref.getInt("DataSize",0);

        //filldata(bloodPressArray, pref, size);

        bloodPressArray.add(new BloodPress(120,80));
        bloodPressArray.add(new BloodPress(160,90));
        bloodPressArray.add(new BloodPress(150,70));
        bloodPressArray.add(new BloodPress(140,80));

        diary_list = (ListView) findViewById(R.id.diaryList);
        BloodPressAdapter bloodAdapter = new BloodPressAdapter(this, R.layout.activity_list_blood_press, bloodPressArray);
        diary_list.setAdapter(bloodAdapter);

    }

    public void deleteAllData(View view)
    {
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.apply();
    }

    public void filldata(ArrayList<BloodPress> bloodPressArray, SharedPreferences pref, int arraySize)
    {
        BloodPress item = new BloodPress(0,0, 0);
        for(int i = 0; i < arraySize; i++){
            item.setSystolicValue( pref.getInt("SysVal" + arraySize, 0));
            item.setDiastolicValue( pref.getInt("DisVal" + arraySize, 0));
            item.setResValue( pref.getInt("ResVal" + arraySize, 0));

            bloodPressArray.add(item);
        }
    }
}
