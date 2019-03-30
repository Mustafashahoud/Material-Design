package com.example.materialdesignapp.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.materialdesignapp.R;
import com.example.materialdesignapp.fragments.FirstFragment;
import com.example.materialdesignapp.fragments.SecondFragment;

public  class TestFragmentsActivity extends AppCompatActivity {
    FragmentManager mFragmentManager;
    Button btnTestFrag;

    Fragment fragment;
    TextView textView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_trasction_test);

        mFragmentManager = getSupportFragmentManager();
        textView = findViewById(R.id.logTextView);
        textView.setText("fragment count in back stack: " + mFragmentManager.getBackStackEntryCount());
        textView.setTextColor(getResources().getColor(R.color.white));


        mFragmentManager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                textView.setText("fragment count in back stack: " + mFragmentManager.getBackStackEntryCount());
            }
        });



        btnTestFrag = findViewById(R.id.addFrag);
        btnTestFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment ();
                textView.setText("fragment count in back stack: " + mFragmentManager.getBackStackEntryCount());

                StringBuilder stringBuilder = new StringBuilder("Current status of fragment transaction back stack:" +
                        mFragmentManager.getBackStackEntryCount() + "\n" );
                for (int index= (mFragmentManager.getBackStackEntryCount()-1) ; index>=0 ; index--){
                    FragmentManager.BackStackEntry entry = mFragmentManager.getBackStackEntryAt(index);
                    stringBuilder.append(entry.getName()+"\n");
                }
            }
        });
    }

    private void addFragment (){
        fragment = mFragmentManager.findFragmentById(R.id.containerTest);
        if (fragment instanceof FirstFragment){
            fragment = new SecondFragment();
        }else if (fragment instanceof SecondFragment){
            fragment = new FirstFragment();
        }else {// null case there is nothing in the container
            fragment = new FirstFragment();
        }
        FragmentTransaction ft = mFragmentManager.beginTransaction();
        ft.add(R.id.containerTest, fragment);

        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        Fragment fragment = mFragmentManager.findFragmentById(R.id.containerTest);
        if (fragment != null){
            FragmentTransaction ft = mFragmentManager.beginTransaction();
            ft.addToBackStack("Remove"+ fragment.toString());
            ft.remove(fragment).commit();

        }else
        super.onBackPressed();
    }
}
