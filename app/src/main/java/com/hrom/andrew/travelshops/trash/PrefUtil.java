package com.hrom.andrew.travelshops.trash;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.HashSet;
import java.util.Set;

public class PrefUtil {
    public static final String PRES_KEY_SHOP = "SHOP";
    public static final String PRES_KEY_INTERSTITIAL = "INTERSTITIAL";

    public static void save(Context context, String text) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        Set<String> myList = preferences.getStringSet(StringVariables.PRES_KEY_SHOP, new HashSet<String>());
        myList.add(text);
        editor.putStringSet(StringVariables.PRES_KEY_SHOP, myList);
        editor.apply();
    }

    public static Set<String> getValueList(Context context) {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        Set<String> myList = new HashSet<>();
        myList = settings.getStringSet(StringVariables.PRES_KEY_SHOP, myList);
        return myList;
    }

    public static void remove(Context context, String text) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        Set<String> myList = preferences.getStringSet(StringVariables.PRES_KEY_SHOP, new HashSet<String>());
        myList.remove(text);
        editor.putStringSet(StringVariables.PRES_KEY_SHOP, myList);
        editor.apply();
    }

    public static void save(Context context, int countInterstitial, String key) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(key, countInterstitial);
        editor.commit();
    }

    public static int getCountInterstitial(Context context, String key) {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        return settings.getInt(key, 1);
    }
}
