package com.rolmanager.Adapter;


import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.rolmanager.R;
import com.rolmanager.activity.DetallesPersonajeActivity;
import com.rolmanager.database.BaseDatos;
import com.rolmanager.database.Personajes;

import java.util.ArrayList;

public class AdapterListaPersonajes extends RecyclerView.Adapter<AdapterListaPersonajes.PersonajesViewHolder>{
    private ArrayList<Personajes> items;

    public AdapterListaPersonajes(){}

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
        holder.id.setText(String.valueOf(items.get(position).getId()));

        holder.setOnClickListener();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public class PersonajesViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView nombre;
        private TextView especie;
        private EditText edad;
        private TextView id;
        private Button eliminar;
        private Button editar;
        private Context context;

        private BaseDatos admindb;
        private SQLiteDatabase db;
        private RecyclerView.Adapter adapter;

        public PersonajesViewHolder(View v){
            super(v);
            context=v.getContext();

            nombre = (TextView) v.findViewById(R.id.lblNombrePersonaje);
            especie = (TextView) v.findViewById(R.id.lblEspecieJugador);
            edad = (EditText) v.findViewById(R.id.lblEdadPersonaje);
            id = (TextView) v.findViewById(R.id.textViewId);
            eliminar = (Button) v.findViewById(R.id.buttonEliminar);
            editar = (Button) v.findViewById(R.id.buttonEditar);

            admindb = new BaseDatos(context, "DBLocal", null, 1);
        }

        public void setOnClickListener() {
            eliminar.setOnClickListener(this);
            editar.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.buttonEliminar:
                    db=admindb.getWritableDatabase();
                    db.delete("tablePersonajes", "id="+String.valueOf(id.getText()),null);
                    adapter= new AdapterListaPersonajes();
                    Toast.makeText(v.getContext(), "Personaje borrado. Vuelve para atras para cargar la lista", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.buttonEditar:
                    Intent intent = new Intent(context, DetallesPersonajeActivity.class);
                    intent.putExtra("id",id.getText());
                    context.startActivities(new Intent[]{intent});
                    break;
            }
        }
    }
}
