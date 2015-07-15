package com.jianyan.android.burglaralarm.ui;

import android.support.v4.app.Fragment;

import com.jianyan.android.burglaralarm.base.SingleFragmentActivity;
import com.jianyan.android.burglaralarm.fragment.PhoneStateFragment;

public class MainActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new PhoneStateFragment();
    }
}