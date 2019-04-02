package com.Euspacetech.bakery.activity;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.Euspacetech.bakery.R;
import com.Euspacetech.bakery.database.DBHelper;
import com.Euspacetech.bakery.model.Billing_Details;

import java.util.ArrayList;

public class BillActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);

        int shopId = getIntent().getIntExtra(DBHelper.SHOP_ID,1);
        DBHelper db = new DBHelper(this);
        RecyclerView billRecyclerview = findViewById(R.id.bill_recyclerview);
        billRecyclerview.setAdapter(new BillAdapter(db.getShopBillDetails(shopId)));
        billRecyclerview.setLayoutManager(new LinearLayoutManager(this));
    }

    class BillAdapter extends RecyclerView.Adapter<BillAdapter.BillViewHolder>  {

        private final ArrayList<Billing_Details> billDetails;

        public BillAdapter(ArrayList<Billing_Details> shopBillDetails) {
            this.billDetails = shopBillDetails;
        }

        @NonNull
        @Override
        public BillViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bill_item_layout,viewGroup,false);

            return new BillViewHolder(view);

        }

        @Override
        public void onBindViewHolder(@NonNull BillViewHolder billViewHolder, int i) {
            Billing_Details billing_details = billDetails.get(i);
            billViewHolder.dateOfPurchase.setText(billing_details.created_at);
            billViewHolder.itemName.setText(billing_details.item_name);
            billViewHolder.price.setText(billing_details.price);
            billViewHolder.quantity.setText(billing_details.quantity);
            billViewHolder.amount.setText(String.valueOf(Integer.parseInt(billing_details.quantity) * Integer.parseInt(billing_details.price)));
        }

        @Override
        public int getItemCount() {
            return billDetails.size();
        }



        private class BillViewHolder extends RecyclerView.ViewHolder {

            private final TextView itemName;
            private final TextView dateOfPurchase;
            private final TextView amount;
            private final TextView price;
            private final TextView quantity;

            public BillViewHolder(@NonNull View itemView) {
                super(itemView);
                itemName = itemView.findViewById(R.id.itemName);
                dateOfPurchase = itemView.findViewById(R.id.date_of_purchase);
                amount = itemView.findViewById(R.id.amount);
                price = itemView.findViewById(R.id.price);
                quantity = itemView.findViewById(R.id.quantity);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int position=getAdapterPosition();
                        Billing_Details billing_details=billDetails.get(position);
                        String sID=billing_details.getItem_name();
                        DBHelper dbHelper=new DBHelper(getApplicationContext());
                        dbHelper.replaceOrder(sID);
                    }
                });
            }
        }

    }
}
