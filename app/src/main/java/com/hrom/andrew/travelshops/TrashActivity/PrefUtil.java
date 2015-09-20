package com.hrom.andrew.travelshops.TrashActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.hrom.andrew.travelshops.ShopDB.BikeShop;

import java.util.HashSet;
import java.util.Set;

public class PrefUtil {
    public static final String PRES_KEY = "SHOP";
    private static BikeShop bikeShop = new BikeShop();

    public static void save(Context context, String text) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        Set<String> myList = preferences.getStringSet(PRES_KEY,new HashSet<String>());
        myList.add(text);
        editor.putStringSet(PRES_KEY,myList);
        editor.apply();
    }

    public static Set<String> getValueList(Context context){
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        Set<String> myList = new HashSet<>();
        myList=settings.getStringSet(PRES_KEY, null);
        return myList;
    }


    public static String getValue(Context context) {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        String text = settings.getString(PRES_KEY, null);
        String text1 = text;
        /*for (int i = 0; i < bikeShop.getListShops().size(); i++) {
            if (bikeShop.getListShops().get(i).equals(text)) {
                text1 = bikeShop.getLinkShop(i) ;
            }
        }*/
        return text;
    }
}
