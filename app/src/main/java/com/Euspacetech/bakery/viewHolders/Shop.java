package com.Euspacetech.bakery.viewHolders;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.Euspacetech.bakery.R;
import com.Euspacetech.bakery.model.AddShop;

public class Shop extends RecyclerView.ViewHolder {

    public CardView cardView;
    public TextView txtname;
    public TextView txtaddress;
    public TextView txtnumber;
    public ImageButton btndelete;
    View view;
    Context context;
    public Shop(@NonNull final View itemView) {
        super(itemView);

        txtname = itemView.findViewById(R.id.sname);
        txtnumber = itemView.findViewById(R.id.snumber);
        txtaddress = itemView.findViewById(R.id.saddress);
        cardView = itemView.findViewById(R.id.cardview);


       cardView.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
           @Override
           public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
               menu.add(121,(int) itemView.getTag(),0,"Delete Item");
               menu.add(122,(int) itemView.getTag(),0,"Add Data");
           }
       });
    }
}
