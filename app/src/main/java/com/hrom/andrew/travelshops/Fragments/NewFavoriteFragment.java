package com.hrom.andrew.travelshops.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.hrom.andrew.travelshops.MainActivity;
import com.hrom.andrew.travelshops.R;
import com.hrom.andrew.travelshops.ShopDB.NewFavoriteFactory;
import com.hrom.andrew.travelshops.trash.StringVariables;

public class NewFavoriteFragment extends NewCategoryFragment{
    public final static String TAG = StringVariables.TAG_FAVORITE_LIST;
    private NewFavoriteFactory favoriteFactory;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        favoriteFactory = new NewFavoriteFactory(activity);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createListShop(view, R.drawable.f_image,favoriteFactory);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (getActivity() != null) {
            ((MainActivity)getActivity()).getSupportActionBar().setTitle("Favorite shops");
        }
    }
}
