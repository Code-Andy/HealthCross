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

public class MainActivity extends AppCompatActivity {


    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;


    @Override

    protected void onCreate(Bundle savedInstanceState) {


        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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
                            Intent info = new Intent(MainActivity.this, InfoActivity.class);
                            startActivity(info);
                        }

                        if (newitem == R.id.tracker) {
                            Intent tracker = new Intent(MainActivity.this, Tracker.class);
                            startActivity(tracker);
                        }

                        if (newitem == R.id.tracker) {
                            Intent tracker = new Intent(MainActivity.this, Tracker.class);
                            startActivity(tracker);
                        }

                        if (newitem == R.id.news) {
                            Intent news = new Intent(MainActivity.this, NewsActivity.class);
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



    public void openCutActivity(View view) {
        Intent cut = new Intent(MainActivity.this, Cut.class);
        startActivity(cut);
    }

    public void openFracturesActivity(View view) {
        Intent fractures = new Intent(MainActivity.this, Fractures.class);
        startActivity(fractures);
    }

    public void openBurnsActivity(View view) {
        Intent burns = new Intent(MainActivity.this, Burns.class);
        startActivity(burns);
    }

    public void openScrapesActivity(View view) {
        Intent scrapes = new Intent(MainActivity.this, Scrapes.class);
        startActivity(scrapes);
    }

    public void openPuncturesActivity(View view) {
        Intent punctures = new Intent(MainActivity.this, Punctures.class);
        startActivity(punctures);
    }

    public void openSplintersActivity(View view) {
        Intent splinters = new Intent(MainActivity.this, Splinters.class);
        startActivity(splinters);
    }

    public void openCPRActivity(View view) {
        Intent cpr = new Intent(MainActivity.this, CPR.class);
        startActivity(cpr);
    }

    public void openFluActivity(View view) {
        Intent flu = new Intent(MainActivity.this, Flu.class);
        startActivity(flu);
    }


}





