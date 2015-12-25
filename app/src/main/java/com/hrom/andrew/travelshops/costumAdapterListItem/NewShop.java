package com.hrom.andrew.travelshops.costumAdapterListItem;

import com.google.android.gms.maps.model.LatLng;

public class NewShop {
    private int id;
    private int iconShop;
    private String nameShop;
    private String urlShop;
    private boolean favoriteShop;
    private LatLng coordinateCity;
    private LatLng coordinateShop;

    public NewShop(int id, int iconShop, String nameShop, String urlShop, boolean favoriteShop) {
        this.id = id;
        this.iconShop = iconShop;
        this.nameShop = nameShop;
        this.urlShop = urlShop;
        this.favoriteShop = favoriteShop;
    }

    public void setIconShop(int iconShop) {
        this.iconShop = iconShop;
    }

    public void setFavoriteShop(boolean favoriteShop) {
        this.favoriteShop = favoriteShop;
    }

    public int getId() {
        return id;
    }

    public int getIconShop() {
        return iconShop;
    }

    public String getNameShop() {
        return nameShop;
    }

    public String getUrlShop() {
        return urlShop;
    }

    public boolean getFavoriteShop() {
        return favoriteShop;
    }

    public LatLng getCoordinateCity() {
        return coordinateCity;
    }

    public LatLng getCoordinateShop() {
        return coordinateShop;
    }
}
