package com.example.emilyrasmussen.galgeleg;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;


/**
 * Created by emilyrasmussen on 20/10/2017.
 */

public class Hjelpakt extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        String hjælpHtml = "<html><body>"
                + "<h1>Hj&aelig;lpesk&aelig;rm</h1>"
                + "<p>Her kunne st&aring; noget hj&aelig;lp.<br>Men den er ikke skrevet endnu.</p>";

        WebView wv = new WebView(getActivity());
        wv.loadData(hjælpHtml, "text/html", null);
        return wv;
    }
}





