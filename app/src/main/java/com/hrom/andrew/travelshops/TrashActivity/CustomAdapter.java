package com.hrom.andrew.travelshops.TrashActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hrom.andrew.travelshops.Fragments.WebViewFragment;
import com.hrom.andrew.travelshops.R;
import com.hrom.andrew.travelshops.ShopDB.BikeShop;
import com.hrom.andrew.travelshops.ShopDB.FavoriteShop;
import com.hrom.andrew.travelshops.ShopDB.MountainShop;
import com.hrom.andrew.travelshops.ShopDB.Shop;
import com.hrom.andrew.travelshops.ShopDB.SkisShop;
import com.hrom.andrew.travelshops.ShopDB.SnowboardShop;
import com.hrom.andrew.travelshops.ShopDB.SportShop;

import java.util.HashMap;
import java.util.List;

public class CustomAdapter extends ArrayAdapter {
    private List object;

    private ImageView imgIcon;
    private TextView nameShop;
    private ImageView imgPlus;
    private BikeShop bikeShop = new BikeShop();
    private SportShop sportShop;
    private HashMap<String, String> hash;
    private List<String> items;

    public CustomAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
        this.object = objects;

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
            sportShop = new FavoriteShop(context);
        }
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final View view = LayoutInflater.from(getContext()).inflate(R.layout.list_single, null);
        hash = (HashMap<String, String>) object.get(position);

        imgIcon = (ImageView) view.findViewById(R.id.imgForList);
        imgIcon.setImageResource(Integer.parseInt(hash.get("img")));

        nameShop = (TextView) view.findViewById(R.id.textForList);
        nameShop.setText(hash.get("txt"));

        imgPlus = (ImageView) view.findViewById(R.id.imgForMyList);
        imgPlus.setImageResource(Integer.parseInt(hash.get("imgMy")));

        imgIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(MyTag.TEST, "1");
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(bikeShop.getLinkShop(position)));
                view.getContext().startActivity(intent);

                /*WebViewFragment fragment = new WebViewFragment();
                Bundle bundle = new Bundle();
                bundle.putString(MyTag.WEB, sportShop.getLinkShop(position));
                fragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();*/
            }
        });

        nameShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(MyTag.TEST, "2");
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(bikeShop.getLinkShop(position)));
                view.getContext().startActivity(intent);
            }
        });

        imgPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(MyTag.TEST, "3");
                Shop shop = new Shop();

                shop.setIconShop(sportShop.getIconShops().get(position));
                shop.setNameShop(sportShop.getListShops().get(position));
                shop.setUrl(sportShop.getLinkShop((position)));

                String item = new Gson().toJson(shop);
                Log.d(MyTag.TEST, item);


                if (PrefUtil.getValueList(getContext()).contains(item)) {
                    PrefUtil.remove(getContext(), item);
                    imgPlus = (ImageView) view.findViewById(R.id.imgForMyList);
                    imgPlus.setImageResource(R.drawable.ic_control_point_black_24dp);
                } else {
                    PrefUtil.save(getContext(), item);
                    imgPlus = (ImageView) view.findViewById(R.id.imgForMyList);
                    imgPlus.setImageResource(R.drawable.ic_group_work_black_18dp);
                }

                v.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //Toast.makeText(getContext(), PrefUtil.getValue(getContext()), Toast.LENGTH_SHORT).show();
                        Toast.makeText(getContext(), PrefUtil.getValueList(getContext()).toString() +
                                " " + PrefUtil.getValueList(getContext()).size(), Toast.LENGTH_SHORT).show();
                    }
                }, 1000);
            }
        });

        return view;
    }

    public void swapItems(List<String> items) {
        this.items = items;
        notifyDataSetChanged();
    }

}
