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

public class CrearArmaActivity extends AppCompatActivity {
    private EditText inputNombre;
    private EditText inputDano;
    private EditText inputManos;
    private EditText inputAlcance;
    private EditText inputInic;
    private EditText inputEfecto;
    private Button guardar;

    private String nombre;
    private String dano;
    private String manos;
    private String alcance;
    private String inic;
    private String efecto;
    private ContentValues nuevaArma;

    private BaseDatos admindb;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_arma);

        admindb=new BaseDatos(this, "DBLocal", null, 1);

        inputNombre = (EditText) findViewById(R.id.inputNuevoNombreArma);
        inputDano = (EditText) findViewById(R.id.inputNuevoDanoArma);
        inputManos = (EditText) findViewById(R.id.inputNuevoManosArma);
        inputAlcance = (EditText) findViewById(R.id.inputNuevoRangoArma);
        inputInic = (EditText) findViewById(R.id.inputNuevoInicArma);
        inputEfecto = (EditText) findViewById(R.id.inputNuevoEfectoArma);

        guardar = (Button) findViewById(R.id.buttonGuardarArmadura);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nombre=inputNombre.getText().toString();
                dano=inputDano.getText().toString();
                manos=inputManos.getText().toString();
                alcance=inputAlcance.getText().toString();
                inic=inputInic.getText().toString();
                efecto=inputEfecto.getText().toString();

                if(nombre.isEmpty() || dano.isEmpty() || manos.isEmpty() || alcance.isEmpty() || inic.isEmpty() || efecto.isEmpty()){
                    Toast.makeText(CrearArmaActivity.this, "Rellene todos los campos", Toast.LENGTH_SHORT).show();
                }else{
                    db=admindb.getWritableDatabase();

                    nuevaArma=new ContentValues();
                    nuevaArma.put("nombre", nombre);
                    nuevaArma.put("daño", dano);
                    nuevaArma.put("numManos", Integer.parseInt(manos));
                    nuevaArma.put("alcance", alcance);
                    nuevaArma.put("modInicitiava", Integer.parseInt(inic));
                    nuevaArma.put("efecto", efecto);

                    db.insert("tableArmas", null, nuevaArma);

                    Toast.makeText(CrearArmaActivity.this, "Nueva arma creada", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }
}
