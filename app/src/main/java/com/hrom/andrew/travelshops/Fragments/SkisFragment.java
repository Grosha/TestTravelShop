package com.hrom.andrew.travelshops.Fragments;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SimpleAdapter;

import com.hrom.andrew.travelshops.MainActivity;
import com.hrom.andrew.travelshops.R;
import com.hrom.andrew.travelshops.ShopDB.FavoriteShop;
import com.hrom.andrew.travelshops.ShopDB.SkisShop;
import com.hrom.andrew.travelshops.TrashActivity.CustomAdapter;
import com.hrom.andrew.travelshops.TrashActivity.MyTag;
import com.hrom.andrew.travelshops.TrashActivity.MyWebClent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SkisFragment extends ListFragment {
    public final static String TAG = MyTag.TAG_SKIS;
    private SkisShop skisShop = new SkisShop();
    private FavoriteShop favoriteShop;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        favoriteShop = new FavoriteShop(activity);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        List<HashMap<String, String>> listSkiShop = new ArrayList<>();

        ((MainActivity) getActivity()).setLastFragmentTag(this.getClass().toString());

        for (int i = 0; i < skisShop.getListShops().size(); i++) {
            HashMap<String, String> hm = new HashMap<>();

            hm.put("img", Integer.toString(skisShop.getIconShops().get(i)));
            hm.put("txt", skisShop.getListShops().get(i));
            if (favoriteShop.getListShops().contains(skisShop.getListShops().get(i))) {
                hm.put("imgMy", Integer.toString(R.drawable.ic_group_work_black_18dp));
            } else {
                hm.put("imgMy", Integer.toString(R.drawable.ic_control_point_black_24dp));
            }
            listSkiShop.add(hm);
        }

        /*String[] from = {"img", "txt"};
        int[] to = {R.id.imgForList, R.id.textForSnowboard};

        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), listBikeShop, R.layout.list_for_snowboard, from, to);
        setListAdapter(adapter);*/
        CustomAdapter customAdapter = new CustomAdapter(getActivity().getBaseContext(), R.layout.list_single, listSkiShop);
        setListAdapter(customAdapter);

        view.setBackgroundResource(R.drawable.background_skis);
    }

    /*@Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        *//*Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(skisShop.getLinkShop(position)));
        startActivity(intent);*//*

        //відкриття сайте через свій веб в фрагменті
        WebViewFragment fragment = new WebViewFragment();
        Bundle bundle = new Bundle();
        bundle.putString(MyTag.WEB, skisShop.getLinkShop(position));
        fragment.setArguments(bundle);
        getFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }*/

    @Override
    public void onResume() {
        super.onResume();
        if (getActivity() != null) {
            getActivity().setTitle("Ski");
        }
    }
}
