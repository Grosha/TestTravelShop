package com.hrom.andrew.travelshops.ShopDB;

import com.hrom.andrew.travelshops.R;
import com.hrom.andrew.travelshops.costumAdapterListItem.NewShop;
import com.hrom.andrew.travelshops.trash.StringVariables;

import java.util.HashMap;

public class NewMapShops {
    public HashMap<NewShop, Integer> hashMapShops() {
        HashMap<NewShop, Integer> listShops = new HashMap<>();

        listShops.put(new NewShop(1, R.drawable.icon_universal, "Velomarket", "http://velomarket.org.ua/", false), StringVariables.TYPE_SHOP_BIKE);
        listShops.put(new NewShop(2, R.drawable.icon_extrim_style, "Екстрем Стайл", "http://extremstyle.ua/", false), StringVariables.TYPE_SHOP_BIKE);
        listShops.put(new NewShop(3, R.drawable.icon_universal, "Спорт Самміт", "http://www.sportsummit.ua/", false), StringVariables.TYPE_SHOP_BIKE);
        listShops.put(new NewShop(4, R.drawable.icon_groosha, "Groosha", "http://groosha.ua/catalog/velosipedy_i_roliki/", false), StringVariables.TYPE_SHOP_BIKE);
        listShops.put(new NewShop(5, R.drawable.icon_specialized, "Specialized", "http://www.specialized.com.ua/", false), StringVariables.TYPE_SHOP_BIKE);
        listShops.put(new NewShop(6, R.drawable.icon_veloplaneta, "Велопланета", "http://veloplaneta.com.ua/", false), StringVariables.TYPE_SHOP_BIKE);

        return listShops;
    }
}
