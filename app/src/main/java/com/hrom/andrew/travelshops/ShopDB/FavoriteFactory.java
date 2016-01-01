package com.hrom.andrew.travelshops.ShopDB;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.hrom.andrew.travelshops.costumAdapterListItem.Shop;
import com.hrom.andrew.travelshops.trash.PrefUtil;
import com.hrom.andrew.travelshops.trash.StringVariables;
import com.hrom.andrew.travelshops.trash.Type;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class FavoriteFactory {
    public final static String TAG = StringVariables.TAG_FAVORITE_LIST;
    private ArrayList<Shop> listFavorite = new ArrayList<>();
    private Set<String> gsonList;
    private DataFactory dataFactory = new DataFactory();

    public FavoriteFactory(Context context) {
        gsonList = PrefUtil.getValueList(context);
        newListGson();
    }

    private void newListGson() {
        if (gsonList == null) {
            gsonList = new HashSet<>();
        } else
            for (String s : gsonList) {
                int idShop = new Gson().fromJson(s, Integer.class);
                ArrayList<Shop> listItems = dataFactory.getListShop(Type.All);

                //хреновий варіант
                for (int i = 0; i < listItems.size(); i++) {
                    if (listItems.get(i).getId() == idShop) {
                        Shop shop = listItems.get(i);
                        shop.setFavoriteShop(true);
                        listFavorite.add(shop);
                        Log.d(StringVariables.TEST, "get  " + listItems.get(i).getId() + " " + listItems.get(i).getNameShop() + " " + listItems.get(i).getFavoriteShop());
                    }
                }
            }
    }

    public ArrayList<Shop> getListFavorite() {
        return listFavorite;
    }
}
