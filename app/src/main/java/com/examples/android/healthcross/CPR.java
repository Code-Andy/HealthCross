package com.examples.android.healthcross;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class CPR extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cpr);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.Drawer_Layout);
        mToggle =  new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        NavigationView navigationView = (NavigationView)findViewById(R.id.navview);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        int newitem = menuItem.getItemId();

                        if (newitem == R.id.tracker) {
                            Intent track = new Intent(CPR.this, Tracker.class);
                            startActivity(track);
                        }

                        if (newitem == R.id.about) {
                            Intent info = new Intent(CPR.this, InfoActivity.class);
                            startActivity(info);
                        }

                        if (newitem == R.id.settings) {
                            Intent setting = new Intent(CPR.this, SettingsActivity.class);
                            startActivity(setting);
                        }

                        if (newitem == R.id.home) {
                            Intent home = new Intent(CPR.this, MainActivity.class);
                            startActivity(home);
                        }

                        if (newitem == R.id.news) {
                            Intent news = new Intent(CPR.this, NewsActivity.class);
                            startActivity(news);
                        }




                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here

                        return true;
                    }
                });


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }

        if (id == R.id.emergency) {
            Intent call = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "911"));
            startActivity(call);
        }
        return super.onOptionsItemSelected(item);
    }



}