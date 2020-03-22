package com.rpgassistant.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Space;
import android.widget.TextView;

import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;
import com.luseen.spacenavigation.SpaceOnClickListener;
import com.rpgassistant.R;
import com.rpgassistant.adapters.MainActivityPagerAdapter;
import com.rpgassistant.utils.NonSwipeableViewPager;

public class MainActivity extends AppCompatActivity {

    NonSwipeableViewPager pager;
    TextView titleTV;
    MainActivityPagerAdapter mainActivityPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        final SpaceNavigationView spaceNavigationView = (SpaceNavigationView) findViewById(R.id.space);
        spaceNavigationView.initWithSaveInstanceState(savedInstanceState);
        spaceNavigationView.addSpaceItem(new SpaceItem(getResources().getString(R.string.home), R.drawable.knight));
        spaceNavigationView.addSpaceItem(new SpaceItem(getResources().getString(R.string.compendium), R.drawable.book));
        spaceNavigationView.showIconOnly();

        pager = findViewById(R.id.viewPager);
        mainActivityPagerAdapter = new MainActivityPagerAdapter(getSupportFragmentManager(), 0);
        pager.setAdapter(mainActivityPagerAdapter);

        spaceNavigationView.setSpaceOnClickListener(new SpaceOnClickListener() {
            @Override
            public void onCentreButtonClick() {

            }

            @Override
            public void onItemClick(int itemIndex, String itemName) {
                pager.setCurrentItem(itemIndex);
            }

            @Override
            public void onItemReselected(int itemIndex, String itemName) { }});

    }
}
