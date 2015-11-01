package com.hrom.andrew.travelshops.custom_drawer;

import android.support.v7.widget.RecyclerView;

import com.mikepenz.materialdrawer.holder.ColorHolder;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;

public class CustomSecondaryDrawerItem extends SecondaryDrawerItem {

    private ColorHolder background;

    public CustomSecondaryDrawerItem withBackgroundColor(int backgroundColor) {
        this.background = ColorHolder.fromColor(backgroundColor);
        return this;
    }

    public CustomSecondaryDrawerItem withBackgroundRes(int backgroundRes) {
        this.background = ColorHolder.fromColorRes(backgroundRes);
        return this;
    }

    @Override
    public void bindView(RecyclerView.ViewHolder holder) {
        super.bindView(holder);

        if (background != null) {
            background.applyToBackground(holder.itemView);
        }
    }
}
