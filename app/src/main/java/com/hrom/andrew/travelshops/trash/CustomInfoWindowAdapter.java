package com.hrom.andrew.travelshops.trash;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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

        //ImageView iconShop = (ImageView) myContentsView.findViewById(R.id.icon_info_window);
        TextView shopName = (TextView) myContentsView.findViewById(R.id.name_shop_info_window);
        shopName.setText(marker.getTitle());
        TextView shopSite = (TextView) myContentsView.findViewById(R.id.site_shop_info_window);
        shopSite.setText(marker.getSnippet());

        return myContentsView;
    }
}
