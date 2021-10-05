package com.example.analizapp.model;

import android.text.format.Time;

public class BloodPress {

    private int systolicValue;
    private int diastolicValue;
    private int resValue;
    private int dayValue;
    private int monthValue;
    private int yearValue;
    private int hourValue;
    private int minuteValue;


    public BloodPress(int systolicValue, int diastolicValue) {
        this.systolicValue = systolicValue;
        this.diastolicValue = diastolicValue;
        this.resValue = systolicValue - diastolicValue;
    }

    public BloodPress(int systolicValue, int diastolicValue, int resValue) {
        this.systolicValue = systolicValue;
        this.diastolicValue = diastolicValue;
        this.resValue = resValue;
    }

    public BloodPress(int systolicValue, int diastolicValue, int resValue, int dayValue, int monthValue, int yearValue, int hourValue, int minuteValue) {
        this.systolicValue = systolicValue;
        this.diastolicValue = diastolicValue;
        this.resValue = resValue;
        this.dayValue = dayValue;
        this.monthValue = monthValue;
        this.yearValue = yearValue;
        this.hourValue = hourValue;
        this.minuteValue = minuteValue;
    }

    public int getDayValue() {
        return dayValue;
    }

    public int getMonthValue() {
        return monthValue;
    }

    public int getYearValue() {
        return yearValue;
    }

    public int getHourValue() {
        return hourValue;
    }

    public void setDayValue(int dayValue) {
        this.dayValue = dayValue;
    }

    public void setMonthValue(int monthValue) {
        this.monthValue = monthValue;
    }

    public void setYearValue(int yearValue) {
        this.yearValue = yearValue;
    }

    public void setHourValue(int hourValue) {
        this.hourValue = hourValue;
    }

    public void setMinuteValue(int minuteValue) {
        this.minuteValue = minuteValue;
    }

    public int getMinuteValue() {
        return minuteValue;
    }

    public int getSystolicValue() {
        return systolicValue;
    }

    public int getDiastolicValue() {
        return diastolicValue;
    }

    public int getResValue() {
        return resValue;
    }

    public void setSystolicValue(int systolicValue) {
        this.systolicValue = systolicValue;
    }

    public void setDiastolicValue(int diastolicValue) {
        this.diastolicValue = diastolicValue;
    }

    public void setResValue(int resValue) {
        this.resValue = resValue;
    }
}
