package com.example.task3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

//    private RecyclerView recyclerView;
//    private RecyclerView.Adapter adapter;
//    private List<ListItem> listItems;
//    JsonPlaceHolderApi jsonPlaceHolderApi;
//    String heading = null;
//    String description = null;
//    String moves;
//    String statistics;
//    String types;
//    Retrofit retrofit;
//    ListItem listItem ;
//    ProgressBar progressBar;
    DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this , drawerLayout , toolbar , R.string.navigation_drawer_open , R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        if(savedInstanceState== null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer , new PokemonFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_pokemon);
        }
/*
        progressBar = (ProgressBar) findViewById(R.id.progressBar1) ;
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        listItems = new ArrayList<>();
        adapter = new MyAdapter(listItems , this);
        recyclerView.setAdapter(adapter);

        retrofit = new Retrofit.Builder().baseUrl("https://pokeapi.co/api/v2/").addConverterFactory(GsonConverterFactory.create()).build();
        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        //image and name and base_Experience of the pokemon
        for(int i=1 ; i<=20 ; i++) {
            Call<Pokemon> call = jsonPlaceHolderApi.getPokemon(i);
            final String url = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + i + ".png";
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

                    description = "Base Experience : ";
                    description += response.body().getExperience();

                    moves = response.body().getMoves().get(0).getMoveNames().getNames() + ", ";
                    moves += response.body().getMoves().get(1).getMoveNames().getNames() + ", ";
                    moves += response.body().getMoves().get(2).getMoveNames().getNames() + ", ";
                    moves += response.body().getMoves().get(3).getMoveNames().getNames();

                    statistics = "" ;
                    for(int j=0 ; j<5 ; j++) {
                        statistics += response.body().getStatistics().get(j).getStatName().getNames()
                                + " ( Base Percent " + response.body().getStatistics().get(j).getBaseStat() + " )\n";
                    }

                    types = "" ;
                    for(int j=0 ; j<response.body().getTypeNames().size() ; j++) {
                        types += response.body().getTypeNames().get(j).getType().getNames() + "\n";
                    }

                    listItem = new ListItem(heading , description , url , moves , statistics ,types );
                    listItems.add(listItem);
                    adapter.notifyDataSetChanged();
                    if(listItems.size() == 20){
                        progressBar.setVisibility(View.GONE);
                    }

                    Log.i("heading"  , heading);
                    Log.i("description"  , description);
                    Log.i("moves"  , moves);
                    Log.i("statistics"  , statistics);
                    Log.i("types"  , types);

                }

                @Override
                public void onFailure(Call<Pokemon> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "failure", Toast.LENGTH_SHORT).show();
                    Log.i("error bhai" , String.valueOf(t.getMessage()));
                }
            });
            Log.i("final place" , "don dana done");
            adapter.notifyDataSetChanged();
        }



        adapter.notifyDataSetChanged();
*/

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_pokemon :
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer , new PokemonFragment()).commit();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;    }
}
