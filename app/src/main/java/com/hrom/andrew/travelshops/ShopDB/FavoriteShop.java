package com.hrom.andrew.travelshops.ShopDB;

import android.util.Log;

import com.hrom.andrew.travelshops.TrashActivity.MyTag;
import com.hrom.andrew.travelshops.TrashActivity.PrefUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class FavoriteShop extends SportShop {
    private List<String> siteShops = new ArrayList<>();
    private List<Integer> imageShops = new ArrayList<>();
    private ArrayList<String> listAdressWebSite = new ArrayList<>();
    private Set<String> gsonList = PrefUtil.getValueList(this);

    @Override
    public List<String> getListShops() {
        listGson();
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

    private String getVelue(String value) {
        String[] trueValue = value.split(":");
        if (trueValue.length > 2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(trueValue[trueValue.length - 2]).append(":").append(trueValue[trueValue.length - 1]);
            return stringBuilder.toString();
        } else return trueValue[trueValue.length - 1];
    }

    public void listGson() {
        for (String s : gsonList) {
            Log.d(MyTag.TEST, s);
            String[] element = s.replace("\"", "").replace("}", "").split(",");
            Log.d(MyTag.TEST, element[0]);
            Log.d(MyTag.TEST, element[1]);
            Log.d(MyTag.TEST, element[2]);

            Log.d(MyTag.TEST, getVelue(element[0]));
            Log.d(MyTag.TEST, getVelue(element[1]));
            Log.d(MyTag.TEST, getVelue(element[2]));

            imageShops.add(Integer.valueOf(getVelue(element[0])));
            siteShops.add(getVelue(element[1]));
            listAdressWebSite.add(getVelue(element[2]));
        }
    }
}
