package com.example.task3.fragments;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.task3.JsonPlaceHolderApi;
import com.example.task3.adapterBhaibandhu.ListItem;
import com.example.task3.adapters.ItemsAdapter;
import com.example.task3.adapters.MyAdapter;
import com.example.task3.adapters.RegionAdapter;
import com.example.task3.dataCollection.Pokemon;
import com.example.task3.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PokemonFragment extends Fragment {

    private PokemonViewModel mViewModel;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter1;
    private List<ListItem> listItems ;
    JsonPlaceHolderApi jsonPlaceHolderApi;
    String heading = null;
    String description = null;
    String moves;
    String statistics;
    String types;
    Retrofit retrofit;
    ListItem listItem ;
    ProgressBar progressBar;

    public static PokemonFragment newInstance() {
        return new PokemonFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.pokemon_fragment, container, false);
        progressBar = (ProgressBar) rootView.findViewById(R.id.progressBar);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);


        return rootView;



    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(PokemonViewModel.class);
//         TODO: Use the ViewModel

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listItems = new ArrayList<>();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter1 = new MyAdapter(listItems , PokemonFragment.this);
        try {
            recyclerView.setAdapter(adapter1);
        }catch (Exception e){
            Log.i("bhaijan" , e.getMessage());
        }


        retrofit = new Retrofit.Builder().baseUrl("https://pokeapi.co/api/v2/").addConverterFactory(GsonConverterFactory.create()).build();
        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        //image and name and base_Experience of the pokemon. I have set progress bar disappear on 30 items so as to avoid irritation of user
        for(int i=1 ; i<=50 ; i++) {
            Call<Pokemon> call = jsonPlaceHolderApi.getPokemon(i);
            final String url = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + i + ".png";
            Log.i("initial place" , "hi");

            call.enqueue(new Callback<Pokemon>() {
                @Override
                public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                    if(!response.isSuccessful()){
                        Toast.makeText(getActivity(), "Could not connect :(", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    assert response.body() != null;
                    String temp = response.body().getName();
                    heading = temp.substring(0 , 1).toUpperCase() + temp.substring(1);

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
                    adapter1.notifyDataSetChanged();
                    if(listItems.size() == 30){
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
//                    Toast.makeText(getActivity(), "failure", Toast.LENGTH_SHORT).show();
                    Log.i("error bhai" , String.valueOf(t.getMessage()));
                }
            });
            Log.i("final place" , "don dana done");
            adapter1.notifyDataSetChanged();
        }

        adapter1.notifyDataSetChanged();
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        MenuItem searchItem = menu.findItem(R.id.search);
        SearchView searchView =  (SearchView) searchItem.getActionView() ;
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            public MyAdapter adapter = (MyAdapter) adapter1;

            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.i("Pressed" , "Submit");
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.i("pressed" , "Change");
                adapter.getFilter().filter(newText);
                return true;
            }
        });

        super.onCreateOptionsMenu(menu, inflater);
    }

}