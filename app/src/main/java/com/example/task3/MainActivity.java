package com.example.task3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.task3.fragments.FavouriteFragment;
import com.example.task3.fragments.ItemsFragment;
import com.example.task3.fragments.LocationFragment;
import com.example.task3.fragments.PokemonFragment;
import com.example.task3.fragments.RegionFragment;
import com.example.task3.fragments.TypesFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

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

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_pokemon : {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new PokemonFragment()).commit();
                break;
            }
            case R.id.nav_itmes : {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new ItemsFragment()).commit();
                break;
            }
            case R.id.nav_location : {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new LocationFragment()).commit();
                break;
            }
            case R.id.nav_types : {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new TypesFragment()).commit();
                break;
            }
            case R.id.nav_region : {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new RegionFragment()).commit();
                break;
            }
            case R.id.nav_fav : {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new FavouriteFragment()).commit();
                break;
            }
            case R.id.nav_share : {
                break;
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;    }
}
