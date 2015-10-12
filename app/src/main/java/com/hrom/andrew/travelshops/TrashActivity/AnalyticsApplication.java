package com.hrom.andrew.travelshops.TrashActivity;

import android.app.Application;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;
import com.hrom.andrew.travelshops.R;

import java.util.HashMap;

public class AnalyticsApplication extends Application{
    private static final String PROPERTY_ID = "UA-68632384-1";
    private Tracker mTracker;

    synchronized public Tracker getTracker() {
        if (mTracker == null) {
            GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
            mTracker = analytics.newTracker(R.xml.global_tracker);
        }
        return mTracker;
    }
}
