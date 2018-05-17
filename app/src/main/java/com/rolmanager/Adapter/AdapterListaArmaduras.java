package com.rolmanager.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.rolmanager.R;
import com.rolmanager.database.Armaduras;

import java.util.ArrayList;

public class AdapterListaArmaduras extends ArrayAdapter<Armaduras> {
    private TextView nombre;
    private TextView tipo;
    private TextView ca;
    private TextView penalizacion;
    private ArrayList<Armaduras> armaduras;

    public AdapterListaArmaduras(Context context, ArrayList<Armaduras> armaduras) {
        super(context, R.layout.activity_lista_objetos, armaduras);
        this.armaduras=armaduras;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.lista_armaduras, null);

        nombre = (TextView) item.findViewById(R.id.lblNombreArmadura);
        nombre.setText(armaduras.get(position).getNombre());

        tipo = (TextView) item.findViewById(R.id.textViewTipoArmadura);
        tipo.setText(armaduras.get(position).getTipo());

        ca = (TextView) item.findViewById(R.id.editTextCA);
        ca.setText(String.valueOf(armaduras.get(position).getCa()));

        penalizacion = (TextView) item.findViewById(R.id.editTextPenalizacion);
        penalizacion.setText(String.valueOf(armaduras.get(position).getPenalizacion()));

        return(item);
    }

    public long getItemId(int position){
        return position;
    }

    public Armaduras getItem(int position) {
        return armaduras.get(position);
    }
}
