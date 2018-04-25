package com.rolmanager.tabs;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rolmanager.R;

public class PageCaracteristicas extends Fragment {

    public PageCaracteristicas() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.page_caracteristicas, container, false);
        return view;
    }
}