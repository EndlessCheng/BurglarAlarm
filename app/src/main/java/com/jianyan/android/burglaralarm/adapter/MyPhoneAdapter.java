package com.jianyan.android.burglaralarm.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.jianyan.android.burglaralarm.R;
import com.jianyan.android.burglaralarm.bean.MyPhone;

import java.util.ArrayList;
public class MyPhoneAdapter extends ArrayAdapter<MyPhone> {
    Activity mActivity;

    public MyPhoneAdapter(Activity activity, ArrayList<MyPhone> myPhones) {
        super(activity, 0, myPhones);

        mActivity = activity;
    }

//    @Override
//    public boolean areAllItemsEnabled() {
//        return false;
//    }
//
//    @Override
//    public boolean isEnabled(int position) {
//        return 0 != position;
//    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (null == convertView) {
            convertView = mActivity.getLayoutInflater().inflate(R.layout.list_item_phone, null); // *
        }

        MyPhone s = getItem(position);

        TextView phoneNameTextView = (TextView) convertView.findViewById(R.id.phone_name_text_view);
        phoneNameTextView.setText(s.getPhoneName());

        return convertView;
    }
}
