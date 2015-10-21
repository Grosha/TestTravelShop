package com.hrom.andrew.travelshops.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.hrom.andrew.travelshops.R;
import com.hrom.andrew.travelshops.ShopDB.FavoriteShop;
import com.hrom.andrew.travelshops.ShopDB.SnowboardShop;
import com.hrom.andrew.travelshops.TrashActivity.StringVariables;

public class SnowboardFragment extends CategoryFragment {
    public final static String TAG = StringVariables.TAG_SNOWBOARD;
    private SnowboardShop snowboardShop = new SnowboardShop();
    private FavoriteShop favoriteShop;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        favoriteShop = new FavoriteShop(activity);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createListShop(view, snowboardShop, favoriteShop, R.drawable.bgr_bord, R.layout.list_for_snowboard);

        /*List<HashMap<String, String>> listSnowShop = new ArrayList<>();

        ((MainActivity) getActivity()).setLastFragmentTag(this.getClass().toString());

        for (int i = 0; i < snowboardShop.getListShops().size(); i++) {
            HashMap<String, String> hm = new HashMap<>();

            hm.put("img", Integer.toString(snowboardShop.getIconShops().get(i)));
            hm.put("txt", snowboardShop.getListShops().get(i));
            if (favoriteShop.getListShops().contains(snowboardShop.getListShops().get(i))) {
                hm.put("imgMy", Integer.toString(R.drawable.ic_group_work_black_18dp));
            } else {
                hm.put("imgMy", Integer.toString(R.drawable.ic_control_point_black_24dp));
            }
            listSnowShop.add(hm);
        }

        *//*String[] from = {"img", "txt"};
        int[] to = {R.id.imgForList, R.id.textForSnowboard};

        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), listSnowShop, R.layout.list_for_snowboard, from, to);
        setListAdapter(adapter);*//*
        CustomAdapter customAdapter = new CustomAdapter(getActivity().getBaseContext(), R.layout.list_single, listSnowShop);
        setListAdapter(customAdapter);

        view.setBackgroundResource(R.drawable.background_snowboard_2);*/
    }

    /*@Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(snowboardShop.getLinkShop(position)));
        startActivity(intent);
    }*/

    @Override
    public void onResume() {
        super.onResume();
        if (getActivity() != null) {
            getActivity().setTitle("Snowboard");
        }
    }
}
