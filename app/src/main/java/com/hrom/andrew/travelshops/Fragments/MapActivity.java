package com.hrom.andrew.travelshops.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.hrom.andrew.travelshops.R;
import com.hrom.andrew.travelshops.ShopDB.BikeShop;
import com.hrom.andrew.travelshops.ShopDB.CoordinateShop;

public class MapActivity extends Activity {
    private static final String NAMEFRAGMENT = "FRAGMENT";
    static final LatLng KYEV = new LatLng(50.447968, 30.507971);
    static final LatLng KIEL = new LatLng(50.451692, 30.383927);
    private GoogleMap map;
    private CoordinateShop shop = new CoordinateShop();
    private BikeShop bike = new BikeShop();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_maps);
        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
                .getMap();

        if (map != null) {
            Marker hamburg = map.addMarker(new MarkerOptions().position(KYEV)
                    .title("KYEV"));
            for (int i = 0; i < bike.getListShops().size(); i++) {
                Log.d(NAMEFRAGMENT, String.valueOf(shop.getCoordinate(bike.getListShops().get(i))));
                Toast.makeText(this, String.valueOf(shop.getCoordinate(bike.getListShops().get(i))), Toast.LENGTH_LONG);
                if (shop.getCoordinate(bike.getListShops().get(i))==null) {
                    continue;
                } else {
                    Marker kiel = map.addMarker(
                            new MarkerOptions()
                                    .position(shop.getCoordinate(bike.getListShops().get(i)))
                                    .title(bike.getListShops().get(i))
                                    .snippet("Kiel is cool")
                                    .icon(BitmapDescriptorFactory
                                            .fromResource(bike.getIconShops().get(i))));
                }
            }

            /*Marker hamburg = map.addMarker(new MarkerOptions().position(KYEV)
                    .title("Hamburg"));
            Marker kiel = map.addMarker(new MarkerOptions()
                    .position(KIEL)
                    .title("Kiel")
                    .snippet("Kiel is cool")
                    .icon(BitmapDescriptorFactory
                            .fromResource(R.drawable.ic_group_work_black_18dp)));*/
        }

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(KYEV, 15));
        map.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);
    }
}
