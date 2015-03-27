package com.example.levi.myapplication;
import android.app.ActionBar;
import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.ArcShape;
import android.graphics.drawable.shapes.OvalShape;
import android.media.Image;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Random;

/**
 * Created by Levi on 27/03/2015.
 */
public class UniformAdapter extends PagerAdapter {
   private Activity activity;
   private TypedArray flag_images;
   private TypedArray flag_names;
   private int flagNumber;
   private String[] Uniforms;
   private Paint[] paints;
   private Random rdm;
   private DisplayMetrics metrics;

   public UniformAdapter(Activity activity, DisplayMetrics m) {
       this.activity = activity;
       this.flag_images = activity.getResources().obtainTypedArray(R.array.flagImages);
       this.flag_names = activity.getResources().obtainTypedArray(R.array.flagNames);
       flagNumber = 0;
       rdm = new Random();
       buildUniforms(flagNumber);
       metrics = m;
      // Toast.makeText(activity,"testando " + Integer.toString(flagNumber), Toast.LENGTH_SHORT).show();
        }
    public void buildUniforms(int fNumb) {
        flagNumber = fNumb;
        Uniforms = new String[10];
        paints = new Paint[10];
        for (int i = 0; i < 10; i++) {
            paints[i] = new Paint();
            Uniforms[i] = flag_names.getString(flagNumber) + Integer.toString(i);
            paints[i].setARGB(255,this.rdm.nextInt(255),this.rdm.nextInt(255),this.rdm.nextInt(255));
        }
        //Toast.makeText(activity,"Uniform Build: " + Integer.toString(flagNumber), Toast.LENGTH_SHORT).show();

    }

    public LayerDrawable drawShields(int i) {
        ShapeDrawable circle = new ShapeDrawable(new OvalShape());
        circle.getPaint().set(paints[i]);
        circle.setBounds(0, 0, 10 * metrics.widthPixels, 20 * metrics.widthPixels);

        Drawable[] drawables = {flag_images.getDrawable(flagNumber), circle};
        LayerDrawable layerDrawable = new LayerDrawable(drawables);

        return layerDrawable;
    }

        @Override
        public Object instantiateItem (ViewGroup container, int position){
            LayoutInflater inflater = (LayoutInflater)this.activity.getSystemService(this.activity.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.uniform_layout, null);

            ImageView imgView = (ImageView) layout.findViewById(R.id.uniformImg);
            TextView txtView = (TextView) layout.findViewById(R.id.uniformText);

            //imgView.setImageResource(flag_images.getResourceId(flagNumber,-1));
            LayerDrawable shield = drawShields(position);
            imgView.setImageDrawable(shield);
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
