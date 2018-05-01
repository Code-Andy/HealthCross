package com.examples.android.healthcross;

/**
 * Created by Andy on 4/28/2018.
 */

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
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;

public class DetailsActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    WebView webView;
    ProgressBar loader;
    String url = "";
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        loader = findViewById(R.id.loader);
        webView = findViewById(R.id.webView);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        webView.loadUrl(url);

        mDrawerLayout = findViewById(R.id.Drawer_Layout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        NavigationView navigationView = findViewById(R.id.navview);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        int newitem = menuItem.getItemId();

                        if (newitem == R.id.about) {
                            Intent info = new Intent(DetailsActivity.this, InfoActivity.class);
                            startActivity(info);
                        }

                        if (newitem == R.id.tracker) {
                            Intent tracker = new Intent(DetailsActivity.this, Tracker.class);
                            startActivity(tracker);
                        }

                        if (newitem == R.id.tracker) {
                            Intent tracker = new Intent(DetailsActivity.this, SettingsActivity.class);
                            startActivity(tracker);
                        }

                        if (newitem == R.id.home) {
                            Intent home = new Intent(DetailsActivity.this, MainActivity.class);
                            startActivity(home);
                        }

                        if (newitem == R.id.news) {
                            Intent news = new Intent(DetailsActivity.this, NewsActivity.class);
                            startActivity(news);
                        }


                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here

                        return true;
                    }
                });

        webView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                if (progress == 100) {
                    loader.setVisibility(View.GONE);
                } else {
                    loader.setVisibility(View.VISIBLE);
                }
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }

        if (id == R.id.emergency) {
            Intent call = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "911"));
            startActivity(call);
        }
        return super.onOptionsItemSelected(item);
    }
}