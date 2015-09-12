package com.hrom.andrew.travelshops.TrashActivity;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreference {
    public static final String FILE_NAME = "MY_LIST";
    public static final String PRES_KEY = "SHOP";

    public SharedPreference() {
        super();
    }

    public void save(Context context, String text){
        SharedPreferences preferences = context.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(PRES_KEY,text);
        editor.commit();
    }

    public String getValue(Context context) {
        SharedPreferences settings = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        String text = settings.getString(PRES_KEY, null);
        return text;
    }
}
