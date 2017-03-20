package com.example.ramices.projetoramices;

import android.location.Location;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


import com.example.ramices.projetoramices.fragment.MapaFragment;
import com.example.ramices.projetoramices.fragment.MuseuListFragment;
import com.example.ramices.projetoramices.fragment.TeatroListFragment;
import com.google.android.gms.location.LocationListener;


/**
 * Created by Ramices on 05/03/2017.
 */
public class TelaPrincipal extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener
{
     private FragmentManager fm;
    private MapaFragment map;
    private TeatroListFragment teatro;
    private MuseuListFragment museu;
    private DrawerLayout layout;
    private String key;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        fm = getSupportFragmentManager();
        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#4B0082")));

        map = new MapaFragment();
        museu = new MuseuListFragment();
        teatro = new TeatroListFragment();

        layout = (DrawerLayout) findViewById(R.id.layout);

        NavigationView navigationView = (NavigationView) findViewById(R.id.drawer);
        navigationView.setNavigationItemSelectedListener(this);

        if(savedInstanceState == null)
        {
            fm.beginTransaction().replace(R.id.telaPrincipal, map).addToBackStack("").commit();
            key = "map";
        }
        else
        {
            String aux = savedInstanceState.getString("chave");
            boolean bool = savedInstanceState.getBoolean("estado");

            if(bool)
            {
                layout.openDrawer(GravityCompat.START);
            }

            switch(aux)
            {
                case "map":
                    fm.beginTransaction().replace(R.id.telaPrincipal, map).addToBackStack("").commit();
                    key = "map";
                    break;

                case "teatro":
                    fm.beginTransaction().replace(R.id.telaPrincipal, teatro).addToBackStack("").commit();
                    key = "teatro";
                    break;

                case "museu":
                    key = "museu";
                    fm.beginTransaction().replace(R.id.telaPrincipal, museu).addToBackStack("").commit();
                    break;
            }

        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("chave", key);
        outState.putBoolean("estado", layout.isDrawerOpen(GravityCompat.START));

    }


    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        switch (item.getItemId())
        {
            case R.id.menu:
                if (layout.isDrawerOpen(GravityCompat.START)) {
                    layout.closeDrawer(GravityCompat.START);
                }
                else
                    if(!(item.getGroupId() == R.id.map))
                    layout.openDrawer(GravityCompat.START);

                return true;



            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed()
    {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer);

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected( MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.nav_mapa:
                if(!(item.getGroupId() == R.id.nav_mapa))
                {
                    fm.beginTransaction().replace(R.id.telaPrincipal, map).addToBackStack("").commit();
                    layout.closeDrawer(GravityCompat.START);
                    key = "map";
                }
                return true;

            case R.id.nav_teatro:
                if(!(item.getGroupId() == R.id.nav_teatro))
                {
                    fm.beginTransaction().replace(R.id.telaPrincipal, teatro).addToBackStack("").commit();
                    layout.closeDrawer(GravityCompat.START);
                    key = "teatro";
                }
                return true;

            case R.id.nav_museu:
                if(!(item.getGroupId() == R.id.nav_museu))
                {

                    fm.beginTransaction().replace(R.id.telaPrincipal, museu).addToBackStack("").commit();
                    layout.closeDrawer(GravityCompat.START);
                    key = "museu";
                }
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}



