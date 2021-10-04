package com.example.analizapp.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.analizapp.R;
import com.example.analizapp.model.BloodPress;

import java.util.ArrayList;
import java.util.List;


///*/*/*/////***//*//*/*/*/*/*/**
public class BloodPressAdapter extends ArrayAdapter<BloodPress> {

    private int resourceLayout;
    private Context mContext;

    public BloodPressAdapter(Context context, int resource, List<BloodPress> items){
        super(context, resource, items);
        this.resourceLayout = resource;
        this.mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(mContext);
            v = vi.inflate(resourceLayout, null);
        }

        BloodPress p = getItem(position);

        if (p != null)
        {
            ((TextView) v.findViewById(R.id.SYSValText)).setText(p.getSystolicValue());
            ((TextView) v.findViewById(R.id.DIAValText)).setText(p.getDiastolicValue());
            ((TextView) v.findViewById(R.id.PulsePressValText)).setText(p.getResValue());
        }
        return v;
    }
}
