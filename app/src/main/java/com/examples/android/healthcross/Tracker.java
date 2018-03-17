package com.examples.android.healthcross;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class  Tracker extends AppCompatActivity implements SensorEventListener {


    TextView tv_steps;

    SensorManager sensorManager;

    boolean running = false;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    @SuppressLint("ServiceCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracker);

        tv_steps = (TextView) findViewById(R.id.tv_steps);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.Drawer_Layout);
        mToggle =  new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        NavigationView navigationView = (NavigationView)findViewById(R.id.navview);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        int newitem = menuItem.getItemId();

                        if (newitem == R.id.about) {
                            Intent info = new Intent(Tracker.this, InfoActivity.class);
                            startActivity(info);
                        }

                        if (newitem == R.id.news) {
                            Intent news = new Intent(Tracker.this, NewsActivity.class);
                            startActivity(news);
                        }

                        if (newitem == R.id.settings) {
                            Intent setting = new Intent(Tracker.this, SettingsActivity.class);
                            startActivity(setting);
                        }

                        if (newitem == R.id.home) {
                            Intent home = new Intent(Tracker.this, MainActivity.class);
                            startActivity(home);
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



    @Override
    protected void onResume() {
        super.onResume();
        running = true;
        Sensor countSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        if(countSensor !=null){
            sensorManager.registerListener(this, countSensor, SensorManager.SENSOR_DELAY_UI);
        } else {
            Toast.makeText(this, "Sensor not found!", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onPause() {
        super.onPause();
        running = false;
    }


    @Override
    public void onSensorChanged(SensorEvent event) {
        if(running){
            tv_steps.setText(String.valueOf(event.values[0]));
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
