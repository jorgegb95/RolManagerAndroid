package com.rolmanager.Adapter;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rolmanager.R;
import com.rolmanager.database.Especies;

import java.util.ArrayList;

public class AdapterEspecies extends RecyclerView.Adapter<AdapterEspecies.EspeciesViewHolder>{
    private ArrayList<Especies> items;
    private Context context;

    public static class EspeciesViewHolder extends RecyclerView.ViewHolder{
        public ImageView imagen;
        public TextView nombre;
        public TextView relacion;
        public TextView pesoMinimo;
        public TextView pesoMaximo;
        public TextView alturaMinima;
        public TextView alturaMaxima;
        public TextView edadMedia;
        public TextView edadAdulto;
        public TextView aspectos;

        public EspeciesViewHolder (View v){
            super(v);
            imagen= (ImageView) v.findViewById(R.id.imagenCard);
            nombre = (TextView) v.findViewById(R.id.LblNombre);
            relacion = (TextView) v.findViewById(R.id.LblRelacion);
            pesoMinimo = (TextView) v.findViewById(R.id.pesoMinimo);
            pesoMaximo = (TextView) v.findViewById(R.id.pesoMaximo);
            alturaMinima = (TextView) v.findViewById(R.id.alturaMinima);
            alturaMaxima = (TextView) v.findViewById(R.id.alturaMaxima);
            edadMedia = (TextView) v.findViewById(R.id.edadMedia);
            edadAdulto = (TextView) v.findViewById(R.id.edadAdulto);
            aspectos = (TextView) v.findViewById(R.id.aspectos);

        }
    }

    public AdapterEspecies(ArrayList<Especies> items, Context context){
        this.items=items;
        this.context=context;
    }

    @Override
    public EspeciesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.especies_cards, parent, false);

        return new EspeciesViewHolder(v);
    }

    @Override
    public void onBindViewHolder(EspeciesViewHolder holder, int position) {
        String uri=null;

        switch (items.get(position).getNombre()){
            case "Elfos": uri="@drawable/elfo";
                break;
            case "Enanos":uri="@drawable/enano";
                break;
            case "Humanos":uri="@drawable/humano";
                break;
            case "Gnomos":uri="@drawable/gnomo";
                break;
            case "Trasgos":uri="@drawable/trasgo";
                break;
            case "Orcos":uri="@drawable/orco";
                break;
            case "Medianos":uri="@drawable/medianos";
                break;
        }

        int resId=context.getResources().getIdentifier(uri,null, context.getPackageName());
        Drawable img =ContextCompat.getDrawable(context.getApplicationContext(), resId);

        holder.imagen.setImageDrawable(img);
        holder.nombre.setText(items.get(position).getNombre());
        holder.relacion.setText(items.get(position).getRelacion());
        holder.pesoMinimo.setText("Peso minimo"+String.valueOf(items.get(position).getPesoMinimo())+"Kg");
        holder.pesoMaximo.setText("Peso maximo:"+String.valueOf(items.get(position).getPesoMaximo())+"Kg");
        holder.alturaMinima.setText("Altura minima:"+String.valueOf(items.get(position).getAlturaMinima())+"cm");
        holder.alturaMaxima.setText("Altura maxima:"+String.valueOf(items.get(position).getAlturaMaxima())+"cm");
        holder.edadMedia.setText("Edad media:"+String.valueOf(items.get(position).getEdadMedia()));
        holder.edadAdulto.setText("Edad adulta:"+String.valueOf(items.get(position).getEdadAdulta()));
        holder.aspectos.setText(items.get(position).getAspectos());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
