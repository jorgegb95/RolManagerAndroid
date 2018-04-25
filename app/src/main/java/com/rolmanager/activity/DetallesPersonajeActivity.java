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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_personaje);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewpager);

        tabLayout.setupWithViewPager(viewPager);


    }

    private void setUpViewPager(ViewPager pager){
        AdapterViewPage tabViewPagerAdapter = new AdapterViewPage(getSupportFragmentManager());
        tabViewPagerAdapter.addFragment(new PageUsuario(), "Tab1");
        tabViewPagerAdapter.addFragment(new PageCaracteristicas(), "Tab2");
        tabViewPagerAdapter.addFragment(new PageEquipo(), "Tab3");
        tabViewPagerAdapter.addFragment(new PageMochila(), "Tab3");
        pager.setAdapter(tabViewPagerAdapter);
    }

}
