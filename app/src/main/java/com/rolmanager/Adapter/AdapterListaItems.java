package com.rolmanager.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.rolmanager.R;
import com.rolmanager.database.Items;

import java.util.ArrayList;

public class AdapterListaItems extends ArrayAdapter<Items> {
    private ArrayList<Items> items;
    private TextView nombre;
    private TextView descripcion;

    public AdapterListaItems(Context context, ArrayList<Items> items) {
        super(context, R.layout.activity_lista_objetos, items);
        this.items=items;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.lista_items, null);

        nombre = (TextView) item.findViewById(R.id.lblNombreItem);
        nombre.setText(items.get(position).getNombre());

        descripcion = (TextView) item.findViewById(R.id.textViewDescripcionItem);
        descripcion.setText(items.get(position).getDescripcion());

        return(item);
    }

    public long getItemId(int position){
        return position;
    }

    public Items getItem(int position) {
        return items.get(position);
    }
}
