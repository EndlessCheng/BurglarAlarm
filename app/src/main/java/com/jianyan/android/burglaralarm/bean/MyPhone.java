package com.jianyan.android.burglaralarm.bean;

public class MyPhone {
    private String phoneName;

    // private Bitmap phonePicture;

    private double safetyDistance;

    public MyPhone() {
    }

    public MyPhone(String phoneName) {
        this.phoneName = phoneName;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public double getSafetyDistance() {
        return safetyDistance;
    }

    public void setSafetyDistance(double safetyDistance) {
        this.safetyDistance = safetyDistance;
    }
}
