package com.hrom.andrew.travelshops.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;

import com.hrom.andrew.travelshops.MainActivity;
import com.hrom.andrew.travelshops.R;
import com.hrom.andrew.travelshops.ShopDB.DataFactory;
import com.hrom.andrew.travelshops.ShopDB.NewFavoriteFactory;
import com.hrom.andrew.travelshops.ShopDB.SportShop;
import com.hrom.andrew.travelshops.costumAdapterListItem.ItemListViewAdapter;
import com.hrom.andrew.travelshops.costumAdapterListItem.NewItemListViewAdapter;
import com.hrom.andrew.travelshops.costumAdapterListItem.NewShop;
import com.hrom.andrew.travelshops.costumAdapterListItem.ObjectListItem;
import com.hrom.andrew.travelshops.trash.OnPlusButtonClickListenner;
import com.hrom.andrew.travelshops.trash.PrefUtil;
import com.hrom.andrew.travelshops.trash.RetainedFragment;
import com.hrom.andrew.travelshops.trash.StringVariables;
import com.hrom.andrew.travelshops.trash.Type;

import java.util.ArrayList;

public class NewCategoryFragment extends ListFragment {
    private int countInterstitial = 0;
    private ArrayList<NewShop> listItems;
    private DataFactory dataFactory;
    private NewFavoriteFactory favoriteFactory;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        countInterstitial = PrefUtil.getCountInterstitial(getActivity().getBaseContext(), StringVariables.PRES_KEY_INTERSTITIAL_WEB);
    }

    public View createListShop(View view,int background) {

        ((MainActivity) getActivity()).setLastFragmentTag(this.getClass().toString());
        Log.d(StringVariables.TEST, this.getClass().toString());

        if (RetainedFragment.getClassName().contains(StringVariables.TAG_BIKE)) {
            listItems = dataFactory.getListShop(Type.Bike);
            view.setBackgroundResource(background);
        } else if (RetainedFragment.getClassName().contains(StringVariables.TAG_MOUNTAIN)) {
            listItems = dataFactory.getListShop(Type.Mountain);
            view.setBackgroundResource(background);
        } else if (RetainedFragment.getClassName().contains(StringVariables.TAG_SKIS)) {
            listItems = dataFactory.getListShop(Type.Ski);
            view.setBackgroundResource(background);
        } else if (RetainedFragment.getClassName().contains(StringVariables.TAG_SNOWBOARD)) {
            listItems = dataFactory.getListShop(Type.Snowboard);
            view.setBackgroundResource(background);
        } else if (RetainedFragment.getClassName().contains(StringVariables.TAG_FAVORITE_LIST)) {
            listItems = favoriteFactory.getListFavorite();
            /*if (shopFav.getListShops().size() == 0) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.container, new EmptyListFragment()).commit();
            } else {
                view.setBackgroundResource(background);
            }*/
        }

        getListView().addFooterView(createListFooter());
        NewItemListViewAdapter newItemListViewAdapter = new NewItemListViewAdapter(getActivity(), R.layout.item_list, listItems);
        setListAdapter(newItemListViewAdapter);
        newItemListViewAdapter.setOnPlusClickListenner(new OnPlusButtonClickListenner() {

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

        return view;
    }

    public View createListFooter() {
        View res = new View(getActivity());
        res.setLayoutParams(new AbsListView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, getActivity().getResources().getDimensionPixelOffset(R.dimen.list_item_height)));
        return res;
    }
}
