package com.rolmanager.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.rolmanager.database.Personajes;
import com.rolmanager.tabs.PageCaracteristicas;
import com.rolmanager.tabs.PageEquipo;
import com.rolmanager.tabs.PageMochila;
import com.rolmanager.tabs.PageUsuario;

import java.util.ArrayList;
import java.util.List;


public class AdapterViewPage extends FragmentPagerAdapter { ;
    private final String titulos[] = new String[]{"Usuario", "Detalles", "Equipo", "Mochila"};
    private static Personajes personaje;

    public AdapterViewPage(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0 : return new PageUsuario();
            case 1 : return new PageCaracteristicas();
            case 2 : return new PageEquipo();
            case 3 : return new PageMochila();
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position){
        return titulos[position];
    }

    public Personajes getPersonaje() {
        return personaje;
    }

    public void setPersonaje(Personajes personaje) {
        this.personaje = personaje;
    }
}
