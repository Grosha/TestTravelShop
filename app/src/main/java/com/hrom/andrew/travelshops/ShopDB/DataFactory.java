package com.hrom.andrew.travelshops.ShopDB;

import com.hrom.andrew.travelshops.R;
import com.hrom.andrew.travelshops.costumAdapterListItem.Shop;
import com.hrom.andrew.travelshops.trash.Type;

import java.util.ArrayList;

public class DataFactory {

    public ArrayList<Shop> getListShop(Type typeshop) {
        ArrayList<Shop> listShop = new ArrayList<>();
        switch (typeshop) {
            case Mountain:
                listShop = getListMountain();
                break;
            case Bike:
                listShop = getListBike();
                break;
            case Ski:
                listShop = getListSki();
                break;
            case Snowboard:
                listShop = getListSnowBoard();
                break;
            case All:
                listShop = getListAllShops();
                break;
        }

        return listShop;
    }

    private ArrayList<Shop> getListBike() {
        ArrayList<Shop> listBike = new ArrayList<>();

        listBike.add(new Shop(1, R.drawable.icon_universal, "Velomarket", "http://velomarket.org.ua/", false));
        listBike.add(new Shop(2, R.drawable.icon_extrim_style, "Екстрем Стайл", "http://extremstyle.ua/", false));
        listBike.add(new Shop(3, R.drawable.icon_universal, "Спорт Самміт", "http://www.sportsummit.ua/", false));
        listBike.add(new Shop(4, R.drawable.icon_groosha, "Groosha", "http://groosha.ua/catalog/velosipedy_i_roliki/", false));
        listBike.add(new Shop(5, R.drawable.icon_specialized, "Specialized", "https://specialized.com/ua/ru/", false));
        listBike.add(new Shop(6, R.drawable.icon_veloplaneta, "Велопланета", "http://veloplaneta.com.ua/", false));
        listBike.add(new Shop(7, R.drawable.icon_velodom, "ВелоДом", "http://velodom.kiev.ua/", false));
        listBike.add(new Shop(8, R.drawable.icon_veloonline, "Veloonline", "http://www.veloonline.com/", false));
        listBike.add(new Shop(9, R.drawable.icon_velomoto, "Velomoto", "http://www.velomoto.kiev.ua/", false));
        listBike.add(new Shop(10, R.drawable.icon_porover, "Porover", "http://porover.com/", false));
        listBike.add(new Shop(11, R.drawable.icon_rider_co, "Rider", "http://rider-co.com/", false));
        listBike.add(new Shop(12, R.drawable.icon_cube, "Cube", "http://cubeukraine.com/", false));
        listBike.add(new Shop(13, R.drawable.icon_velohit, "Velohit", "http://www.velohit.kiev.ua/", false));
        listBike.add(new Shop(14, R.drawable.icon_universal, "Orbeabikes", "http://orbeabikes.com.ua/", false));
        listBike.add(new Shop(15, R.drawable.icon_velostar, "Velostar", "http://velostar.com.ua/", false));
        listBike.add(new Shop(16, R.drawable.icon_veloviva, "Veloviva", "http://veloviva.com.ua/", false));
        listBike.add(new Shop(17, R.drawable.icon_scott, "Scott", "http://scott.ua/", false));
        listBike.add(new Shop(18, R.drawable.icon_bikemotive, "Bikemotive", "http://bikemotive.com.ua/", false));
        listBike.add(new Shop(19, R.drawable.icon_universal, "Veloteam", "http://www.veloteam.com.ua/", false));
        listBike.add(new Shop(20, R.drawable.icon_megadrive, "Megadrive", "http://megadrive.kiev.ua/", false));
        listBike.add(new Shop(21, R.drawable.icon_freestyle, "Freestyle", "http://www.freestyle.org.ua/", false));
        listBike.add(new Shop(22, R.drawable.icon_alpsport, "Alpsport", "http://alpsport.kiev.ua/", false));
        listBike.add(new Shop(23, R.drawable.icon_protoca, "Protoca", "http://www.sportsite.com.ua/", false));

        return listBike;
    }

