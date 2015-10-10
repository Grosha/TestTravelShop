package com.hrom.andrew.travelshops.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.hrom.andrew.travelshops.R;
import com.hrom.andrew.travelshops.ShopDB.FavoriteShop;
import com.hrom.andrew.travelshops.ShopDB.MountainShop;
import com.hrom.andrew.travelshops.TrashActivity.StringVariables;

public class MountainFragment extends CategoryFragment {
    public final static String TAG = StringVariables.TAG_MOUNTAIN;
    private MountainShop mountainShop = new MountainShop();
    private FavoriteShop favoriteShop;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        favoriteShop = new FavoriteShop(activity);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createListShop(view, mountainShop, favoriteShop, R.drawable.background_mountain, R.layout.list_single);

        /*List<HashMap<String, String>> listMountainShop = new ArrayList<>();

        ((MainActivity) getActivity()).setLastFragmentTag(this.getClass().toString());

        for (int i = 0; i < mountainShop.getListShops().size(); i++) {
            HashMap<String, String> hm = new HashMap<>();

            hm.put("img", Integer.toString(mountainShop.getIconShops().get(i)));
            hm.put("txt", mountainShop.getListShops().get(i));
            //hm.put("imgMy", Integer.toString(R.drawable.ic_control_point_black_24dp));
            if (favoriteShop.getListShops().contains(mountainShop.getListShops().get(i))) {
                hm.put("imgMy", Integer.toString(R.drawable.ic_group_work_black_18dp));
            } else {
                hm.put("imgMy", Integer.toString(R.drawable.ic_control_point_black_24dp));
            }
            listMountainShop.add(hm);
        }

        *//*String[] from = {"img", "txt", "imgMy"};
        int[] to = {R.id.imgForList, R.id.textForList, R.id.imgForMyList};

        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), listMountainShop, R.layout.list_single, from, to);
        setListAdapter(adapter);*//*

        CustomAdapter customAdapter = new CustomAdapter(getActivity().getBaseContext(), R.layout.list_single, listMountainShop);
        setListAdapter(customAdapter);

        view.setBackgroundResource(R.drawable.background_mountain);*/
    }

    /*@Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(mountainShop.getLinkShop(position)));
        startActivity(intent);
    }*/

    @Override
    public void onResume() {
        super.onResume();
        if (getActivity() != null) {
            getActivity().setTitle("Mountain");
        }
    }
}
