package com.rolmanager.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toolbar;

import com.rolmanager.Adapter.AdapterViewPage;
import com.rolmanager.R;

public class DetallesPersonajeActivity extends AppCompatActivity {
    private TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_personaje);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarDetalles);


        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new AdapterViewPage());

        tabLayout = (TabLayout) findViewById(R.id.tabsDetalles);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.usuario);
        tabLayout.getTabAt(1).setIcon(R.drawable.caracteristicas);
        tabLayout.getTabAt(2).setIcon(R.drawable.equipo);
        tabLayout.getTabAt(3).setIcon(R.drawable.mochila);

        selectIcon(0);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //nothing here
            }

            @Override
            public void onPageSelected(int position) {
                selectIcon(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                //nothing here
            }
        });
    }

    private void selectIcon(int position) {
        for (int i = 0; i < 4; i++) {
            if (i == position) {
                tabLayout.getTabAt(i).getIcon().setAlpha(255);
            } else {
                tabLayout.getTabAt(i).getIcon().setAlpha(128);
            }
        }
    }

}
