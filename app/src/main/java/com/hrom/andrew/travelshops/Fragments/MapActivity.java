package com.hrom.andrew.travelshops.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.hrom.andrew.travelshops.DBCoordinates.CityCoordinate;
import com.hrom.andrew.travelshops.R;
import com.hrom.andrew.travelshops.ShopDB.BikeShop;
import com.hrom.andrew.travelshops.DBCoordinates.ShopCoordinate;

import java.util.Collection;

public class MapActivity extends Activity {
    private static final String NAMEFRAGMENT = "FRAGMENT";
    private ShopCoordinate shop = new ShopCoordinate();
    private BikeShop bike = new BikeShop();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_maps);
        GoogleMap map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
                .getMap();

        if (map != null) {
            Marker city = map.addMarker(new MarkerOptions().position(CityCoordinate.KYEV)
                    .title("KYEV"));
            for (int i = 0; i < bike.getListShops().size(); i++) {
                Collection<LatLng> colecLng = shop.getCoordinate(bike.getListShops().get(i));
                Log.d(NAMEFRAGMENT, String.valueOf(bike.getListShops().get(i)));
                Log.d(NAMEFRAGMENT, String.valueOf(shop.getCoordinate(bike.getListShops().get(i))));
                if (shop.getCoordinate(bike.getListShops().get(i)) == null) {
                    continue;
                } else {
                    for (LatLng latLng : colecLng) {
                        Marker shopMarker = map.addMarker(
                                new MarkerOptions()
                                        .position(latLng)
                                        .title(bike.getListShops().get(i))
                                        .snippet("Kiel is cool")
                                        .icon(BitmapDescriptorFactory
                                                .fromResource(bike.getIconShops().get(i))));
                    }
                    /*
                    Marker kiel = map.addMarker(
                            new MarkerOptions()
                                    .position(shop.getCoordinate(bike.getListShops().get(i)))
                                    .title(bike.getListShops().get(i))
                                    .snippet("Kiel is cool")
                                    .icon(BitmapDescriptorFactory
                                            .fromResource(bike.getIconShops().get(i))));
                */
                }
            }
        }

        map.setMyLocationEnabled(true);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(CityCoordinate.KYEV, 15));
        map.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);
    }
}
