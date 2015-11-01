package com.hrom.andrew.travelshops.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;

import com.hrom.andrew.travelshops.MainActivity;
import com.hrom.andrew.travelshops.R;
import com.hrom.andrew.travelshops.ShopDB.SportShop;
import com.hrom.andrew.travelshops.trash.CustomAdapter;
import com.hrom.andrew.travelshops.trash.StringVariables;
import com.hrom.andrew.travelshops.trash.OnPlusButtonClickListenner;
import com.hrom.andrew.travelshops.trash.PrefUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CategoryFragment extends ListFragment {
    private List<HashMap<String, String>> listShop;
    private int countInterstitial = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        countInterstitial = PrefUtil.getCountInterstitial(getActivity().getBaseContext(), StringVariables.PRES_KEY_INTERSTITIAL_WEB);
    }

    public View createListShop(View view, SportShop shop, SportShop shopFav, int background, int list) {

        listShop = new ArrayList<>();

        ((MainActivity) getActivity()).setLastFragmentTag(this.getClass().toString());
        Log.d(StringVariables.TEST, this.getClass().toString());

        for (int i = 0; i < shop.getListShops().size(); i++) {
            HashMap<String, String> hm = new HashMap<>();

            hm.put("img", Integer.toString(shop.getIconShops().get(i)));
            hm.put("txt", shop.getListShops().get(i));
            if (shopFav.getListShops().contains(shop.getListShops().get(i))) {
                hm.put("imgMy", Integer.toString(R.drawable.ic_group_work_black_18dp));
            } else {
                hm.put("imgMy", Integer.toString(R.drawable.ic_control_point_black_24dp));
            }
            listShop.add(hm);
        }

        getListView().addFooterView(createListFooter());

        CustomAdapter customAdapter = new CustomAdapter(getActivity().getBaseContext(), list, listShop);
        setListAdapter(customAdapter);
        customAdapter.setOnPlusClickListenner(new OnPlusButtonClickListenner() {
            @Override
            public void onPlusClick(String url) {
                Intent intent;
                PrefUtil.save(getActivity().getBaseContext(), ++countInterstitial, StringVariables.PRES_KEY_INTERSTITIAL_WEB);
                Log.d(StringVariables.TEST, String.valueOf(PrefUtil.getCountInterstitial(getActivity().getBaseContext(), StringVariables.PRES_KEY_INTERSTITIAL_WEB)));

                if (PrefUtil.getCountInterstitial(getActivity().getBaseContext(), StringVariables.PRES_KEY_INTERSTITIAL_WEB) % 5 == 0) {
                    ((MainActivity) getActivity()).showInterstitial();
                    countInterstitial = 0;
                    PrefUtil.save(getActivity().getBaseContext(), countInterstitial, StringVariables.PRES_KEY_INTERSTITIAL_WEB);
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent);
                } else {
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent);
                }
            }
        });

        if (shop.equals(shopFav)) {
            if (shopFav.getListShops().size() == 0) {
                view.setBackgroundResource(R.drawable.background_bike_1);
            } else {
                view.setBackgroundResource(background);
            }
        } else {
            view.setBackgroundResource(background);
        }


        return view;
    }

    public View createListFooter() {
        View res = new View(getActivity());
        res.setLayoutParams(new AbsListView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, getActivity().getResources().getDimensionPixelOffset(R.dimen.list_item_height)));
        return res;
    }
}
