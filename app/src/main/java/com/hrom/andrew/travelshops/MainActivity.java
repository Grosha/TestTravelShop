package com.hrom.andrew.travelshops;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.hrom.andrew.travelshops.Fragments.BikeFragment;
import com.hrom.andrew.travelshops.Fragments.MountainFragment;
import com.hrom.andrew.travelshops.Fragments.SkisFragment;
import com.hrom.andrew.travelshops.Fragments.SnowboardFragment;
import com.hrom.andrew.travelshops.ShopDatas.SportShop;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeader;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Drawer drawer;
    private BikeFragment bikeFragment;
    private SkisFragment skisFragment;
    private SnowboardFragment snowboardFragment;
    private MountainFragment mountainFragment;
    private static final String NAMEFRAGMENT = "FRAGMENT";

    private android.support.v4.app.FragmentManager manager;
    private android.support.v4.app.FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        manager = getSupportFragmentManager();

        bikeFragment = new BikeFragment();
        skisFragment = new SkisFragment();
        mountainFragment = new MountainFragment();
        snowboardFragment = new SnowboardFragment();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initializeNavigatorDrawer(toolbar);
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
                                .withName("BikePage")
                                .withIcon(R.drawable.bicycle_icon_18)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {

                    @Override
                    public boolean onItemClick(AdapterView<?> adapterView, View view, int i, long l, IDrawerItem iDrawerItem) {
                        transaction = manager.beginTransaction();

                        switch (i) {
                            case 0:
                                Log.d(NAMEFRAGMENT, "0");
                                break;
                            case 2:
                                Log.d(NAMEFRAGMENT, "нажав на гори");
                                if (manager.findFragmentByTag(MountainFragment.TAG) == null) {
                                    Log.d(NAMEFRAGMENT, "прийшов фрагмент " + MountainFragment.TAG);
                                    transaction.add(R.id.container, mountainFragment, MountainFragment.TAG);
                                }
                                break;
                            case 3:
                                Log.d(NAMEFRAGMENT, "нажав на лижі");
                                if (manager.findFragmentByTag(SkisFragment.TAG) == null) {
                                    Log.d(NAMEFRAGMENT, "прийшов фрагмент " + SkisFragment.TAG);
                                    transaction.replace(R.id.container, skisFragment, SkisFragment.TAG);
                                }
                                break;
                            case 4:
                                Log.d(NAMEFRAGMENT, "нажав на борд");
                                if (manager.findFragmentByTag(SnowboardFragment.TAG) == null) {
                                    Log.d(NAMEFRAGMENT, "прийшов фрагмент " + SnowboardFragment.TAG);
                                    transaction.replace(R.id.container, snowboardFragment, SnowboardFragment.TAG);
                                }
                                break;
                            case 5:
                                Log.d(NAMEFRAGMENT, "нажав на байк");
                                if (manager.findFragmentByTag(BikeFragment.TAG) == null) {
                                    Log.d(NAMEFRAGMENT, "прийшов фрагмент " + BikeFragment.TAG);
                                    transaction.replace(R.id.container, bikeFragment, BikeFragment.TAG);
                                }
                                break;
                        }
                        transaction.commit();
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
}
