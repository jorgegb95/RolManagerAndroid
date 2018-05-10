package com.rolmanager.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rolmanager.Adapter.AdapterViewPage;
import com.rolmanager.R;
import com.rolmanager.tabs.PageCaracteristicas;
import com.rolmanager.tabs.PageEquipo;
import com.rolmanager.tabs.PageMochila;
import com.rolmanager.tabs.PageUsuario;

public class DetallesPersonajeActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private AdapterViewPage adapterViewPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_personaje);

        adapterViewPage = new AdapterViewPage(getSupportFragmentManager());

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        tabLayout.setupWithViewPager(viewPager);
        setUpViewPager(viewPager);
    }

    private void setUpViewPager(ViewPager pager){
        AdapterViewPage tabViewPagerAdapter = new AdapterViewPage(getSupportFragmentManager());
        tabViewPagerAdapter.addFragment(new PageUsuario(), "Usuario");
        tabViewPagerAdapter.addFragment(new PageCaracteristicas(), "Caracteristicas");
        tabViewPagerAdapter.addFragment(new PageEquipo(), "Equipo");
        tabViewPagerAdapter.addFragment(new PageMochila(), "Mochila");
        pager.setAdapter(tabViewPagerAdapter);
    }

}
