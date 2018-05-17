package com.rolmanager.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.rolmanager.R;
import com.rolmanager.database.Armas;

import java.util.ArrayList;

public class AdapterListaArmas extends ArrayAdapter<Armas>{
    private TextView nombre;
    private TextView dano;
    private TextView alcance;
    private TextView inic;
    private TextView efecto;
    private ArrayList<Armas> armas;

    public AdapterListaArmas(Context context, ArrayList<Armas> armas) {
        super(context, R.layout.activity_lista_objetos, armas);
        this.armas=armas;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.lista_armas, null);

        nombre = (TextView) item.findViewById(R.id.lblNombreManosArma);
        nombre.setText(armas.get(position).getNombre()+" ("+armas.get(position).getNumManos()+" manos)");

        dano = (TextView) item.findViewById(R.id.textViewTipoArmadura);
        dano.setText(armas.get(position).getDaño());

        alcance = (TextView) item.findViewById(R.id.editTextCA);
        alcance.setText(String.valueOf(armas.get(position).getAlcance()));

        inic = (TextView) item.findViewById(R.id.editTextPenalizacion);
        inic.setText(String.valueOf(armas.get(position).getModIniciativa()));

        efecto = (TextView) item.findViewById(R.id.editTextCA);
        efecto.setText(String.valueOf(armas.get(position).getEfecto()));

        return(item);
    }

    public long getItemId(int position){
        return position;
    }

    public Armas getItem(int position) {
        return armas.get(position);
    }
}
