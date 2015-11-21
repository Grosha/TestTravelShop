package com.hrom.andrew.travelshops.NewDrawer;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hrom.andrew.travelshops.MainActivity;
import com.hrom.andrew.travelshops.R;

import java.util.ArrayList;
import java.util.List;

public class ListViewAdapter extends ArrayAdapter<CategoryShops> {

    private MainActivity activity;
    private ArrayList<CategoryShops> categoryShops;

    public ListViewAdapter(MainActivity activity, int resource, ArrayList<CategoryShops> objects) {
        super(activity, resource, objects);
        this.activity = activity;
        this.categoryShops = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.drawer_list, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.icon.setImageResource(getItem(position).getImageId());
        holder.name.setText(getItem(position).getCategoryName());
        holder.linearLayout.setBackgroundColor(convertView.getResources().getColor(getItem(position).getColorId()));

        convertView.setOnClickListener(onClickListener(position));

        return convertView;
    }


    private class ViewHolder {
        private ImageView icon;
        private TextView name;
        private LinearLayout linearLayout;

        public ViewHolder(View v) {
            icon = (ImageView) v.findViewById(R.id.drawer_category_icon);
            name = (TextView) v.findViewById(R.id.drawer_category_name);
            linearLayout = (LinearLayout) v.findViewById(R.id.colorDrawerIcon);
        }
    }

    private View.OnClickListener onClickListener(final int position) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                activity.updateMainLayout(getItem(position));
                activity.showInterstitial(position);
            }
        };
    }
}
