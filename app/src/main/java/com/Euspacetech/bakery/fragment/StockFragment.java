package com.Euspacetech.bakery.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.Euspacetech.bakery.R;
import com.Euspacetech.bakery.activity.AddItemActivity;
import com.Euspacetech.bakery.activity.LoginActivity;
import com.Euspacetech.bakery.activity.TotalShopsActivity;
import com.Euspacetech.bakery.adapter.StockAdapter;
import com.Euspacetech.bakery.database.DBHelper;
import com.Euspacetech.bakery.model.ItemDetail;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class StockFragment extends Fragment {
    ImageButton btnadd, btnupdate;
    Context context;
    RecyclerView recyclerView;
    TextView tdate, textView1, textView2, textView3;
    EditText ename;
    Button search;

    public StockFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stock, container, false);
       tdate = view.findViewById(R.id.date);
        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        tdate.setText(date);

   /*     textView1 = view.findViewById(R.id.ak1);
        textView2 = view.findViewById(R.id.ak2);
        textView3 = view.findViewById(R.id.ak3);

        ename = view.findViewById(R.id.date);
        search = view.findViewById(R.id.btnsearch);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String akash = ename.getText().toString().trim();

                if (TextUtils.isEmpty(akash)) {
                    Toast.makeText(getContext(), "Akash enter the data", Toast.LENGTH_SHORT).show();
                }
                DBHelper dbHelper = new DBHelper(getActivity());
                ItemDetail itemDetail = dbHelper.getItem(akash);

                if (akash == null) {
                    Toast.makeText(getContext(), "Akash not found", Toast.LENGTH_SHORT).show();
                } else {

                }
                textView1.setText(itemDetail.getName());
                textView2 .setText(itemDetail.getPrice());
                textView3.setText(itemDetail.getQuantity());

            }
        });*/


        btnadd = view.findViewById(R.id.additem);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AddItemActivity.class);
                startActivity(intent);
            }
        });

        btnupdate = view.findViewById(R.id.btnupdate);
        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ak = new Intent(getContext(), TotalShopsActivity.class);
                startActivity(ak);
            }
        });


        recyclerView = view.findViewById(R.id.rview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        DBHelper dbHelper = new DBHelper(getContext());
        List<ItemDetail> itemDetails = dbHelper.getAllItem();

        StockAdapter adapter = new StockAdapter( itemDetails, dbHelper);
        recyclerView.setAdapter(adapter);


        return view;
    }

}
