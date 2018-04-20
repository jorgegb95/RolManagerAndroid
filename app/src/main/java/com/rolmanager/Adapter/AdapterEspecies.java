package com.rolmanager.Adapter;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rolmanager.R;
import com.rolmanager.database.Especies;

import java.util.ArrayList;

public class AdapterRecycle extends RecyclerView.Adapter<AdapterRecycle.EspeciesViewHolder>{
    private ArrayList<Especies> items;

    public static class EspeciesViewHolder extends RecyclerView.ViewHolder{
        public ImageView imagen;
        public TextView nombre;
        public TextView relacion;

        public EspeciesViewHolder (View v){
            super(v);
            imagen= (ImageView) v.findViewById(R.id.imagenCard);
            nombre = (TextView) v.findViewById(R.id.LblNombre);
            nombre = (TextView) v.findViewById(R.id.LblRelacion);
        }
    }

    public AdapterRecycle(ArrayList<Especies> items){
        this.items=items;
    }

    @Override
    public EspeciesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.especies_cards, parent, false);

        return new EspeciesViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull EspeciesViewHolder holder, int position) {
        holder.imagen.setImageResource(items.get(position).getImagen());
        holder.nombre.setText(items.get(position).getNombre());
        holder.relacion.setText(items.get(position).getRelacion());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
