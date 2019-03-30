package com.example.materialdesignapp.activities;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.materialdesignapp.R;

public class StandAloneToolBarActivity extends AppCompatActivity {
    Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar_standalone);

         mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("Mustafa");
        mToolbar.setSubtitle("Mustafa.shahoud@gmail.com");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            mToolbar.setElevation(10f);
        }

        setupMenu();
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

                Toast.makeText(StandAloneToolBarActivity.this, msg + " clicked !", Toast.LENGTH_SHORT).show();

                return true;
            }
        });
    }
}
