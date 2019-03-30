package com.example.materialdesignapp.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.materialdesignapp.R;

public class CollapsingToolBarLayoutActivity extends AppCompatActivity {
    Toolbar mToolbar ;
    CardView mCardView;
    Context mContext;
    CollapsingToolbarLayout mCollapsingToolbarLayout;
    AppBarLayout appBarLayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing_toolbar_layout);

        //toolbar
        mToolbar =findViewById(R.id.toolbar);
        mToolbar.setTitle("This is Toolbar");
        setupMenu();

        //AppbarLayout
        appBarLayout = findViewById(R.id.appbar);

        //CollapsingToolbarLayout
        mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbar);
        mCollapsingToolbarLayout.setTitle("Collapsing Title");


        //To set the title only when it's collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = true;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    mCollapsingToolbarLayout.setTitle("Title");
                    isShow = true;
                } else if(isShow) {
                    mCollapsingToolbarLayout.setTitle(" ");//carefully there should a space between double quote otherwise it won't work
                    isShow = false;
                }
            }
        });


    }

    public void setupMenu(){
        mToolbar.inflateMenu(R.menu.menu_main);

        /*For Toolbar as action bar we should do

         * 1- setSupportActionBar(mToolbar)

         * 2- Override onCreateOptionsMenu(Menu menu){
         * getMenuInflater().inflate(R.menu.menu_main, menu)
         * return true;

         * 3- Override onOptionItemSelected (){
         * */
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                String title = menuItem.getTitle().toString();
                // Toast.makeText(StandAloneToolBarActivity.this, title  + "Selected!"  , Toast.LENGTH_LONG).show();

                String msg = "";

                switch (menuItem.getItemId()) {

                    case R.id.save:
                        msg = "Save"; /*getString(R.string.save)*/
                        break;

                    case R.id.mail:
                        msg = "Mail"; /*getString(R.string.mail)*/
                        break;

                    case R.id.camera:
                        msg = "Camera"; /*getString(R.string.camera)*/
                        break;

                    case R.id.settings:
                        msg = "Setting";/*getString(R.string.settings);*/
                        break;

                    case R.id.web_search:
                        msg = "Search";/*getString(R.string.web_search)*/
                        break;

                    case R.id.help:
                        msg = "Help"; /*getString(R.string.help)*/
                        break;
                }
                Toast.makeText(CollapsingToolBarLayoutActivity.this, msg + " clicked !", Toast.LENGTH_SHORT).show();

                return true;
            }
        });
    }
}
