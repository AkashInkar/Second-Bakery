package com.Euspacetech.bakery.activity;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.Euspacetech.bakery.R;
import com.Euspacetech.bakery.database.DBHelper;

public class RepacementActivity extends AppCompatActivity implements View.OnClickListener {
    EditText replcename,replceprice,replcequantity,replcereason;
    String name,price,quantity,reason;
    String id;
    Button replacebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repacement);
        replcename= findViewById(R.id.replace_name);
        replceprice= findViewById(R.id.replace_price);
        replcequantity= findViewById(R.id.replace_quantity);
        replcereason= findViewById(R.id.replace_reason);
        replacebtn=findViewById(R.id.r_update);
        replacebtn.setOnClickListener(this);
        Intent intent= getIntent();
        String name=intent.getStringExtra("Name");
        id=intent.getStringExtra("Id");
        replcename.setText(name);
    }


    @Override
    public void onClick(View v) {
        name = replcename.getText().toString().trim();
        price = replceprice.getText().toString().trim();
        quantity = replcequantity.getText().toString().trim();
        reason = replcereason.getText().toString().trim();
       ContentValues cv=new ContentValues();
        cv.put("item_name",name);
        cv.put("count",quantity);
        DBHelper dbHelper=new DBHelper(this);
        dbHelper.replacOrderData(cv,id);
    }
}
