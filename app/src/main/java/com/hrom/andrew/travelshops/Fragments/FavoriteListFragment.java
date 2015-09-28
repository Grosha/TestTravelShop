package com.hrom.andrew.travelshops.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;

import com.hrom.andrew.travelshops.MainActivity;
import com.hrom.andrew.travelshops.R;
import com.hrom.andrew.travelshops.ShopDB.FavoriteShop;
import com.hrom.andrew.travelshops.TrashActivity.CustomAdapter;
import com.hrom.andrew.travelshops.TrashActivity.MyTag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FavoriteListFragment extends ListFragment {
    public final static String TAG = MyTag.TAG_FAVORITE_LIST;
    private FavoriteShop favoriteShop;
    private CustomAdapter customAdapter;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        favoriteShop = new FavoriteShop(activity);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<HashMap<String, String>> listFavoriteShops = new ArrayList<>();
        ((MainActivity) getActivity()).setLastFragmentTag(this.getClass().toString());

        for (int i = 0; i < favoriteShop.getListShops().size(); i++) {
            HashMap<String, String> hm = new HashMap<>();

            hm.put("img", Integer.toString(favoriteShop.getIconShops().get(i)));
            hm.put("txt", favoriteShop.getListShops().get(i));
            hm.put("imgMy", Integer.toString(R.drawable.ic_group_work_black_18dp));
            listFavoriteShops.add(hm);
        }

        customAdapter = new CustomAdapter(getActivity().getBaseContext(), R.layout.list_single, listFavoriteShops);
        setListAdapter(customAdapter);

        if (favoriteShop.getListShops().size() == 0) {
            view.setBackgroundResource(R.drawable.background_bike_1);
        } else {
            view.setBackgroundResource(R.drawable.background_bike_2);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (getActivity() != null) {
            getActivity().setTitle("Favorite shops");
        }
        //customAdapter.swapItems(favoriteShop.getListShops());

    }


}
