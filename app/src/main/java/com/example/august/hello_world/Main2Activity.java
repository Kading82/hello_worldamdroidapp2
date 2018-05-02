package com.example.august.hello_world;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class Main2Activity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

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

    // Add Fragments to Tabs
    private void setupViewPager(ViewPager viewPager) {
        Adapter adapter = new Adapter(getSupportFragmentManager());
        adapter.addFragment(new ListContentFragment(), "List");
        adapter.addFragment(new TileContentFragment(), "Tile");
        adapter.addFragment(new CardContentFragment(), "Card");
        viewPager.setAdapter(adapter);
    }

    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public Adapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    public void button2(View b){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}
