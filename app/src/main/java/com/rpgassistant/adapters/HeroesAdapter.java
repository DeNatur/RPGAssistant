package com.rpgassistant.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.rpgassistant.R;
import com.rpgassistant.models.Hero;

public class HeroesAdapter extends ListAdapter<Hero, HeroesAdapter.ViewHolder> {

    public HeroesAdapter() { super(DIFF_CALLBACK); }
    private static final DiffUtil.ItemCallback<Hero> DIFF_CALLBACK = new DiffUtil.ItemCallback<Hero>() {
        @Override
        public boolean areItemsTheSame(@NonNull Hero oldItem, @NonNull Hero newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Hero oldItem, @NonNull Hero newItem) {
            String oldHeroClass = "", newHeroClass = "", oldHeroLvl = "", newHeroLvl = "";
            for (int value : oldItem.getHeroClasses()){
                oldHeroClass = oldHeroClass + String.valueOf(value);
            }
            for (int value : newItem.getHeroClasses()){
                newHeroClass = newHeroClass + String.valueOf(value);
            }
            for (int value : oldItem.getLvls()){
                oldHeroLvl = oldHeroLvl + String.valueOf(value);
            }
            for (int value : newItem.getLvls()){
                newHeroLvl = newHeroLvl + String.valueOf(value);
            }
            return  oldHeroClass.equals(newHeroClass) &&
                    oldHeroLvl.equals(newHeroLvl) &&
                    oldItem.getName().equals(newItem.getName()) &&
                    oldItem.getStatsJson().equals(newItem.getStatsJson()) &&
                    oldItem.getType() == newItem.getType();
        }
    };

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hero,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Hero hero = getHeroAt(position);
        holder.heroNameTV.setText(hero.getName());
        holder.heroClassTV.setText(hero.getProperHeroClass(0) + " lvl " + hero.getLvls()[0]);
        holder.avatarIV.setImageResource(hero.getIconResource());
        switch (hero.getType()){
            default:
                holder.heroTypeTV.setText("D&D 5e");
        }

    }

    public Hero getHeroAt(int position){
        return getItem(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView heroNameTV, heroClassTV, heroTypeTV;
        ImageView avatarIV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            heroNameTV = itemView.findViewById(R.id.heroNameTV);
            heroClassTV = itemView.findViewById(R.id.heroClassTV);
            heroTypeTV = itemView.findViewById(R.id.heroTypeTV);
            avatarIV = itemView.findViewById(R.id.heroAvatarIV);
        }
    }
}
