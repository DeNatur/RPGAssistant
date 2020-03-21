package com.rpgassistant.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.rpgassistant.fragments.CompendiumFragment;
import com.rpgassistant.fragments.ProfileFragment;


public class MainActivityPagerAdapter extends FragmentStatePagerAdapter {


    public MainActivityPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        switch (position){
            case 0:
                fragment = new ProfileFragment();
                break;
            case 1:
                fragment = new CompendiumFragment();
                break;
            default:
                fragment = new ProfileFragment();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
