package com.hrom.andrew.travelshops.custom_drawer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hrom.andrew.travelshops.R;
import com.mikepenz.materialdrawer.model.BasePrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

public class CustomItem implements IDrawerItem<CustomItem> {
    @Override
    public Object getTag() {
        return null;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public boolean isSelected() {
        return false;
    }

    @Override
    public CustomItem withSetSelected(boolean selected) {
        return null;
    }

    @Override
    public boolean isSelectable() {
        return false;
    }

    @Override
    public CustomItem withSelectable(boolean selectable) {
        return null;
    }

    @Override
    public String getType() {
        return "PRIMARY_ITEM";
    }

    @Override
    public int getLayoutRes() {
        return R.layout.drawer_list;
    }

    @Override
    public View generateView(Context ctx) {
        return null;
    }

    @Override
    public View generateView(Context ctx, ViewGroup parent) {
        return null;
    }

    @Override
    public RecyclerView.ViewHolder getViewHolder(ViewGroup parent) {
        return null;
    }

    @Override
    public void bindView(RecyclerView.ViewHolder holder) {

    }

    @Override
    public boolean equals(Integer id) {
        return false;
    }

    @Override
    public CustomItem withIdentifier(int identifier) {
        return null;
    }

    @Override
    public int getIdentifier() {
        return 0;
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
