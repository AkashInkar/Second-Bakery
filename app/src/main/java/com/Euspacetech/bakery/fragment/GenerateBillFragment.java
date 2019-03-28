package com.Euspacetech.bakery.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.Euspacetech.bakery.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class GenerateBillFragment extends Fragment {


    public GenerateBillFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_generate_bill, container, false);
    }

}
