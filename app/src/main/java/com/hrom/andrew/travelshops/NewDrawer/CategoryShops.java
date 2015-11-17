package com.hrom.andrew.travelshops.NewDrawer;

public class CategoryShops {
    private int imageId;
    private int colorId;
    private String categoryName;

    public CategoryShops(int imageId, String categoryName, int colorId) {
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
