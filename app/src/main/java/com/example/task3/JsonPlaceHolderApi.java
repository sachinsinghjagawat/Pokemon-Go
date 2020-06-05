package com.example.task3;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JsonPlaceHolderApi {

    @GET ("pokemon/{id}")
    Call<Pokemon> getPokemon (@Path("id") int id);


}
