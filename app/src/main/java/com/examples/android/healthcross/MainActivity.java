package com.examples.android.healthcross;

import android.content.Intent;
import android.os.Bundle;
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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.Drawer_Layout);
        mToggle =  new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

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

         if (id == R.id.mybutton) {

         }

         return super.onOptionsItemSelected(item);
     }



    public void openTrackerView(View view) {
        Intent t = new Intent(this, TrackerActivity.class);
        startActivity(t);
    }

    public void openNewsView(View view) {
        Intent n = new Intent(this, NewsActivity.class);
        startActivity(n);
    }

    public void openSettingsView(View view) {
        Intent s = new Intent(this, SettingsActivity.class);
        startActivity(s);
    }

    public void openInfoView(View view) {
        Intent i = new Intent(this, InfoActivity.class);
        startActivity(i);
    }


}

