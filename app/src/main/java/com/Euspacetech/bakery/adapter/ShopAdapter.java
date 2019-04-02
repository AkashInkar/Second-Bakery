package com.Euspacetech.bakery.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.Euspacetech.bakery.R;
import com.Euspacetech.bakery.activity.BillActivity;
import com.Euspacetech.bakery.activity.CartActivity;
import com.Euspacetech.bakery.activity.TotalShopsActivity;
import com.Euspacetech.bakery.database.DBHelper;
import com.Euspacetech.bakery.model.AddShop;
import com.Euspacetech.bakery.viewHolders.Shop;

import java.util.List;

public class ShopAdapter extends RecyclerView.Adapter<Shop> {

    private final TotalShopsActivity activity;
    List<AddShop> addShopList;
    DBHelper dbHelper;
    Context context;

    public ShopAdapter(TotalShopsActivity totalShopsActivity, List<AddShop> addShopList, DBHelper dbHelper) {
        this.addShopList = addShopList;
        this.dbHelper = dbHelper;
        this.activity = totalShopsActivity;
    }

    @NonNull
    @Override
    public Shop onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.shoplist,viewGroup,false);
        return new Shop(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Shop shopholder, final int position)
    {
       final AddShop addshop = addShopList.get(position);
        shopholder.txtname.setText(addshop.getSname());
        shopholder.txtnumber.setText(addshop.getSnuber());
        shopholder.txtaddress.setText(addshop.getSaddress());
        shopholder.itemView.setTag(addshop.id);

        CardView cardView = shopholder.itemView.findViewById(R.id.cardview);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Dialog dialog = new Dialog(activity);
                    View view = View.inflate(activity,R.layout.shop_options_menu,null);
                    dialog.setContentView(view);
                    TextView addData = view.findViewById(R.id.add_data);
                    addData.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View v) {
                            Intent intent = new Intent(activity,CartActivity.class);
                            intent.putExtra(DBHelper.SHOP_ID,addshop.id);
                            activity.startActivity(intent);
                       }
                   });

                    TextView viewBill = view.findViewById(R.id.view_bill);
                    viewBill.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(activity, BillActivity.class);
                            intent.putExtra(DBHelper.SHOP_ID,addshop.id);
                            activity.startActivity(intent);
                        }
                    });
                    dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    dialog.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return addShopList.size();
    }
}
