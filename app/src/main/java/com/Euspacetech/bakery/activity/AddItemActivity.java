package com.Euspacetech.bakery.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.Euspacetech.bakery.MainActivity;
import com.Euspacetech.bakery.R;
import com.Euspacetech.bakery.database.DBHelper;
import com.Euspacetech.bakery.model.ItemDetail;

public class AddItemActivity extends AppCompatActivity {
    EditText name, price, quantity;
    Button btnsave,btns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        name = findViewById(R.id.i_name);
        price = findViewById(R.id.i_price);
        quantity  = findViewById(R.id.i_quantity);
        btnsave = findViewById(R.id.btnsave);
        btns =  findViewById(R.id.btns);
        btns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddItemActivity.this,LoginActivity.class);
                startActivity(intent);

            }
        });


        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String f_name = name.getText().toString().trim();
                String f_price = price.getText().toString().trim();
                String f_quantity = quantity.getText().toString().trim();

                ItemDetail itemDetail = new ItemDetail(f_name,f_price,f_quantity);
                DBHelper dbHelper = new DBHelper(AddItemActivity.this);

                boolean isAddeds = dbHelper.addItem(itemDetail);

                if (isAddeds)
                {
                    Toast.makeText(getApplicationContext(),"Data is Added " ,Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
