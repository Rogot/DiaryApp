package com.example.analizapp.model;

import android.app.Activity;
import android.content.Context;
import android.os.Environment;
import android.text.style.UpdateLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.analizapp.OpenDiaryActivity;
import com.example.analizapp.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class BloodPressAdapter extends ArrayAdapter<BloodPress> {

    private static final File PATH = Environment.getExternalStoragePublicDirectory(
            Environment.DIRECTORY_DOCUMENTS);
    private static final String fileName = "bloodPressData.ser";
    private static final File FILE = new File(PATH, "/" + fileName);

    private Context mContext;
    private ArrayList<BloodPress> bloodPressList;

    public BloodPressAdapter(@NonNull Context context, ArrayList<BloodPress> list) {
        super(context, 0, list);
        this.mContext = context;
        this.bloodPressList = list;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null){
            listItem = LayoutInflater.from(mContext).inflate(R.layout.activity_list_blood_press,parent,false);
        }

        Button deleteButton = (Button) listItem.findViewById(R.id.deleteButton);

        BloodPress currentData = bloodPressList.get(position);

        TextView sys = (TextView) listItem.findViewById(R.id.SYSValText);
        sys.setText(String.valueOf(currentData.getSystolicValue()));

        TextView dia = (TextView) listItem.findViewById(R.id.DIAValText);
        dia.setText(String.valueOf(currentData.getDiastolicValue()));

        TextView plc = (TextView) listItem.findViewById(R.id.PulsePressValText);
        plc.setText(String.valueOf(currentData.getPulseValue()));

        TextView date = (TextView) listItem.findViewById(R.id.DateValText);
        date.setText(String.valueOf(currentData.getDayValue()) + "-" +
                String.valueOf(currentData.getMonthValue()) + "-" +
                String.valueOf(currentData.getYearValue()));

        TextView time = (TextView) listItem.findViewById(R.id.TimeValText);
        String minute = String.valueOf(currentData.getMinuteValue());
        if (Integer.valueOf(minute) < 10)
            minute = "0" + String.valueOf(currentData.getMinuteValue());
        time.setText(String.valueOf(currentData.getHourValue()) + ":" + minute);

        return listItem;
    }
}
