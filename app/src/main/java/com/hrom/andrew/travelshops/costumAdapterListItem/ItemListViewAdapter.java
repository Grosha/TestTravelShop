package com.hrom.andrew.travelshops.costumAdapterListItem;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import android.widget.Toast;

import com.google.gson.Gson;
import com.hrom.andrew.travelshops.MainActivity;
import com.hrom.andrew.travelshops.R;
import com.hrom.andrew.travelshops.ShopDB.Shop;
import com.hrom.andrew.travelshops.customAdapterDrawer.ObjectCategoryShops;
import com.hrom.andrew.travelshops.ShopDB.BikeShop;
import com.hrom.andrew.travelshops.ShopDB.FavoriteShop;
import com.hrom.andrew.travelshops.ShopDB.MountainShop;
import com.hrom.andrew.travelshops.ShopDB.SkisShop;
import com.hrom.andrew.travelshops.ShopDB.SnowboardShop;
import com.hrom.andrew.travelshops.ShopDB.SportShop;
import com.hrom.andrew.travelshops.google_analytics.AnalyticsEvent;
import com.hrom.andrew.travelshops.trash.MyApplication;
import com.hrom.andrew.travelshops.trash.MyBitMap;
import com.hrom.andrew.travelshops.trash.OnPlusButtonClickListenner;
import com.hrom.andrew.travelshops.trash.PrefUtil;
import com.hrom.andrew.travelshops.trash.RetainedFragment;
import com.hrom.andrew.travelshops.trash.StringVariables;

import java.util.ArrayList;

public class ItemListViewAdapter extends ArrayAdapter<ObjectListItem> {


    private SportShop sportShop;
    FavoriteShop f;
    private OnPlusButtonClickListenner listenner;

    public ItemListViewAdapter(Context activity, int resource, ArrayList<ObjectListItem> objects) {
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
        f = new FavoriteShop(activity);
    }

    public void setOnPlusClickListenner(OnPlusButtonClickListenner listenner) {
        this.listenner = listenner;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.new_item_list, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Bitmap bitmapFon = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.white_fon);
        Bitmap bitmapIconShop = BitmapFactory.decodeResource(getContext().getResources(), getItem(position).getIconShop());
        holder.icon.setImageBitmap(MyBitMap.getBitmapForCategory(bitmapFon, bitmapIconShop));
        //holder.icon.setImageResource(getItem(position).getIconShop());
        holder.icon.setTag(position);
        holder.icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = (Integer) v.getTag();
                getItem(pos);

                if (listenner != null) {
                    listenner.onPlusClick(sportShop.getLinkShop(position));
                    MyApplication.get().sendEvent(
                            AnalyticsEvent.SHOP_CATEGORY,
                            AnalyticsEvent.SHOP_ACTION,
                            AnalyticsEvent.SHOP_ICON_LABEL);
                }
            }
        });

        holder.favoriteShop.setChecked(getItem(position).getFavoriteShop());
        holder.favoriteShop.setTag(position);
        holder.favoriteShop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                int pos = (Integer) buttonView.getTag();
                getItem(pos).setFavoriteShop(isChecked);
                // real save
                Log.d(StringVariables.TEST, String.valueOf(f.getListShops().size()));

                Shop shop = new Shop();

                shop.setIconShop(sportShop.getIconShops().get(position));
                shop.setNameShop(sportShop.getListShops().get(position));
                shop.setUrl(sportShop.getLinkShop((position)));

                String item = new Gson().toJson(shop);

                if (isChecked) {
                    Log.d(StringVariables.TEST, "save");
                    PrefUtil.save(getContext(), item);
                    MyApplication.get().sendEvent(
                            AnalyticsEvent.SHOP_CATEGORY,
                            AnalyticsEvent.SHOP_ACTION,
                            AnalyticsEvent.SHOP_ADD_TO_FAVORITE_LABEL);

                } else {
                    Log.d(StringVariables.TEST, "remove");
                    PrefUtil.remove(getContext(), item);
                    MyApplication.get().sendEvent(
                            AnalyticsEvent.SHOP_CATEGORY,
                            AnalyticsEvent.SHOP_ACTION,
                            AnalyticsEvent.SHOP_DELETE_FROM_FAVORITE_LABEL);
                }

                buttonView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //Toast.makeText(getContext(), PrefUtil.getValue(getContext()), Toast.LENGTH_SHORT).show();
                        Toast.makeText(getContext(), PrefUtil.getValueList(getContext()).toString() +
                                " " + PrefUtil.getValueList(getContext()).size(), Toast.LENGTH_SHORT).show();
                    }
                }, 1000);
            }
        });


        holder.name.setText(getItem(position).getNameShop());
        holder.name.setTag(position);
        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = (Integer) v.getTag();
                getItem(pos);

                if (listenner != null) {
                    listenner.onPlusClick(sportShop.getLinkShop(position));
                    MyApplication.get().sendEvent(
                            AnalyticsEvent.SHOP_CATEGORY,
                            AnalyticsEvent.SHOP_ACTION,
                            AnalyticsEvent.SHOP_NAME_LABEL);
                }
            }
        });

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
                ((MainActivity) getContext()).showInterstitial(position);
            }
        };
    }
}
