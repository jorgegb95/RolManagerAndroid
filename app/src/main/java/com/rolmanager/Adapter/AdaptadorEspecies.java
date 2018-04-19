package com.rolmanager.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.rolmanager.R;
import com.rolmanager.database.Especies;

public class AdaptadorEspecies extends ArrayAdapter<Especies>{
    private Especies lista[];

    public AdaptadorEspecies(Activity context, Especies[] datos){
        super(context, R.layout.activity_especies, datos);
        lista=datos;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item=inflater.inflate(R.layout.textolistview, null);

        TextView lblNombre=(TextView) item.findViewById(R.id.LblNombre);
        lblNombre.setText(lista[position].getNombre());

        TextView lblRelacion=(TextView) item.findViewById(R.id.LblRelacion);
        lblNombre.setText(lista[position].getRelacion());

        return item;
    }
}
