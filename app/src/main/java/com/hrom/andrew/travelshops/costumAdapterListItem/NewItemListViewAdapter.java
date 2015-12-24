package com.hrom.andrew.travelshops.costumAdapterListItem;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.hrom.andrew.travelshops.trash.OnPlusButtonClickListenner;

import java.util.List;

public class NewItemListViewAdapter extends ArrayAdapter<NewShop> {
    private OnPlusButtonClickListenner listenner;

    public NewItemListViewAdapter(Context context, int resource, List<NewShop> objects) {
        super(context, resource, objects);
    }

    public void setOnPlusClickListenner(OnPlusButtonClickListenner listenner) {
        this.listenner = listenner;
    }
}
