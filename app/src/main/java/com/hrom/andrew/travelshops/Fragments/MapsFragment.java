package com.hrom.andrew.travelshops.Fragments;

import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.hrom.andrew.travelshops.DBCoordinates.CityCoordinate;
import com.hrom.andrew.travelshops.DBCoordinates.ShopCoordinate;
import com.hrom.andrew.travelshops.R;
import com.hrom.andrew.travelshops.ShopDB.BikeShop;
import com.hrom.andrew.travelshops.ShopDB.FavoriteShop;
import com.hrom.andrew.travelshops.ShopDB.MountainShop;
import com.hrom.andrew.travelshops.ShopDB.SkisShop;
import com.hrom.andrew.travelshops.ShopDB.SnowboardShop;
import com.hrom.andrew.travelshops.ShopDB.SportShop;
import com.hrom.andrew.travelshops.TrashActivity.AnalyticsEvent;
import com.hrom.andrew.travelshops.TrashActivity.AnalyticsTrackers;
import com.hrom.andrew.travelshops.TrashActivity.MyApplication;
import com.hrom.andrew.travelshops.TrashActivity.StringVariables;
import com.hrom.andrew.travelshops.TrashActivity.RetainedFragment;

import java.util.Collection;

public class MapsFragment extends Fragment {
    private SupportMapFragment mapFragment;
    private ProgressBar progressBar;
    private GoogleMap mGoogleMap;
    private Marker marker;
    private SportShop sportShop;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.layout_maps, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (RetainedFragment.getClassName().contains(StringVariables.TAG_BIKE)) {
            Log.d(StringVariables.TEST, "bike");
            sportShop = new BikeShop();
            MyApplication.get().sendEvent(AnalyticsEvent.MAP_CATEGORY,AnalyticsEvent.MAP_OPEN_ACTION,AnalyticsEvent.MAP_LABEL_BIKE);
        } else if (RetainedFragment.getClassName().contains(StringVariables.TAG_MOUNTAIN)) {
            Log.d(StringVariables.TEST, "montain");
            sportShop = new MountainShop();
            MyApplication.get().sendEvent(AnalyticsEvent.MAP_CATEGORY,AnalyticsEvent.MAP_OPEN_ACTION,AnalyticsEvent.MAP_LABEL_MOUNTAIN);
        } else if (RetainedFragment.getClassName().contains(StringVariables.TAG_SKIS)) {
            Log.d(StringVariables.TEST, "ski");
            sportShop = new SkisShop();
            MyApplication.get().sendEvent(AnalyticsEvent.MAP_CATEGORY,AnalyticsEvent.MAP_OPEN_ACTION,AnalyticsEvent.MAP_LABEL_SKI);
        } else if (RetainedFragment.getClassName().contains(StringVariables.TAG_SNOWBOARD)) {
            Log.d(StringVariables.TEST, "snow");
            sportShop = new SnowboardShop();
            MyApplication.get().sendEvent(AnalyticsEvent.MAP_CATEGORY,AnalyticsEvent.MAP_OPEN_ACTION,AnalyticsEvent.MAP_LABEL_SNOWBOARD);
        } else if (RetainedFragment.getClassName().contains(StringVariables.TAG_FAVORITE_LIST)) {
            Log.d(StringVariables.TEST, "favorite");
            sportShop = new FavoriteShop(getActivity());
            MyApplication.get().sendEvent(AnalyticsEvent.MAP_CATEGORY,AnalyticsEvent.MAP_OPEN_ACTION,AnalyticsEvent.MAP_LABEL_FAVORITE);
        }

        //прогрес бар для мапи
        progressBar = (ProgressBar) getActivity().findViewById(R.id.webProgressBar);
        progressBar.setVisibility(ProgressBar.VISIBLE);

        mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment == null) {

            mapFragment.newInstance();
            getFragmentManager().beginTransaction().replace(R.id.map, mapFragment).commit();
        }
        mapFragment.getMapAsync(onMapReadyCallback);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private GoogleMap.OnMyLocationChangeListener onMyLocationChangeListener = new GoogleMap.OnMyLocationChangeListener() {
        @Override
        public void onMyLocationChange(Location location) {
            Marker myNewMarker = null;
            if (location != null) {
                Log.d(StringVariables.TEST, "LOCATION NOT NULL");
                LatLng target = new LatLng(location.getLatitude(), location.getLongitude());
                if (marker != null) {
                    marker.remove();
                    myNewMarker = mGoogleMap.addMarker(new MarkerOptions()
                            .position(target)
                            .title("ME")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
                }
                marker = mGoogleMap.addMarker(new MarkerOptions()
                        .position(target)
                        .title("ME")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
                if (myNewMarker != null) {
                    myNewMarker.remove();
                }
                /*mGoogleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                    @Override
                    public void onInfoWindowClick(Marker marker) {
                        marker.remove();
                    }
                });*/
            }
        }
    };

   /* //animation bounce
    private GoogleMap.OnMarkerClickListener markerClickListener = new GoogleMap.OnMarkerClickListener() {
        @TargetApi(Build.VERSION_CODES.DONUT)
        @Override
        public boolean onMarkerClick(final Marker marker) {
            final Handler handler = new Handler();

            final long startTime = SystemClock.uptimeMillis();
            final long duration = 2000;

            Projection proj = mGoogleMap.getProjection();
            final LatLng markerLatLng = marker.getPosition();
            Point startPoint = proj.toScreenLocation(markerLatLng);
            startPoint.offset(0, -100);
            final LatLng startLatLng = proj.fromScreenLocation(startPoint);

            final Interpolator interpolator = new BounceInterpolator();

            handler.post(new Runnable() {
                @Override
                public void run() {
                    long elapsed = SystemClock.uptimeMillis() - startTime;
                    float t = interpolator.getInterpolation((float) elapsed / duration);
                    double lng = t * markerLatLng.longitude + (1 - t) * startLatLng.longitude;
                    double lat = t * markerLatLng.latitude + (1 - t) * startLatLng.latitude;
                    marker.setPosition(new LatLng(lat, lng));

                    if (t < 1.0) {
                        // Post again 16ms later.
                        handler.postDelayed(this, 16);
                    }
                }
            });
            return false;
        }
    };*/

    private OnMapReadyCallback onMapReadyCallback = new OnMapReadyCallback() {
        @Override
        public void onMapReady(GoogleMap googleMap) {

            mGoogleMap = googleMap;
            progressBar.setVisibility(ProgressBar.GONE);
            googleMap.setOnMyLocationChangeListener(onMyLocationChangeListener);

            ShopCoordinate shop = new ShopCoordinate();

            Log.d(StringVariables.TEST, "TEST");

            if (googleMap != null) {
                googleMap.setMyLocationEnabled(true);

                Marker city = googleMap.addMarker(new MarkerOptions().position(CityCoordinate.KYEV)
                        .title("KYEV"));

                for (int i = 0; i < sportShop.getListShops().size(); i++) {
                    Collection<LatLng> colecLng = shop.getCoordinate(sportShop.getListShops().get(i));

                    Log.d(StringVariables.NAMEFRAGMENT, String.valueOf(sportShop.getListShops().get(i)));
                    Log.d(StringVariables.NAMEFRAGMENT, String.valueOf(colecLng));

                    if (shop.getCoordinate(sportShop.getListShops().get(i)) == null) {
                        //if (i != bike.getListShops().size() - 1) {
                        continue;
                        //} else break;
                    } else {
                        for (LatLng latLng : colecLng) {
                            Marker shopMarker = googleMap.addMarker(
                                    new MarkerOptions()
                                            .position(latLng)
                                            .title(sportShop.getListShops().get(i))
                                            .snippet(getUrl(i))
                                            .icon(BitmapDescriptorFactory
                                                    .fromResource(sportShop.getIconShops().get(i))));
                        }
                    }

                }
            }


            //googleMap.setOnMarkerClickListener(markerClickListener);
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(CityCoordinate.KYEV, 13));
            googleMap.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);

            googleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                @Override
                public void onInfoWindowClick(Marker marker) {
                    Log.d(StringVariables.TEST, marker.getSnippet());
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + marker.getSnippet()));
                    startActivity(intent);
                    MyApplication.get().sendEvent(AnalyticsEvent.MAP_CATEGORY, AnalyticsEvent.MAP_SHOP_ACTION, marker.getSnippet());
                }
            });
        }
    };

    private String getUrl(int i) {
        return sportShop.getLinkShop(i).substring(7, sportShop.getLinkShop(i).length() - 1);
    }
}
