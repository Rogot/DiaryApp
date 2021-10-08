package com.example.analizapp;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ListView;
import com.example.analizapp.model.BloodPress;
import com.example.analizapp.model.BloodPressAdapter;

import androidx.annotation.Nullable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class OpenDiaryActivity extends Activity {

    private static final File PATH = Environment.getExternalStoragePublicDirectory(
            Environment.DIRECTORY_DOCUMENTS);
    private static final String fileName = "bloodPressData.ser";
    private static final File FILE = new File(PATH, "/" + fileName);

    private ListView diary_list;
    private BloodPressAdapter mAdapter;

    private BloodPress bloodPress = new BloodPress(0,0);
    private static ArrayList<BloodPress> bloodPressArray = new ArrayList<BloodPress>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.open_diary);

        bloodPressArray = fillData();

        diary_list = (ListView) findViewById(R.id.diaryList);
        mAdapter = new BloodPressAdapter(this, bloodPressArray);
        diary_list.setAdapter(mAdapter);
    }

    public void deleteAllData(View view)
    {
        new File(FILE.toString()).delete();
        try {
            FileOutputStream fos = new FileOutputStream(FILE);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        setContentView(R.layout.open_diary);
    }

    //Fill array for ListView using data from permanent memory
    public ArrayList<BloodPress> fillData()
    {
        ArrayList<BloodPress> temp = new ArrayList<BloodPress>();
        try {
            FileInputStream fis = new FileInputStream(FILE);
            ObjectInputStream ois = new ObjectInputStream(fis);
            temp = (ArrayList<BloodPress>) ois.readObject();
            ois.close();
            fis.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }
}
