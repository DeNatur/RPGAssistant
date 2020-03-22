package com.rpgassistant.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.gigamole.navigationtabstrip.NavigationTabStrip;
import com.rpgassistant.R;
import com.rpgassistant.adapters.HeroesPartyPagerAdapter;

public class ProfileFragment extends Fragment {
    NavigationTabStrip navigationTabBar;
    ViewPager pager;
    ImageView roundoutline;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.profile_fragment, container, false);

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navigationTabBar = view.findViewById(R.id.navigationTabBar);
        pager = view.findViewById(R.id.pager);
        roundoutline = view.findViewById(R.id.round_outline);
        roundoutline.setClipToOutline(true);

        HeroesPartyPagerAdapter heroesPartyPagerAdapter =new HeroesPartyPagerAdapter(getParentFragmentManager(),0);
        pager.setAdapter(heroesPartyPagerAdapter);
        navigationTabBar.setViewPager(pager);
    }
}
