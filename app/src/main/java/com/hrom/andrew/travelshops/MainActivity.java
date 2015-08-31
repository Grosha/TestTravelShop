package com.hrom.andrew.travelshops;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.Target;
import com.github.amlcurran.showcaseview.targets.ViewTarget;
import com.hrom.andrew.travelshops.Fragments.BikeFragment;
import com.hrom.andrew.travelshops.Fragments.MapActivity;
import com.hrom.andrew.travelshops.Fragments.MapsFragment;
import com.hrom.andrew.travelshops.Fragments.MountainFragment;
import com.hrom.andrew.travelshops.Fragments.SkisFragment;
import com.hrom.andrew.travelshops.Fragments.SnowboardFragment;
import com.hrom.andrew.travelshops.ShopDB.MountainShop;
import com.hrom.andrew.travelshops.TrashActivity.MyTag;
import com.hrom.andrew.travelshops.TrashActivity.RetainedFragment;
import com.hrom.andrew.travelshops.TrashActivity.SwipeMountain;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeader;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;


public class MainActivity extends AppCompatActivity {

    private Drawer drawer;
    private MountainFragment mountainFragment;
    private BikeFragment bikeFragment;
    private SnowboardFragment snowboardFragment;
    private SkisFragment skisFragment;
    private android.support.v4.app.FragmentManager manager;
    private android.support.v4.app.FragmentTransaction transaction;
    private ShowcaseView showcaseView;
    private Target targetButMap, targetClickList;
    private int numberItem = 0;
    private int clickedItem = -1;
    //private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, new MountainFragment());
        transaction.commit();

        manager = getSupportFragmentManager();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initializeNavigatorDrawer(toolbar);

        targetButMap = new ViewTarget(R.id.action_search, this);
        targetClickList = new ViewTarget(R.id.travelList, this);

        showcaseView = new ShowcaseView.Builder(this)
                .setTarget(Target.NONE)
                //.hideOnTouchOutside()
                /*.setOnClickListener()*/
                .setContentTitle("MY Tutorial")
                .setContentText("AbuDabi")
                .setStyle(R.style.CustomShowcaseTheme2)
                .build();
        showcaseView.setButtonText("I GOT IT");

        //progressBar = (ProgressBar)findViewById(R.id.progress_bar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
                                    /*Intent intent = new Intent(getApplicationContext(), MapActivity.class);
                                    startActivity(intent);*/
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
                            transaction.commit();
                            clickedItem = -1;
                        }
                    }

                    @Override
                    public void onDrawerSlide(View view, float v) {

                    }
                })
                .addDrawerItems(new PrimaryDrawerItem()
                                .withName("All links")
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
                                .withIcon(R.drawable.bicycle_icon_18),
                        new SecondaryDrawerItem()
                                .withName("Maps")
                                .withIcon(R.drawable.ic_map_black_36dp)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {

                    @Override
                    public boolean onItemClick(AdapterView<?> adapterView, View view, int i, long l, IDrawerItem iDrawerItem) {
                        clickedItem = i;
                        drawer.closeDrawer();
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
            case R.id.action_search:
                transaction.replace(R.id.container, new MapsFragment()).commit();
                return true;
            /*case R.id.action_settings:
                openSettings();
                return true;*/
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void tutorial(View view) {
        switch (numberItem) {
            case 0:
                showcaseView.setShowcase(targetButMap, true);
                showcaseView.setContentTitle("Map");
                showcaseView.setButtonText("Bike Map");
                break;
            case 1:
                showcaseView.setShowcase(targetClickList, true);
                showcaseView.setContentTitle("A");
                showcaseView.setButtonText("BikeAAAAAAAAA Map");
                break;
            case 2:
                showcaseView.hide();
                break;
        }
        numberItem++;
    }

}
