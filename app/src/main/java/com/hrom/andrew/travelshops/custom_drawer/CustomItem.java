package com.hrom.andrew.travelshops.custom_drawer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hrom.andrew.travelshops.R;
import com.mikepenz.materialdrawer.holder.BadgeStyle;
import com.mikepenz.materialdrawer.holder.StringHolder;
import com.mikepenz.materialdrawer.model.BaseDrawerItem;
import com.mikepenz.materialdrawer.model.BasePrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.ColorfulBadgeable;
import com.mikepenz.materialdrawer.model.utils.ViewHolderFactory;

public class CustomItem extends BasePrimaryDrawerItem<CustomItem> implements ColorfulBadgeable<CustomItem> {

    @Override
    public ViewHolderFactory getFactory() {
        return null;
    }

    @Override
    public CustomItem withBadgeStyle(BadgeStyle badgeStyle) {
        return null;
    }

    @Override
    public BadgeStyle getBadgeStyle() {
        return null;
    }

    @Override
    public CustomItem withBadge(String badge) {
        return null;
    }

    @Override
    public CustomItem withBadge(int badgeRes) {
        return null;
    }

    @Override
    public CustomItem withBadge(StringHolder badgeRes) {
        return null;
    }

    @Override
    public StringHolder getBadge() {
        return null;
    }

    @Override
    public String getType() {
        return null;
    }

    @Override
    public int getLayoutRes() {
        return 0;
    }

    @Override
    public void bindView(RecyclerView.ViewHolder holder) {

    }

    private static class ViewHolder extends RecyclerView.ViewHolder {
        protected View view;
        protected ImageView icon;
        protected TextView name;

        public ViewHolder(View view) {
            super(view);
            this.view = view;
            this.icon = (ImageView) view.findViewById(R.id.drawer_category_icon);
            this.name = (TextView) view.findViewById(R.id.drawer_category_name);
        }
    }


}
