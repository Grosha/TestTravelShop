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
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hrom.andrew.travelshops.Fragments.EmptyListFragment;
import com.hrom.andrew.travelshops.MainActivity;
import com.hrom.andrew.travelshops.R;
import com.hrom.andrew.travelshops.ShopDB.DataFactory;
import com.hrom.andrew.travelshops.ShopDB.NewFavoriteFactory;
import com.hrom.andrew.travelshops.ShopDB.Shop;
import com.hrom.andrew.travelshops.google_analytics.AnalyticsEvent;
import com.hrom.andrew.travelshops.trash.MyApplication;
import com.hrom.andrew.travelshops.trash.MyBitMap;
import com.hrom.andrew.travelshops.trash.OnPlusButtonClickListenner;
import com.hrom.andrew.travelshops.trash.PrefUtil;
import com.hrom.andrew.travelshops.trash.RetainedFragment;
import com.hrom.andrew.travelshops.trash.StringVariables;
import com.hrom.andrew.travelshops.trash.Type;

import java.util.ArrayList;
import java.util.List;

public class NewItemListViewAdapter extends ArrayAdapter<NewShop> {
    private OnPlusButtonClickListenner listenner;
    private ArrayList<NewShop> listItems;
    private DataFactory dataFactory = new DataFactory();
    private NewFavoriteFactory favoriteFactory;

    public NewItemListViewAdapter(Context context, int resource, List<NewShop> objects) {
        super(context, resource, objects);
        favoriteFactory = new NewFavoriteFactory(context);
        //if (listItems != null) {
            if (RetainedFragment.getClassName().contains(StringVariables.TAG_BIKE)) {
                listItems = dataFactory.getListShop(Type.Bike);
            } else if (RetainedFragment.getClassName().contains(StringVariables.TAG_MOUNTAIN)) {
                listItems = dataFactory.getListShop(Type.Mountain);
            } else if (RetainedFragment.getClassName().contains(StringVariables.TAG_SKIS)) {
                listItems = dataFactory.getListShop(Type.Ski);
            } else if (RetainedFragment.getClassName().contains(StringVariables.TAG_SNOWBOARD)) {
                listItems = dataFactory.getListShop(Type.Snowboard);
            } else if (RetainedFragment.getClassName().contains(StringVariables.TAG_FAVORITE_LIST)) {
                listItems = favoriteFactory.getListFavorite();
            }
        //}
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
                    listenner.onPlusClick(listItems.get(position).getUrlShop());
                    MyApplication.get().sendEvent(
                            AnalyticsEvent.SHOP_CATEGORY,
                            AnalyticsEvent.SHOP_ACTION,
                            AnalyticsEvent.SHOP_ICON_LABEL);
                }
            }
        });

        holder.favoriteShop.setChecked(getItem(position).getFavoriteShop());
        holder.favoriteShop.setTag(position);
        holder.favoriteShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = (Integer) v.getTag();
                boolean checked = ((CompoundButton) v).isChecked();
                getItem(pos).setFavoriteShop(checked);
                // real save
                String item = new Gson().toJson(getItem(position).getId());

                if (checked) {
                    Log.d(StringVariables.TEST, "save");
                    PrefUtil.save(getContext(), item);
                    Log.d(StringVariables.TEST, "after save");
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

                v.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //Toast.makeText(getContext(), PrefUtil.getValue(getContext()), Toast.LENGTH_SHORT).show();
                        Toast.makeText(getContext(), /*PrefUtil.getValueList(getContext()).toString() +*/
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
                    listenner.onPlusClick(listItems.get(position).getUrlShop());
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

    public void setOnPlusClickListenner(OnPlusButtonClickListenner listenner) {
        this.listenner = listenner;
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
