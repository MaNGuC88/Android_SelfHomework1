package com.example.selfhomework1.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.selfhomework1.data.interfaces.OnItemClickListener;
import com.example.selfhomework1.data.models.SuperHero;
import com.example.selfhomework1.databinding.ItemSuperheroBinding;

import java.util.ArrayList;
import java.util.List;

public class SuperHeroAdapter extends RecyclerView.Adapter<SuperHeroAdapter.SuperHeroViewHolder> {

    private List<SuperHero> superHeroes = new ArrayList<>();
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setSuperHeroes(List<SuperHero> superHeroes) {
        this.superHeroes = superHeroes;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SuperHeroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemSuperheroBinding binding =ItemSuperheroBinding.inflate(LayoutInflater
                .from(parent.getContext()), parent, false);
        return new SuperHeroViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SuperHeroViewHolder holder, int position) {
        holder.onBind(superHeroes.get(position));
    }

    @Override
    public int getItemCount() {
        return superHeroes.size();
    }

    public SuperHero getItem(int position) {
        return superHeroes.get(position);
    }

    public class SuperHeroViewHolder extends RecyclerView.ViewHolder {

        private ItemSuperheroBinding binding;

        public SuperHeroViewHolder(@NonNull ItemSuperheroBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(getAdapterPosition());
                }
            });
        }

        public void onBind(SuperHero superHero) {
            binding.superheroName.setText(superHero.getName());
            binding.publisher.setText(superHero.getPublisher());
        }
    }
}
