package com.hrom.andrew.travelshops.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.hrom.andrew.travelshops.R;
import com.hrom.andrew.travelshops.ShopDB.MountainShop;
import com.hrom.andrew.travelshops.TrashActivity.MyTag;
import com.hrom.andrew.travelshops.TrashActivity.RetainedFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MountainFragment extends ListFragment {
    public final static String TAG = MyTag.TAG_MOUNTAIN;
    private MountainShop mountainShop = new MountainShop();

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
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

        view.setBackgroundResource(R.drawable.background_mountain);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(mountainShop.getLinkShop(position)));
        startActivity(intent);
    }
}
