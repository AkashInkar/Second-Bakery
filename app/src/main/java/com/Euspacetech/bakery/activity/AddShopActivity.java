package com.Euspacetech.bakery.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.Euspacetech.bakery.R;
import com.Euspacetech.bakery.database.DBHelper;
import com.Euspacetech.bakery.model.AddShop;

public class AddShopActivity extends AppCompatActivity {
    EditText edtname,edtnumber,edtaddress;
    Button btnsave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_shop);
        edtname = findViewById(R.id.a_s_name);
        edtnumber =findViewById(R.id.a_s_number);
        edtaddress = findViewById(R.id.a_s_address);
        btnsave = findViewById(R.id.a_s_btnsave);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtname.getText().toString().trim();
                String number  = edtnumber.getText().toString().trim();
                String address = edtaddress.getText().toString().trim();

                AddShop addShop = new AddShop(name,number,address);
                DBHelper dbHelper = new DBHelper(AddShopActivity.this);
                boolean data = dbHelper.addShop(addShop);
                if (data)
                {
                    Toast.makeText(getApplicationContext(),"Shop is add",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
