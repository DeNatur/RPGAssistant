package com.rpgassistant.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rpgassistant.R;
import com.rpgassistant.adapters.HeroesAdapter;
import com.rpgassistant.models.Hero;
import com.rpgassistant.utils.ListDecorator;
import com.rpgassistant.viewmodels.HeroViewModel;

import java.util.ArrayList;
import java.util.List;

public class HeroesFragment extends Fragment {
    RecyclerView heroesRecycler;

    private HeroViewModel heroViewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.heroes_fragment, container, false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        heroesRecycler = view.findViewById(R.id.heroesRV);


        final HeroesAdapter adapter = new HeroesAdapter();
        heroesRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        heroesRecycler.addItemDecoration(new ListDecorator(getContext()));
        heroesRecycler.setAdapter(adapter);

        heroViewModel = new ViewModelProvider(this).get(HeroViewModel.class);
        heroViewModel.getAllHeroes().observe(this, new Observer<List<Hero>>() {
            @Override
            public void onChanged(List<Hero> heroes) {
                adapter.submitList(heroes);
            }
        });
    }
}
