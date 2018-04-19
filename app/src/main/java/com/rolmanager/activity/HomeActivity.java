package com.rolmanager.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.rolmanager.R;
import com.rolmanager.activity.EspeciesActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void abrirVistaEspecies(View view){
        Intent especiesView= new Intent(this, EspeciesActivity.class);
        startActivity(especiesView);
    }
}
