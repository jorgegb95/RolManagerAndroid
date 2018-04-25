package com.rolmanager.tabs;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rolmanager.R;

public class PageEquipo extends Fragment {
    public PageEquipo() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.page_equipo, container, false);
        return view;
    }
}
