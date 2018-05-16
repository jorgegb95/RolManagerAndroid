package com.rolmanager.activity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Spinner;

import com.rolmanager.Adapter.AdapterListaArmaduras;
import com.rolmanager.R;
import com.rolmanager.database.Armaduras;
import com.rolmanager.database.BaseDatos;

import java.util.ArrayList;

public class ListaObjetosActivity extends AppCompatActivity {
    private ArrayList<Armaduras> listArmaduras;
    private BaseDatos admindb;
    private SQLiteDatabase db;
    private FloatingActionButton fabItem;
    private FloatingActionButton fabArma;
    private FloatingActionButton fabArmadura;
    private Spinner spinner;
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_objetos);

        admindb=new BaseDatos(this, "DBLocal", null, 1);

        listView = (ListView) findViewById(R.id.listaObjetos);

        fabItem = (FloatingActionButton) findViewById(R.id.fabitems);
        /*fabItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crearItem(v);
            }
        });*/

        fabArma = (FloatingActionButton) findViewById(R.id.fabarmas);
        /*fabArma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crearArma(v);
            }
        });*/

        fabArmadura = (FloatingActionButton) findViewById(R.id.fabarmaduras);
       /* fabItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crearArmadura(v);
            }
        });*/

       spinner = (Spinner) findViewById(R.id.spinnerOjetos);
       if (spinner.getSelectedItem().toString().compareToIgnoreCase("Items")==1){

       }else if(spinner.getSelectedItem().toString().compareToIgnoreCase("Armas")==1){

       }else{
           cargarListaArmaduras(listView);
       }

    }

    public void cargarListaArmaduras(ListView listView){
        db=admindb.getReadableDatabase();

        if(db!=null){
            Cursor c=db.rawQuery("select * from tableArmaduras", null);

            if(c.moveToFirst()){
                listArmaduras=new ArrayList<Armaduras>();
                listArmaduras.clear();

                do{
                    Armaduras armadura = new Armaduras();
                    armadura.setNombre(c.getString(1));
                    armadura.setCa(c.getInt(2));
                    armadura.setPenalizacion(c.getInt(3));

                    listArmaduras.add(armadura);
                }while(c.moveToNext());

                AdapterListaArmaduras adapterListaArmaduras=new AdapterListaArmaduras(this, listArmaduras);
                listView.setAdapter(adapterListaArmaduras);
            }
        }

    }

    /*public void crearArmadura(View v){
        Intent nuevoPersonajesView= new Intent(this, CrearArmaduraActivity.class);
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
