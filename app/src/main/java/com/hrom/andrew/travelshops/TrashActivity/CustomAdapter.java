package com.hrom.andrew.travelshops.TrashActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hrom.andrew.travelshops.R;
import com.hrom.andrew.travelshops.ShopDB.BikeShop;

import java.util.HashMap;
import java.util.List;

public class CustomAdapter extends ArrayAdapter {
    private List object;

    private ImageView imgIcon;
    private TextView nameShop;
    private ImageView imgPlus;
    private BikeShop bikeShop = new BikeShop();

    public CustomAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
        this.object = objects;

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final View view = LayoutInflater.from(getContext()).inflate(R.layout.list_single, null);
        HashMap<String, String> hash = (HashMap<String, String>) object.get(position);

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
                PrefUtil.save(getContext(), "BIKE");

                v.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getContext(), PrefUtil.getValue(getContext()), Toast.LENGTH_SHORT).show();
                    }
                }, 1000);
            }
        });

        return view;
    }
}
