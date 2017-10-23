package com.example.emilyrasmussen.galgeleg;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

/**
 * Created by emilyrasmussen on 20/10/2017.
 */

public class Spilakt extends Fragment implements View.OnClickListener {


    private TextView info;
    private Button spilKnap;
    private EditText et;
    private Galgelogik logik;
    private ImageView galge;
    private Integer[] img = {
            R.drawable.galge,
            R.drawable.forkert1,
            R.drawable.forkert2,
            R.drawable.forkert3,
            R.drawable.forkert4,
            R.drawable.forkert5,
            R.drawable.forkert6,
    };

    public Spilakt(Galgelogik l) {
        logik = l;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("Velkomst", "fragmentet blev vist!");

        TableLayout tl = new TableLayout(getActivity());

        info = new TextView(getActivity());
        info.setText("Velkommen til mit fantastiske spil." +
                "\nDu skal gætte dette ord: "+logik.getSynligtOrd() +
                "\nSkriv et bogstav herunder og tryk 'Spil'.\n");
        String velkomst = getArguments().getString("velkomst");
        if (velkomst!=null) info.append(velkomst);
        tl.addView(info);

        et = new EditText(getActivity());
        et.setHint("Skriv et bogstav her.");
        tl.addView(et);

        spilKnap = new Button(getActivity());
        spilKnap.setText("Spil");
        spilKnap.setCompoundDrawablesWithIntrinsicBounds(android.R.drawable.ic_media_play, 0, 0, 0);
        tl.addView(spilKnap);

        galge = new ImageView(getActivity());
        galge.setImageResource(R.drawable.galge);
        tl.addView(galge);

        spilKnap.setOnClickListener(this);

        return tl;
    }

    @Override
    public void onClick(View view) {
        String bogstav = et.getText().toString();
        if (bogstav.length() != 1) {
            et.setError("Skriv præcis ét bogstav");
            return;
        }
        logik.gætBogstav(bogstav);
        et.setText("");
        et.setError(null);
        opdaterSkærm();
    }


    private void opdaterSkærm() {
        info.setText("Gæt ordet: " + logik.getSynligtOrd());
        if(logik.erSidsteBogstavKorrekt()==true) {
            info.append("\n\nDu har " + logik.getAntalForkerteBogstaver() + " forkerte:" + logik.getBrugteBogstaver());

        } else if (logik.erSidsteBogstavKorrekt()==false) {
            info.append("\n\nDu har " + logik.getAntalForkerteBogstaver() + " forkerte:" + logik.getBrugteBogstaver());
            galge.setImageResource(img[logik.getAntalForkerteBogstaver()]);
        }
        if (logik.erSpilletVundet()) {
            info.append("\nDu har vundet");
        }
        if (logik.erSpilletTabt()) {
            info.setText("Du har tabt, ordet var : " + logik.getOrdet());
        }

    }

}
