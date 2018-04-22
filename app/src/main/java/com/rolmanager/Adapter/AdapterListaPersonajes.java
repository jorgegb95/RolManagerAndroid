package com.rolmanager.Adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.rolmanager.R;
import com.rolmanager.database.Personajes;

import java.util.ArrayList;

public class AdapterListaPersonajes extends RecyclerView.Adapter<AdapterListaPersonajes.PersonajesViewHolder> {
    private ArrayList<Personajes> items;

    public AdapterListaPersonajes(ArrayList<Personajes> items){
        this.items=items;
    }

    @Override
    public PersonajesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_personajes_cards, parent, false);

        return new PersonajesViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PersonajesViewHolder holder, int position) {
        holder.especie.setText(items.get(position).getEspecie());
        holder.nombre.setText(items.get(position).getNombre());
        holder.edad.setText(String.valueOf(items.get(position).getEdad()));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class PersonajesViewHolder extends  RecyclerView.ViewHolder{
        public TextView nombre;
        public TextView especie;
        public EditText edad;

        public PersonajesViewHolder(View v){
            super(v);
            nombre = (TextView) v.findViewById(R.id.lblNombrePersonaje);
            especie = (TextView) v.findViewById(R.id.lblEspecieJugador);
            edad = (EditText) v.findViewById(R.id.lblEdadPersonaje);
        }
    }
}
