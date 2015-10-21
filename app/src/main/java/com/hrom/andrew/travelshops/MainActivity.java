package com.hrom.andrew.travelshops;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdView;
import com.hrom.andrew.travelshops.Fragments.BikeFragment;
import com.hrom.andrew.travelshops.Fragments.FavoriteListFragment;
import com.hrom.andrew.travelshops.Fragments.MapsFragment;
import com.hrom.andrew.travelshops.Fragments.MountainFragment;
import com.hrom.andrew.travelshops.Fragments.SkisFragment;
import com.hrom.andrew.travelshops.Fragments.SnowboardFragment;
import com.hrom.andrew.travelshops.TrashActivity.AnalyticsEvent;
import com.hrom.andrew.travelshops.TrashActivity.IntermediaryActivity;
import com.hrom.andrew.travelshops.TrashActivity.MyApplication;
import com.hrom.andrew.travelshops.TrashActivity.PrefUtil;
import com.hrom.andrew.travelshops.TrashActivity.StringVariables;
import com.hrom.andrew.travelshops.TrashActivity.RetainedFragment;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeader;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;


public class MainActivity extends IntermediaryActivity {

    private Drawer drawer;
    private android.support.v4.app.FragmentManager manager;
    private android.support.v4.app.FragmentTransaction transaction;
    private int clickedItem = -1;
    private ProgressBar progressBar;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        MyApplication.get().sendEvent(
                AnalyticsEvent.CATEGORY_APPLICATION,
                AnalyticsEvent.ACTION_APPLICATION,
                null);

        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, new MountainFragment());
        transaction.commit();

        manager = getSupportFragmentManager();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initializeNavigatorDrawer(toolbar);

        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        admobBanner(mAdView);
        admobInterstitial();
    }

    public Toolbar getToolbar() {
        return toolbar;
    }

    private void initializeNavigatorDrawer(Toolbar toolbar) {

        AccountHeader header = creatAccountHeader();

        drawer = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withAccountHeader(header)
                .withDisplayBelowToolbar(false)
                .withTranslucentStatusBar(true)
                .withActionBarDrawerToggleAnimated(true)
                .withOnDrawerListener(new Drawer.OnDrawerListener() {
                    @Override
                    public void onDrawerOpened(View view) {

                    }

                    @Override
                    public void onDrawerClosed(View view) {

                        if (clickedItem >= 0) {
                            transaction = manager.beginTransaction();
                            switch (clickedItem) {
                                case 0:
                                    transaction.replace(R.id.container, new FavoriteListFragment());
                                    MyApplication.get().sendEvent(
                                            AnalyticsEvent.DRAWER_CATEGORY,
                                            AnalyticsEvent.DRAWER_ACTION,
                                            AnalyticsEvent.DRAWER_LABEL_FAVORITE);
                                    break;
                                case 2:
                                    transaction.replace(R.id.container, new MountainFragment());
                                    //transaction.replace(R.id.container, new SwipeMountain());
                                    MyApplication.get().sendEvent(
                                            AnalyticsEvent.DRAWER_CATEGORY,
                                            AnalyticsEvent.DRAWER_ACTION,
                                            AnalyticsEvent.DRAWER_LABEL_MOUNTAIN);
                                    break;
                                case 3:
                                    transaction.replace(R.id.container, new SkisFragment());
                                    MyApplication.get().sendEvent(
                                            AnalyticsEvent.DRAWER_CATEGORY,
                                            AnalyticsEvent.DRAWER_ACTION,
                                            AnalyticsEvent.DRAWER_LABEL_SKI);
                                    break;
                                case 4:
                                    transaction.replace(R.id.container, new SnowboardFragment());
                                    MyApplication.get().sendEvent(
                                            AnalyticsEvent.DRAWER_CATEGORY,
                                            AnalyticsEvent.DRAWER_ACTION,
                                            AnalyticsEvent.DRAWER_LABEL_SNOWBOARD);
                                    break;
                                case 5:
                                    transaction.replace(R.id.container, new BikeFragment());
                                    MyApplication.get().sendEvent(
                                            AnalyticsEvent.DRAWER_CATEGORY,
                                            AnalyticsEvent.DRAWER_ACTION,
                                            AnalyticsEvent.DRAWER_LABEL_BIKE);
                                    break;
                                case 6:
                                    transaction.replace(R.id.container, new MapsFragment());
                                    MyApplication.get().sendEvent(
                                            AnalyticsEvent.DRAWER_CATEGORY,
                                            AnalyticsEvent.DRAWER_ACTION,
                                            AnalyticsEvent.DRAWER_LABEL_MAP);
                                    break;
                            }
                            try {
                                transaction.commit();
                                clickedItem = -1;
                            } catch (IllegalStateException e) {

                            }
                        }
                    }

                    @Override
                    public void onDrawerSlide(View view, float v) {

                    }
                })
                .addDrawerItems(new PrimaryDrawerItem()
                                .withIdentifier(1)
                                .withName("Favorite shops")
                                .withTextColor(R.color.new_color)
                                .withIcon(R.drawable.ic_group_work_black_18dp)
                                .withIconColor(R.color.red_dr),
                        new DividerDrawerItem(),
                        new SecondaryDrawerItem()
                                .withName("Mountain")
                                .withIcon(R.drawable.ic_filter_hdr_black_18dp),
                        new SecondaryDrawerItem()
                                .withName("Skis")
                                .withIcon(R.drawable.skiing_18),
                        new SecondaryDrawerItem()
                                .withName("Snowboard")
                                .withIcon(R.drawable.snowboarder_18),
                        new SecondaryDrawerItem()
                                .withName("Bike")
                                .withIcon(R.drawable.ic_directions_bike_black_18dp),
                        new SecondaryDrawerItem()
                                .withName("Maps")
                                .withIcon(R.drawable.ic_map_black_36dp)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {

                    @Override
                    public boolean onItemClick(AdapterView<?> adapterView, View view, int i, long l, IDrawerItem iDrawerItem) {
                        PrefUtil.save(getBaseContext(), ++countInterstitial, StringVariables.PRES_KEY_INTERSTITIAL_DRAWER);
                        //Log.d(StringVariables.TEST, String.valueOf(PrefUtil.getCountInterstitial(getBaseContext(), StringVariables.PRES_KEY_INTERSTITIAL_DRAWER)));
                        if (PrefUtil.getCountInterstitial(getBaseContext(), StringVariables.PRES_KEY_INTERSTITIAL_DRAWER) % 5 == 0) {
                            showInterstitial();
                            clickedItem = i;
                            drawer.closeDrawer();
                            PrefUtil.save(getApplication(), 0, StringVariables.PRES_KEY_INTERSTITIAL_DRAWER);
                        } else {
                            clickedItem = i;
                            drawer.closeDrawer();
                        }

                        return true;
                    }
                })
                .build();
    }

    private AccountHeader creatAccountHeader() {
        return new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.fon)
                .build();
    }

    @Override
    public void onBackPressed() {
        if (drawer != null && drawer.isDrawerOpen()) {
            drawer.closeDrawer();
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
                //Here u can get the value "query" which is entered in the search box.
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

        transaction = manager.beginTransaction();
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
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
