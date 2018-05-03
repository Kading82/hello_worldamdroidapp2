package com.example.august.hello_world;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class ListContentFragment extends Fragment {

    public ListContentFragment(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.list_tab, container, false);


        Bundle extras = getActivity().getIntent().getExtras();

        String message3 = extras.getString(MainActivity.EXTRA_MESSAGE5);
        TextView textViewtab1 = view.findViewById(R.id.textviewtab5);
        textViewtab1.setText("Age: " + message3);

        String message = extras.getString(MainActivity.EXTRA_MESSAGE);
        TextView textView = view.findViewById(R.id.textviewtab1);
        textView.setText("Thanks for Signing Up " + message +"!");

        String message2 = extras.getString(MainActivity.EXTRA_MESSAGE2);
        TextView textView2 = view.findViewById(R.id.textviewtab2);
        textView2.setText("Name: " + message2);

        String message5 = extras.getString(MainActivity.EXTRA_MESSAGE3);
        TextView textView1 = view.findViewById(R.id.textviewtab3);
        textView1.setText("Email: " + message5);

        String message4 = extras.getString(MainActivity.EXTRA_MESSAGE4);
        TextView textView4 = view.findViewById(R.id.textviewtab4);
        textView4.setText("Birthday: " + message4);

        Button btn = (Button) view.findViewById(R.id.button3);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }

        });
       return view;
    }


}
