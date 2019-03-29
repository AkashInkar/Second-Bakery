package com.Euspacetech.bakery.activity;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.TextView;
import com.Euspacetech.bakery.R;
import com.Euspacetech.bakery.adapter.CartAdapter;
import com.Euspacetech.bakery.database.DBHelper;
import com.Euspacetech.bakery.model.Cart;
import com.Euspacetech.bakery.model.ItemDetail;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class CartActivity extends AppCompatActivity {
   TextView sdate;
   Cart cart;
   RecyclerView recyclerView;
   DBHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        sdate =findViewById(R.id.cartdate);
        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        sdate.setText(date);

        recyclerView = findViewById(R.id.cartrview);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));

        DBHelper dbHelper = new DBHelper(CartActivity.this);
        final List<ItemDetail> carts = dbHelper.getAllItem();

        final CartAdapter adapter = new CartAdapter(carts,dbHelper);
        recyclerView.setAdapter(adapter);


        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i)
            {
                carts.remove(viewHolder.getAdapterPosition());
                adapter.notifyDataSetChanged();

            }
        }).attachToRecyclerView(recyclerView);



    }

}
