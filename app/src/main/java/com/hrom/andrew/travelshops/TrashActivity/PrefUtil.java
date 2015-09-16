package com.hrom.andrew.travelshops.TrashActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceManager;

public class PrefUtil {

    public static final String PRES_KEY = "SHOP";


    public static void save(Context context, String text){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(PRES_KEY,text);
        editor.apply();
    }

    public static String getValue(Context context) {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        String text = settings.getString(PRES_KEY, null);
        return text;
    }
}
