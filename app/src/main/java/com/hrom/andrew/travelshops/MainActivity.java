package com.hrom.andrew.travelshops;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.hrom.andrew.travelshops.Fragments.MapsFragment;
import com.hrom.andrew.travelshops.Fragments.BikeFragment;
import com.hrom.andrew.travelshops.Fragments.FavoriteFragment;
import com.hrom.andrew.travelshops.Fragments.MountainFragment;
import com.hrom.andrew.travelshops.Fragments.SkiFragment;
import com.hrom.andrew.travelshops.Fragments.SnowboardFragment;
import com.hrom.andrew.travelshops.customAdapterDrawer.ObjectCategoryShops;
import com.hrom.andrew.travelshops.customAdapterDrawer.ListViewAdapter;
import com.hrom.andrew.travelshops.google_analytics.AnalyticsEvent;
import com.hrom.andrew.travelshops.trash.TransitActivity;
import com.hrom.andrew.travelshops.trash.MyApplication;
import com.hrom.andrew.travelshops.trash.PrefUtil;
import com.hrom.andrew.travelshops.trash.StringVariables;
import com.hrom.andrew.travelshops.trash.RetainedFragment;

import java.util.ArrayList;


public class MainActivity extends TransitActivity {

    private ProgressBar progressBar;
    private Toolbar toolbar;

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private ListView listView;
    private ArrayList<ObjectCategoryShops> objectCategoryShops;
    private ListViewAdapter adapter;
    private int pixel = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        Log.d(StringVariables.TEST, String.valueOf(metrics.densityDpi));
        pixel = metrics.densityDpi;

