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

import java.lang.reflect.Array;

/**
 * Created by Levi on 27/03/2015.
 */
public class UniformAdapter extends PagerAdapter {
   private Activity activity;
   private TypedArray flag_images;
   private TypedArray flag_names;
   private int flagNumber;
   private String[] Uniforms;
   public UniformAdapter(Activity activity) {
            this.activity = activity;
            this.flag_images = activity.getResources().obtainTypedArray(R.array.flagImages);
            this.flag_names = activity.getResources().obtainTypedArray(R.array.flagNames);
       flagNumber = 0;
       buildUniforms(flagNumber);
      // Toast.makeText(activity,"testando " + Integer.toString(flagNumber), Toast.LENGTH_SHORT).show();
        }
    public void buildUniforms(int fNumb) {
        flagNumber = fNumb;
        Uniforms = new String[10];
        for (int i = 0; i < 10; i++) {
            Uniforms[i] = flag_names.getString(flagNumber) + Integer.toString(i);
        }
        //Toast.makeText(activity,"Uniform Build: " + Integer.toString(flagNumber), Toast.LENGTH_SHORT).show();

    }

        @Override
        public Object instantiateItem (ViewGroup container, int position){
            LayoutInflater inflater = (LayoutInflater)this.activity.getSystemService(this.activity.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.uniform_layout, null);

            ImageView imgView = (ImageView) layout.findViewById(R.id.uniformImg);
            TextView txtView = (TextView) layout.findViewById(R.id.uniformText);

            imgView.setImageResource(flag_images.getResourceId(flagNumber,-1));
           // Toast.makeText(activity,"from intantiate: " + Integer.toString(flagNumber), Toast.LENGTH_SHORT).show();
            if(position < 10 && position >= 0)
                txtView.setText(Uniforms[position]);
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
            return 10;
        }

        @Override
        public void destroyItem (ViewGroup container, int position, Object object) {
            ((ViewPager)container).removeView((View)object);
        }

    public int getItemPosition(Object paramObject)
    {
        return POSITION_NONE;
    }
}
