package com.rolmanager.tabs;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rolmanager.R;

public class PageMochila extends Fragment{

    public PageMochila() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.page_mochila, container, false);
        return view;
    }
}
