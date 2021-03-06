package com.rolmanager.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDatos extends SQLiteOpenHelper {

    public BaseDatos(Context context, String nombre, SQLiteDatabase.CursorFactory factory, int version){
        super(context, nombre, factory, version);
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table if not exists tableEspecies(id INTEGER PRIMARY KEY AUTOINCREMENT, nombre text,\n" +
                "        edadMedia INTEGER,\n" +
                "        edadAdulta INTEGER,\n" +
                "        pesoMinimo INTEGER,\n" +
                "        pesoMaximo INTEGER,\n" +
                "        alturaMinima FLOAT,\n" +
                "        alturaMaxima FLOAT,\n" +
                "        aspectos text,\n" +
                "        relacionOtrasEspecies text,\n" +
                "        imagen text)");

        db.execSQL("create table if not exists tablePersonajes(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre texto," +
                "nombreJugador texto," +
                "edad INTEGER," +
                "altura FLOAT," +
                "sexo texto," +
                "clase texto,"+
                "especie texto)");

        db.execSQL("create table if not exists tableArmaduras(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre texto," +
                "ca INTEGER," +
                "penalizacion INTEGER,"+
                "tipo texto)");

        db.execSQL("create table if not exists tableItems(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre texto,"+
                "descripcion texto)");

        db.execSQL("create table if not exists tableArmas(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre texto,"+
                "daño texto,"+
                "numManos INTEGER,"+
                "alcance INTEGER,"+
                "modIniciativa INTEGER,"+
                "efecto texto)");
    }

    public void onUpgrade (SQLiteDatabase db, int version1, int version2){
        db.execSQL("drop table if exists tableEspecies");
        onCreate(db);
    }

}
