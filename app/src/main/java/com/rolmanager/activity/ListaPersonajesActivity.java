package com.rolmanager.activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;


import com.rolmanager.Adapter.AdapterListaPersonajes;
import com.rolmanager.R;
import com.rolmanager.database.BaseDatos;
import com.rolmanager.database.Personajes;

import java.util.ArrayList;

public class ListaPersonajesActivity extends AppCompatActivity {

    private BaseDatos admindb;
    private SQLiteDatabase db;
    private ArrayList<Personajes> listaPersonajes;
    private Personajes personaje;
    private RecyclerView recycler;
    private AdapterListaPersonajes adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_personajes);

        admindb=new BaseDatos(this, "DBLocal", null, 1);

        cargarListaJugadores();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crearPersonaje(v);
            }
        });
    }

    private void cargarListaJugadores(){
        db=admindb.getReadableDatabase();

        if(db!=null){
            Cursor c = db.rawQuery("select * from tablePersonajes", null);

            if(c.moveToFirst()){
                listaPersonajes=new ArrayList<Personajes>();

                do{
                    personaje = new Personajes();
                    personaje.setId(c.getInt(0));
                    personaje.setNombre(c.getString(1));
                    personaje.setAltura(c.getDouble(4));
                    personaje.setEdad(c.getInt(3));
                    personaje.setNombreJugador(c.getString(2));
                    personaje.setSexo(c.getString(5));
                    personaje.setEspecie(c.getString(6));

                    listaPersonajes.add(personaje);

                }while(c.moveToNext());

                recycler = (RecyclerView) findViewById(R.id.recicladorListaPersonajes);
                recycler.setHasFixedSize(true);

                adapter = new AdapterListaPersonajes(listaPersonajes);
                recycler.setAdapter(adapter);

                recycler.setItemAnimator(new DefaultItemAnimator());
            }
        }
    }

    public void crearPersonaje(View v){
        Intent nuevoPersonajesView= new Intent(this, CrearPersonajeActivity.class);
        startActivity(nuevoPersonajesView);
        finish();
    }

}
