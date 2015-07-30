package com.hrom.andrew.travelshops.ShopDataBase;

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

        return lngMap.get(tag);
    }

}
