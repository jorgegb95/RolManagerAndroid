package com.rolmanager.activity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.rolmanager.R;
import com.rolmanager.database.BaseDatos;

public class CrearPersonajeActivity extends AppCompatActivity {

    private EditText inputJugador;
    private EditText inputPersonaje;
    private EditText inputEdad;
    private EditText inputAltura;
    private Spinner spinnerEspecie;
    private Spinner spinnerClases;
    private RadioGroup radioButton;
    private Button guardar;

    private BaseDatos admindb;
    private SQLiteDatabase db;

    private String jugador;
    private String personaje;
    private String edad;
    private String altura;
    private String especie;
    private String clases;
    private String sexo;
    private ContentValues nuevoPersonaje;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_personaje);

        admindb=new BaseDatos(this, "DBLocal", null, 1);

        spinnerEspecie =(Spinner) findViewById(R.id.spinnerEspecie);
        spinnerClases =(Spinner) findViewById(R.id.spinnerClase);
        inputJugador = findViewById(R.id.inputJugador);
        inputPersonaje = findViewById(R.id.inputPersonaje);
        inputEdad = findViewById(R.id.inputEdad);
        inputAltura = findViewById(R.id.inputAltura);
        radioButton = (RadioGroup) findViewById(R.id.radioGroup);

        guardar = (Button) findViewById(R.id.buttonGuardar);
        guardar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                jugador=inputJugador.getText().toString();
                personaje=inputPersonaje.getText().toString();
                edad=inputEdad.getText().toString();
                altura=inputAltura.getText().toString();
                especie=spinnerEspecie.getSelectedItem().toString();
                clases=spinnerClases.getSelectedItem().toString();

                if(radioButton.getCheckedRadioButtonId() == R.id.radioButtonHombre){
                    sexo="Hombre";
                }else{
                    sexo="Mujer";
                }

                if(jugador.isEmpty() ||personaje.isEmpty() ||edad.isEmpty() ||altura.isEmpty() ||especie.isEmpty() ||clases.isEmpty()){
                    Toast.makeText(CrearPersonajeActivity.this, "Rellene todos los campos", Toast.LENGTH_SHORT).show();
                }else{
                    db = admindb.getWritableDatabase();

                    nuevoPersonaje = new ContentValues();
                    nuevoPersonaje.put("especie",especie);
                    nuevoPersonaje.put("sexo",sexo);
                    nuevoPersonaje.put("nombreJugador",jugador);
                    nuevoPersonaje.put("nombre",personaje);
                    nuevoPersonaje.put("edad",Integer.parseInt(edad));
                    nuevoPersonaje.put("altura",Double.valueOf(altura));
                    nuevoPersonaje.put("clase",clases);

                    Log.d("Nuevo personaje",nuevoPersonaje.toString());

                    db.insert("tablePersonajes", null, nuevoPersonaje);

                    Toast.makeText(CrearPersonajeActivity.this, "Nuevo personaje creado", Toast.LENGTH_SHORT).show();

                }
                finish();
            }
        });
    }

}
