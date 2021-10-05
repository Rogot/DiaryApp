package com.example.analizapp.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.text.format.Time;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.analizapp.R;
import com.example.analizapp.model.BloodPress;

import java.util.ArrayList;
import java.util.List;


public class BloodPressAdapter extends ArrayAdapter<BloodPress> {

    private Context mContext;
    private List<BloodPress> bloodPressList = new ArrayList<>();

    public BloodPressAdapter(@NonNull Context context, ArrayList<BloodPress> list) {
        super(context, 0, list);
        mContext = context;
        bloodPressList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null){
            listItem = LayoutInflater.from(mContext).inflate(R.layout.activity_list_blood_press,parent,false);
        }

        BloodPress currentData = bloodPressList.get(position);

        TextView sys = (TextView) listItem.findViewById(R.id.SYSValText);
        sys.setText(String.valueOf(currentData.getSystolicValue()));

        TextView dia = (TextView) listItem.findViewById(R.id.DIAValText);
        dia.setText(String.valueOf(currentData.getDiastolicValue()));

        TextView plc = (TextView) listItem.findViewById(R.id.PulsePressValText);
        plc.setText(String.valueOf(currentData.getResValue()));

        TextView day = (TextView) listItem.findViewById(R.id.DateDay);
        day.setText("Д: " + String.valueOf(currentData.getDayValue()));

        TextView month = (TextView) listItem.findViewById(R.id.DateMonth);
        month.setText("M: " + String.valueOf(currentData.getMonthValue()));

        TextView year = (TextView) listItem.findViewById(R.id.DateYear);
        year.setText("Г: " + String.valueOf(currentData.getYearValue()));

        TextView hour = (TextView) listItem.findViewById(R.id.TimeHours);
        hour.setText(String.valueOf(currentData.getHourValue()));

        TextView minute = (TextView) listItem.findViewById(R.id.TimeMinutes);
        minute.setText(String.valueOf(currentData.getMinuteValue()));


        return listItem;
    }
}
