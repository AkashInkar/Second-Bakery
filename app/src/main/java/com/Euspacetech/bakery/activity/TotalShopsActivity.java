package com.Euspacetech.bakery.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.Euspacetech.bakery.R;
import com.Euspacetech.bakery.adapter.ShopAdapter;
import com.Euspacetech.bakery.database.DBHelper;
import com.Euspacetech.bakery.model.AddShop;

import java.util.List;

public class TotalShopsActivity extends AppCompatActivity {
    RecyclerView recyclerView;
   Button btnadd;
    DBHelper dbHelper;
    AddShop addShop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_shops);
        recyclerView = findViewById(R.id.s_review);
        btnadd = findViewById(R.id.addshop);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TotalShopsActivity.this, AddShopActivity.class);
                startActivity(intent);
            }
        });


        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        final DBHelper dbHelper = new DBHelper(getApplicationContext());
        final List<AddShop> addShops = dbHelper.getAllShop();
        final ShopAdapter adapter = new ShopAdapter(this,addShops, dbHelper);
        recyclerView.setAdapter(adapter);
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i)
            {
                boolean isdeleted = dbHelper.deleteShop(viewHolder.getAdapterPosition());
//                adapter.notifyDataSetChanged();
                if(isdeleted)
                {
                   addShops.remove(viewHolder.getAdapterPosition());
                adapter.notifyDataSetChanged();
                    Toast.makeText(getApplicationContext(), "the data is deleted", Toast.LENGTH_SHORT).show();

                    SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putInt("adapter position",viewHolder.getAdapterPosition());
                    editor.commit();

                }
            }
        }).attachToRecyclerView(recyclerView);

    }
}
