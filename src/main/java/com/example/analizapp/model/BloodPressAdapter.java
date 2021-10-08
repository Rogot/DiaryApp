package com.example.analizapp.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.text.format.Time;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
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

        Button delete = (Button) listItem.findViewById(R.id.deleteButton);


        return listItem;
    }
}
