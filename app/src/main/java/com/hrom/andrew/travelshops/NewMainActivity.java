package com.hrom.andrew.travelshops;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import com.hrom.andrew.travelshops.Fragments.BikeFragment;
import com.hrom.andrew.travelshops.Fragments.FavoriteListFragment;
import com.hrom.andrew.travelshops.Fragments.MapsFragment;
import com.hrom.andrew.travelshops.Fragments.MountainFragment;
import com.hrom.andrew.travelshops.Fragments.SkisFragment;
import com.hrom.andrew.travelshops.Fragments.SnowboardFragment;
import com.hrom.andrew.travelshops.NewDrawer.CategoryShops;
import com.hrom.andrew.travelshops.NewDrawer.ListViewAdapter;
import com.hrom.andrew.travelshops.trash.StringVariables;

import java.util.ArrayList;

public class NewMainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private ListView listView;
    private ArrayList<CategoryShops> categoryShops;
    private ListViewAdapter adapter;
    private android.support.v4.app.FragmentManager manager;
    private android.support.v4.app.FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_mainlayout);

        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();

        /*transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, new MountainFragment());
        transaction.commit();*/

        categoryShops = new ArrayList<>();
        findViewById();
        setSupportActionBar(toolbar);
        initDrawerLayout();
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
        adapter = new ListViewAdapter(this, R.layout.drawer_list, categoryShops);
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
        categoryShops.add(new CategoryShops(R.drawable.ic_favorite, "Favorite", R.color.colorFavoriteSection));
        categoryShops.add(new CategoryShops(R.drawable.ic_mountins, "Mountain", R.color.colorMountainSection));
        categoryShops.add(new CategoryShops(R.drawable.ic_skis, "Ski", R.color.colorSkiSection));
        categoryShops.add(new CategoryShops(R.drawable.ic_snowboard, "Snowboard", R.color.colorSnowboardSection));
        categoryShops.add(new CategoryShops(R.drawable.ic_bike, "Bike", R.color.colorBikeSection));
        categoryShops.add(new CategoryShops(R.drawable.ic_map, "Map", R.color.colorMapSection));
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

    public void updateNewMainLayout(CategoryShops categoryShops) {
        //FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Log.d(StringVariables.TEST, "updateNewMainLayout");
        transaction = manager.beginTransaction();
        Log.d(StringVariables.TEST, String.valueOf(categoryShops.getImageId()));
        Log.d(StringVariables.TEST, String.valueOf(R.drawable.ic_mountins));
        switch (categoryShops.getImageId()) {
            case R.drawable.ic_mountins:
                transaction.replace(R.id.new_container, new MountainFragment());
            case R.drawable.ic_skis:
                transaction.replace(R.id.new_container, new SkisFragment());
            case R.drawable.ic_snowboard:
                transaction.replace(R.id.new_container, new SnowboardFragment());
            case R.drawable.ic_bike:
                transaction.replace(R.id.new_container, new BikeFragment());
            case R.drawable.ic_map:
                transaction.replace(R.id.new_container, new MapsFragment());
            case R.drawable.ic_favorite:
                transaction.replace(R.id.new_container, new FavoriteListFragment());
        }

        transaction.commit();

        //close navigation drawer after replace fragment
        drawerLayout.closeDrawers();
    }
}
