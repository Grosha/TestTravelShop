package com.hrom.andrew.travelshops.ShopDB;

import android.content.Context;

import com.google.gson.Gson;
import com.hrom.andrew.travelshops.costumAdapterListItem.NewShop;
import com.hrom.andrew.travelshops.trash.PrefUtil;
import com.hrom.andrew.travelshops.trash.StringVariables;
import com.hrom.andrew.travelshops.trash.Type;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class NewFavoriteFactory {
    public final static String TAG = StringVariables.TAG_FAVORITE_LIST;
    private ArrayList<NewShop> listFavorite = new ArrayList<>();
    private Set<String> gsonList;
    private DataFactory dataFactory;

    public NewFavoriteFactory(Context context) {
        gsonList = PrefUtil.getValueList(context);
        newListGson();
    }

    private void newListGson() {
        if (gsonList == null) {
            gsonList = new HashSet<>();
        } else
            for (String s : gsonList) {
                int idShop = new Gson().fromJson(s, Integer.class);
                ArrayList<NewShop> listItems = dataFactory.getListShop(Type.All);
                listFavorite.add(listItems.get(idShop));
            }
    }

    public ArrayList<NewShop> getListFavorite() {
        return listFavorite;
    }
}