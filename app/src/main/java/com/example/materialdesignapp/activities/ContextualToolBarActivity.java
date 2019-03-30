package com.example.materialdesignapp.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.materialdesignapp.R;

public class ContextualToolBarActivity extends AppCompatActivity {

    Toolbar mToolbar;
    Button contextual;
    ActionMode actionMode;
    Context mContext = ContextualToolBarActivity.this;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar_contextual);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("Mustafa !");
        mToolbar.setSubtitle("mustafa.shahoud@gmail.com !");

        contextual = (Button) findViewById(R.id.btnContextual);
        mToolbar.inflateMenu(R.menu.menu_main);
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {


            @Override
            public boolean onMenuItemClick(MenuItem item) {

                String title = (String) item.getTitle(); // here show how to get the title directly.

                Toast.makeText(ContextualToolBarActivity.this, title + " Selected !", Toast.LENGTH_SHORT).show();

                switch (item.getItemId()) {

                    case R.id.save:
                        // Perform the individual Menu Actions.
                        break;

                    case R.id.mail:
                        // Perform some Actions.
                        break;

                    // Similarly you can write CASES for other menu items as well.
                }
                return true;
            }
        });

        contextual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionMode = ContextualToolBarActivity.this.startActionMode(new ContextualCallback());

            }
        });
    }

    class ContextualCallback implements android.view.ActionMode.Callback {


        @Override
        public boolean onCreateActionMode(android.view.ActionMode actionMode, Menu menu) {
            actionMode.getMenuInflater().inflate(R.menu.contextual_menu, menu);

            return true;
        }

        @Override
        public boolean onPrepareActionMode(android.view.ActionMode actionMode, Menu menu) {
            actionMode.setTitle("This the Action Mode");
            actionMode.setSubtitle("Mustafa Shahoud");

            return false;
        }

        @Override
        public boolean onActionItemClicked(android.view.ActionMode actionMode, MenuItem item) {
            return false;
        }

        @Override
        public void onDestroyActionMode(android.view.ActionMode actionMode) {

        }
    }
}
