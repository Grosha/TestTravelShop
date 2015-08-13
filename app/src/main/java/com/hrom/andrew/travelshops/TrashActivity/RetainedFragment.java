package com.hrom.andrew.travelshops.TrashActivity;

import android.app.Fragment;
import android.os.Bundle;

public class RetainedFragment extends Fragment{
    private Fragment fragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public Fragment getFragment() {
        return fragment;
    }
}
