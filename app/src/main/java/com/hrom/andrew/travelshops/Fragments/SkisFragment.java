package com.hrom.andrew.travelshops.Fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.hrom.andrew.travelshops.R;
import com.hrom.andrew.travelshops.ShopDatas.SkisShop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SkisFragment extends ListFragment {
    public final static String TAG = "Ski";
    private SkisShop skisShop = new SkisShop();

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        List<HashMap<String, String>> listBikeShop = new ArrayList<>();

        for (int i = 0; i < skisShop.getListShops().size(); i++) {
            HashMap<String, String> hm = new HashMap<>();

            hm.put("img", Integer.toString(skisShop.getIconShops().get(i)));
            hm.put("txt", skisShop.getListShops().get(i));
            listBikeShop.add(hm);
        }

        String[] from = {"img", "txt"};
        int[] to = {R.id.imgForList, R.id.textForSnowboard};

        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), listBikeShop, R.layout.list_for_snowboard, from, to);
        setListAdapter(adapter);

        view.setBackgroundResource(R.drawable.background_skis);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(skisShop.getLinkShop(position)));
        startActivity(intent);
    }
}
