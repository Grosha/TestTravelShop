package com.hrom.andrew.travelshops.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.hrom.andrew.travelshops.R;
import com.hrom.andrew.travelshops.ShopDB.FavoriteShop;
import com.hrom.andrew.travelshops.trash.StringVariables;

public class FavoriteListFragment extends CategoryFragment {
    public final static String TAG = StringVariables.TAG_FAVORITE_LIST;
    private FavoriteShop favoriteShop;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        favoriteShop = new FavoriteShop(activity);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createListShop(view, favoriteShop, favoriteShop, R.drawable.background_bike_2, R.layout.list_single);

        /*List<HashMap<String, String>> listFavoriteShops = new ArrayList<>();
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
        }*/
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
