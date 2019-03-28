package com.Euspacetech.bakery.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.Euspacetech.bakery.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewBillFragment extends Fragment {
    TextView txtname,txtprice,txtquantity;


    public ViewBillFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view_bill, container, false);
        txtname = view.findViewById(R.id.item_name);
        txtprice = view.findViewById(R.id.item_price);
        txtquantity = view.findViewById(R.id.item_quantity);

        return view;

    }

}
