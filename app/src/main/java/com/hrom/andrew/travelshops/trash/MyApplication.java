package com.hrom.andrew.travelshops.trash;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import android.util.Log;

import com.facebook.FacebookSdk;
import com.google.android.gms.analytics.HitBuilders;
import com.hrom.andrew.travelshops.google_analytics.AnalyticsTrackers;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MyApplication extends Application {
    private static MyApplication singleton;

    public static MyApplication get() {
        return singleton;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;
        showHashKod();
        FacebookSdk.sdkInitialize(getApplicationContext());
        AnalyticsTrackers.initialize(this);
    }

    public void sendEvent(String category, String action, String label) {
        AnalyticsTrackers.getInstance().get().send(new HitBuilders.EventBuilder()
                .setCategory(category)
                .setAction(action)
                .setLabel(label)
                .build());

        if (label == null) {
            Log.d(StringVariables.EventSender, "category: " + category + ", action: " + action);
        } else if (!label.isEmpty() & !action.isEmpty() & !category.isEmpty()) {
            Log.d(StringVariables.EventSender, "category: " + category + ", action: " + action + ", label: " + label);
        }
    }

    public void showHashKod() {
        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.hrom.andrew.travelshops",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }
    }
}
