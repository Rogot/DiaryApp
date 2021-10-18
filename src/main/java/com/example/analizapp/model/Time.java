package com.example.analizapp.model;

import java.io.Serializable;

public class Time implements Serializable {

    private int mHour;
    private int mMinute;

    public Time(int hour, int minute){
        this.mHour = hour;
        this.mMinute = minute;
    }

    public int getHour() {
        return mHour;
    }

    public int getMinute() {
        return mMinute;
    }

    public void setHour(int hour) {
        this.mHour = hour;
    }

    public void setMinute(int minute) {
        this.mMinute = minute;
    }
}
