package com.hrom.andrew.travelshops.TrashActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.HashSet;
import java.util.Set;

public class PrefUtil {
    public static final String PRES_KEY_SHOP = "SHOP";
    public static final String PRES_KEY_INTERSTITIAL = "SHOP";

    public static void save(Context context, String text) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        Set<String> myList = preferences.getStringSet(PRES_KEY_SHOP, new HashSet<String>());
        myList.add(text);
        editor.putStringSet(PRES_KEY_SHOP, myList);
        editor.apply();
    }

    public static Set<String> getValueList(Context context) {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        Set<String> myList = new HashSet<>();
        myList = settings.getStringSet(PRES_KEY_SHOP, myList);
        return myList;
    }

    public static void remove(Context context, String text) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        Set<String> myList = preferences.getStringSet(PRES_KEY_SHOP, new HashSet<String>());
        myList.remove(text);
        editor.putStringSet(PRES_KEY_SHOP, myList);
        editor.apply();
    }

    public static void save(Context context, int countInterstitial) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(PRES_KEY_INTERSTITIAL, countInterstitial);
        editor.apply();
    }

    public static int getCountInterstitial(Context context) {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        return settings.getInt(PRES_KEY_INTERSTITIAL, 1);
    }
}
