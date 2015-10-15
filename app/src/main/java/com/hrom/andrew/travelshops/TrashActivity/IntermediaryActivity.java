package com.hrom.andrew.travelshops.TrashActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class IntermediaryActivity extends AppCompatActivity {
    private AdRequest adRequest;
    protected InterstitialAd mInterstitialAd;
    protected int countInterstitial = 0;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        countInterstitial = PrefUtil.getCountInterstitial(getBaseContext(), StringVariables.PRES_KEY_INTERSTITIAL_WEB);
    }

    protected AdRequest testDevices() {
        adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("77AB095C50F526A0914479291F8868DB")
                .addTestDevice("280C6F51A33084036DA3033F54CDE388")
                .build();
        return adRequest;
    }

    protected void admobBanner(AdView mAdView) {
        mAdView.loadAd(testDevices());

        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdFailedToLoad(int errorCode) {
                super.onAdFailedToLoad(errorCode);
                //

            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                //
                MyApplication.get().sendEvent(AnalyticsEvent.ADMOB_CATEGORY, AnalyticsEvent.ADMOB_ACTION, AnalyticsEvent.ADMOB_BANNER_LABEL);
            }

            @Override
            public void onAdLeftApplication() {
                super.onAdLeftApplication();
                //
            }
        });
    }

    protected void admobInterstitial() {
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-5331719326093705/1909164471");

        mInterstitialAd.loadAd(testDevices());
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                super.onAdClosed();
                mInterstitialAd.loadAd(testDevices());
            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
            }

            @Override
            public void onAdLeftApplication() {
                super.onAdLeftApplication();
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                super.onAdFailedToLoad(errorCode);
            }
        });
    }

    public void showInterstitial() {
        Log.d(StringVariables.TEST, "load");
        if (mInterstitialAd.isLoaded()) {
            Log.d(StringVariables.TEST, "show");
            mInterstitialAd.show();
            MyApplication.get().sendEvent(AnalyticsEvent.ADMOB_CATEGORY, AnalyticsEvent.ADMOB_ACTION, AnalyticsEvent.ADMOB_INRESTITIAL_LABEL);
        }
    }
}
