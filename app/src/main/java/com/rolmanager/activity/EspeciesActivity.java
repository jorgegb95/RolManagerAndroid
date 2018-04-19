package com.rolmanager.activity;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.rolmanager.Adapter.AdaptadorEspecies;
import com.rolmanager.database.AdminBaseDatos;
import com.rolmanager.R;
import com.rolmanager.database.Especies;

import java.util.ArrayList;

public class EspeciesActivity extends AppCompatActivity {

    private AdminBaseDatos admindb;
    private SQLiteDatabase db;
    private ListView lvLista;
    private Especies[] listaEspecies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_especies);

        lvLista = (ListView) findViewById(R.id.lvEspecies);
        admindb = new AdminBaseDatos(this, "DBEspecies", null, 1);

    }

    private void cargarLista(){
        db=admindb.getReadableDatabase();

        if(db!=null){
            Cursor c = db.rawQuery("select * from tableEspecies order by id asc", null);

            if(c.moveToFirst()){
                listaEspecies=new Especies[c.getCount()];

                int i=0;
                do{
                    listaEspecies[i] = new Especies();
                    listaEspecies[i].setNombre(c.getString(0));
                    listaEspecies[i].setEdadAdulta(c.getInt(1));
                    listaEspecies[i].setEdadMedia(c.getInt(2));
                    listaEspecies[i].setPesoMinimo(c.getInt(3));
                    listaEspecies[i].setPesoMinimo(c.getInt(4));
                    listaEspecies[i].setPesoMaximo(c.getInt(5));
                    listaEspecies[i].setAlturaMinima(c.getDouble(6));
                    listaEspecies[i].setAlturaMaxima(c.getDouble(7));
                    listaEspecies[i].setAspectos(c.getString(8));
                    listaEspecies[i].setRelacion(c.getString(9));
                    i++;
                }while(c.moveToNext());

                AdaptadorEspecies adaptadorEspecies=new AdaptadorEspecies(this, listaEspecies);

                lvLista = (ListView) findViewById(R.id.lvEspecies);
                lvLista.setAdapter(adaptadorEspecies);
            }
        }
    }

}
