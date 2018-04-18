package com.rolmanager;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class EspeciesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_especies);
    }

    public void consulta(View view){
        AdminBaseDatos admin = new AdminBaseDatos(this, "especie", null, 1);

        SQLiteDatabase bd = admin.getWritableDatabase();

        Cursor fila = bd.rawQuery ("select * from tableEspecies where id="+1, null);

        if(fila.isFirst()){

        }else{

        }

        bd.close();
    }
}
