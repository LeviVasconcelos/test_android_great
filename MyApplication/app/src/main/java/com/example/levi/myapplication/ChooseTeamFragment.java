package com.example.levi.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * Created by Levi on 26/03/2015.
 */
public class ChooseTeamFragment
        extends android.support.v4.app.Fragment
        implements ViewPager.PageTransformer, View.OnClickListener {

    private TeamAdapter teamAdapter;
    private ViewPager uniformPager;
    private ViewPager teamPager;

    @Override
    public void onCreate(Bundle savedInstanceStates) {
        super.onCreate(savedInstanceStates);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_teams, container, false);

        teamAdapter = new TeamAdapter(getActivity());
        teamPager = (ViewPager) layout.findViewById(R.id.teamViewPager);
        uniformPager = (ViewPager) layout.findViewById(R.id.uniformViewPager);

        /**
         * ****************** Buttons on click listeners *******************
         */

        //Team Buttons
        Button nextTeamButton = (Button) layout.findViewById(R.id.nextTeam);
        nextTeamButton.setOnClickListener(this);
        Button previousTeamButton = (Button) layout.findViewById(R.id.previousTeam);
        previousTeamButton.setOnClickListener(this);

        //Uniform Buttons
        Button nextUniformButton = (Button) layout.findViewById(R.id.nextUniform);
        nextUniformButton.setOnClickListener(this);
        Button previousUniformButton = (Button) layout.findViewById(R.id.previousUniform);
        previousUniformButton.setOnClickListener(this);




        teamPager.setAdapter(teamAdapter);
        teamPager.setPageTransformer(true, this);


        return layout;
    }

    public void onClick(View view) {

        if (view.equals(getView().findViewById(R.id.nextTeam))) {
            teamPager.setCurrentItem(teamPager.getCurrentItem() + 1, true);
            return;
            //((ViewPager) getView().findViewById(R.id.teamViewPager)).setCurrentItem();
        }
        if(view.equals(getView().findViewById(R.id.previousTeam))) {
            teamPager.setCurrentItem(teamPager.getCurrentItem() - 1, true);
            return;
        }

        if(view.equals(getView().findViewById(R.id.previousUniform))) {
            uniformPager.setCurrentItem(uniformPager.getCurrentItem() - 1, true);
            return;
        }
        if(view.equals(getView().findViewById(R.id.nextUniform))) {
            uniformPager.setCurrentItem(uniformPager.getCurrentItem() + 1, true);
            return;
        }

    }


    public void transformPage(View page, float relPos) { //Animação de mudança, escala e transparencia
        if (relPos < -1 || relPos > 1) { //Saiu da tela
            page.setAlpha(0.0F);
            return;
        } else if (relPos <= 1.0F) { //Mudando...
            //Escala
            float scale = Math.max(0.6F, 1.0F - Math.abs(relPos));
            page.setScaleX(scale);
            page.setScaleY(scale);
            //Transparencia
            float transparency = Math.max(0.6F,1.0F - Math.abs(relPos));
            page.setAlpha(transparency);
            return;
        }
    }
}
