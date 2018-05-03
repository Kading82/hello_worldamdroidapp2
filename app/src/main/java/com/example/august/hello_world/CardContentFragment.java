package com.example.august.hello_world;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CardContentFragment extends Fragment {

    public CardContentFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.settings_tab, container, false);

        TextView textViewtab1 = view.findViewById(R.id.textViewsettings1);
        textViewtab1.setText("Settings will go here!!");

        return view;
    }
}

