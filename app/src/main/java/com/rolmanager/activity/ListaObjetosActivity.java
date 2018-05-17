package com.rolmanager.activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;
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

        fabItem = findViewById(R.id.fabitems);
        /*fabItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crearItem(v);
            }
        });*/

        fabArma = findViewById(R.id.fabarmas);
        /*fabArma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crearArma(v);
            }
        });*/

        fabArmadura = findViewById(R.id.fabarmaduras);
        fabArmadura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crearArmadura(v);
            }
        });

       spinner = (Spinner) findViewById(R.id.spinnerOjetos);
       spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               if (position==1){

               }else if(position==2){
                   cargarListaArmaduras(listView);
               }else{

               }
           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });

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
                    armadura.setTipo(c.getString(4));

                    listArmaduras.add(armadura);
                }while(c.moveToNext());

                AdapterListaArmaduras adapterListaArmaduras=new AdapterListaArmaduras(this, listArmaduras);
                listView.setAdapter(adapterListaArmaduras);
            }
        }

    }

    public void crearArmadura(View v){
        Intent nuevoPersonajesView= new Intent(this, CrearArmaduraActivity.class);
        startActivity(nuevoPersonajesView);
        finish();
    }

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
