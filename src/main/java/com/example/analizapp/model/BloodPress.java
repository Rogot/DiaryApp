package com.example.analizapp.model;

public class BloodPress {

    private int systolicValue;
    private int diastolicValue;
    private int resValue;

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
