package com.Euspacetech.bakery.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.Euspacetech.bakery.R;
import com.Euspacetech.bakery.database.DBHelper;
import com.Euspacetech.bakery.model.Cart;
import com.Euspacetech.bakery.model.ItemDetail;
import com.Euspacetech.bakery.viewHolders.CartViewHolder;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartViewHolder> {
    List<ItemDetail> cartList;
    DBHelper dbHelper;
    Context context;

    public CartAdapter(List<ItemDetail> cartList, DBHelper dbHelper) {
        this.cartList = cartList;
        this.dbHelper = dbHelper;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View view =LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cartitemlist,viewGroup,false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CartViewHolder holder, final int position)
    {
        final ItemDetail cart = cartList.get(position);
         holder.itemname.setText(cart.getName());
         holder.itemprice.setText(cart.getPrice());
         holder.itemquantity.setText(cart.getQuantity());
         holder.btnsave.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v)
             {
                String iteaname = holder.itemname.getText().toString().trim();
                String itemprice = holder.itemprice.getText().toString().trim();
                String itemquantity = holder.itequantity.getText().toString().trim();

                Cart cart1 = new Cart(iteaname,itemquantity);
                DBHelper dbHelper = new DBHelper(context);
                dbHelper.forBilling(cart1,context);

             }
         });

    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }
}
