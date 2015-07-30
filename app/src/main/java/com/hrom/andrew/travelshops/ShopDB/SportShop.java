package com.hrom.andrew.travelshops.ShopDB;

import android.support.v7.app.AppCompatActivity;

import java.util.List;

public abstract class SportShop extends AppCompatActivity {
    public abstract List<String> getListShops();

    public abstract List<Integer> getIconShops();

    public abstract String getLinkShop(int position);
}
