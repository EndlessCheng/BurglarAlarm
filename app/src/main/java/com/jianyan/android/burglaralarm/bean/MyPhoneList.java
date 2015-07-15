package com.jianyan.android.burglaralarm.bean;

import java.util.ArrayList;

public class MyPhoneList {
    ArrayList<MyPhone> mMyPhoneArrayList;

    public MyPhoneList(){
        mMyPhoneArrayList = new ArrayList<MyPhone>();
    }

    public MyPhoneList(ArrayList<MyPhone> myPhoneArrayList){
        mMyPhoneArrayList = myPhoneArrayList;
    }

    public void add(MyPhone myphone){
        mMyPhoneArrayList.add(myphone);
    }
}
