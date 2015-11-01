package com.hrom.andrew.travelshops.trash;

import android.support.v4.app.Fragment;

public class RetainedFragment extends Fragment {
    private static String className = "";

    public static String getClassName() {
        return className;
    }

    public static void setClassName(String className) {
        RetainedFragment.className = className;
    }
}
