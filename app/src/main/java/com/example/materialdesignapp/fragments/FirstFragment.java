package com.example.materialdesignapp.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.materialdesignapp.R;
import com.example.materialdesignapp.activities.ActionListenerInterface;

import java.util.zip.Inflater;

public class FirstFragment extends Fragment implements View.OnClickListener {
    ImageView imageView;

    Button button;
    ActionListenerInterface mActionListenerInterface;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        button = view.findViewById(R.id.go);
        button.setOnClickListener(this);

        return view;
    }

    public void setActionListerInterface(ActionListenerInterface mActionListenerInterface ){
        this.mActionListenerInterface = mActionListenerInterface;
    }

    @Override
    public String toString() {
        return FirstFragment.class.getSimpleName();
    }

    public void goToSecondFragment(){
        Bundle bundle = new Bundle();
        bundle.putInt(ActionListenerInterface.keyForActionValue, ActionListenerInterface.ACTION_KEY);
        bundle.putString(ActionListenerInterface.getKeyForStringValue, "Fuck You");
        mActionListenerInterface.onCallbackListener(bundle);
    }

    @Override
    public void onClick(View v) {

        if (mActionListenerInterface != null){
            goToSecondFragment();
        }
    }
}
