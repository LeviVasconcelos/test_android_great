package com.example.levi.myapplication;

import android.content.res.Resources;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout layout = (LinearLayout) findViewById(R.id.relLayout);
  //      FragmentManager fragmentManager = getFragmentManager();
//        Fragment f = fragmentManager.findFragmentById(R.id.fragTeam2);
        //View lay2 = inflater.inflateinflater.inflate(R.layout.fragment_teams);
        //TextView computerTitle = (TextView) f.findViewById(R.id.chooseTeamFragmentTitle);
        //computerTitle.setText(getString(R.string.chooseTeam2Title));


        // text view label
        TextView txtTitle = (TextView) findViewById(R.id.text1);
        Button mybutton = (Button) findViewById(R.id.button1);

        // Loading Font Face
        Resources resources = getResources();

        Typeface tf_ezo = null;
        Log.d("DEBUG", "Antes de Load");
        tf_ezo = Typeface.createFromAsset(getAssets(), "edosz.ttf");
        Typeface tf_arabolic = null;
        tf_arabolic = Typeface.createFromAsset(getAssets(), "arabolic.ttf");
        Log.d("DEBUG","Depois de Load");

        // Applying font
        if(tf_ezo != null && tf_arabolic != null) {
            txtTitle.setTypeface(tf_ezo);
            mybutton.setTypeface(tf_arabolic);
        }
        mybutton.setBackgroundResource(R.drawable.custom_button);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
