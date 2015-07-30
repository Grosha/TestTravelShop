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


        return lngMap.get(tag);
    }

}
