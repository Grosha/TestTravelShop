package com.hrom.andrew.travelshops.TrashActivity;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.hrom.andrew.travelshops.Fragments.MountainFragment;

public class RetainedFragment extends Fragment {
    private MountainFragment mountainFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public void setFragment(MountainFragment fragment) {
        this.mountainFragment = fragment;
    }

    public MountainFragment getFragment() {
        return mountainFragment;
    }
}
