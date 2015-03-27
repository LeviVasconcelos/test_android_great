package com.example.levi.myapplication;

import android.content.res.TypedArray;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.util.Log;
import com.example.levi.myapplication.UniformAdapter;
/**
 * Created by Levi on 27/03/2015.
 */
public class TeamListener extends SimpleOnPageChangeListener {
    private UniformAdapter uniformAdapter;
    private ViewPager uniformPager;

    public TeamListener(UniformAdapter adapter, ViewPager pager) {
        uniformAdapter = adapter;
        uniformPager = pager;
    }

    public void onPageSelected(int position) {
        uniformAdapter.buildUniforms(position);
        uniformAdapter.notifyDataSetChanged();
        if(uniformPager.getCurrentItem() == (uniformAdapter.getCount()/2)) {
            uniformPager.beginFakeDrag();
            uniformPager.fakeDragBy(-1.0F);
            uniformPager.endFakeDrag();
        }
        else {
            uniformPager.setCurrentItem(uniformAdapter.getCount()/2,true);
        }
    }
}
