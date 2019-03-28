package com.Euspacetech.bakery.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.Euspacetech.bakery.R;
import com.Euspacetech.bakery.database.DBHelper;
import com.Euspacetech.bakery.model.AddShop;
import com.Euspacetech.bakery.viewHolders.Shop;

import java.util.List;

public class ShopAdapter extends RecyclerView.Adapter<Shop> {

    List<AddShop> addShopList;
    DBHelper dbHelper;

    public ShopAdapter(List<AddShop> addShopList, DBHelper dbHelper) {
        this.addShopList = addShopList;
        this.dbHelper = dbHelper;

    }

    @NonNull
    @Override
    public Shop onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.shoplist,viewGroup,false);
        return new Shop(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Shop shopholder, int position)
    {
       final AddShop addshop = addShopList.get(position);
        shopholder.txtname.setText(addshop.getSname());
        shopholder.txtnumber.setText(addshop.getSnuber());
        shopholder.txtaddress.setText(addshop.getSaddress());


    /*   shopholder.btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isDeleted  = (boolean) dbHelper.deleteShop(addshop.getId());

                if (isDeleted)
                {
                    addShopList.remove(addshop);
                    notifyDataSetChanged();
                }
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return addShopList.size();
    }
}