        MyApplication.get().sendEvent(
                AnalyticsEvent.CATEGORY_APPLICATION,
                AnalyticsEvent.ACTION_APPLICATION,
                null);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, new MountainFragment());
        transaction.commit();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        objectCategoryShops = new ArrayList<>();
        findViewById();

        initDrawerLayout();

        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /*AdView mAdView = (AdView) findViewById(R.id.adView);
        admobBanner(mAdView);*/
        admobInterstitial();
    }

    private void findViewById() {
        listView = (ListView) findViewById(R.id.list);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
    }

    private void initDrawerLayout() {
        setListViewData();
        setListViewHeader();
        //Mount listview with adapter
        adapter = new ListViewAdapter(this, R.layout.drawer_list, objectCategoryShops);
        listView.setAdapter(adapter);

        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.drawer_open, R.string.drawer_close) {

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

            }
        };
        drawerLayout.setDrawerListener(drawerToggle);
    }

    private void setListViewData() {
        objectCategoryShops.add(new ObjectCategoryShops(R.drawable.ic_favorite, "Favorite", R.color.colorFavoriteSection));
        objectCategoryShops.add(new ObjectCategoryShops(R.drawable.ic_mountins, "Mountain", R.color.colorMountainSection));
        objectCategoryShops.add(new ObjectCategoryShops(R.drawable.ic_skis, "Ski", R.color.colorSkiSection));
        objectCategoryShops.add(new ObjectCategoryShops(R.drawable.ic_snowboard, "Snowboard", R.color.colorSnowboardSection));
        objectCategoryShops.add(new ObjectCategoryShops(R.drawable.ic_bike, "Bike", R.color.colorBikeSection));
        objectCategoryShops.add(new ObjectCategoryShops(R.drawable.ic_map, "Map", R.color.colorMapSection));
    }

    private void setListViewHeader() {
        LayoutInflater inflater = getLayoutInflater();
        View header = inflater.inflate(R.layout.header_listview, listView, false);
        listView.addHeaderView(header, null, false);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    public void updateMainLayout(ObjectCategoryShops objectCategoryShops) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (objectCategoryShops.getImageId()) {
            case R.drawable.ic_mountins:
                transaction.replace(R.id.container, new MountainFragment());
                MyApplication.get().sendEvent(
                        AnalyticsEvent.DRAWER_CATEGORY,
                        AnalyticsEvent.DRAWER_ACTION,
                        AnalyticsEvent.DRAWER_LABEL_MOUNTAIN);
                break;
            case R.drawable.ic_skis:
                transaction.replace(R.id.container, new SkiFragment());
                MyApplication.get().sendEvent(
                        AnalyticsEvent.DRAWER_CATEGORY,
                        AnalyticsEvent.DRAWER_ACTION,
                        AnalyticsEvent.DRAWER_LABEL_SKI);
                break;
            case R.drawable.ic_snowboard:
                transaction.replace(R.id.container, new SnowboardFragment());
                MyApplication.get().sendEvent(
                        AnalyticsEvent.DRAWER_CATEGORY,
                        AnalyticsEvent.DRAWER_ACTION,
                        AnalyticsEvent.DRAWER_LABEL_SNOWBOARD);
                break;
            case R.drawable.ic_bike:
                transaction.replace(R.id.container, new BikeFragment());
                MyApplication.get().sendEvent(
                        AnalyticsEvent.DRAWER_CATEGORY,
                        AnalyticsEvent.DRAWER_ACTION,
                        AnalyticsEvent.DRAWER_LABEL_BIKE);
                break;
            case R.drawable.ic_map:
                transaction.replace(R.id.container, new MapsFragment());
                MyApplication.get().sendEvent(
                        AnalyticsEvent.DRAWER_CATEGORY,
                        AnalyticsEvent.DRAWER_ACTION,
                        AnalyticsEvent.DRAWER_LABEL_MAP);
                break;
            case R.drawable.ic_favorite:
                transaction.replace(R.id.container, new FavoriteFragment());
                MyApplication.get().sendEvent(
                        AnalyticsEvent.DRAWER_CATEGORY,
                        AnalyticsEvent.DRAWER_ACTION,
                        AnalyticsEvent.DRAWER_LABEL_FAVORITE);
                break;
        }

        transaction.commit();

        //close navigation drawer after replace fragment
        drawerLayout.closeDrawers();
    }

    public void showInterstitial(int position) {
        PrefUtil.save(getBaseContext(), ++countInterstitial, StringVariables.PRES_KEY_INTERSTITIAL_DRAWER);
        //Log.d(StringVariables.TEST, String.valueOf(PrefUtil.getCountInterstitial(getBaseContext(), StringVariables.PRES_KEY_INTERSTITIAL_DRAWER)));
        if (PrefUtil.getCountInterstitial(getBaseContext(), StringVariables.PRES_KEY_INTERSTITIAL_DRAWER) % 5 == 0) {
            showInterstitial();
            drawerLayout.closeDrawers();
            PrefUtil.save(getApplication(), 0, StringVariables.PRES_KEY_INTERSTITIAL_DRAWER);
        } else {
            drawerLayout.closeDrawers();
        }
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout != null && drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawers();
        } else super.onBackPressed();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getDelegate().onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_toolbar, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        SearchView.OnQueryTextListener queryTextListener = new SearchView.OnQueryTextListener() {
            public boolean onQueryTextChange(String newText) {
                // this is your adapter that will be filtered
                return true;
            }

            public boolean onQueryTextSubmit(String query) {
                //Here u can get the value "query" which is entered in the ic_search box.
                if (!query.isEmpty()) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=" + query));
                    startActivity(intent);
                }
                return true;
            }
        };
        searchView.setOnQueryTextListener(queryTextListener);

        return super.onCreateOptionsMenu(menu);
    }

    public void setLastFragmentTag(String tag) {
        RetainedFragment.setClassName(tag);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (item.getItemId()) {
            case R.id.action_map:
                transaction.replace(R.id.container, new MapsFragment()).commit();
                MyApplication.get().sendEvent(
                        AnalyticsEvent.TOOLBOX_CATEGORY,
                        AnalyticsEvent.TOOLBOX_ACTION,
                        AnalyticsEvent.TOOLBOX_LABEL_MAP);
                return true;
            case R.id.action_search:
                MyApplication.get().sendEvent(
                        AnalyticsEvent.TOOLBOX_CATEGORY,
                        AnalyticsEvent.TOOLBOX_ACTION,
                        AnalyticsEvent.TOOLBOX_LABEL_SEARCH);
                return true;
            case R.id.action_share:
                Intent shareIntent = new Intent(android.content.Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Insert Subject Here");
                String shareMessage = "Insert message body here." + "\n\nhttps://play.google.com/store/apps/details?id=com.highlyrecommendedapps.droidkeeper&hl=ru";
                shareIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareMessage);

                Bitmap image = BitmapFactory.decodeResource(getResources(), R.mipmap.main_icon_18);
                shareIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON, image);

                startActivity(Intent.createChooser(shareIntent, "Insert share chooser title here"));
                return true;
            /*case R.id.action_bitmap:
                Intent intent = new Intent(this, TestBitmap.class);
                startActivity(intent);
                return true;*/
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public int getDpi() {
        return pixel;
    }

}
