package com.rolmanager.activity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.widget.ToggleButton;

import com.rolmanager.Adapter.AdapterEspecies;
import com.rolmanager.database.BaseDatos;
import com.rolmanager.R;
import com.rolmanager.database.Especies;

import java.util.ArrayList;

public class EspeciesActivity extends AppCompatActivity {

    private BaseDatos admindb;
    private SQLiteDatabase db;
    private ArrayList<Especies> listaEspecies;
    private Especies especie;
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_especies);

        admindb=new BaseDatos(this, "DBLocal", null, 1);
        SQLiteDatabase db = admindb.getWritableDatabase();

        if(db!=null){
            admindb.onUpgrade(db, 1, 2);

            db.execSQL("insert into tableEspecies \n" +
                    "        (nombre,edadMedia,edadAdulta,pesoMinimo ,pesoMaximo ,alturaMinima ,alturaMaxima ,aspectos ,relacionOtrasEspecies ,imagen)\n" +
                    "        VALUES\n" +
                    "        ('Elfos',280,40,35,90,1.20,2.30,'+1 Carisma, +1 Destreza, +5 a las pruebas de otear, Vision en la oscuridad casi absoluta, -1 Constitucion','No son amigos de relacionarse con otras especies, aunque les agrada la compañia de gnomos y medianos. A los humanos los respetan, pero prefieren mantenerse distantes hasta que los conocen. Suelen ser hostiles con los enanos, desprecian a los trasgos y odian a los orcos','@drawable/elfo.png');\n" +
                    "    ");

            db.execSQL("insert into tableEspecies \n" +
                    "        (nombre,edadMedia,edadAdulta,pesoMinimo ,pesoMaximo ,alturaMinima ,alturaMaxima ,aspectos ,relacionOtrasEspecies ,imagen)\n" +
                    "        VALUES\n" +
                    "        ('Enanos',200,30,80,120,1.10,1.60,'+1 Constitución, -1 Carisma, visión en la infraoscuridad, +5 a orientarse bajo la superficie, +2 a todas las TS contra efectos mágicos','Si tienen que elegir prefieren a humanos. Gnomos y medianos, cuando consiguen ganarse el respeto de los enanos, suelen ser tratados de forma paternalista. Los elfos son friamente respetados y debidos a historias anteriores mantienen un cortes distanciamiento. Sienten desprecios por los trasgos y un odio profundo por los orcos','@drawable/enano.png');\n");

            db.execSQL("insert into tableEspecies \n" +
                    "        (nombre,edadMedia,edadAdulta,pesoMinimo ,pesoMaximo ,alturaMinima ,alturaMaxima ,aspectos ,relacionOtrasEspecies ,imagen)\n" +
                    "        VALUES\n" +
                    "        ('Humanos',70,16,35,60,0.90,1.20,'Aprendizaje rápido +2, Punto de Fortuna +1','Los humanos son una de las especies que más cómoda se encuentra junto a representantes de las demás.','@drawable/humano.png');\n");

            db.execSQL("insert into tableEspecies \n" +
                    "        (nombre,edadMedia,edadAdulta,pesoMinimo ,pesoMaximo ,alturaMinima ,alturaMaxima ,aspectos ,relacionOtrasEspecies ,imagen)\n" +
                    "        VALUES\n" +
                    "        ('Gnomos',70,12,35,90,1.20,2.30,'+1 Destreza, +1 Inteligencia, +5 a la pericia de olfatear, saborear y escuchar, -1 Fuerza, +1 Punto de Fortuna','Los gnomos, para sus correrías, prefieren a humanos y elfos, y se llevan perfectamente bien con medianos. Con respecto los medianos, los soportan hasta que empiezan a ser paternalistas. A los orcos les temen y no comprenden su brutalidad, mientras que a los trasgos oscila de un extremos a otro.','@drawable/gnomo.png');\n");

            db.execSQL("insert into tableEspecies \n" +
                    "        (nombre,edadMedia,edadAdulta,pesoMinimo ,pesoMaximo ,alturaMinima ,alturaMaxima ,aspectos ,relacionOtrasEspecies ,imagen)\n" +
                    "        VALUES\n" +
                    "        ('Medianos',120,22,35,60,0.90,1.30,'+1 Destreza, -1 Fuerza, visión en la infraoscuridad, +5 a orientarse bajo la superficie, +2 a todas las TS contra efectos mágicos, +1 Punto de Fortuna','Los mejores compañeros de viaje para los medianos son los gnomos, auque tambien aceptan agradablemente a los medianos. No les desagrada viajar con elfos y humanos pero consideran que ambas son un tanto estiradas y preocupadas por todo','@drawable/medianos.png');\n");

            db.execSQL("insert into tableEspecies \n" +
                    "        (nombre,edadMedia,edadAdulta,pesoMinimo ,pesoMaximo ,alturaMinima ,alturaMaxima ,aspectos ,relacionOtrasEspecies ,imagen)\n" +
                    "        VALUES\n" +
                    "        ('Orcos',50,12,60,120,1.20,1.80,'+1 Fuerza, +1 Constitución, visión en la infraoscuridad, +5 a la pericia de olfatear, saborear y escuchar), -1 Inteligencia, -3 a cualquier tirada con una fuerte luz solar','Prefieren a los humanos como compañeros, aunque los consideran débiles y más bien blanditos. A los elfos y enanos los desprecian, aunque reconocen el valor de los primeros y la fiereza de los últimos en batalla. A los gnomos y medianos los aborrecen. Sienten un profundo odio hacia los trasgos por haberlos expulsados de sus territorios en el pasado.','@drawable/orco.png');\n");

            db.execSQL("insert into tableEspecies \n" +
                    "        (nombre,edadMedia,edadAdulta,pesoMinimo ,pesoMaximo ,alturaMinima ,alturaMaxima ,aspectos ,relacionOtrasEspecies ,imagen)\n" +
                    "        VALUES\n" +
                    "        ('Trasgos',50,12,30,70,0.80,1.50,'Ágil , Visión en la infraoscuridad, +5 a la pericia de olfatear, saborear y escuchar), -1 Constitución y +1 Punto de Fortuna','Temen y odian a los orcos casi tanto como estos les desprecian. Como compañeros de aventura prefieren a los humanos; el sentimiento no es recíproco. Los trasgos desconfían mucho de los enanos y los elfos. Los gnomos y los medianos suelen ser vistos como seres inferiores.','@drawable/trasgo.png');\n");

            db.close();
        }

        cargarLista();

    }

    private void cargarLista(){
        db=admindb.getReadableDatabase();

        if(db!=null){
            Cursor c = db.rawQuery("select * from tableEspecies", null);

            if(c.moveToFirst()){
                listaEspecies=new ArrayList<Especies>();
                listaEspecies.clear();

                do{
                    especie = new Especies();
                    especie.setNombre(c.getString(1));
                    especie.setEdadMedia(c.getInt(2));
                    especie.setEdadAdulta(c.getInt(3));
                    especie.setPesoMinimo(c.getInt(4));
                    especie.setPesoMaximo(c.getInt(5));
                    especie.setAlturaMinima(c.getDouble(6));
                    especie.setAlturaMaxima(c.getDouble(7));
                    especie.setAspectos(c.getString(8));
                    especie.setRelacion(c.getString(9));
                    especie.setImagen(c.getInt(10));

                    listaEspecies.add(especie);

                }while(c.moveToNext());


                recycler = (RecyclerView) findViewById(R.id.reciclador);
                recycler.setHasFixedSize(true);

                lManager = new LinearLayoutManager(this);
                recycler.setLayoutManager(lManager);

                adapter = new AdapterEspecies(listaEspecies, this);
                recycler.setAdapter(adapter);
            }
        }
    }

}
