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
        listBike.add(new Shop(5, R.drawable.icon_specialized, "Specialized", "http://www.specialized.com.ua/", false));
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
        listBike.add(new Shop(19, R.drawable.icon_universal, "Велотим", "http://www.veloteam.com.ua/", false));
        listBike.add(new Shop(20, R.drawable.icon_megadrive, "Megadrive", "http://megadrive.kiev.ua/", false));
        listBike.add(new Shop(21, R.drawable.icon_freestyle, "Freestyle", "http://www.freestyle.org.ua/velosport/", false));

        return listBike;
    }

    private ArrayList<Shop> getListMountain() {
        ArrayList<Shop> listMountain = new ArrayList<>();

        listMountain.add(new Shop(101, R.drawable.icon_azimut, "Азімут", "http://www.azimut.com.ua/", false));
        listMountain.add(new Shop(102, R.drawable.icon_universal, "Волоцюга", "http://volocuga.com/", false));
        listMountain.add(new Shop(103, R.drawable.icon_atlantida, "Атлантида", "http://atlantida.net.ua/", false));
        listMountain.add(new Shop(104, R.drawable.icon_el_cap, "Ель-капітан", "http://el-cap.kiev.ua/", false));
        listMountain.add(new Shop(105, R.drawable.icon_ex, "Команда Екс", "http://ex.com.ua/", false));
        listMountain.add(new Shop(106, R.drawable.icon_extrim_style, "Екстрем Стайл", "http://extremstyle.ua/", false));
        listMountain.add(new Shop(107, R.drawable.icon_x_zone, "X-Zone", "http://www.x-zone.com.ua/", false));
        listMountain.add(new Shop(108, R.drawable.icon_gorgany, "Gorgany", "http://www.gorgany.com/", false));
        listMountain.add(new Shop(109, R.drawable.icon_adrenalin, "Adrenalin", "http://www.adrenalin.kiev.ua/", false));
        listMountain.add(new Shop(110, R.drawable.icon_podoroj, "Подорож", "http://www.podoroj.com.ua/", false));
        listMountain.add(new Shop(111, R.drawable.icon_nomad, "Номад", "http://nomad.com.ua/", false));
        listMountain.add(new Shop(112, R.drawable.icon_ordana, "Ордана", "http://ordana.com/", false));
        listMountain.add(new Shop(113, R.drawable.icon_universal, "Skimarket", "http://skimarket.com.ua/", false));
        listMountain.add(new Shop(114, R.drawable.icon_bizon, "Bizon", "http://bizon.com.ua/", false));
        listMountain.add(new Shop(115, R.drawable.icon_expert_centre, "Expert", "http://www.expert-centre.com.ua/", false));
        listMountain.add(new Shop(116, R.drawable.icon_multisport, "Мультіспорт", "http://multisport.com.ua/", false));
        listMountain.add(new Shop(117, R.drawable.icon_traverse, "Траверс", "http://traverse.com.ua/uk/", false));
        listMountain.add(new Shop(118, R.drawable.icon_beskid, "Бескід", "http://beskid.com.ua/", false));
        listMountain.add(new Shop(119, R.drawable.icon_commandor, "Командор", "http://www.commandor.com.ua/", false));
        listMountain.add(new Shop(120, R.drawable.icon_gofree, "GoFree", "http://www.gofree.com.ua/", false));
        listMountain.add(new Shop(121, R.drawable.icon_drive_sport, "Драйв Спорт", "http://ru.drive-sport.com.ua/", false));
        listMountain.add(new Shop(122, R.drawable.icon_capricorn, "Каприкорн", "http://www.capricorn.com.ua/", false));
        listMountain.add(new Shop(123, R.drawable.icon_terraincognita, "Terra Incognita", "http://terraincognita.ua/ukr/", false));
        listMountain.add(new Shop(124, R.drawable.icon_northwall, "NorthWall", "http://northwall.com.ua/", false));
        listMountain.add(new Shop(125, R.drawable.icon_vershyna, "Вершина", "http://vershyna.com.ua/", false));
        listMountain.add(new Shop(126, R.drawable.icon_freestyle, "Freestyle", "http://www.freestyle.org.ua/", false));
        listMountain.add(new Shop(127, R.drawable.icon_turkul, "Turkul", "http://turkul.net/", false));
        listMountain.add(new Shop(128, R.drawable.icon_campsite, "Campsite", "http://campsite.com.ua/", false));
        listMountain.add(new Shop(129, R.drawable.icon_8000, "8000", "http://www.8000.com.ua/", false));

        return listMountain;
    }

    private ArrayList<Shop> getListSki() {
        ArrayList<Shop> listSki = new ArrayList<>();

        listSki.add(new Shop(201, R.drawable.icon_kant, "Kant", "http://kant.ua/category-lyzhi/", false));
        listSki.add(new Shop(202, R.drawable.icon_universal, "Modena Sport", "http://msport.com.ua/ski/", false));
        listSki.add(new Shop(203, R.drawable.icon_extrim_style, "Екстрем Стайл", "http://extremstyle.ua/lyzhi-gornye-catalogs/", false));
        listSki.add(new Shop(204, R.drawable.icon_sportzone, "Sportzone", "http://sportzone.com.ua/lyizhi", false));
        listSki.add(new Shop(205, R.drawable.icon_x_zone, "X-Zone", "http://www.x-zone.com.ua/winter.html", false));
        listSki.add(new Shop(206, R.drawable.icon_adrenalin, "Adrenalin", "http://www.adrenalin.kiev.ua/", false));
        listSki.add(new Shop(207, R.drawable.icon_seeski, "SeeSki", "http://seeski.visit.ua/", false));
        listSki.add(new Shop(208, R.drawable.icon_playsport, "Playsport", "http://www.playsport.com.ua/lyzhi/", false));
        listSki.add(new Shop(209, R.drawable.icon_skimag, "Skimag", "http://skimag.com.ua/gornye-lyzhi/", false));
        listSki.add(new Shop(210, R.drawable.icon_sport_stylus, "Sport Stylus", "http://sport.stylus.com.ua/ru/products/skiing/index.html", false));
        listSki.add(new Shop(211, R.drawable.icon_shlem, "Shlem", "http://shlem.com.ua/zimniy-sport/lizhi", false));
        listSki.add(new Shop(212, R.drawable.icon_universal, "A-Sport", "http://a-sport.in.ua/", false));
        listSki.add(new Shop(213, R.drawable.icon_skaut, "Skaut", "http://skaut.com.ua/market/zima/lyzhi", false));
        listSki.add(new Shop(214, R.drawable.icon_gorgany, "Gorgany", "http://ru.gorgany.com/begovye-lyzhi", false));
        listSki.add(new Shop(215, R.drawable.icon_sportek, "Sportek", "http://sportek.ua/shop/category/zimnie-vidy-sporta/lyzhi", false));
        listSki.add(new Shop(216, R.drawable.icon_veloviva, "Veloviva", "http://veloviva.com.ua/catalog/mountain-skiing/", false));
        listSki.add(new Shop(217, R.drawable.icon_ekip_sport, "Ekip Sport", "http://ekip-sport.com.ua/category/gornye_lyzhi/", false));
        listSki.add(new Shop(218, R.drawable.icon_fishersports, "Fischersports", "http://www.fischersports.com.ua/catalogue/cat/gornie-lizhi-fischer/", false));
        listSki.add(new Shop(219, R.drawable.icon_skirental, "Skirental", "http://skirental.kiev.ua/shop", false));
        listSki.add(new Shop(221, R.drawable.icon_keeperstore, "Keeperstore", "http://www.keeperstore.com.ua/catalog/gornye_lyzhi_dlya_frirayda/", false));
        listSki.add(new Shop(222, R.drawable.icon_gofree, "Gofree", "http://www.gofree.com.ua/category/struktura-magazina/gornye-lyzhi", false));
        listSki.add(new Shop(223, R.drawable.icon_lavina, "Lavina", "http://www.lavina.com.ua/lyzhi-s-kreplenijami.html", false));
        listSki.add(new Shop(224, R.drawable.icon_groosha, "Groosha", "http://groosha.ua/catalog/lyzhi/", false));
        listSki.add(new Shop(225, R.drawable.icon_protest, "Protest", "http://protest.ua/twin-tip-background_skis", false));
        listSki.add(new Shop(226, R.drawable.icon_freestyle, "Freestyle", "http://www.freestyle.org.ua/gornye-lyji/", false));
        listSki.add(new Shop(227, R.drawable.icon_kingsize, "Kingsize", "http://www.kingsize.com.ua/", false));
        listSki.add(new Shop(228, R.drawable.icon_8000, "8000", "http://www.8000.com.ua/", false));
        //listSki.add(new Shop(224, R.drawable.icon_profirider, "Profi Rider", "http://profirider.com.ua/shop/category/gornye-lyzhi", false));
        //listSki.add(new Shop(224, R.drawable.icon_sport_co, "Sport Continent", "http://sport-co.com.ua/catalog6/", false));

        return listSki;
    }

    private ArrayList<Shop> getListSnowBoard() {
        ArrayList<Shop> listSnowBoard = new ArrayList<>();

        listSnowBoard.add(new Shop(301, R.drawable.icon_extrim_style, "Екстрем Стайл", "http://extremstyle.ua/doski-catalogs/", false));
        listSnowBoard.add(new Shop(302, R.drawable.icon_svoboda, "Svoboda", "http://snowboard.kiev.ua/shop/", false));
        listSnowBoard.add(new Shop(303, R.drawable.icon_drive_sport, "Драйв Спорт", "http://ru.drive-sport.com.ua/", false));
        listSnowBoard.add(new Shop(304, R.drawable.icon_veloplaneta, "Велопланета", "http://veloplaneta.com.ua/catalog/zimnie-tovary/", false));
        listSnowBoard.add(new Shop(305, R.drawable.icon_lavina, "Лавіна", "http://www.lavina.com.ua/snoubord-2.html", false));
        listSnowBoard.add(new Shop(306, R.drawable.icon_boardshop, "Boardshop", "http://boardshop.com.ua/", false));
        listSnowBoard.add(new Shop(307, R.drawable.icon_boomerang, "Boomerang", "http://boomerang.kiev.ua/snow", false));
        listSnowBoard.add(new Shop(308, R.drawable.icon_shlem, "Shlem", "http://shlem.com.ua/zimniy-sport/snoubordi", false));
        listSnowBoard.add(new Shop(309, R.drawable.icon_boardshop, "Board Club", "http://www.board-club.com.ua/", false));
        listSnowBoard.add(new Shop(310, R.drawable.icon_playsport, "Playsport", "http://www.playsport.com.ua/snoubordy/", false));
        listSnowBoard.add(new Shop(311, R.drawable.icon_universal, "Ист Сервис", "http://shop.ist.ua/", false));
        listSnowBoard.add(new Shop(312, R.drawable.icon_extreme_stock, "Extreme Stock", "http://www.extreme-stock.com/33-bu-snoubordy", false));
        listSnowBoard.add(new Shop(313, R.drawable.icon_x_zone, "X-Zone", "http://www.x-zone.com.ua/winter.html", false));
        listSnowBoard.add(new Shop(314, R.drawable.icon_kingsize, "Kingsize", "http://www.kingsize.com.ua/", false));
        listSnowBoard.add(new Shop(315, R.drawable.icon_sportzone, "Sportzone", "http://sportzone.com.ua/snoubord", false));
        listSnowBoard.add(new Shop(325, R.drawable.icon_snow_boarding, "Snow-boarding", "http://www.snow-boarding.com.ua/", false));
        listSnowBoard.add(new Shop(316, R.drawable.icon_universal, "X-board", "http://x-board.com.ua/index.php?cat=2", false));
        listSnowBoard.add(new Shop(317, R.drawable.icon_keeperstore, "Keeperstore", "http://www.keeperstore.com.ua/catalog/snoubord/", false));
        listSnowBoard.add(new Shop(318, R.drawable.icon_gorgany, "Gorgany", "http://www.gorgany.com/snoubordyng", false));
        listSnowBoard.add(new Shop(319, R.drawable.icon_kant, "Kant", "http://kant.ua/category-snoubordy/snoubordy/", false));
        listSnowBoard.add(new Shop(320, R.drawable.icon_ekip_sport, "Ekip sport", "http://ekip-sport.com.ua/category/snoubordy_2/", false));
        listSnowBoard.add(new Shop(321, R.drawable.icon_northwall, "NorthWall", "http://northwall.com.ua/", false));
        listSnowBoard.add(new Shop(322, R.drawable.icon_freestyle, "Freestyle", "http://www.freestyle.org.ua/snoubord/", false));
        listSnowBoard.add(new Shop(323, R.drawable.icon_jamstore, "Jamstore", "http://www.jamstore.com.ua/", false));
        listSnowBoard.add(new Shop(324, R.drawable.icon_snow_shop, "Snow-shop", "http://snow-shop.com.ua/", false));
        listSnowBoard.add(new Shop(325, R.drawable.icon_8000, "8000", "http://www.8000.com.ua/", false));

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
