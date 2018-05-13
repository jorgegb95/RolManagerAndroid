package com.rolmanager.activity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;


import com.rolmanager.Adapter.AdapterViewPage;
import com.rolmanager.R;
import com.rolmanager.database.BaseDatos;
import com.rolmanager.database.Personajes;


public class DetallesPersonajeActivity extends FragmentActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private String valor;
    private AdapterViewPage adapterViewPage;
    private BaseDatos admindb;
    private SQLiteDatabase db;
    private Personajes personaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_personaje);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        AdapterViewPage tabViewPagerAdapter = new AdapterViewPage(getSupportFragmentManager());


        tabLayout.setupWithViewPager(viewPager);
        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(tabViewPagerAdapter);

        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            valor = extras.getString("id");
        }

        admindb=new BaseDatos(this, "DBLocal", null, 1);
        db = admindb.getReadableDatabase();

        String[] args= new String[]{extras.getString("id")};

        Cursor c=db.rawQuery("select * from tablePersonajes where id=?", args);

        if(c.moveToFirst()){
            personaje=new Personajes();
            personaje.setNombre(c.getString(1));
            personaje.setNombreJugador(c.getString(2));
            personaje.setEspecie(c.getString(7));
            personaje.setEdad(c.getInt(3));
            personaje.setAltura(c.getDouble(4));
            personaje.setSexo(c.getString(5));
            personaje.setClase(c.getString(6));
            personaje.setId(c.getInt(c.getInt(0)));

            tabViewPagerAdapter.setPersonaje(personaje);
        }

    }
}
