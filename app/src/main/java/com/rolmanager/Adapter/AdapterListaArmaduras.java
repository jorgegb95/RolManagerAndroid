package com.rolmanager.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import com.rolmanager.R;
import com.rolmanager.database.Armaduras;

import java.util.ArrayList;

public class AdapterListaArmaduras extends ArrayAdapter<Armaduras> {
    private TextView nombre;
    private EditText ca;
    private EditText penalizacion;
    private ArrayList<Armaduras> armaduras;

    public AdapterListaArmaduras(Context context, ArrayList<Armaduras> armaduras) {
        super(context, R.layout.lista_armaduras, armaduras);
        this.armaduras=armaduras;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.lista_armaduras, null);

        nombre = (TextView) item.findViewById(R.id.lblNombreArmadura);
        nombre.setText(armaduras.get(position).getNombre());

        ca = (EditText) item.findViewById(R.id.editTextCA);
        ca.setText(armaduras.get(position).getCa());

        penalizacion = (EditText) item.findViewById(R.id.editTextPenalizacion);
        penalizacion.setText(armaduras.get(position).getPenalizacion());

        return(item);
    }
}
