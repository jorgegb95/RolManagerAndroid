package com.rolmanager.tabs;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rolmanager.Adapter.AdapterViewPage;
import com.rolmanager.R;
import com.rolmanager.database.Personajes;

public class PageUsuario extends Fragment{
    private AdapterViewPage adapterViewPage;
    private Personajes personaje;
    private TextView nombre;
    private TextView nombreJugador;
    private TextView edad;
    private TextView altura;
    private TextView especie;
    private TextView clase;
    private TextView sexo;



    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.page_usuario, container, false);

        adapterViewPage = new AdapterViewPage(getFragmentManager());

        personaje=new Personajes();
        personaje=adapterViewPage.getPersonaje();

        Log.d("Personaje", personaje.toString());

        nombre= (TextView) view.findViewById(R.id.textViewTituloDetallesPersonaje);
        nombreJugador= (TextView) view.findViewById(R.id.textViewJugadorDetallesPersonaje);
        edad=(TextView) view.findViewById(R.id.textViewEdadDetallesPersonaje);
        altura=(TextView) view.findViewById(R.id.textViewAlturaDetallesPersonaje);
        especie=(TextView) view.findViewById(R.id.textViewEspecieDetallesPersonaje);
        clase=(TextView) view.findViewById(R.id.textViewClaseDetallesPersonaje);
        sexo=(TextView) view.findViewById(R.id.textViewSexoDetallesPersonaje);

        nombre.setText(personaje.getNombre());
        nombreJugador.setText(personaje.getNombreJugador());
        edad.setText(String.valueOf(personaje.getEdad()));
        altura.setText(String.valueOf(personaje.getAltura()));
        especie.setText(personaje.getEspecie());
        clase.setText(personaje.getClase());
        sexo.setText(personaje.getSexo());

        return view;
    }

}
