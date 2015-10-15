package com.hrom.andrew.travelshops.TrashActivity;

import android.app.Application;
import android.util.Log;

import com.google.android.gms.analytics.HitBuilders;

public class MyApplication extends Application {
    private static MyApplication singleton;

    public static MyApplication get() {
        return singleton;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;
        AnalyticsTrackers.initialize(this);
     }

    public void sendEvent(String category, String action, String label){
        AnalyticsTrackers.getInstance().get().send(new HitBuilders.EventBuilder()
                .setCategory(category)
                .setAction(action)
                .setLabel(label)
                .build());

        if (label.isEmpty()) {
            Log.d(StringVariables.EventSender, "category " + category + ", action " + action);
        } else if (!label.isEmpty() & !action.isEmpty() & !category.isEmpty()) {
            Log.d(StringVariables.EventSender, "category " + category + ", action " + action + ", label " + label);
        }
    }
}
