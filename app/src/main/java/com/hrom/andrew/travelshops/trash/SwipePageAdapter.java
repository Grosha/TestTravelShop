package com.hrom.andrew.travelshops.trash;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.hrom.andrew.travelshops.fragments.MapsFragment;
import com.hrom.andrew.travelshops.fragments.MountainFragment;

public class SwipePageAdapter extends FragmentPagerAdapter {
    public SwipePageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new MountainFragment();
            case 1:
                return new MapsFragment();
            default:
                break;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
