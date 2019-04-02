package com.Euspacetech.bakery;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.Euspacetech.bakery.activity.TotalShopsActivity;
import com.Euspacetech.bakery.database.DBHelper;
import com.Euspacetech.bakery.fragment.DashBoardFragment;
import com.Euspacetech.bakery.fragment.GenerateBillFragment;
import com.Euspacetech.bakery.fragment.ShopDetailsFragment;
import com.Euspacetech.bakery.fragment.StockFragment;
import com.Euspacetech.bakery.fragment.ViewBillFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    TextView txtcount,shopcount;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        shopcount = findViewById(R.id.totalshop);
        DBHelper db = new DBHelper(this);
        shopcount.setText(String .valueOf(db.allShopCount()));
     shopcount.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent intent = new Intent(MainActivity.this, TotalShopsActivity.class);
             startActivity(intent);
         }
     });



        txtcount = findViewById(R.id.txtCount);
        DBHelper dbs = new DBHelper(this);
        txtcount.setText(String.valueOf(dbs.getProfilesCount()));
        setSupportActionBar(toolbar);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id)
        {
            case R.id.dashboard:
                changeFragment(new ShopDetailsFragment());
                break;
            case R.id.stock:
                changeFragment(new StockFragment());
                break;
            case R.id.shop:
               Intent shop = new Intent(MainActivity.this,TotalShopsActivity.class);
               startActivity(shop);
                break;
            case R.id.nav_view:
                changeFragment(new ViewBillFragment());
                break;
            case R.id.nav_share:
                changeFragment(new ShopDetailsFragment());
                break;
            case R.id.nav_send:
                changeFragment(new DashBoardFragment());
                break;


        }

     /*   if (id == R.id.nav_camera) {
            // Handle the camera action
            changeFragment(new ShopDetailsFragment());
        }
        else if (id == R.id.nav_gallery)
        {
            changeFragment(new StockFragment());
        }
        else if (id == R.id.nav_slideshow)
        {
            changeFragment(new GenerateBillFragment());
        }
        else if (id == R.id.nav_view)
        {
            changeFragment(new ViewBillFragment());
        }
        else if (id == R.id.nav_share)
        {
            changeFragment(new ShopDetailsFragment());
        }
        else if (id == R.id.nav_send)
        {

            changeFragment(new DashBoardFragment());
        }*/
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void changeFragment(Fragment fragment)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.parent,fragment);
        fragmentTransaction.commit();
    }
}
