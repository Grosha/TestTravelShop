package com.hrom.andrew.travelshops.ShopDB;

import com.hrom.andrew.travelshops.R;

import java.util.ArrayList;
import java.util.List;

public class BikeShop extends SportShop {
    @Override
    public List<String> getListShops() {
        List<String> siteShops = new ArrayList<>();
        siteShops.add("Velomarket");
        siteShops.add("Екстрем Стайл");
        siteShops.add("Спорт Самміт");
        siteShops.add("Groosha");
        siteShops.add("Велопланета");
        siteShops.add("Specialized");
        siteShops.add("Veloonline");
        siteShops.add("Velomoto");
        siteShops.add("Porover");
        siteShops.add("Rider");
        siteShops.add("Cube");
        siteShops.add("Velohit");
        siteShops.add("Orbeabikes");
        siteShops.add("Velostar");
        siteShops.add("Veloviva");
        siteShops.add("Scott");
        siteShops.add("Bikemotive");
        siteShops.add("Велотим");
        siteShops.add("Megadrive");
        return siteShops;
    }

    @Override
    public List<Integer> getIconShops() {
        List<Integer> imageShops = new ArrayList<>();
        imageShops.add(R.drawable.web_);
        imageShops.add(R.drawable.icon_extrim_style);
        imageShops.add(R.drawable.web_);
        imageShops.add(R.drawable.icon_groosha);
        imageShops.add(R.drawable.icon_veloplaneta);
        imageShops.add(R.drawable.icon_specialized);
        imageShops.add(R.drawable.icon_veloonline);
        imageShops.add(R.drawable.icon_velomoto);
        imageShops.add(R.drawable.icon_porover);
        imageShops.add(R.drawable.icon_rider_co);
        imageShops.add(R.drawable.icon_cube);
        imageShops.add(R.drawable.icon_velohit);
        imageShops.add(R.drawable.web_);
        imageShops.add(R.drawable.icon_velostar);
        imageShops.add(R.drawable.icon_veloviva);
        imageShops.add(R.drawable.icon_scott);
        imageShops.add(R.drawable.icon_bikemotive);
        imageShops.add(R.drawable.web_);
        imageShops.add(R.drawable.icon_megadrive);
        return imageShops;
    }

    @Override
    public String getLinkShop(int position) {
        ArrayList<String> listAdressWebSite = new ArrayList<>();
        listAdressWebSite.add("http://velomarket.org.ua/");
        listAdressWebSite.add("http://extremstyle.ua/");
        listAdressWebSite.add("http://www.sportsummit.ua/");
        listAdressWebSite.add("http://groosha.ua/catalog/velosipedy_i_roliki/");
        listAdressWebSite.add("http://veloplaneta.com.ua/");
        listAdressWebSite.add("http://www.specialized.com.ua/");
        listAdressWebSite.add("http://www.veloonline.com/");
        listAdressWebSite.add("http://www.velomoto.kiev.ua/");
        listAdressWebSite.add("http://porover.com/");
        listAdressWebSite.add("http://rider-co.com/");
        listAdressWebSite.add("http://cubeukraine.com/");
        listAdressWebSite.add("http://www.velohit.kiev.ua/");
        listAdressWebSite.add("http://orbeabikes.com.ua/");
        listAdressWebSite.add("http://velostar.com.ua/");
        listAdressWebSite.add("http://veloviva.com.ua/");
        listAdressWebSite.add("http://scott.ua/");
        listAdressWebSite.add("http://bikemotive.com.ua/");
        listAdressWebSite.add("http://www.veloteam.com.ua/");
        listAdressWebSite.add("http://megadrive.kiev.ua/");

        return listAdressWebSite.get(position);
    }
}
