package com.hrom.andrew.travelshops;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.hrom.andrew.travelshops.Fragments.BikeFragment;
import com.hrom.andrew.travelshops.Fragments.MapActivity;
import com.hrom.andrew.travelshops.Fragments.MapsFragment;
import com.hrom.andrew.travelshops.Fragments.MountainFragment;
import com.hrom.andrew.travelshops.Fragments.SkisFragment;
import com.hrom.andrew.travelshops.Fragments.SnowboardFragment;
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
    private android.support.v4.app.FragmentManager manager;
    private android.support.v4.app.FragmentTransaction transaction;

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
                                    Intent intent = new Intent(getApplicationContext(), MapActivity.class);
                                    startActivity(intent);
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
                                .withName("BikePage")
                                .withIcon(R.drawable.bicycle_icon_18),
                        new SecondaryDrawerItem()
                                .withName("Maps")
                                .withIcon(R.drawable.ic_room_black_18dp)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {

                    @Override
                    public boolean onItemClick(AdapterView<?> adapterView, View view, int i, long l, IDrawerItem iDrawerItem) {
                        clickedItem = i;
                        /*transaction = manager.beginTransaction();
                        switch (i) {
                            case 0:
                                Intent intent = new Intent(getApplicationContext(), MapActivity.class);
                                startActivity(intent);
                                break;
                            case 2:
                                transaction.replace(R.id.container, new MountainFragment());
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
                        transaction.commit();*/
                        drawer.closeDrawer();
                        return true;
                    }
                })
                .build();
    }

    int clickedItem = -1;

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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        transaction = manager.beginTransaction();
        switch (item.getItemId()) {
            case R.id.action_search:
                transaction.replace(R.id.container, new MapsFragment());
                transaction.commit();
                return true;
            /*case R.id.action_settings:
                openSettings();
                return true;*/
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
