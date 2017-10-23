package com.example.emilyrasmussen.galgeleg;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by emilyrasmussen on 20/10/2017.
 */

public class Velkommen extends Fragment implements Runnable{


    Handler handler = new Handler();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("Velkomst", "hej!");

        ImageView iv = new ImageView(getActivity());
        iv.setImageResource(R.drawable.logo);


        // Hvis savedInstanceState ikke er null er fragmentet ved at blive genstartet
        if (savedInstanceState == null) {
            handler.postDelayed(this, 3000); // <1> Kør run() om 4 sekunder
        }

        return iv;
    }

    public void run() {
        Fragment fragment = new Menuakt();
        getFragmentManager().beginTransaction()
                .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                .replace(R.id.fragmentindhold, fragment)
                .commit();
    }
}
