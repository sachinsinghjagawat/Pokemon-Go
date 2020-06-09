package com.example.task3.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.task3.JsonPlaceHolderApi;
import com.example.task3.R;
import com.example.task3.adapterBhaibandhu.ItemsItem;
import com.example.task3.adapters.ItemsAdapter;
import com.example.task3.adapters.MyAdapter;
import com.example.task3.dataCollection.Category;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ItemsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ItemsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ItemsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ItemsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ItemsFragment newInstance(String param1, String param2) {
        ItemsFragment fragment = new ItemsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    ProgressBar progressBar;
    RecyclerView recyclerView;
    List <ItemsItem> listItems;
    ItemsItem listItem;
    private RecyclerView.Adapter adapter;
    Retrofit retrofit;
    JsonPlaceHolderApi jsonPlaceHolderApi;
    int count = 0;
    int currentCount = 0;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_items, container, false);
        progressBar = (ProgressBar) rootView.findViewById(R.id.progressBarItems);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerViewItems);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listItems = new ArrayList<>();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new ItemsAdapter(ItemsFragment.this , listItems);
        recyclerView.setAdapter(adapter);


        retrofit = new Retrofit.Builder().baseUrl("https://pokeapi.co/api/v2/").addConverterFactory(GsonConverterFactory.create()).build();
        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        // starting from here
        for(int i=1 ; i<=20 ; i++){
            Call<Category> call = jsonPlaceHolderApi.getItems(i);

            call.enqueue(new Callback<Category>() {
                @Override
                public void onResponse(Call<Category> call, Response<Category> response) {
                    if(!response.isSuccessful()){
                        Toast.makeText(getActivity(), "Could not connect :(", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    String temp = response.body().getName();
                    String name = temp.substring(0 , 1).toUpperCase() + temp.substring(1);
                    String flingPower = "Fling Power :-" + response.body().getFlingPower();
                    String category = response.body().getCategory().getName();
                    String heldByPokemon = "";
                    String effectEntriesEffect = "Effect :- ";
                    String effectEntriesShortEffect = "Short Effect :-";

                    int max = 0;
                    if(response.body().getHeldByPokemon().size() <= 5){
                        max = response.body().getHeldByPokemon().size();
                    }else{
                        max = 5;
                    }
                    for(int j=0 ; j< max ; j++){
                        heldByPokemon += response.body().getHeldByPokemon().get(j).getName() + "\n" ;
                    }
                    if(response.body().getEffectEntries().size() <= 5){
                        max = response.body().getEffectEntries().size();
                    }else{
                        max = 5;
                    }
                    for(int j=0 ; j< max ; j++){
                        effectEntriesEffect += response.body().getEffectEntries().get(j).getEffect() + "\n" ;
                        effectEntriesShortEffect += response.body().getEffectEntries().get(j).getShortEffect() + "\n";
                    }
                    String effectEntry = effectEntriesEffect + effectEntriesShortEffect ;
                    listItem = new ItemsItem(name , flingPower, category , heldByPokemon , effectEntry);
                    listItems.add(listItem);
                    adapter.notifyDataSetChanged();
                    if(listItems.size() == 20){
                        progressBar.setVisibility(View.GONE);
                    }
                    Log.i("Items bhai" , name);
                    Log.i("Items bhai" , flingPower);
                    Log.i("Items bhai" , category);
                    Log.i("Items bhai" , heldByPokemon);
                    Log.i("Items bhai" , effectEntry);

                }

                @Override
                public void onFailure(Call<Category> call, Throwable t) {
                    Toast.makeText(getActivity(), "failure", Toast.LENGTH_SHORT).show();
                    Log.i("error bhai" , String.valueOf(t.getMessage()));
                }
            });
        }
    }
}