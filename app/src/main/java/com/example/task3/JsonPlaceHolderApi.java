package com.example.task3;

import com.example.task3.dataCollection.Category;
import com.example.task3.dataCollection.Pokemon;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JsonPlaceHolderApi {

    @GET ("pokemon/{id}")
    Call<Pokemon> getPokemon (@Path("id") int id);

    @GET ("type/{id}")
    Call<Category> getTypes (@Path("id") int id);

    @GET ("region/{id}")
    Call<Category> getRegions (@Path("id") int id);

    @GET ("location/{id}")
    Call<Category> getLocations (@Path("id") int id);

    @GET ("item/{id}")
    Call<Category> getItems (@Path("id") int id);



}
