package com.example.task3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListItem> listItems;
    JsonPlaceHolderApi jsonPlaceHolderApi;
    String heading = null;
    Retrofit retrofit;
    ListItem listItem ;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progressBar) ;
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        listItems = new ArrayList<>();
        adapter = new MyAdapter(listItems , this);
        recyclerView.setAdapter(adapter);

        retrofit = new Retrofit.Builder().baseUrl("https://pokeapi.co/api/v2/").addConverterFactory(GsonConverterFactory.create()).build();
        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        //image and name of the pokemon
        for(int i=1 ; i<=50 ; i++) {
            Call<Pokemon> call = jsonPlaceHolderApi.getPokemon(i);
            final String url = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + i + ".png";
//            listItem.setImage(url);
//            listItem.setDescription("desc");
            Log.i("initial place" , "hi");

            call.enqueue(new Callback<Pokemon>() {
                @Override
                public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                    if(!response.isSuccessful()){
                        Toast.makeText(MainActivity.this, "Could not connect :(", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    assert response.body() != null;
                    heading = response.body().getName();
                    listItem = new ListItem(heading , "description" , url);
                    listItems.add(listItem);
//                    listItem.setHeading(heading);
                    adapter.notifyDataSetChanged();
                    if(listItems.size() == 50){
                        progressBar.setVisibility(View.GONE);
                    }

                    Log.i("aur batao"  , heading);
                }

                @Override
                public void onFailure(Call<Pokemon> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "failure", Toast.LENGTH_SHORT).show();
                    Log.i("error bhai" , String.valueOf(t.getCause()));
                }
            });
            Log.i("final place" , "don dana done");
            adapter.notifyDataSetChanged();
        }



        adapter.notifyDataSetChanged();

    }

}
