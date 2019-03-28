package com.example.materialdesignapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.materialdesignapp.R;

public class AppBarLayout extends AppCompatActivity {
    Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appbarlayout_nestedscrollview);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("AppBarLayout");
    }
}
/*
	scroll: this flag should be set for all views that want to scroll off the screen
	- for views that do not use this flag, they’ll remain pinned to the top of the screen.

	enterAlways: this flag ensures that any downward scroll will cause this view to become visible,
	enabling the ‘quick return’ pattern.

	enterAlwaysCollapsed: When your view has declared a minHeight and you use this flag,
	your View will only enter at its minimum height (i.e., ‘collapsed’),
	only re-expanding to its full height when the scrolling view has reached it’s top.
	exitUntilCollapsed: this flag causes the view to scroll off until it is ‘collapsed’ (its minHeight)
	before exiting.
*/
