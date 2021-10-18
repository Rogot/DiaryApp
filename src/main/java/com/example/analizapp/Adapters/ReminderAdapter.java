package com.example.analizapp.Adapters;

import android.content.Context;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.analizapp.R;
import com.example.analizapp.model.Time;

import java.io.File;
import java.util.ArrayList;

public class ReminderAdapter extends ArrayAdapter<Time> {

    private static final File PATH = Environment.getExternalStoragePublicDirectory(
            Environment.DIRECTORY_DOCUMENTS);
    private static final String fileName = "reminderList.ser";
    private static final File FILE = new File(PATH, "/" + fileName);

    private Context mContext;
    private ArrayList<Time> mTimeList;
    private int mResource;

    String temp;

    public ReminderAdapter(@NonNull Context context, @NonNull int resource, ArrayList<Time> list) {
        super(context, 0, list);
        this.mContext = context;
        this.mTimeList = list;
        this.mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listReminders = convertView;
        if(listReminders == null){
            listReminders = LayoutInflater.from(mContext).inflate(mResource,parent,false);
        }

        Time currentData = mTimeList.get(position);

        TextView hour = (TextView) listReminders.findViewById(R.id.timeText_Hour);
        hour.setText(String.valueOf(currentData.getHour()));

        TextView minute = (TextView) listReminders.findViewById(R.id.timeText_Minutes);
        if (currentData.getMinute() < 10)
            minute.setText("0" + String.valueOf(currentData.getMinute()));
        else minute.setText(String.valueOf(currentData.getMinute()));

        return listReminders;
    }
}
