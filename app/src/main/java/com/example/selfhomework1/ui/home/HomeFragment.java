package com.example.selfhomework1.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.selfhomework1.App;
import com.example.selfhomework1.R;
import com.example.selfhomework1.data.interfaces.OnItemClickListener;
import com.example.selfhomework1.data.models.SuperHero;
import com.example.selfhomework1.databinding.FragmentHomeBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    public FragmentHomeBinding binding;
    private SuperHeroAdapter adapter;

    public HomeFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new SuperHeroAdapter();

        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                SuperHero superHero = adapter.getItem(position);
                if (superHero != null) {

                }
            }
        });
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.recycler.setAdapter(adapter);

        App.api.gerHeroes().enqueue(new Callback<List<SuperHero>>() {
            @Override
            public void onResponse(Call<List<SuperHero>> call, Response<List<SuperHero>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    adapter.setSuperHeroes(response.body());
                    Log.e("Naima", "Success: " + response.body().toString());
                } else {
                    Log.e("Naima2", "onFailure: " + response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<List<SuperHero>> call, Throwable t) {
                Log.e("Naima3", "onFailure" + t.getLocalizedMessage());
            }
        });
    }
}