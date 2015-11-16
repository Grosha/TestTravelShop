package com.hrom.andrew.travelshops;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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

import java.util.ArrayList;

public class NewMainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private ListView listView;
    private ArrayList<CategoryShops> categoryShops;
    private ListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_mainlayout);

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
        categoryShops.add(new CategoryShops(R.drawable.ic_map_1, "Mountain"));
        categoryShops.add(new CategoryShops(R.drawable.ic_map_2, "Ski"));
        categoryShops.add(new CategoryShops(R.drawable.ic_map_3, "Snowboard"));
        categoryShops.add(new CategoryShops(R.drawable.ic_map_4, "Bike"));
        categoryShops.add(new CategoryShops(R.drawable.ic_map_5, "Map"));
        categoryShops.add(new CategoryShops(R.drawable.ic_map_6, "Favorite"));
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
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        switch (categoryShops.getImageId()) {
            case R.drawable.ic_map_1:
                transaction.replace(R.id.container, new MountainFragment());
            case R.drawable.ic_map_2:
                transaction.replace(R.id.container, new SkisFragment());
            case R.drawable.ic_map_3:
                transaction.replace(R.id.container, new SnowboardFragment());
            case R.drawable.ic_map_4:
                transaction.replace(R.id.container, new BikeFragment());
            case R.drawable.ic_map_5:
                transaction.replace(R.id.container, new MapsFragment());
            case R.drawable.ic_map_6:
                transaction.replace(R.id.container, new FavoriteListFragment());
        }

        transaction.commit();

        //close navigation drawer after replace fragment
        drawerLayout.closeDrawers();
    }
}
