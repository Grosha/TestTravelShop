package com.hrom.andrew.travelshops.costumAdapterListItem;

import android.widget.CheckBox;

public class ObjectListItem {
    private int iconShop;
    private String nameShop;
    private Boolean favoriteShop;

    public ObjectListItem(int iconShop, String nameShop, Boolean favoriteShop) {
        this.iconShop = iconShop;
        this.nameShop = nameShop;
        this.favoriteShop = favoriteShop;
    }

    public Boolean getFavoriteShop() {

        return favoriteShop;
    }

    public int getIconShop() {
        return iconShop;
    }

    public String getNameShop() {
        return nameShop;
    }

    public void setFavoriteShop(boolean favoriteShop) {
        this.favoriteShop = favoriteShop;
        //real save
    }
}
