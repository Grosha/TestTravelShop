package com.hrom.andrew.travelshops.trash;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.hrom.andrew.travelshops.R;

public class SwipeMountain extends FragmentActivity{
    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_swipe);

        pager = (ViewPager)findViewById(R.id.pager);

        SwipePageAdapter adapter = new SwipePageAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
    }
}
