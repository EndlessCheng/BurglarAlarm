package com.jianyan.android.burglaralarm;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class AppConfig {

    public static SharedPreferences getSharedPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }
}
