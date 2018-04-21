package com.rolmanager.activity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.rolmanager.Adapter.AdapterEspecies;
import com.rolmanager.R;
import com.rolmanager.database.BaseDatosEspecies;
import com.rolmanager.database.Especies;
import com.rolmanager.database.Personajes;

import java.util.ArrayList;

public class ListaPersonajesActivity extends AppCompatActivity {

    private BaseDatosEspecies admindb;
    private SQLiteDatabase db;
    private ArrayList<Personajes> listaPersonajes;
    private Personajes personaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_personajes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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


                    listaPersonajes.add(personaje);

                }while(c.moveToNext());
            }
        }
    }

}
