package com.Euspacetech.bakery.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.Euspacetech.bakery.R;
import com.Euspacetech.bakery.database.DBHelper;
import com.Euspacetech.bakery.model.Billing_Details;

public class CartActivity extends AppCompatActivity {
    EditText edtname,edtquantity,edtnumber;
    Button btnsave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        edtname = findViewById(R.id.edtname);
        edtquantity = findViewById(R.id.edtquantity);
        edtnumber = findViewById(R.id.edtno);

        btnsave = findViewById(R.id.btncsave);
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Demo for the test",Toast.LENGTH_SHORT).show();
                String name = edtname.getText().toString().trim();
                String quantity  = edtquantity.getText().toString().trim();
                String number = edtnumber.getText().toString().trim();

                Billing_Details billing_details = new Billing_Details(number,name,quantity);

                DBHelper dbHelper = new DBHelper(CartActivity.this);

                boolean isadd = dbHelper.forBilling(billing_details);
                if (isadd)
                {
                    Toast.makeText(getApplicationContext(), "Data is added", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
