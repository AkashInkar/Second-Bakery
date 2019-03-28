package com.Euspacetech.bakery.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.Euspacetech.bakery.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShopDetailsFragment extends Fragment {
    EditText shopname, shopnumber, shopaddress;
    Button btnsave;


    public ShopDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_shop_details, container, false);

        shopname = view.findViewById(R.id.d_s_name);
        shopnumber = view.findViewById(R.id.d_s_number);
        shopaddress =  view.findViewById(R.id.d_s_address);
        btnsave = view.findViewById(R.id.d_btnsave);



        return view;

    }

}