    private ArrayList<Shop> getListMountain() {
        ArrayList<Shop> listMountain = new ArrayList<>();

        listMountain.add(new Shop(1001, R.drawable.icon_azimut, "Азімут", "http://www.azimut.com.ua/", false));
        listMountain.add(new Shop(1002, R.drawable.icon_universal, "Волоцюга", "http://volocuga.com/", false));
        listMountain.add(new Shop(1003, R.drawable.icon_atlantida, "Атлантида", "http://atlantida.in.ua/", false));
        listMountain.add(new Shop(1004, R.drawable.icon_el_cap, "Ель-капітан", "http://el-cap.kiev.ua/", false));
        listMountain.add(new Shop(1005, R.drawable.icon_ex, "Команда Екс", "http://ex.com.ua/", false));
        listMountain.add(new Shop(1006, R.drawable.icon_extrim_style, "Екстрем Стайл", "http://extremstyle.ua/", false));
        listMountain.add(new Shop(1007, R.drawable.icon_x_zone, "X-Zone", "http://www.x-zone.com.ua/", false));
        listMountain.add(new Shop(1008, R.drawable.icon_gorgany, "Gorgany", "http://www.gorgany.com/", false));
        listMountain.add(new Shop(1009, R.drawable.icon_adrenalin, "Adrenalin", "http://www.adrenalin.kiev.ua/", false));
        listMountain.add(new Shop(1010, R.drawable.icon_podoroj, "Подорож", "http://www.podoroj.com.ua/", false));
        listMountain.add(new Shop(1011, R.drawable.icon_nomad, "Номад", "http://nomad.com.ua/", false));
        listMountain.add(new Shop(1012, R.drawable.icon_ordana, "Ордана", "http://ordana.com/", false));
        listMountain.add(new Shop(1013, R.drawable.icon_universal, "Skimarket", "http://skimarket.com.ua/", false));
        listMountain.add(new Shop(1014, R.drawable.icon_bizon, "Bizon", "http://bizon.com.ua/", false));
        listMountain.add(new Shop(1015, R.drawable.icon_expert_centre, "Expert", "http://www.expert-centre.com.ua/", false));
        listMountain.add(new Shop(1016, R.drawable.icon_multisport, "Мультіспорт", "http://multisport.com.ua/", false));
        listMountain.add(new Shop(1017, R.drawable.icon_traverse, "Траверс", "http://traverse.com.ua/uk/", false));
        listMountain.add(new Shop(1018, R.drawable.icon_beskid, "Бескід", "http://beskid.com.ua/", false));
        listMountain.add(new Shop(1019, R.drawable.icon_commandor, "Командор", "http://www.commandor.com.ua/", false));
        listMountain.add(new Shop(1020, R.drawable.icon_gofree, "GoFree", "http://www.gofree.com.ua/", false));
        listMountain.add(new Shop(1021, R.drawable.icon_drive_sport, "Драйв Спорт", "http://ru.drive-sport.com.ua/", false));
        listMountain.add(new Shop(1022, R.drawable.icon_capricorn, "Каприкорн", "http://www.capricorn.com.ua/", false));
        listMountain.add(new Shop(1023, R.drawable.icon_terraincognita, "Terra Incognita", "http://terraincognita.ua/ukr/", false));
        listMountain.add(new Shop(1024, R.drawable.icon_northwall, "NorthWall", "http://northwall.com.ua/", false));
        listMountain.add(new Shop(1025, R.drawable.icon_vershyna, "Вершина", "http://vershyna.com.ua/", false));
        listMountain.add(new Shop(1026, R.drawable.icon_freestyle, "Freestyle", "http://www.freestyle.org.ua/", false));
        listMountain.add(new Shop(1027, R.drawable.icon_turkul, "Turkul", "http://turkul.net/", false));
        listMountain.add(new Shop(1028, R.drawable.icon_campsite, "Campsite", "http://campsite.com.ua/", false));
        listMountain.add(new Shop(1029, R.drawable.icon_8000, "8000", "http://www.8000.com.ua/", false));
        listMountain.add(new Shop(1030, R.drawable.icon_alpsport, "Alpsport", "http://alpsport.kiev.ua/", false));
        listMountain.add(new Shop(1031, R.drawable.icon_fram_equipment, "Fram Equipment", "http://fram-equip.com/uk", false));

        return listMountain;
    }

