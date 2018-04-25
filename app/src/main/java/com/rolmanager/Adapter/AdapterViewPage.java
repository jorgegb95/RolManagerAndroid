package com.rolmanager.Adapter;


import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;


public class AdapterViewPage extends PagerAdapter{
    private LinearLayout page1;
    private LinearLayout page2;
    private ListView page3;
    private LinearLayout page4;


    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public boolean isViewFromObject(View view,Object object) {
    return false;
    }
}
