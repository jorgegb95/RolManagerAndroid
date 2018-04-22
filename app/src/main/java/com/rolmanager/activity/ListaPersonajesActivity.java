package com.rolmanager.activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;


import com.rolmanager.Adapter.AdapterListaPersonajes;
import com.rolmanager.R;
import com.rolmanager.database.BaseDatosPersonajes;
import com.rolmanager.database.Personajes;

import java.util.ArrayList;

public class ListaPersonajesActivity extends AppCompatActivity {

    private BaseDatosPersonajes admindb;
    private SQLiteDatabase db;
    private ArrayList<Personajes> listaPersonajes;
    private Personajes personaje;
    private RecyclerView recycler;
    private RecyclerView.LayoutManager lManager;
    private RecyclerView.Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_personajes);

        admindb=new BaseDatosPersonajes(this, "DBPersonajes", null, 1);

        cargarListaJugadores();

    }

    private void cargarListaJugadores(){
        db=admindb.getReadableDatabase();

        if(db!=null){
            Cursor c = db.rawQuery("select * from tablePersonajes", null);

            if(c.moveToFirst()){
                listaPersonajes=new ArrayList<Personajes>();

                do{
                    personaje = new Personajes();
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

                lManager = new LinearLayoutManager(this);
                recycler.setLayoutManager(lManager);

                adapter = new AdapterListaPersonajes(listaPersonajes);
                recycler.setAdapter(adapter);
            }
        }
    }

    public void crearPersonaje(View v){
        Intent nuevoPersonajesView= new Intent(this, NuevoPersonajeActivity.class);
        startActivity(nuevoPersonajesView);
    }

}