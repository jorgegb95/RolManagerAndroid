package com.rolmanager.activity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.rolmanager.R;
import com.rolmanager.database.BaseDatos;

public class CrearArmaduraActivity extends AppCompatActivity {
    private EditText inputNombre;
    private EditText inputCA;
    private EditText inputPenalizacion;
    private Spinner spinnerTipo;
    private Button guardar;

    private String nombre;
    private String ca;
    private String penalizacion;
    private String tipo;
    private ContentValues nuevaArmadura;

    private BaseDatos admindb;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_armadura);

        admindb=new BaseDatos(this, "DBLocal", null, 1);

        inputNombre = (EditText) findViewById(R.id.editTextNuevoNombreArmadura);
        inputCA = (EditText) findViewById(R.id.editTextNuevoCaArmadura);
        inputPenalizacion = (EditText) findViewById(R.id.editTextNuevoPenalizacionArmadura);
        spinnerTipo = (Spinner) findViewById(R.id.spinnerTipo);

        guardar = (Button) findViewById(R.id.buttonGuardarArmadura);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nombre=inputNombre.getText().toString();
                ca=inputCA.getText().toString();
                penalizacion=inputPenalizacion.getText().toString();
                tipo=spinnerTipo.getSelectedItem().toString();

                if(nombre.isEmpty() ||ca.isEmpty() ||penalizacion.isEmpty() ||tipo.isEmpty()){
                    Toast.makeText(CrearArmaduraActivity.this, "Rellene todos los campos", Toast.LENGTH_SHORT).show();
                }else{
                    db=admindb.getWritableDatabase();

                    nuevaArmadura=new ContentValues();
                    nuevaArmadura.put("nombre", nombre);
                    nuevaArmadura.put("ca", Integer.parseInt(ca));
                    nuevaArmadura.put("penalizacion", Integer.parseInt(penalizacion));
                    nuevaArmadura.put("tipo", tipo);

                    db.insert("tableArmaduras", null, nuevaArmadura);

                    Toast.makeText(CrearArmaduraActivity.this, "Nueva armadura creada", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }
}
