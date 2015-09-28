package com.hrom.andrew.travelshops.Fragments;

import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;

import com.hrom.andrew.travelshops.MainActivity;
import com.hrom.andrew.travelshops.R;
import com.hrom.andrew.travelshops.ShopDB.BikeShop;
import com.hrom.andrew.travelshops.ShopDB.FavoriteShop;
import com.hrom.andrew.travelshops.ShopDB.MountainShop;
import com.hrom.andrew.travelshops.ShopDB.SkisShop;
import com.hrom.andrew.travelshops.ShopDB.SnowboardShop;
import com.hrom.andrew.travelshops.ShopDB.SportShop;
import com.hrom.andrew.travelshops.TrashActivity.CustomAdapter;
import com.hrom.andrew.travelshops.TrashActivity.MyTag;
import com.hrom.andrew.travelshops.TrashActivity.RetainedFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CategoryFragment extends ListFragment {
    private List<HashMap<String, String>> listShop;
    private SportShop sportShop;


    public View createListShop(View view, SportShop shop, SportShop shopFav, int background, int list) {

        listShop = new ArrayList<>();

        ((MainActivity) getActivity()).setLastFragmentTag(this.getClass().toString());
        Log.d(MyTag.TEST, this.getClass().toString());

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
        CustomAdapter customAdapter = new CustomAdapter(getActivity().getBaseContext(), list, listShop);
        setListAdapter(customAdapter);

        if (getTypeShop().equals(shopFav)) {
            if (shopFav.getListShops().size() == 0) {
                view.setBackgroundResource(R.drawable.background_bike_1);
            } else {
                view.setBackgroundResource(background);
            }
        } else view.setBackgroundResource(background);

        getListView().addFooterView(createListFooter());

        return view;
    }

    public View createListFooter() {
        View res = new View(getActivity());
        res.setLayoutParams(new AbsListView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, getActivity().getResources().getDimensionPixelOffset(R.dimen.list_item_height)));
        return res;
    }

    public SportShop getTypeShop() {
        if (RetainedFragment.getClassName().contains(MyTag.TAG_BIKE)) {
            Log.d(MyTag.TEST, "bike");
            sportShop = new BikeShop();
        } else if (RetainedFragment.getClassName().contains(MyTag.TAG_MOUNTAIN)) {
            Log.d(MyTag.TEST, "montain");
            sportShop = new MountainShop();
        } else if (RetainedFragment.getClassName().contains(MyTag.TAG_SKIS)) {
            Log.d(MyTag.TEST, "ski");
            sportShop = new SkisShop();
        } else if (RetainedFragment.getClassName().contains(MyTag.TAG_SNOWBOARD)) {
            Log.d(MyTag.TEST, "snow");
            sportShop = new SnowboardShop();
        } else if (RetainedFragment.getClassName().contains(MyTag.TAG_FAVORITE_LIST)) {
            Log.d(MyTag.TEST, "favorite");
            sportShop = new FavoriteShop(getActivity());
        }
        return sportShop;
    }
}
