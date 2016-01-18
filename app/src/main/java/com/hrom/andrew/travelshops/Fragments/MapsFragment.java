package com.hrom.andrew.travelshops.Fragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import com.hrom.andrew.travelshops.MainActivity;
import com.hrom.andrew.travelshops.R;
import com.hrom.andrew.travelshops.ShopDB.DataFactory;
import com.hrom.andrew.travelshops.ShopDB.FavoriteFactory;
import com.hrom.andrew.travelshops.costumAdapterListItem.Shop;
import com.hrom.andrew.travelshops.google_analytics.AnalyticsEvent;
import com.hrom.andrew.travelshops.trash.CustomInfoWindowAdapter;
import com.hrom.andrew.travelshops.trash.MyApplication;
import com.hrom.andrew.travelshops.trash.MyBitMap;
import com.hrom.andrew.travelshops.trash.StringVariables;
import com.hrom.andrew.travelshops.trash.RetainedFragment;
import com.hrom.andrew.travelshops.trash.Type;

import java.util.ArrayList;
import java.util.Collection;

public class MapsFragment extends Fragment {
    private SupportMapFragment mapFragment;
    private ProgressBar progressBar;
    private GoogleMap mGoogleMap;
    private Marker marker;
    private Bitmap location = null;
    private DataFactory dataFactory = new DataFactory();
    private ArrayList<Shop> listItems;
    private FavoriteFactory favoriteFactory;
    private int pixelRation;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_maps, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (RetainedFragment.getClassName().contains(StringVariables.TAG_BIKE)) {
            location = BitmapFactory.decodeResource(getResources(), R.drawable.ic_map_4);
            Log.d(StringVariables.TEST, "bike");
            listItems = dataFactory.getListShop(Type.Bike);
            //sportShop = new BikeShop();
            MyApplication.get().sendEvent(
                    AnalyticsEvent.MAP_CATEGORY,
                    AnalyticsEvent.MAP_OPEN_ACTION,
                    AnalyticsEvent.MAP_LABEL_BIKE);
        } else if (RetainedFragment.getClassName().contains(StringVariables.TAG_MOUNTAIN)) {
            location = BitmapFactory.decodeResource(getResources(), R.drawable.ic_map_1);
            Log.d(StringVariables.TEST, "montain");
            listItems = dataFactory.getListShop(Type.Mountain);
            MyApplication.get().sendEvent(
                    AnalyticsEvent.MAP_CATEGORY,
                    AnalyticsEvent.MAP_OPEN_ACTION,
                    AnalyticsEvent.MAP_LABEL_MOUNTAIN);
        } else if (RetainedFragment.getClassName().contains(StringVariables.TAG_SKIS)) {
            location = BitmapFactory.decodeResource(getResources(), R.drawable.ic_map_2);
            Log.d(StringVariables.TEST, "ski");
            listItems = dataFactory.getListShop(Type.Ski);
            MyApplication.get().sendEvent(
                    AnalyticsEvent.MAP_CATEGORY,
                    AnalyticsEvent.MAP_OPEN_ACTION,
                    AnalyticsEvent.MAP_LABEL_SKI);
        } else if (RetainedFragment.getClassName().contains(StringVariables.TAG_SNOWBOARD)) {
            location = BitmapFactory.decodeResource(getResources(), R.drawable.ic_map_3);
            Log.d(StringVariables.TEST, "snow");
            listItems = dataFactory.getListShop(Type.Snowboard);
            MyApplication.get().sendEvent(
                    AnalyticsEvent.MAP_CATEGORY,
                    AnalyticsEvent.MAP_OPEN_ACTION,
                    AnalyticsEvent.MAP_LABEL_SNOWBOARD);
        } else if (RetainedFragment.getClassName().contains(StringVariables.TAG_FAVORITE_LIST)) {
            location = BitmapFactory.decodeResource(getResources(), R.drawable.ic_map_6);
            Log.d(StringVariables.TEST, "favorite");
            favoriteFactory = new FavoriteFactory(getActivity());
            listItems = favoriteFactory.getListFavorite();
            MyApplication.get().sendEvent(
                    AnalyticsEvent.MAP_CATEGORY,
                    AnalyticsEvent.MAP_OPEN_ACTION,
                    AnalyticsEvent.MAP_LABEL_FAVORITE);
        }
        pixelRation = ((MainActivity) getActivity()).getDpi();
        Log.d(StringVariables.TEST, String.valueOf(pixelRation) + " pixel");

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

