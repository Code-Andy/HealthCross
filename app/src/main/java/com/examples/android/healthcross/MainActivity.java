package com.examples.android.healthcross;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
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
     public boolean onOptionsItemSelected(MenuItem item){

         if(mToggle.onOptionsItemSelected(item)){
             return true;
         }

         return super.onOptionsItemSelected(item);
     }



    public void openTrackerView(View view) {
        Intent i = new Intent(this, TrackerActivity.class);
        startActivity(i);
    }

    public void openNewsView(View view) {
        Intent l = new Intent(this, NewsActivity.class);
        startActivity(l);
    }

    public void openSettingsView(View view) {
        Intent k = new Intent(this, SettingsActivity.class);
        startActivity(k);
    }

    public void openInfoView(View view) {
        Intent s = new Intent(this, InfoActivity.class);
        startActivity(s);
    }


}
