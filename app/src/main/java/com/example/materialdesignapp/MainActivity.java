package com.example.materialdesignapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnStandaloneToolbar;
    Button btnContextualToolbar;
    Button btnAppbarLayout;
    Button btnCollapsingToolbarLayout;
    Button btnNavigationView;
    Button btnRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //widgets link
        btnStandaloneToolbar = findViewById(R.id.standaloneToolbar);
        btnContextualToolbar = findViewById(R.id.contextualMenu);
        btnAppbarLayout = findViewById(R.id.appbarLayout);
        btnCollapsingToolbarLayout = findViewById(R.id.btnCollapsingToolbarLayout);
        btnNavigationView = findViewById(R.id.btnNavigationView);
        btnRecyclerView = findViewById(R.id.btnRecyclerView);

        //Button click listeners
        btnContextualToolbar.setOnClickListener(this);
        btnStandaloneToolbar.setOnClickListener(this);
        btnAppbarLayout.setOnClickListener(this);
        btnCollapsingToolbarLayout.setOnClickListener(this);
        btnNavigationView.setOnClickListener(this);
        btnRecyclerView.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.standaloneToolbar:
                Intent intent1 = new Intent(MainActivity.this,StandAloneToolBarActivity.class);
                startActivity(intent1);
                 break;

            case R.id.contextualMenu:
                Intent intent2 = new Intent(MainActivity.this,ContextualToolBarActivity.class);
                startActivity(intent2);
                break;

            case R.id.appbarLayout:
                Intent intent3 = new Intent(MainActivity.this, AppBarLayout.class);
                startActivity(intent3);
                break;

            case R.id.btnCollapsingToolbarLayout:
                Intent intent4 = new Intent(MainActivity.this, CollapsingToolBarLayoutActivity.class);
                startActivity(intent4);
                break;
            case R.id.btnNavigationView:
                Intent intent5 = new Intent(MainActivity.this, NavigationViewActivity.class);
                startActivity(intent5);
                break;
            case R.id.btnRecyclerView:
                Intent intent6 = new Intent(MainActivity.this, RecyclerViewActivity.class);
                startActivity(intent6);
                break;

        }


    }
}