    private ArrayList<Shop> getListSki() {
        ArrayList<Shop> listSki = new ArrayList<>();

        listSki.add(new Shop(2001, R.drawable.icon_kant, "Kant", "http://kant.ua/lignoe-snariagenie/", false));
        listSki.add(new Shop(2002, R.drawable.icon_universal, "Modena Sport", "http://msport.com.ua/ski/", false));
        listSki.add(new Shop(2003, R.drawable.icon_extrim_style, "Екстрем Стайл", "http://extremstyle.ua/", false));
        listSki.add(new Shop(2004, R.drawable.icon_sportzone, "Sportzone", "http://sportzone.com.ua/lyizhi", false));
        listSki.add(new Shop(2005, R.drawable.icon_x_zone, "X-Zone", "http://www.x-zone.com.ua/", false));
        listSki.add(new Shop(2006, R.drawable.icon_adrenalin, "Adrenalin", "http://www.adrenalin.kiev.ua/", false));
        listSki.add(new Shop(2007, R.drawable.icon_seeski, "SeeSki", "http://seeski.visit.ua/", false));
        //listSki.add(new Shop(208, R.drawable.icon_playsport, "Playsport", "http://www.playsport.com.ua/lyzhi/", false));
        listSki.add(new Shop(2009, R.drawable.icon_skimag, "Skimag", "http://skimag.com.ua/gornye-lyzhi/", false));
        listSki.add(new Shop(2010, R.drawable.icon_sport_stylus, "Sport Stylus", "http://sport.stylus.com.ua/ru/products/skiing/index.html", false));
        listSki.add(new Shop(2011, R.drawable.icon_shlem, "Shlem", "http://shlem.com.ua/zimniy-sport/lizhi", false));
        listSki.add(new Shop(2012, R.drawable.icon_universal, "A-Sport", "http://a-sport.in.ua/", false));
        listSki.add(new Shop(2013, R.drawable.icon_skaut, "Skaut", "http://skaut.com.ua/market/zima/lyzhi", false));
        listSki.add(new Shop(2014, R.drawable.icon_gorgany, "Gorgany", "http://ru.gorgany.com/begovye-lyzhi", false));
        listSki.add(new Shop(2015, R.drawable.icon_sportek, "Sportek", "http://sportek.ua/shop/category/zimnie-vidy-sporta/lyzhi", false));
        listSki.add(new Shop(2016, R.drawable.icon_veloviva, "Veloviva", "http://veloviva.com.ua/catalog/mountain-skiing/", false));
        listSki.add(new Shop(2017, R.drawable.icon_ekip_sport, "Ekip Sport", "http://ekip-sport.com.ua/category/gornye_lyzhi/", false));
        listSki.add(new Shop(2018, R.drawable.icon_fishersports, "Fischersports", "http://www.fischersports.com.ua/catalogue/cat/gornie-lizhi-fischer/", false));
        listSki.add(new Shop(2019, R.drawable.icon_skirental, "Skirental", "http://skirental.kiev.ua/shop", false));
        listSki.add(new Shop(2021, R.drawable.icon_keeperstore, "Keeperstore", "http://www.keeperstore.com.ua/catalog/gornye_lyzhi_dlya_frirayda/", false));
        listSki.add(new Shop(2022, R.drawable.icon_gofree, "Gofree", "http://www.gofree.com.ua/category/struktura-magazina/gornye-lyzhi", false));
        listSki.add(new Shop(2023, R.drawable.icon_lavina, "Lavina", "http://www.lavina.com.ua/", false));
        listSki.add(new Shop(2024, R.drawable.icon_groosha, "Groosha", "http://groosha.ua/catalog/lyzhi/", false));
        listSki.add(new Shop(2025, R.drawable.icon_protest, "Protest", "http://protest.ua/twin-tip-skis", false));
        listSki.add(new Shop(2026, R.drawable.icon_freestyle, "Freestyle", "http://www.freestyle.org.ua/", false));
        listSki.add(new Shop(2027, R.drawable.icon_kingsize, "Kingsize", "http://www.kingsize.com.ua/", false));
        listSki.add(new Shop(2028, R.drawable.icon_8000, "8000", "http://www.8000.com.ua/", false));
        listSki.add(new Shop(2029, R.drawable.icon_alpsport, "Alpsport", "http://alpsport.kiev.ua/", false));
        //listSki.add(new Shop(224, R.drawable.icon_profirider, "Profi Rider", "http://profirider.com.ua/shop/category/gornye-lyzhi", false));
        //listSki.add(new Shop(224, R.drawable.icon_sport_co, "Sport Continent", "http://sport-co.com.ua/catalog6/", false));

        return listSki;
    }

