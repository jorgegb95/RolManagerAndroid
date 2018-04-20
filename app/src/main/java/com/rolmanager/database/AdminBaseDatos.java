package com.rolmanager.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminBaseDatos extends SQLiteOpenHelper {

    public AdminBaseDatos (Context context, String nombre, SQLiteDatabase.CursorFactory factory, int version){
        super(context, nombre, factory, version);
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table tableEspecies(id INTEGER PRIMARY KEY AUTOINCREMENT, nombre text,\n" +
                "        edadMedia INTEGER,\n" +
                "        edadAdulta INTEGER,\n" +
                "        pesoMinimo INTEGER,\n" +
                "        pesoMaximo INTEGER,\n" +
                "        alturaMinima FLOAT,\n" +
                "        alturaMaxima FLOAT,\n" +
                "        aspectos text,\n" +
                "        relacionOtrasEspecies text,\n" +
                "        imagen text)");

    }

    public void onUpgrade (SQLiteDatabase db, int version1, int version2){
        db.execSQL("drop table if exists tableEspecies");
        onCreate(db);
    }
}
