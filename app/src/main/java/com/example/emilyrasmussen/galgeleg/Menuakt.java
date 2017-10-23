package com.example.emilyrasmussen.galgeleg;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by emilyrasmussen on 20/10/2017.
 */

public class Menuakt extends Fragment implements View.OnClickListener {
    public Galgelogik logik = new Galgelogik();

    Button bhjaelp, bindstillinger, bspil;


    @Override
    public View onCreateView(LayoutInflater i, ViewGroup container, Bundle savedInstanceState) {
        View rod = i.inflate(R.layout.activity_main, container, false);

        bspil = (Button) rod.findViewById(R.id.bspil);
        bspil.setText("Spil");


        bindstillinger = (Button) rod.findViewById(R.id.bindstillinger);
        bindstillinger.setText("Indstillinger");

        bhjaelp = (Button) rod.findViewById(R.id.bhjealp);
        bhjaelp.setText("Hjælp");


        bhjaelp.setOnClickListener(this);
        bindstillinger.setOnClickListener(this);
        bspil.setOnClickListener(this);

        return rod;
    }


    public void onClick(View v) {
        if (v == bhjaelp) {


            getFragmentManager().beginTransaction()
                    .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                    .replace(R.id.fragmentindhold, new Hjelpakt())
                    .addToBackStack(null)
                    .commit();

        } else if (v == bindstillinger) {

            Intent i = new Intent(getActivity(), Indstillingerakt.class);
            startActivity(i);

        } else if (v == bspil) {

            Spilakt fragment = new Spilakt(logik);
            Bundle argumenter = new Bundle();
            argumenter.putString("velkomst", "\n\nHalløj fra Hovedmenu_frag!\n");
            fragment.setArguments(argumenter);

            getFragmentManager().beginTransaction()
                    .replace(R.id.fragmentindhold, fragment)
                    .addToBackStack(null)
                    .commit();
        }
    }
}
