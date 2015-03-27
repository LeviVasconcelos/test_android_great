package com.example.levi.myapplication;

import android.app.ActionBar;
import android.app.Activity;
import android.content.res.TypedArray;
import android.media.Image;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Levi on 26/03/2015.
 */
public class TeamAdapter extends PagerAdapter {
    private Activity activity;
    private TypedArray flag_images;
    private TypedArray flag_names;
    public TeamAdapter(Activity activity) {
        this.activity = activity;
        this.flag_images = activity.getResources().obtainTypedArray(R.array.flagImages);
        this.flag_names = activity.getResources().obtainTypedArray(R.array.flagNames);
        //Toast.makeText(activity,"testando " + Integer.toString(flag_names.length()), Toast.LENGTH_SHORT).show();


    }
    @Override
    public Object instantiateItem (ViewGroup container, int position){
        LayoutInflater inflater = (LayoutInflater)this.activity.getSystemService(this.activity.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.page_layout, null);

        ImageView imgView = (ImageView) layout.findViewById(R.id.pageImg);
        TextView txtView = (TextView) layout.findViewById(R.id.pagerText);

        imgView.setImageResource(flag_images.getResourceId(position,-1));
        txtView.setText(flag_names.getString(position));
        ((ViewPager) container).addView(layout, 0);
        return layout;
    }

    @Override
    public boolean isViewFromObject (View view, Object object) {
        return view == object;
    }
    @Override
    public int getCount()
    {
        return flag_names.length();
    }

    @Override
    public void destroyItem (ViewGroup container, int position, Object object) {
        ((ViewPager)container).removeView((View)object);
    }
}
