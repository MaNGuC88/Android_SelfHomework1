package com.example.selfhomework1.data.remote;

import com.example.selfhomework1.data.models.SuperHero;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SuperHeroApi {

    @GET("/id")
    Call<List<SuperHero>> gerHeroes();

    @GET("/id/{name}")
    Call<SuperHero> getHero(
            @Path("name") String name
    );
}
