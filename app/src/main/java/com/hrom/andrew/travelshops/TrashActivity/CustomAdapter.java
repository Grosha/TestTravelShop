package com.hrom.andrew.travelshops.TrashActivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hrom.andrew.travelshops.R;

import java.util.List;

public class CustomAdapter extends ArrayAdapter {
    private ImageView imgIcon;
    private TextView nameShop;
    private ImageView imgPlus;

    public CustomAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return super.getView(position, convertView, parent);

        View view = LayoutInflater.from(getContext()).inflate(R.layout.list_single, null);

        imgIcon = (ImageView) view.findViewById(R.id.imgForList);
        nameShop = (TextView) view.findViewById(R.id.textForList);
        imgPlus = (ImageView) view.findViewById(R.id.imgForMyList);

        imgIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        nameShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        imgPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return view;
    }
}
