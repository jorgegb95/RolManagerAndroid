package com.rolmanager.activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.rolmanager.Adapter.AdapterListaArmaduras;
import com.rolmanager.R;
import com.rolmanager.database.Armaduras;
import com.rolmanager.database.BaseDatos;

import java.util.ArrayList;

public class ListaObjetosActivity extends AppCompatActivity {
    private ArrayList<Armaduras> listArmaduras;
    private Armaduras auxArm=new Armaduras();
    private BaseDatos admindb;
    private SQLiteDatabase db;
    private FloatingActionButton fabItem;
    private FloatingActionButton fabArma;
    private FloatingActionButton fabArmadura;
    private Spinner spinner;
    private SwipeMenuListView listView;
    private AdapterListaArmaduras adapterListaArmaduras;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_objetos);

        admindb=new BaseDatos(this, "DBLocal", null, 1);
        db=admindb.getWritableDatabase();

        listView = (SwipeMenuListView) findViewById(R.id.listaObjetos);

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

        SwipeMenuCreator swipeMenuCreator = new SwipeMenuCreator() {
            @Override
            public void create(SwipeMenu menu) {
                // create "delete" item
                SwipeMenuItem deleteItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9,
                        0x3F, 0x25)));
                // set item width
                deleteItem.setWidth(170);
                // set a icon
                deleteItem.setIcon(R.drawable.delete);
                // add to menu
                menu.addMenuItem(deleteItem);
            }
        };

        listView.setMenuCreator(swipeMenuCreator);

        listView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                auxArm=adapterListaArmaduras.getItem(position);
                String[] args=new String[]{auxArm.getNombre(), String.valueOf(auxArm.getCa()), String.valueOf(auxArm.getPenalizacion()), auxArm.getTipo()};
                db.execSQL("delete from tableArmaduras where nombre=? and ca=? and penalizacion=? and tipo=?", args);
                adapterListaArmaduras.remove(auxArm);
                adapterListaArmaduras.notifyDataSetChanged();
                return false;
            }
        });

    }

    public void cargarListaArmaduras(SwipeMenuListView listView){
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

                adapterListaArmaduras=new AdapterListaArmaduras(this, listArmaduras);
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
