package com.example.dizzer.testtaskappa.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.dizzer.testtaskappa.R;
import com.example.dizzer.testtaskappa.adapter.CustomPagerAdapter;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.view_pager_main_activity);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout_main_activity);

        viewPager.setAdapter(new CustomPagerAdapter(getSupportFragmentManager(),MainActivity.this));
        tabLayout.setupWithViewPager(viewPager);
    }
}