                try {
                    if (marker != null) {
                        marker.remove();
                        myNewMarker = mGoogleMap.addMarker(new MarkerOptions()
                                .position(target)
                                .title("ME")
                                .snippet("")
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_flag_test1)));
                    }
                    marker = mGoogleMap.addMarker(new MarkerOptions()
                            .position(target)
                            .title("ME")
                            .snippet("")
                            .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_flag_test1)));
                    /*.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));*/
                    if (myNewMarker != null) {
                        myNewMarker.remove();
                    }
                } catch (IllegalArgumentException e) {

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

                Bitmap icon = null;
                Bitmap bitmapFon = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.white_fon);

                Marker city = googleMap.addMarker(new MarkerOptions().position(CityCoordinate.KYEV)
                        .title("KYEV"));

                for (int i = 0; i < listItems.size(); i++) {
                    Collection<LatLng> colecLng = shop.getCoordinate(listItems.get(i).getNameShop());

                    Log.d(StringVariables.NAMEFRAGMENT, String.valueOf(listItems.get(i).getNameShop()));
                    Log.d(StringVariables.NAMEFRAGMENT, String.valueOf(colecLng));

                    if (shop.getCoordinate(listItems.get(i).getNameShop()) == null) {
                        //if (i != bike.getListShops().size() - 1) {
                        continue;
                        //} else break;
                    } else {
                        for (LatLng latLng : colecLng) {

                            icon = BitmapFactory.decodeResource(getResources(), listItems.get(i).getIconShop());
                            icon = MyBitMap.getBitmapForMap(bitmapFon, icon);

                            Marker shopMarker = googleMap.addMarker(
                                    new MarkerOptions()
                                            .position(latLng)
                                            .title(listItems.get(i).getNameShop())
                                            .snippet(getUrl(i))
                                            .icon(BitmapDescriptorFactory
                                                    .fromBitmap(MyBitMap.getBitmapForMap2(location, icon, getPixelRation1(pixelRation)))));
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
                    Log.d(StringVariables.TEST, marker.getTitle());
                    Log.d(StringVariables.TEST, marker.getSnippet());
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + marker.getSnippet()));
                    startActivity(intent);
                    MyApplication.get().sendEvent(
                            AnalyticsEvent.MAP_CATEGORY,
                            AnalyticsEvent.MAP_SHOP_ACTION,
                            marker.getSnippet());
                }
            });
            googleMap.setInfoWindowAdapter(new CustomInfoWindowAdapter(getContext()));
        }
    };

    private String getUrl(int i) {
        String site = listItems.get(i).getUrlShop().substring(7, listItems.get(i).getUrlShop().length() - 1);
        if (site.indexOf("/") > 0) {
            return site.substring(0, site.indexOf("/"));
        } else return site.substring(0, site.length());
    }

    private float getPixelRation(int pixel) {
        float k = 0;
        if (pixel <= 160) k = 1;
        else if (pixel <= 240) k = 1.5f;
        else if (pixel <= 320) k = 2.0f;
        else if (pixel <= 640) k = 3.f;
        else if (pixel > 640) k = 4.0f;
        Log.d(StringVariables.TEST, String.valueOf("k = " + k));
        return k;
    }

    private float[] getPixelRation1(int pixel) {
        float coordinate[] = new float[2];
        if (pixel <= 160) {
            coordinate[0] = 18.0f;
            coordinate[1] = 16.0f;
        } else if (pixel <= 240) {
            coordinate[0] = 14.0f;
            coordinate[1] = 12.0f;
        } else if (pixel <= 320) {
            coordinate[0] = 18.0f;
            coordinate[1] = 16.0f;
        } else if (pixel <= 480) {
            coordinate[0] = 27.0f;
            coordinate[1] = 24.0f;
        } else if (pixel <= 640) {
            coordinate[0] = 41.0f;
            coordinate[1] = 40.0f;
        } else {
            coordinate[0] = 27.0f;
            coordinate[1] = 24.0f;
        }
        Log.d(StringVariables.TEST, String.valueOf("x = " + coordinate[0] + "; y = " + coordinate[1]));
        return coordinate;
    }
}
