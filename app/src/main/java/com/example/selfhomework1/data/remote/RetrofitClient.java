package com.example.selfhomework1.data.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private Retrofit provideRetrofit = new Retrofit.Builder()
            .baseUrl("https://cdn.jsdelivr.net")

            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public SuperHeroApi provideSuperHeroApi() {
        return provideRetrofit.create(SuperHeroApi.class);
    }
}
