package com.hrom.andrew.travelshops.ShopDB;

import com.google.android.gms.maps.model.LatLng;

import java.util.HashMap;
import java.util.Map;

public class CoordinateShop {/*
    private String nameShop;

    public CoordinateShop(String nameShop) {
        this.nameShop = nameShop;
    }*/

    public LatLng getCoordinate(String tag){
        Map<String, LatLng> lngMap = new HashMap<>();
        lngMap.put("Bizon",new LatLng(50.457181, 30.475242));
        lngMap.put("Gofree",new LatLng(50.463088, 30.505062));
        lngMap.put("Ордана",new LatLng(50.631794, 30.422878));
        lngMap.put("Мультіспорт",new LatLng(50.441537, 30.480193));
        lngMap.put("Playsport",new LatLng(50.518692, 30.462809));
        lngMap.put("Bikemotive",new LatLng(50.385961, 30.507014));
        lngMap.put("Траверс",new LatLng(50.458732, 30.628498));
        lngMap.put("Lavina",new LatLng(50.432317, 30.515730));
        lngMap.put("Lavina",new LatLng(50.466817, 30.515748));
        lngMap.put("Екстрем Стайл",new LatLng(50.462457, 30.498950));
        lngMap.put("Екстрем Стайл",new LatLng(50.406095, 30.613166));
        lngMap.put("Board Club",new LatLng(50.460879, 30.523703));
        lngMap.put("Велотим",new LatLng(50.471513, 30.612778));
        lngMap.put("Атлантида",new LatLng(50.467145, 30.511701));
        lngMap.put("Groosha",new LatLng(50.429071, 30.356024));
        lngMap.put("Velohit",new LatLng(50.495964, 30.459198));
        lngMap.put("Бескід",new LatLng(50.430766, 30.398878));
        lngMap.put("Svoboda",new LatLng(50.423885, 30.497164));
        lngMap.put("Kant",new LatLng(50.419260, 30.473568));
        lngMap.put("Драйв Спорт",new LatLng(50.469490, 30.443531));
        lngMap.put("Драйв Спорт",new LatLng(50.411319, 30.530179));
        lngMap.put("Skimarket",new LatLng(50.460821, 30.484599));
        lngMap.put("Veloviva",new LatLng(50.480078, 30.595237));
        lngMap.put("Номад",new LatLng(50.417040, 30.541335));
        lngMap.put("Ист Сервис",new LatLng(50.427629, 30.510453));
        lngMap.put("Gorgany",new LatLng(50.394643, 30.636576));
        lngMap.put("Подорож",new LatLng(50.488781, 30.496300));
        lngMap.put("Подорож",new LatLng(50.488781, 30.496300));
        lngMap.put("Velomoto",new LatLng(50.496974, 30.606994));
        lngMap.put("Velomoto",new LatLng(50.404392, 30.623163));
        lngMap.put("Sport Stylus",new LatLng(50.457288, 30.487548));
        lngMap.put("Shlem",new LatLng(50.450248, 30.497961));
        lngMap.put("Ekip Sport",new LatLng(50.448420, 30.590765));
        lngMap.put("Boomerang",new LatLng(50.447407, 30.514459));
        lngMap.put("Orbeabikes",new LatLng(50.431902, 30.545349));
        lngMap.put("Boomerang",new LatLng(50.447407, 30.514459));


        return lngMap.get(tag);
    }

}