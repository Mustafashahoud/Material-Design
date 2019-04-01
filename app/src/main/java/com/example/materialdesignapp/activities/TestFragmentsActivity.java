package com.example.materialdesignapp.activities;

import android.content.IntentFilter;
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

public  class TestFragmentsActivity extends AppCompatActivity implements ActionListenerInterface {
    FragmentManager mFragmentManager;
    Button btnTestFrag;

    MyBroadcastReceiver mMyBroadcastReceiver;

    Fragment fragment;
    Fragment fragment2;
    TextView textView;

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter("android.intent.action.AIRPLANE_MODE");
        registerReceiver(mMyBroadcastReceiver, intentFilter );
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(mMyBroadcastReceiver);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_trasction_test);

        mMyBroadcastReceiver = new MyBroadcastReceiver();

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
            ((FirstFragment) fragment).setActionListerInterface(this);
        }else {// null case there is nothing in the container
            fragment = new FirstFragment();
            ((FirstFragment) fragment).setActionListerInterface(this);
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

    public void goToSecondFragWithBundle(Bundle bundle){

        fragment2 = new SecondFragment();
        fragment2.setArguments(bundle);
        FragmentTransaction ft = mFragmentManager.beginTransaction();
        ft.addToBackStack(fragment2.toString());
        ft.replace(R.id.containerTest, fragment2).commit();
    }

    @Override
    public void onCallbackListener(Bundle bundle) {
        int actionInt = bundle.getInt(ActionListenerInterface.keyForActionValue);
        //String valueReceived = bundle.getString(ActionListenerInterface.getKeyForStringValue, "This is Default");

        if (actionInt == ActionListenerInterface.ACTION_KEY){
            goToSecondFragWithBundle(bundle);
        }
    }
}
