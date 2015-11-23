package com.hrom.andrew.travelshops.trash;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.ShareButton;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.hrom.andrew.travelshops.R;
import com.hrom.andrew.travelshops.google_analytics.AnalyticsEvent;

public class TransitActivity extends AppCompatActivity {
    private AdRequest adRequest;
    protected InterstitialAd mInterstitialAd;
    protected int countInterstitial = 0;
    private ShareButton shareButton;
    private Bitmap image;
    private int counter = 0;


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

    public void sharedVK(View v) {
        Toast.makeText(this, "VK", Toast.LENGTH_SHORT).show();
        ImageView sharingButton = new ImageButton(this);
        sharingButton.setLayoutParams(new ViewGroup.LayoutParams(RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT));
        sharingButton.setImageResource(R.drawable.ic_vk);

        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = "Here is the share content body";
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);

        image = BitmapFactory.decodeResource(getResources(), R.mipmap.main_icon_18);
        SharePhoto photo = new SharePhoto.Builder()
                .setBitmap(image)
                .build();

        SharePhotoContent contentPhoto = new SharePhotoContent.Builder()
                .addPhoto(photo)
                .build();
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }

    public void sharedFacebook(View v) {
        Toast.makeText(this, "facebook", Toast.LENGTH_SHORT).show();
        ShareLinkContent contentLink = new ShareLinkContent.Builder()
                .setContentTitle("Test application")
                .setContentDescription("Wow, super app!")
                .setContentUrl(Uri.parse("https://developers.facebook.com"))
                .setImageUrl(Uri.parse("http://www.tema-sport.ru/db_img/54060/54061.jpg"))
                .build();



        ShareButton shareButton = (ShareButton) findViewById(R.id.shareButton);
        shareButton.setShareContent(contentLink);

        /*if (counter == 0) {
            // creates immutable clone of image
            image = BitmapFactory.decodeResource(getResources(), R.mipmap.main_icon_18);

            //share dialog
            AlertDialog.Builder shareDialog = new AlertDialog.Builder(this);
            shareDialog.setTitle("Application 'FreeRideX'");
            shareDialog.setMessage("This application with Kiev's shops for winter sport, climbing " +
                    "and traveling. You can open website and show it products. And if you want to " +
                    "compare some price you can open another shop and check it");
            shareDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    //share the image to Facebook
                    SharePhoto photo = new SharePhoto.Builder().setBitmap(image).build();
                    SharePhotoContent content = new SharePhotoContent.Builder().addPhoto(photo).build();
                    if (content == null) {
                        shareButton.setShareContent(content);
                        counter = 1;
                        shareButton.performClick();
                    }
                }
            });
            shareDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            shareDialog.show();
        } else {
            counter = 0;
            shareButton.setShareContent(null);
        }*/
    }

    public void sharedGoogle(View v) {
        Toast.makeText(this, "google", Toast.LENGTH_SHORT).show();
    }

    public void sharedTwitter(View v) {
        Toast.makeText(this, "twitter", Toast.LENGTH_SHORT).show();
    }
}
