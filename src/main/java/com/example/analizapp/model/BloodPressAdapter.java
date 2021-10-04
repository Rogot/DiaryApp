package com.example.analizapp.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
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

        return listItem;
    }
}
