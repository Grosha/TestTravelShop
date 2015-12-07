package com.hrom.andrew.travelshops.costumAdapterListItem;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hrom.andrew.travelshops.MainActivity;
import com.hrom.andrew.travelshops.R;
import com.hrom.andrew.travelshops.customAdapterDrawer.ObjectCategoryShops;
import com.hrom.andrew.travelshops.shopDB.BikeShop;
import com.hrom.andrew.travelshops.shopDB.FavoriteShop;
import com.hrom.andrew.travelshops.shopDB.MountainShop;
import com.hrom.andrew.travelshops.shopDB.SkisShop;
import com.hrom.andrew.travelshops.shopDB.SnowboardShop;
import com.hrom.andrew.travelshops.shopDB.SportShop;
import com.hrom.andrew.travelshops.trash.OnPlusButtonClickListenner;
import com.hrom.andrew.travelshops.trash.RetainedFragment;
import com.hrom.andrew.travelshops.trash.StringVariables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ItemListViewAdapter extends ArrayAdapter<ObjectListItem> {


    private SportShop sportShop;
    private HashMap<String, String> hash;
    private OnPlusButtonClickListenner listenner;
    private MainActivity activity;

    public ItemListViewAdapter(MainActivity activity, int resource, ArrayList<ObjectListItem> objects) {
        super(activity, resource, objects);

        if (RetainedFragment.getClassName().contains(StringVariables.TAG_BIKE)) {
            Log.d(StringVariables.TEST, "bike");
            sportShop = new BikeShop();
        } else if (RetainedFragment.getClassName().contains(StringVariables.TAG_MOUNTAIN)) {
            Log.d(StringVariables.TEST, "montain");
            sportShop = new MountainShop();
        } else if (RetainedFragment.getClassName().contains(StringVariables.TAG_SKIS)) {
            Log.d(StringVariables.TEST, "ski");
            sportShop = new SkisShop();
        } else if (RetainedFragment.getClassName().contains(StringVariables.TAG_SNOWBOARD)) {
            Log.d(StringVariables.TEST, "snow");
            sportShop = new SnowboardShop();
        } else if (RetainedFragment.getClassName().contains(StringVariables.TAG_FAVORITE_LIST)) {
            Log.d(StringVariables.TEST, "favorite");
            sportShop = new FavoriteShop(activity);
        }
    }

    public void setOnPlusClickListenner(OnPlusButtonClickListenner listenner) {
        this.listenner = listenner;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.new_item_list, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.icon.setImageResource(getItem(position).getIconShop());
        holder.icon.setTag(position);
        holder.favoriteShop.setChecked(getItem(position).getFavoriteShop());
        holder.favoriteShop.setTag(position);
        holder.favoriteShop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                int pos = (Integer) buttonView.getTag();
                getItem(pos).setFavoriteShop(isChecked);
                // real save
            }
        });
        holder.icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = (Integer) v.getTag();
                getItem(pos);
            }
        });
        holder.name.setText(getItem(position).getNameShop());

        convertView.setOnClickListener(onClickListener(position));

        return convertView;
    }

    private class ViewHolder {
        private ImageView icon;
        private TextView name;
        private CheckBox favoriteShop;

        public ViewHolder(View v) {
            icon = (ImageView) v.findViewById(R.id.iconShop);
            name = (TextView) v.findViewById(R.id.nameShop);
            favoriteShop = (CheckBox) v.findViewById(R.id.checkBoxFavorite);
        }
    }

    private View.OnClickListener onClickListener(final int position) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.showInterstitial(position);
            }
        };
    }
}
