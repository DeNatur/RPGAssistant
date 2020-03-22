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
            return
                    oldItem.getName().equals(newItem.getName()) &&
                    oldItem.getStatsJson().equals(newItem) &&
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
        holder.heroClassTV.setText(hero.getProperHeroClass(0) + " lvl" + hero.getLvls()[0]);
        holder.avatarIV.setImageResource(hero.getIconResource());

    }

    public Hero getHeroAt(int position){
        return getItem(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView heroNameTV, heroClassTV;
        ImageView avatarIV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            heroNameTV = itemView.findViewById(R.id.heroNameTV);
            heroClassTV = itemView.findViewById(R.id.heroClassTV);
            avatarIV = itemView.findViewById(R.id.heroAvatarIV);
        }
    }
}
