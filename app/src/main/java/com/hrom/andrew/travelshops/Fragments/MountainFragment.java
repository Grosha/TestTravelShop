package com.hrom.andrew.travelshops.Fragments;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;

import com.hrom.andrew.travelshops.R;
import com.hrom.andrew.travelshops.ShopDatas.MountainShop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MountainFragment extends ListFragment {
    public final static String TAG = "Mountain";
    private MountainShop mountainShop = new MountainShop();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        List<HashMap<String, String>> listMountainShop = new ArrayList<>();

        for (int i = 0; i < mountainShop.getListShops().size(); i++) {
            HashMap<String, String> hm = new HashMap<>();

            hm.put("img", Integer.toString(mountainShop.getIconShops().get(i)));
            hm.put("txt", mountainShop.getListShops().get(i));
            listMountainShop.add(hm);
        }

        String[] from = {"img", "txt"};
        int[] to = {R.id.imgForList, R.id.textForList};

        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), listMountainShop, R.layout.list_single, from, to);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
