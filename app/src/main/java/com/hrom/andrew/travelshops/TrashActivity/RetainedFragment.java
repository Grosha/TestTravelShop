package com.hrom.andrew.travelshops.TrashActivity;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.hrom.andrew.travelshops.Fragments.MountainFragment;

public class RetainedFragment extends Fragment {
    private static String className = "";

    public static String getClassName() {
        return className;
    }

    public static void setClassName(String className) {
        RetainedFragment.className = className;
    }
}
