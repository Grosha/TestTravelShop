package com.hrom.andrew.travelshops.ShopDB;

import android.widget.ImageView;
import android.widget.TextView;

public class Shop {
    private Integer iconShop;
    private String nameShop;
    private String url;

    public String getNameShop() {
        return nameShop;
    }

    public void setNameShop(String nameShop) {
        this.nameShop = nameShop;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getIconShop() {

        return iconShop;
    }

    public void setIconShop(Integer iconShop) {
        this.iconShop = iconShop;
    }
}
