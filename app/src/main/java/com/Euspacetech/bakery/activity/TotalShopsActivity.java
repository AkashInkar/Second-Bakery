package com.Euspacetech.bakery.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
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
        DBHelper dbHelper = new DBHelper(getApplicationContext());
        List<AddShop> addShops = dbHelper.getAllShop();
        ShopAdapter adapter = new ShopAdapter(addShops, dbHelper);

        recyclerView.setAdapter(adapter);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getGroupId()) {
            case 121:
                dbHelper.deleteShop(item.getItemId());
                Toast.makeText(TotalShopsActivity.this, "Data Deleted", Toast.LENGTH_LONG).show();
                break;
            case  122:
                Intent intent = new Intent(TotalShopsActivity.this,CartActivity.class);
                startActivity(intent);
        }
            return super.onContextItemSelected(item);

    }
}
