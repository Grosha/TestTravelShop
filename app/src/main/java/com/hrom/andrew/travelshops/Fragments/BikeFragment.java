package com.hrom.andrew.travelshops.Fragments;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;

import com.hrom.andrew.travelshops.R;
import com.hrom.andrew.travelshops.ShopDatas.BikeShop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BikeFragment extends ListFragment {
    public final static String TAG = "Bike";
    private BikeShop bikeShop = new BikeShop();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        List<HashMap<String, String>> listBikeShop = new ArrayList<>();

        for (int i = 0; i < bikeShop.getListShops().size(); i++) {
            HashMap<String, String> hm = new HashMap<>();

            hm.put("img", Integer.toString(bikeShop.getIconShops().get(i)));
            hm.put("txt", bikeShop.getListShops().get(i));
            listBikeShop.add(hm);
        }

        String[] from = {"img", "txt"};
        int[] to = {R.id.imgForList, R.id.textForList};

        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), listBikeShop, R.layout.list_single, from, to);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
