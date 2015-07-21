package com.hrom.andrew.travelshops.Fragments;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;

import com.hrom.andrew.travelshops.R;
import com.hrom.andrew.travelshops.ShopDatas.SnowboardShop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SnowboardFragment extends ListFragment {
    public final static String TAG = "Bike";
    private SnowboardShop snowboardShop = new SnowboardShop();

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        List<HashMap<String, String>> listBikeShop = new ArrayList<>();

        for (int i = 0; i < snowboardShop.getListShops().size(); i++) {
            HashMap<String, String> hm = new HashMap<>();

            hm.put("img", Integer.toString(snowboardShop.getIconShops().get(i)));
            hm.put("txt", snowboardShop.getListShops().get(i));
            listBikeShop.add(hm);
        }

        String[] from = {"img", "txt"};
        int[] to = {R.id.imgForList, R.id.textForSnowboard};

        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), listBikeShop, R.layout.list_for_snowboard, from, to);
        setListAdapter(adapter);

        view.setBackgroundResource(R.drawable.background_snowboard_2);
    }
}
