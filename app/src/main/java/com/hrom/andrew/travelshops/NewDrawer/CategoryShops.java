package com.hrom.andrew.travelshops.NewDrawer;

public class CategoryShops {
    private int imageId;
    private String categoryName;

    public CategoryShops(int imageId, String categoryName) {
        this.imageId = imageId;
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public int getImageId() {
        return imageId;
    }
}
