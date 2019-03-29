package com.Euspacetech.bakery.viewHolders;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.Euspacetech.bakery.R;
import com.Euspacetech.bakery.database.DBHelper;
import com.Euspacetech.bakery.model.Cart;
import com.Euspacetech.bakery.model.ItemDetail;

import java.util.List;

public class CartViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
   public TextView itemname,itemquantity,itemprice;
    public  EditText itequantity;
    public  Button btnsave;
    public  Context context;

    public CartViewHolder(@NonNull View itemView) {
        super(itemView);
        itemname =itemView.findViewById(R.id.cartname);
        itemprice =itemView.findViewById(R.id.cartprice);
        itemquantity = itemView.findViewById(R.id.cartquantity);
        itequantity = itemView.findViewById(R.id.edtcart);
        btnsave = itemView.findViewById(R.id.cartsave);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = itemname.getText().toString().trim();
                String quantity = itemquantity.getText().toString().trim();
                String itemQuantity = itequantity .getText().toString().trim();

                Cart cart = new Cart(name,itemQuantity);
               /*// Cart cart = new Cart(name,itemQuantity);
                ItemDetail itemDetail = new ItemDetail(name,quantity,itemQuantity);*/

                DBHelper dbHelper = new DBHelper(context);
                dbHelper.forBilling(cart,context);

            }
        });
    }

    @Override
    public void onClick(View v) {

        Toast.makeText(context,"hi this is try ",Toast.LENGTH_SHORT).show();

       /* int position = getAdapterPosition();
        Cart adapterdata = this.adapterdata.get(position);
        Intent intent = new Intent(String.valueOf(this.context));
        intent.putExtra("name",adapterdata.getItemname());
        intent.putExtra("url",adapterdata.getItemquantity());
        intent.putExtra("img",adapterdata.getOrder_no());
        this.context.startActivity(intent);
*/
    }
}
