package com.example.august.hello_world;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        // Get the Intent that started this activity and extract the string
        Bundle extras = getIntent().getExtras();
        String message = extras.getString(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.textView3);
        textView.setText("Thanks for Signing Up " + message +"!");

        String message2 = extras.getString(MainActivity.EXTRA_MESSAGE2);
        TextView textView2 = findViewById(R.id.textView2);
        textView2.setText("Name: " + message2);

        String message3 = extras.getString(MainActivity.EXTRA_MESSAGE3);
        TextView textView1 = findViewById(R.id.textView1);
        textView1.setText("Email: " + message3);

        String message4 = extras.getString(MainActivity.EXTRA_MESSAGE4);
        TextView textView4 = findViewById(R.id.textView4);
        textView4.setText("Birthday: " + message4);

        String message5 = extras.getString(MainActivity.EXTRA_MESSAGE5);
        TextView textView5 = findViewById(R.id.textView5);
        textView5.setText("Age: " + message5);


    }

    public void button2(View b){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
