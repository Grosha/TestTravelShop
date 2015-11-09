package com.hrom.andrew.travelshops.trash;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.hrom.andrew.travelshops.R;

public class CustomInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {
    private final View myContentsView;

    public CustomInfoWindowAdapter(Context context) {
        myContentsView = LayoutInflater.from(context).inflate(R.layout.custom_infowindow, null);

    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        return null;
    }
}
