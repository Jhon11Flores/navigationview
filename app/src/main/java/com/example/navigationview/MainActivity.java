package com.example.navigationview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener{
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navView = (NavigationView)findViewById(R.id.nav_view);
        navView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:

                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        boolean fragmentTransaction = false;
        Fragment fragment = null;
        int itemId = item.getItemId();
        if (itemId == R.id.menu_activo) {
            fragment = new Fragmentactivo();
            fragmentTransaction = true;
        } else if (itemId == R.id.menu_agregar) {
            fragment = new Fragmentagregarunestado();
            fragmentTransaction = true;
        } else if (itemId == R.id.menu_todos) {
            fragment = new Fragmentodoslosrecibidos();
            fragmentTransaction = true;
        } else if (itemId == R.id.menu_principal) {
            fragment = new Fragmentprincipal();
            fragmentTransaction = true;
        } else if (itemId == R.id.menu_promociones) {
            fragment = new Fragmentpromociones();
            fragmentTransaction = true;
        } else if (itemId == R.id.menu_social) {
            fragment = new Fragmentsocial();
            fragmentTransaction = true;
        } else if (itemId == R.id.menu_notificaciones) {
            fragment = new Fragmentnotificaciones();
            fragmentTransaction = true;
        } else if (itemId == R.id.menu_foros) {
            fragment = new Fragmentforos();
            fragmentTransaction = true;
        } else if (itemId == R.id.menu_destacados) {
            fragment = new Fragmentdestacados();
            fragmentTransaction = true;
        } else if (itemId == R.id.menu_pospuestos) {
            fragment = new Fragmentpospuestos();
            fragmentTransaction = true;
        }  else if (itemId == R.id.menu_importantes) {
            fragment = new Fragmentimportantes();
            fragmentTransaction = true;
        } else if (itemId == R.id.menu_enviados) {
            fragment = new Fragmentenviados();
            fragmentTransaction = true;
        } else if (itemId == R.id.menu_programados) {
            fragment = new Fragmentprogramados();
            fragmentTransaction = true;
        } else if (itemId == R.id.menu_salida) {
            fragment = new Fragmentsalida();
            fragmentTransaction = true;
        }

        if(fragmentTransaction) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame, fragment)
                    .commit();
            item.setChecked(true);
            getSupportActionBar().setTitle(item.getTitle());
        }
        drawerLayout.closeDrawers();
        return true;
    }

}

