package com.hrom.andrew.travelshops.customAdapterDrawer;

public class ObjectCategoryShops {
    private int imageId;
    private int colorId;
    private String categoryName;

    public ObjectCategoryShops(int imageId, String categoryName, int colorId) {
        this.imageId = imageId;
        this.categoryName = categoryName;
        this.colorId = colorId;

    }

    public String getCategoryName() {
        return categoryName;
    }

    public int getImageId() {
        return imageId;
    }

    public int getColorId() {
        return colorId;
    }
}
