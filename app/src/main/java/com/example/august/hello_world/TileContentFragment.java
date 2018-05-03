package com.example.august.hello_world;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TileContentFragment extends Fragment {

    public TileContentFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.mathces_tab, container, false);

        TextView textViewtab1 = view.findViewById(R.id.textViewmathces1);
        textViewtab1.setText("Matches will go here!!");

        return view;
    }
}