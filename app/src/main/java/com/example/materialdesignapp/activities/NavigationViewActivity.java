package com.example.materialdesignapp.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.materialdesignapp.R;
import com.example.materialdesignapp.fragments.FirstFragment;
import com.example.materialdesignapp.fragments.SecondFragment;

public class NavigationViewActivity extends AppCompatActivity  {
    private static final String TAG = "NavigationViewActivity";
    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private TextView tvEmail;
    Context mContext = NavigationViewActivity.this;
    NavigationView mNavigationView;
    Fragment fragment =  null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_view);

        setupToolbarMenu();
        setupNavigationDrawerMenu();

    }

    private void setupToolbarMenu() {

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        ActionBar actionbar = getSupportActionBar();

        //The first way to add the Navigation Button to the Actionbar

        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

        //The Second way to add the Navigation Button to the Actionbar
        /*
        This for adding the navigation Drawer Button to the lift side of the actionBar
         */
 /*        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this,
                mDrawerLayout,
                mToolbar,
                R.string.drawer_open,
                R.string.drawer_close);

        mDrawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        */

        mToolbar.setTitle("Navigation View");
        mToolbar.inflateMenu(R.menu.menu_main);


    }

    private void setupNavigationDrawerMenu() {

        mNavigationView = (NavigationView) findViewById(R.id.navigationView);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
               // Class fragmentClass;
                switch (menuItem.getItemId()) {
                    case R.id.first:
                        fragment = (Fragment) new FirstFragment();
                        break;
                    case R.id.second:
                        fragment = (Fragment) new SecondFragment();
                        break;

                    default:
                        fragment = (Fragment) new FirstFragment();
                }

                // Insert the fragment by replacing any existing fragment
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit();

                // Highlight the selected item has been done by NavigationView
                menuItem.setChecked(true);
                // Set action bar title
                //setTitle(menuItem.getTitle());
                // Close the navigation drawer
                mDrawerLayout.closeDrawers();

                return true;
            }
        });


    }

    // Close the Drawer
    private void closeDrawer() {
        mDrawerLayout.closeDrawer(GravityCompat.START);
    }

    // Open the Drawer
    private void showDrawer() {
        mDrawerLayout.openDrawer(GravityCompat.START);
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START))
            closeDrawer();
        else
            super.onBackPressed();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}

