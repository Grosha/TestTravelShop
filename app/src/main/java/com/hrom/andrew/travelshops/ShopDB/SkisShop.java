package com.hrom.andrew.travelshops.ShopDB;

import com.hrom.andrew.travelshops.R;

import java.util.ArrayList;
import java.util.List;

public class SkisShop extends SportShop{

    @Override
    public List<String> getListShops() {
        List<String> siteShops = new ArrayList<>();
        siteShops.add("Modena Sport");
        siteShops.add("Екстрем Стайл");
        siteShops.add("Kant");
        siteShops.add("Sportzone");
        siteShops.add("X-Zone");
        siteShops.add("Adrenalin");
        siteShops.add("SeeSki");
        siteShops.add("Playsport");
        siteShops.add("Skimag");
        siteShops.add("Sport Stylus");
        siteShops.add("Shlem");
        siteShops.add("A-Sport");
        //siteShops.add("Profi Rider");//Львів
        siteShops.add("Skaut");
        siteShops.add("Gorgany");
        siteShops.add("Sportek");
        siteShops.add("Veloviva");
        siteShops.add("Ekip Sport");
        //siteShops.add("Sport Continent");//Львів
        siteShops.add("Fischersports");
        siteShops.add("Skirental");
        siteShops.add("Keeperstore");
        siteShops.add("Gofree");
        siteShops.add("Lavina");
        siteShops.add("Groosha");
        siteShops.add("Protest");

        return siteShops;
    }

    @Override
    public List<Integer> getIconShops() {
        List<Integer> imageShops = new ArrayList<>();
        imageShops.add(R.drawable.web_);
        imageShops.add(R.drawable.icon_extrim_style);
        imageShops.add(R.drawable.icon_kant);
        imageShops.add(R.drawable.icon_sportzone);
        imageShops.add(R.drawable.icon_x_zone);
        imageShops.add(R.drawable.icon_adrenalin);
        imageShops.add(R.drawable.icon_seeski);
        imageShops.add(R.drawable.icon_playsport);
        imageShops.add(R.drawable.icon_skimag);
        imageShops.add(R.drawable.icon_sport_stylus);
        imageShops.add(R.drawable.icon_shlem);
        imageShops.add(R.drawable.web_);
        //imageShops.add(R.drawable.icon_profirider);//Львів
        imageShops.add(R.drawable.icon_skaut);
        imageShops.add(R.drawable.icon_gorgany);
        imageShops.add(R.drawable.icon_sportek);
        imageShops.add(R.drawable.icon_veloviva);
        imageShops.add(R.drawable.icon_ekip_sport);
        //imageShops.add(R.drawable.icon_sport_co);//Львів
        imageShops.add(R.drawable.icon_fishersports);
        imageShops.add(R.drawable.icon_skirental);
        imageShops.add(R.drawable.icon_keeperstore);
        imageShops.add(R.drawable.icon_gofree);
        imageShops.add(R.drawable.icon_lavina);
        imageShops.add(R.drawable.icon_groosha);
        imageShops.add(R.drawable.icon_protest);

        return imageShops;
    }

    @Override
    public String getLinkShop(int position) {
        ArrayList<String> listAdressWebSite = new ArrayList<>();
        listAdressWebSite.add("http://msport.com.ua/ski/");
        listAdressWebSite.add("http://extremstyle.ua/lyzhi-gornye-catalogs/");
        listAdressWebSite.add("http://kant.ua/category-lyzhi/");
        listAdressWebSite.add("http://sportzone.com.ua/lyizhi");
        listAdressWebSite.add("http://www.x-zone.com.ua/winter.html");
        listAdressWebSite.add("http://www.adrenalin.kiev.ua/");
        listAdressWebSite.add("http://seeski.visit.ua/");
        listAdressWebSite.add("http://www.playsport.com.ua/lyzhi/");
        listAdressWebSite.add("http://skimag.com.ua/gornye-lyzhi/");
        listAdressWebSite.add("http://sport.stylus.com.ua/ru/products/skiing/index.html");
        listAdressWebSite.add("http://shlem.com.ua/zimniy-sport/lizhi");
        listAdressWebSite.add("http://a-sport.in.ua/");
        //listAdressWebSite.add("http://profirider.com.ua/shop/category/gornye-lyzhi");//Львів
        listAdressWebSite.add("http://skaut.com.ua/market/zima/lyzhi");
        listAdressWebSite.add("http://ru.gorgany.com/begovye-lyzhi");
        listAdressWebSite.add("http://sportek.ua/shop/category/zimnie-vidy-sporta/lyzhi");
        listAdressWebSite.add("http://veloviva.com.ua/catalog/mountain-skiing/");
        listAdressWebSite.add("http://ekip-sport.com.ua/category/gornye_lyzhi/");
        //listAdressWebSite.add("http://sport-co.com.ua/catalog6/");//Львів
        listAdressWebSite.add("http://www.fischersports.com.ua/catalogue/cat/gornie-lizhi-fischer/");
        listAdressWebSite.add("http://skirental.kiev.ua/shop");
        listAdressWebSite.add("http://www.keeperstore.com.ua/catalog/gornye_lyzhi_dlya_frirayda/");
        listAdressWebSite.add("http://www.gofree.com.ua/category/struktura-magazina/gornye-lyzhi");
        listAdressWebSite.add("http://www.lavina.com.ua/lyzhi-s-kreplenijami.html");
        listAdressWebSite.add("http://groosha.ua/catalog/lyzhi/");
        listAdressWebSite.add("http://protest.ua/twin-tip-background_skis");
        return listAdressWebSite.get(position);
    }
}
