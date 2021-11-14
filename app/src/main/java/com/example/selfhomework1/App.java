package com.example.selfhomework1;

import android.app.Application;

import com.example.selfhomework1.data.remote.RetrofitClient;
import com.example.selfhomework1.data.remote.SuperHeroApi;

public class App extends Application {

    private RetrofitClient retrofitClient;
    public static SuperHeroApi api;

    @Override
    public void onCreate() {
        super.onCreate();
        retrofitClient = new RetrofitClient();
        api = retrofitClient.provideSuperHeroApi();
    }

}
