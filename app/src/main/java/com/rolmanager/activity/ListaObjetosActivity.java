package com.rolmanager.activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.rolmanager.R;

public class ListaObjetosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_objetos);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabObjetos);
        FloatingActionButton fabItem = (FloatingActionButton) findViewById(R.id.fabitems);
        /*fabItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crearItem(v);
            }
        });*/

        FloatingActionButton fabArma = (FloatingActionButton) findViewById(R.id.fabarmas);
        /*fabArma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crearArma(v);
            }
        });*/

        FloatingActionButton fabArmadura = (FloatingActionButton) findViewById(R.id.fabarmaduras);
       /* fabItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crearArmadura(v);
            }
        });*/
    }

    /*public void crearArmadura(View v){
        Intent nuevoPersonajesView= new Intent(this, CrearObjetoActivity.class);
        startActivity(nuevoPersonajesView);
        finish();
    }*/

    /*public void crearArma(View v){
        Intent nuevoPersonajesView= new Intent(this, CrearArmaActivity.class);
        startActivity(nuevoPersonajesView);
        finish();
    }*/

    /*public void crearItem(View v){
        Intent nuevoPersonajesView= new Intent(this, CrearItemActivity.class);
        startActivity(nuevoPersonajesView);
        finish();
    }*/
}
