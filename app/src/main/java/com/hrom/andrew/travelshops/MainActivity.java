package com.hrom.andrew.travelshops;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
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
import com.hrom.andrew.travelshops.TrashActivity.IntermediaryActivity;
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
                                    break;
                                case 2:
                                    transaction.replace(R.id.container, new MountainFragment());
                                    //transaction.replace(R.id.container, new SwipeMountain());
                                    break;
                                case 3:
                                    transaction.replace(R.id.container, new SkisFragment());
                                    break;
                                case 4:
                                    transaction.replace(R.id.container, new SnowboardFragment());
                                    break;
                                case 5:
                                    transaction.replace(R.id.container, new BikeFragment());
                                    break;
                                case 6:
                                    transaction.replace(R.id.container, new MapsFragment());
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
                                .withName("Favorite shops")
                                .withIdentifier(1)
                                .withIcon(R.drawable.ic_group_work_black_18dp),
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
                        Log.d(StringVariables.TEST, String.valueOf(countInterstitial));
                        if (countInterstitial % 5 == 0) {
                            showInterstitial();
                            clickedItem = i;
                            drawer.closeDrawer();
                            countInterstitial = 1;
                            /*if (mInterstitialAd.isLoaded()) {
                                mInterstitialAd.show();
                                clickedItem = i;
                                drawer.closeDrawer();
                                countInterstitial = 0;
                            } else {
                                clickedItem = i;
                                drawer.closeDrawer();
                            }*/
                        } else {
                            clickedItem = i;
                            drawer.closeDrawer();
                            countInterstitial++;
                        }

                        return true;
                    }
                })
                .build();
    }

    private AccountHeader creatAccountHeader() {
        return new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.header_1)
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
                return true;
            case R.id.action_search:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
