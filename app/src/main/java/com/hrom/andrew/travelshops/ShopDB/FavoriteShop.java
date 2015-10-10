package com.hrom.andrew.travelshops.ShopDB;

import android.content.Context;

import com.google.gson.Gson;
import com.hrom.andrew.travelshops.TrashActivity.PrefUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FavoriteShop extends SportShop {
    private List<String> siteShops = new ArrayList<>();
    private List<Integer> imageShops = new ArrayList<>();
    private ArrayList<String> listAdressWebSite = new ArrayList<>();
    private Set<String> gsonList;


    public FavoriteShop(Context context) {
        gsonList = PrefUtil.getValueList(context);
        listGson();
    }

    @Override
    public List<String> getListShops() {
        return siteShops;
    }

    @Override
    public List<Integer> getIconShops() {
        return imageShops;
    }

    @Override
    public String getLinkShop(int position) {
        return listAdressWebSite.get(position);
    }

    public void listGson() {
        if (gsonList == null) {
            gsonList = new HashSet<>();
        } else
            for (String s : gsonList) {
                Shop shop = new Gson().fromJson(s, Shop.class);
                imageShops.add(shop.getIconShop());
                siteShops.add(shop.getNameShop());
                listAdressWebSite.add(shop.getUrl());
            }
    }
}
