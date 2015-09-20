package com.hrom.andrew.travelshops.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.hrom.andrew.travelshops.MainActivity;
import com.hrom.andrew.travelshops.R;
import com.hrom.andrew.travelshops.ShopDB.BikeShop;
import com.hrom.andrew.travelshops.TrashActivity.CustomAdapter;
import com.hrom.andrew.travelshops.TrashActivity.MyTag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BikeFragment extends ListFragment {
    public final static String TAG = MyTag.TAG_BIKE;
    private BikeShop bikeShop = new BikeShop();

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        List<HashMap<String, String>> listBikeShop = new ArrayList<>();

        ((MainActivity) getActivity()).setLastFragmentTag(this.getClass().toString());
        Log.d(MyTag.TEST, this.getClass().toString());

        for (int i = 0; i < bikeShop.getListShops().size(); i++) {
            HashMap<String, String> hm = new HashMap<>();

            hm.put("img", Integer.toString(bikeShop.getIconShops().get(i)));
            hm.put("txt", bikeShop.getListShops().get(i));
            hm.put("imgMy", Integer.toString(R.drawable.ic_control_point_black_24dp));
            listBikeShop.add(hm);
        }

        /*String[] from = {"img", "txt", "imgMy"};
        int[] to = {R.id.imgForList, R.id.textForList, R.id.imgForMyList};
*/
        /*SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), listBikeShop, R.layout.list_single, from, to);
        setListAdapter(adapter);*/
        CustomAdapter customAdapter = new CustomAdapter(getActivity().getBaseContext(), R.layout.list_single, listBikeShop);
        setListAdapter(customAdapter);

        view.setBackgroundResource(R.drawable.background_bike_2);
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
}

