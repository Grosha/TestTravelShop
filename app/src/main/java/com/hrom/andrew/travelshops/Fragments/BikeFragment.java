package com.hrom.andrew.travelshops.Fragments;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.hrom.andrew.travelshops.MainActivity;
import com.hrom.andrew.travelshops.R;
import com.hrom.andrew.travelshops.ShopDB.BikeShop;
import com.hrom.andrew.travelshops.ShopDB.FavoriteShop;
import com.hrom.andrew.travelshops.TrashActivity.CustomAdapter;
import com.hrom.andrew.travelshops.TrashActivity.MyTag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BikeFragment extends CategoryFragment {
    public final static String TAG = MyTag.TAG_BIKE;
    private BikeShop bikeShop = new BikeShop();
    private FavoriteShop favoriteShop;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        favoriteShop = new FavoriteShop(activity);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createListShop(view, bikeShop, favoriteShop, R.drawable.background_bike_2, R.layout.list_single);

        //getListView().addFooterView(createListFooter());
    }

    /*@Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(bikeShop.getLinkShop(position)));
        startActivity(intent);
    }*/

    @Override
    public void onResume() {
        super.onResume();
        if (getActivity() != null) {
            getActivity().setTitle("Bike");
        }
    }

    /*private View createListFooter() {
        View res = new View(getActivity());
        res.setLayoutParams(new AbsListView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, getActivity().getResources().getDimensionPixelOffset(R.dimen.list_item_height)));
        return res;
    }*/

}

