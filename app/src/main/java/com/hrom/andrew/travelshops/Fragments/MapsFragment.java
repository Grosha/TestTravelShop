package com.hrom.andrew.travelshops.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.hrom.andrew.travelshops.DBCoordinates.CityCoordinate;
import com.hrom.andrew.travelshops.DBCoordinates.ShopCoordinate;
import com.hrom.andrew.travelshops.R;
import com.hrom.andrew.travelshops.ShopDB.BikeShop;
import com.hrom.andrew.travelshops.TrashActivity.MyTag;

import java.util.Collection;

public class MapsFragment extends Fragment {
    private GoogleMap googleMap;
    private SupportMapFragment mapFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_maps, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mapFragment = SupportMapFragment.newInstance();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.add(R.id.map, mapFragment).commit();
    }

    @Override
    public void onResume() {
        super.onResume();
        ShopCoordinate shop = new ShopCoordinate();
        BikeShop bike = new BikeShop();
        Log.d(MyTag.TEST, "TEST");
        Log.d(MyTag.TEST, String.valueOf(getFragmentManager().findFragmentByTag(MountainFragment.TAG)));
        Fragment fragment = getFragmentManager().findFragmentById(R.id.container);
        Log.d(MyTag.TEST, String.valueOf(MountainFragment.TAG));
        Log.d(MyTag.TEST, String.valueOf(fragment.getClass().getName()));
        Log.d(MyTag.TEST, String.valueOf(getFragmentManager().findFragmentByTag(MyTag.TAG_SKIS)));
        Log.d(MyTag.TEST, String.valueOf(getFragmentManager().findFragmentByTag(MyTag.TAG_BIKE)));
        Log.d(MyTag.TEST, String.valueOf(getFragmentManager().findFragmentByTag(MyTag.TAG_SNOWBOARD)));

        if (getFragmentManager().findFragmentByTag(MyTag.TAG_MOUNTAIN) != null) {
            Log.d(MyTag.TEST, MyTag.TAG_MOUNTAIN);
        } else if (getFragmentManager().findFragmentByTag(MyTag.TAG_SKIS) != null) {
            Log.d(MyTag.TEST, MyTag.TAG_SKIS);
        } else if (getFragmentManager().findFragmentByTag(MyTag.TAG_SNOWBOARD) != null) {
            Log.d(MyTag.TEST, MyTag.TAG_SNOWBOARD);
        } else if (getFragmentManager().findFragmentByTag(MyTag.TAG_BIKE) != null) {
            Log.d(MyTag.TEST, MyTag.TAG_BIKE);
        }


        if (googleMap == null) {
            googleMap = mapFragment.getMap();
            Marker city = googleMap.addMarker(new MarkerOptions().position(CityCoordinate.KYEV)
                    .title("KYEV"));
            for (int i = 0; i < bike.getListShops().size(); i++) {
                Collection<LatLng> colecLng = shop.getCoordinate(bike.getListShops().get(i));

                Log.d(MyTag.NAMEFRAGMENT, String.valueOf(bike.getListShops().get(i)));
                Log.d(MyTag.NAMEFRAGMENT, String.valueOf(colecLng));

                if (shop.getCoordinate(bike.getListShops().get(i)) == null) {
                    //if (i != bike.getListShops().size() - 1) {
                    continue;
                    //} else break;
                } else {
                    for (LatLng latLng : colecLng) {
                        Marker shopMarker = googleMap.addMarker(
                                new MarkerOptions()
                                        .position(latLng)
                                        .title(bike.getListShops().get(i))
                                        .snippet("Kiel is cool")
                                        .icon(BitmapDescriptorFactory
                                                .fromResource(bike.getIconShops().get(i))));
                    }
                }

            }
        }

        googleMap.setMyLocationEnabled(true);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(CityCoordinate.KYEV, 13));
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);
    }
}
