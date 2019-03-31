package com.example.materialdesignapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.materialdesignapp.R;

public class SecParcebleActivity extends AppCompatActivity {

    TextView tvReceived;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec_parcelable);
        tvReceived =findViewById(R.id.tvReceived);

        Intent intent = getIntent();

        ParcelableDataModel obj = intent.getParcelableExtra("this message is being send from MainActivity");
        tvReceived.setText(obj.getFirstName() + " " + obj.getLastName() +" " + obj.getDegree());


    }
}
