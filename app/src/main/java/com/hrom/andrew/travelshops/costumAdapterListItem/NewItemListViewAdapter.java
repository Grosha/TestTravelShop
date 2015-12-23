package com.hrom.andrew.travelshops.costumAdapterListItem;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

public class NewItemListViewAdapter extends ArrayAdapter<NewShop> {
    public NewItemListViewAdapter(Context context, int resource, List<NewShop> objects) {
        super(context, resource, objects);
    }
}
