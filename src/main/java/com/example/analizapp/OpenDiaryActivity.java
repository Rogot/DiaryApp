package com.example.analizapp;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.format.Time;
import android.view.View;
import android.widget.ListView;
import com.example.analizapp.model.BloodPress;
import com.example.analizapp.model.BloodPressAdapter;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class OpenDiaryActivity extends Activity {

    private SharedPreferences pref;

    private ListView diary_list;
    private BloodPressAdapter mAdapter;

    private BloodPress  bloodPress = new BloodPress(0,0);;
    private ArrayList<BloodPress> bloodPressArray = new ArrayList<BloodPress>();;
    private int size = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.open_diary);

        pref = getSharedPreferences("DIARY", MODE_PRIVATE);
        size = pref.getInt("DataSize",0);

        filldata(bloodPressArray, pref, size);

        diary_list = (ListView) findViewById(R.id.diaryList);
        mAdapter = new BloodPressAdapter(this, bloodPressArray);
        diary_list.setAdapter(mAdapter);

    }

    public void deleteAllData(View view)
    {
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.apply();
    }

    //Fill array for ListView using data from permanent memory
    public void filldata(ArrayList<BloodPress> bloodPressArray, SharedPreferences pref, int arraySize)
    {
        for(int i = 0; i < arraySize; i++){
            bloodPressArray.add(new BloodPress(
                    pref.getInt("SysVal" + Integer.toString(i), 0),
                    pref.getInt("DisVal" + Integer.toString(i), 0),
                    pref.getInt("ResVal" + Integer.toString(i), 0),
                    pref.getInt("Day" + Integer.toString(i), 0),
                    pref.getInt("Month" + Integer.toString(i), 0),
                    pref.getInt("Year" + Integer.toString(i), 0),
                    pref.getInt("Hour" + Integer.toString(i), 0),
                    pref.getInt("Minute" + Integer.toString(i), 0)
            ));
        }
    }
}
