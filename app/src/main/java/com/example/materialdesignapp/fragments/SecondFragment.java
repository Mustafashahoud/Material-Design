package com.example.materialdesignapp.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.materialdesignapp.R;
import com.example.materialdesignapp.activities.ActionListenerInterface;

public class SecondFragment extends Fragment {
    ImageView imageView;

    TextView textView;

    String dataReceived;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        textView = (TextView) view.findViewById(R.id.textReceived);


        return view;
    }
    @Override
    public String toString() {
        return SecondFragment.class.getSimpleName();
    }

    @Override
    public void onResume() {
        super.onResume();
        textView.setText(dataReceived);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle !=  null){
            dataReceived = bundle.getString(ActionListenerInterface.getKeyForStringValue, "This is a Default value");
        }

    }
}
