package com.hrom.andrew.travelshops.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.hrom.andrew.travelshops.R;
import com.hrom.andrew.travelshops.ShopDB.BikeShop;
import com.hrom.andrew.travelshops.ShopDB.FavoriteShop;
import com.hrom.andrew.travelshops.TrashActivity.MyTag;

public class BikeFragment extends CategoryFragment {
    public final static String TAG = MyTag.TAG_BIKE;
    private BikeShop bikeShop = new BikeShop();
    private FavoriteShop favoriteShop;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        favoriteShop = new FavoriteShop(activity);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createListShop(view, bikeShop, favoriteShop, R.drawable.background_bike_2, R.layout.list_single);

        //getListView().addFooterView(createListFooter());
    }

    /*@Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(bikeShop.getLinkShop(position)));
        startActivity(intent);
    }*/

    @Override
    public void onResume() {
        super.onResume();
        if (getActivity() != null) {
            getActivity().setTitle("Bike");
        }
    }

    /*private View createListFooter() {
        View res = new View(getActivity());
        res.setLayoutParams(new AbsListView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, getActivity().getResources().getDimensionPixelOffset(R.dimen.list_item_height)));
        return res;
    }*/

}

