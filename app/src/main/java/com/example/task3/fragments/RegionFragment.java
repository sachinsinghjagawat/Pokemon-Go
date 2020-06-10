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
import com.example.task3.R;
import com.example.task3.adapterBhaibandhu.ItemsItem;
import com.example.task3.adapterBhaibandhu.RegionItem;
import com.example.task3.adapters.ItemsAdapter;
import com.example.task3.adapters.LoctionAdapter;
import com.example.task3.adapters.RegionAdapter;
import com.example.task3.dataCollection.Category;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegionFragment extends Fragment {

    private RegionViewModel mViewModel;
    ProgressBar progressBar;
    RecyclerView recyclerView;
    List<RegionItem> listItems;
    RegionItem listItem;
    private RecyclerView.Adapter adapter;
    Retrofit retrofit;
    JsonPlaceHolderApi jsonPlaceHolderApi;


    public static RegionFragment newInstance() {
        return new RegionFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.region_fragment, container, false);
        progressBar = (ProgressBar) rootView.findViewById(R.id.progressBarRegion);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerViewRegion);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(RegionViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listItems = new ArrayList<>();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new RegionAdapter(RegionFragment.this , listItems);
        recyclerView.setAdapter(adapter);


        retrofit = new Retrofit.Builder().baseUrl("https://pokeapi.co/api/v2/").addConverterFactory(GsonConverterFactory.create()).build();
        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        // starting from here
        for(int i=1 ; i<=7 ; i++){
            Call<Category> call = jsonPlaceHolderApi.getRegions(i);

            call.enqueue(new Callback<Category>() {
                @Override
                public void onResponse(Call<Category> call, Response<Category> response) {
                    if(!response.isSuccessful()){
                        Toast.makeText(getActivity(), "Could not connect :(", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    String temp = response.body().getName();
                    String name = temp.substring(0 , 1).toUpperCase() + temp.substring(1);
                    String location = "";
                    String pokedoxes = "";

                    int max = 0;
                    if(response.body().getLocations().size() <= 5){
                        max = response.body().getLocations().size();
                    }else{
                        max = 5;
                    }
                    for(int j=0 ; j< max ; j++){
                        location += response.body().getLocations().get(j).getName() + "\n";
                    }

                    if(response.body().getPokedexes().size() <= 5){
                        max = response.body().getPokedexes().size();
                    }else{
                        max = 5;
                    }
                    for(int j=0 ; j< max ; j++){
                        location += response.body().getPokedexes().get(j).getName() + "\n";
                    }

                    listItem = new RegionItem(name , location , pokedoxes);
                    listItems.add(listItem);
                    adapter.notifyDataSetChanged();
                    if(listItems.size() == 7){
                        progressBar.setVisibility(View.GONE);
                    }
                    Log.i("Region bhai" , "ok");


                }

                @Override
                public void onFailure(Call<Category> call, Throwable t) {
//                    Toast.makeText(getActivity(), "failure", Toast.LENGTH_SHORT).show();
                    Log.i("error bhai" , String.valueOf(t.getMessage()));
                }
            });
        }
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        MenuItem searchItem = menu.findItem(R.id.search);
        SearchView searchView =  (SearchView) searchItem.getActionView() ;
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            public RegionAdapter adapter1 = (RegionAdapter) adapter;

            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.i("Pressed" , "Submit");
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.i("pressed" , "Change");
                adapter1.getFilter().filter(newText);
                return true;
            }
        });

        super.onCreateOptionsMenu(menu, inflater);
    }

}