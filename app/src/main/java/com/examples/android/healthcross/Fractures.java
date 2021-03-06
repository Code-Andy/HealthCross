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

public class Fractures extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fractures);

        mDrawerLayout = findViewById(R.id.Drawer_Layout);
        mToggle =  new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        NavigationView navigationView = findViewById(R.id.navview);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        int newitem = menuItem.getItemId();

                        if (newitem == R.id.about) {
                            Intent info = new Intent(Fractures.this, InfoActivity.class);
                            startActivity(info);
                        }


                        if (newitem == R.id.tracker) {
                            Intent tracker = new Intent(Fractures.this, Tracker.class);
                            startActivity(tracker);
                        }

                        if (newitem == R.id.home) {
                            Intent home = new Intent(Fractures.this, MainActivity.class);
                            startActivity(home);
                        }

                        if (newitem == R.id.news) {
                            Intent news = new Intent(Fractures.this, NewsActivity.class);
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