    private ArrayList<Shop> getListSnowBoard() {
        ArrayList<Shop> listSnowBoard = new ArrayList<>();

        listSnowBoard.add(new Shop(3001, R.drawable.icon_extrim_style, "Екстрем Стайл", "http://extremstyle.ua/", false));
        listSnowBoard.add(new Shop(3002, R.drawable.icon_svoboda, "Svoboda", "http://snowboard.kiev.ua/shop/", false));
        listSnowBoard.add(new Shop(3003, R.drawable.icon_drive_sport, "Драйв Спорт", "http://ru.drive-sport.com.ua/", false));
        listSnowBoard.add(new Shop(3004, R.drawable.icon_veloplaneta, "Велопланета", "http://veloplaneta.com.ua/catalog/zimnie-tovary/", false));
        listSnowBoard.add(new Shop(3005, R.drawable.icon_lavina, "Лавіна", "http://www.lavina.com.ua", false));
        listSnowBoard.add(new Shop(3006, R.drawable.icon_boardshop, "Boardshop", "http://boardshop.com.ua/", false));
        listSnowBoard.add(new Shop(3007, R.drawable.icon_shift, "Shift", "http://shift.kiev.ua/", false));
        listSnowBoard.add(new Shop(3008, R.drawable.icon_shlem, "Shlem", "http://shlem.com.ua/zimniy-sport/snoubordi", false));
        listSnowBoard.add(new Shop(3009, R.drawable.icon_boardshop, "Board Club", "http://www.board-club.com.ua/", false));
        //listSnowBoard.add(new Shop(310, R.drawable.icon_playsport, "Playsport", "http://www.playsport.com.ua/snoubordy/", false));
        listSnowBoard.add(new Shop(3011, R.drawable.icon_universal, "Ист Сервис", "http://shop.ist.ua/", false));
        listSnowBoard.add(new Shop(3012, R.drawable.icon_extreme_stock, "Extreme Stock", "http://www.extreme-stock.com/33-bu-snoubordy", false));
        listSnowBoard.add(new Shop(3013, R.drawable.icon_x_zone, "X-Zone", "http://www.x-zone.com.ua/", false));
        listSnowBoard.add(new Shop(3014, R.drawable.icon_kingsize, "Kingsize", "http://www.kingsize.com.ua/", false));
        listSnowBoard.add(new Shop(3015, R.drawable.icon_sportzone, "Sportzone", "http://sportzone.com.ua/snoubord", false));
        listSnowBoard.add(new Shop(3025, R.drawable.icon_snow_boarding, "Snow-boarding", "http://www.snow-boarding.com.ua/", false));
        listSnowBoard.add(new Shop(3016, R.drawable.icon_universal, "X-board", "http://x-board.com.ua/index.php?cat=2", false));
        listSnowBoard.add(new Shop(3017, R.drawable.icon_keeperstore, "Keeperstore", "http://www.keeperstore.com.ua/catalog/snoubord/", false));
        listSnowBoard.add(new Shop(3018, R.drawable.icon_gorgany, "Gorgany", "http://www.gorgany.com/snoubordyng", false));
        listSnowBoard.add(new Shop(3019, R.drawable.icon_kant, "Kant", "http://kant.ua/snowboads-snariagenie/", false));
        listSnowBoard.add(new Shop(3020, R.drawable.icon_ekip_sport, "Ekip sport", "http://ekip-sport.com.ua/category/snoubordy_2/", false));
        listSnowBoard.add(new Shop(3021, R.drawable.icon_northwall, "NorthWall", "http://northwall.com.ua/", false));
        listSnowBoard.add(new Shop(3022, R.drawable.icon_freestyle, "Freestyle", "http://www.freestyle.org.ua/", false));
        listSnowBoard.add(new Shop(3023, R.drawable.icon_jamstore, "Jamstore", "http://www.jamstore.com.ua/", false));
        listSnowBoard.add(new Shop(3024, R.drawable.icon_snow_shop, "Snow-shop", "http://snow-shop.com.ua/", false));
        listSnowBoard.add(new Shop(3025, R.drawable.icon_8000, "8000", "http://www.8000.com.ua/", false));
        listSnowBoard.add(new Shop(3026, R.drawable.icon_protoca, "Protoca", "http://www.sportsite.com.ua/", false));
        listSnowBoard.add(new Shop(2027, R.drawable.icon_protest, "Protest", "http://protest.ua/snowboards", false));

        return listSnowBoard;
    }

    private ArrayList<Shop> getListAllShops() {
        ArrayList<Shop> listAllShops = new ArrayList<>();
        listAllShops.addAll(getListBike());
        listAllShops.addAll(getListMountain());
        listAllShops.addAll(getListSki());
        listAllShops.addAll(getListSnowBoard());

        return listAllShops;
    }
}
