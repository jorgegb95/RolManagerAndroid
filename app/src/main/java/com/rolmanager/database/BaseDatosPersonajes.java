package com.rolmanager.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDatosPersonajes extends SQLiteOpenHelper {

    public BaseDatosPersonajes(Context context, String nombre, SQLiteDatabase.CursorFactory factory, int version){
        super(context, nombre, factory, version);
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table tablePersonajes(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre texto," +
                "nombreJugador texto," +
                "edad INTEGER," +
                "altura INTEGER," +
                "sexo texto," +
                "especie texto)");

    }


    public void onUpgrade (SQLiteDatabase db, int version1, int version2){
        db.execSQL("drop table if exists tableEspecies");
        onCreate(db);
    }
}
