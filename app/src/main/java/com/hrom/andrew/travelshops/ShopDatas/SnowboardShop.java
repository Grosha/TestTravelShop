package com.hrom.andrew.travelshops.ShopDatas;

import com.hrom.andrew.travelshops.R;

import java.util.ArrayList;
import java.util.List;

public class SnowboardShop extends SportShop {
    @Override
    public List<String> getListShops() {
        List<String> siteShops = new ArrayList<>();
        siteShops.add("Екстрім Стайл");
        siteShops.add("Svoboda");
        siteShops.add("Драйв Спорт");
        siteShops.add("Велопланета");
        siteShops.add("Лавіна");
        siteShops.add("Boardshop");
        siteShops.add("Boomerang");
        siteShops.add("Shlem");
        siteShops.add("Board Club");
        siteShops.add("Playsport");
        siteShops.add("Ист Сервис");
        siteShops.add("Extreme Stock");
        siteShops.add("X-Zone");
        siteShops.add("Kingsize");
        siteShops.add("Sportzone");
        siteShops.add("X-board");
        siteShops.add("Keeperstore");
        siteShops.add("Gorgany");
        siteShops.add("Kant");
        siteShops.add("Ekip-sport");
        return siteShops;
    }

    @Override
    public List<Integer> getIconShops() {
        List<Integer> imageShops = new ArrayList<>();
        imageShops.add(R.drawable.icon_extrim_style);
        imageShops.add(R.drawable.icon_svoboda);
        imageShops.add(R.drawable.icon_drive_sport);
        imageShops.add(R.drawable.icon_veloplaneta);
        imageShops.add(R.drawable.icon_lavina);
        imageShops.add(R.drawable.icon_boardshop);
        imageShops.add(R.drawable.icon_boomerang);
        imageShops.add(R.drawable.icon_shlem);
        imageShops.add(R.drawable.icon_board_club);
        imageShops.add(R.drawable.icon_playsport);
        imageShops.add(R.drawable.web_);
        imageShops.add(R.drawable.icon_extreme_stock);
        imageShops.add(R.drawable.icon_x_zone);
        imageShops.add(R.drawable.icon_kingsize);
        imageShops.add(R.drawable.icon_sportzone);
        imageShops.add(R.drawable.web_);
        imageShops.add(R.drawable.icon_keeperstore);
        imageShops.add(R.drawable.icon_gorgany);
        imageShops.add(R.drawable.icon_kant);
        imageShops.add(R.drawable.icon_ekip_sport);
        return imageShops;
    }

    @Override
    public String getLinkShop(int position) {
        ArrayList<String> listAdressWebSite = new ArrayList<>();
        listAdressWebSite.add("http://extremstyle.ua/doski-catalogs/");
        listAdressWebSite.add("http://snowboard.kiev.ua/shop/");
        listAdressWebSite.add("http://ru.drive-sport.com.ua/");
        listAdressWebSite.add("http://veloplaneta.com.ua/catalog/zimnie-tovary/");
        listAdressWebSite.add("http://www.lavina.com.ua/snoubord-2.html");
        listAdressWebSite.add("http://boardshop.com.ua/");
        listAdressWebSite.add("http://boomerang.kiev.ua/snow");
        listAdressWebSite.add("http://shlem.com.ua/zimniy-sport/snoubordi");
        listAdressWebSite.add("http://www.board-club.com.ua/");
        listAdressWebSite.add("http://www.playsport.com.ua/snoubordy/");
        listAdressWebSite.add("http://shop.ist.ua/");
        listAdressWebSite.add("http://www.extreme-stock.com/33-bu-snoubordy");
        listAdressWebSite.add("http://www.x-zone.com.ua/winter.html");
        listAdressWebSite.add("http://www.kingsize.com.ua/");
        listAdressWebSite.add("http://sportzone.com.ua/snoubord");
        listAdressWebSite.add("http://x-board.com.ua/index.php?cat=2");
        listAdressWebSite.add("http://www.keeperstore.com.ua/catalog/snoubord/");
        listAdressWebSite.add("http://www.gorgany.com/snoubordyng");
        listAdressWebSite.add("http://kant.ua/category-snoubordy/snoubordy/");
        listAdressWebSite.add("http://ekip-sport.com.ua/category/snoubordy_2/");
        return listAdressWebSite.get(position);
    }
}
