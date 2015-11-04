package com.hrom.andrew.travelshops.trash;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hrom.andrew.travelshops.Fragments.CategoryFragment;

public class TestBitmap extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyBitMap(this));
    }
}
