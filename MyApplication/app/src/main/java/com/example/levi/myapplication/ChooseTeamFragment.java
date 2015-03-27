package com.example.levi.myapplication;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by Levi on 26/03/2015.
 */
public class ChooseTeamFragment
        extends android.support.v4.app.Fragment
{

    private TeamAdapter teamAdapter;
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
        teamPager.setAdapter(teamAdapter);
        teamPager.setOffscreenPageLimit(7);
        this.teamPager.setPageMargin(-(int)(0.12D * 3));
        //this.teamPager.setPageTransformer(true, this);


        return layout;
    }

}
