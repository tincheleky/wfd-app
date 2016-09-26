package com.tin.whattoeat;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.tin.whattoeat.DataAdapter.NewEntryPagerAdapter;

public class NewDishActivity extends AppCompatActivity {


    private TabLayout tabLayout;
    private ViewPager viewPager;
    public static String TARGET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_dish);
        Intent intent = getIntent();

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar_new_entry);
        setSupportActionBar(toolbar);

        tabLayout = (TabLayout) findViewById(R.id.tablayout_new_entry);
        viewPager = (ViewPager) findViewById(R.id.viewpager_new_entry);

        tabLayout.addTab(tabLayout.newTab().setText("Detail"));
        tabLayout.addTab(tabLayout.newTab().setText("Description"));
        String target = intent.getStringExtra(TARGET);
        NewEntryPagerAdapter newEntryPagerAdapter = new NewEntryPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount(), "EDIT_MODE", target);
        viewPager.setAdapter(newEntryPagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

}
