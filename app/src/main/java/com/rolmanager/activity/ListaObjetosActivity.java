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
        /*fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crearObjeto(v);
            }
        });*/
    }

    /*public void crearObjeto(View v){
        Intent nuevoPersonajesView= new Intent(this, CrearObjetoActivity.class);
        startActivity(nuevoPersonajesView);
        finish();
    }*/
}
