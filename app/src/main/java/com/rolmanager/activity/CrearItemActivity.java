package com.rolmanager.activity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.rolmanager.R;
import com.rolmanager.database.BaseDatos;

public class CrearItemActivity extends AppCompatActivity {
    private EditText inputNombre;
    private EditText inputDescripcion;
    private Button guardar;

    private String nombre;
    private String descripcion;
    private ContentValues nuevoItem;

    private BaseDatos admindb;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_item);

        admindb=new BaseDatos(this, "DBLocal", null, 1);

        inputNombre = (EditText) findViewById(R.id.inputNuevoNombreItem);
        inputDescripcion = (EditText) findViewById(R.id.textAreaNuevaDescripcionItem);

        guardar = (Button) findViewById(R.id.buttonGuardarItem);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nombre=inputNombre.getText().toString();
                descripcion=inputDescripcion.getText().toString();

                if(nombre.isEmpty() || descripcion.isEmpty()){
                    Toast.makeText(CrearItemActivity.this, "Rellene todos los campos", Toast.LENGTH_SHORT).show();
                }else{
                    db=admindb.getWritableDatabase();

                    nuevoItem=new ContentValues();
                    nuevoItem.put("nombre", nombre);
                    nuevoItem.put("descripcion", descripcion);

                    db.insert("tableItems", null, nuevoItem);

                    Toast.makeText(CrearItemActivity.this, "Nuevo item creado", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }
}
