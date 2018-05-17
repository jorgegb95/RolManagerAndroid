package com.rolmanager.activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.rolmanager.Adapter.AdapterListaArmaduras;
import com.rolmanager.Adapter.AdapterListaArmas;
import com.rolmanager.Adapter.AdapterListaItems;
import com.rolmanager.R;
import com.rolmanager.database.Armaduras;
import com.rolmanager.database.Armas;
import com.rolmanager.database.BaseDatos;
import com.rolmanager.database.Items;

import java.util.ArrayList;

public class ListaObjetosActivity extends AppCompatActivity {
    private ArrayList<Armaduras> listArmaduras=new ArrayList<Armaduras>();
    private ArrayList<Items> listaItems= new ArrayList<Items>();
    private ArrayList<Armas> listaArmas = new ArrayList<Armas>();
    private Armaduras auxArm=new Armaduras();
    private Items auxItem=new Items();
    private Armas auxArmas=new Armas();
    private BaseDatos admindb;
    private SQLiteDatabase db;
    private FloatingActionButton fabItem;
    private FloatingActionButton fabArma;
    private FloatingActionButton fabArmadura;
    private Spinner spinner;
    private SwipeMenuListView listView;
    private AdapterListaArmaduras adapterListaArmaduras;
    private AdapterListaItems adapterListaItems;
    private AdapterListaArmas adapterListaArmas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_objetos);

        admindb=new BaseDatos(this, "DBLocal", null, 1);
        db=admindb.getWritableDatabase();

        listView = (SwipeMenuListView) findViewById(R.id.listaObjetos);

        fabItem = findViewById(R.id.fabitems);
        fabItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crearItem(v);
            }
        });

        fabArma = findViewById(R.id.fabarmas);
        fabArma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crearArma(v);
            }
        });

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
                    cargarListaArmas(listView);
               }else if(position==2){
                   cargarListaArmaduras(listView);
               }else{
                    cargarListaItems(listView);
               }
           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });

        SwipeMenuCreator swipeMenuCreator = new SwipeMenuCreator() {
            @Override
            public void create(SwipeMenu menu) {
                SwipeMenuItem deleteItem = new SwipeMenuItem(
                        getApplicationContext());
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9,0x3F, 0x25)));
                deleteItem.setWidth(170);
                deleteItem.setIcon(R.drawable.delete);
                menu.addMenuItem(deleteItem);
            }
        };

        listView.setMenuCreator(swipeMenuCreator);

        listView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {

                if(spinner.getSelectedItemPosition()==0){//Items
                    auxItem=adapterListaItems.getItem(position);
                    String[] args = new String[] {auxItem.getNombre()};
                    db.execSQL("delete from tableItems where nombre=?", args);
                    adapterListaItems.remove(auxItem);
                    adapterListaItems.notifyDataSetChanged();
                    Toast.makeText(ListaObjetosActivity.this, "Item eliminado", Toast.LENGTH_SHORT).show();
                }else if(spinner.getSelectedItemPosition()==1){//Armas
                    auxArmas=adapterListaArmas.getItem(position);
                    String[] args=new String[]{auxArmas.getNombre(), String.valueOf(auxArmas.getNumManos())};
                    db.execSQL("delete from tableArmas where nombre=? and numManos=?", args);
                    adapterListaArmas.remove(auxArmas);
                    adapterListaArmas.notifyDataSetChanged();
                    Toast.makeText(ListaObjetosActivity.this, "Arma eliminada", Toast.LENGTH_SHORT).show();
                }else{//Armaduras
                    auxArm=adapterListaArmaduras.getItem(position);
                    String[] args=new String[]{auxArm.getNombre(), String.valueOf(auxArm.getCa()), String.valueOf(auxArm.getPenalizacion()), auxArm.getTipo()};
                    db.execSQL("delete from tableArmaduras where nombre=? and ca=? and penalizacion=? and tipo=?", args);
                    adapterListaArmaduras.remove(auxArm);
                    adapterListaArmaduras.notifyDataSetChanged();
                    Toast.makeText(ListaObjetosActivity.this, "Armadura eliminada", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });

    }

    public void crearArmadura(View v){
        Intent nuevoPersonajesView= new Intent(this, CrearArmaduraActivity.class);
        startActivity(nuevoPersonajesView);
        finish();
    }

    public void cargarListaArmaduras(SwipeMenuListView listView){
        db=admindb.getReadableDatabase();

        if(db!=null){
            Cursor c=db.rawQuery("select * from tableArmaduras", null);

            if(c.moveToFirst()){
                listArmaduras=new ArrayList<Armaduras>();

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

    public void crearArma(View v){
        Intent nuevoPersonajesView= new Intent(this, CrearArmaActivity.class);
        startActivity(nuevoPersonajesView);
        finish();
    }

    public void cargarListaArmas(SwipeMenuListView listView){
        db=admindb.getReadableDatabase();

        if(db!=null){
            Cursor c=db.rawQuery("select * from tableArmas", null);

            if(c.moveToFirst()){
                listaArmas=new ArrayList<Armas>();

                do{
                    Armas arma = new Armas();
                    arma.setNombre(c.getString(1));
                    arma.setNumManos(c.getInt(3));
                    arma.setAlcance(c.getInt(4));
                    arma.setDano(c.getString(2));
                    arma.setModIniciativa(c.getInt(5));
                    arma.setEfecto(c.getString(6));

                    listaArmas.add(arma);
                }while(c.moveToNext());

                adapterListaArmas=new AdapterListaArmas(this, listaArmas);
                listView.setAdapter(adapterListaArmas);
            }
        }
    }

    public void crearItem(View v){
        Intent nuevoPersonajesView= new Intent(this, CrearItemActivity.class);
        startActivity(nuevoPersonajesView);
        finish();
    }

    public void cargarListaItems(SwipeMenuListView listView){
        db=admindb.getReadableDatabase();

        if(db!=null){
            Cursor c=db.rawQuery("select * from tableItems", null);

            if(c.moveToFirst()){
                listaItems=new ArrayList<Items>();

                do{
                    Items items = new Items();
                    items.setNombre(c.getString(1));
                    items.setDescripcion(c.getString(2));

                    listaItems.add(items);
                }while(c.moveToNext());

                adapterListaItems=new AdapterListaItems(this, listaItems);
                listView.setAdapter(adapterListaItems);
            }
        }
    }
}
