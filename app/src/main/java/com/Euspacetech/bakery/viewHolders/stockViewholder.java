package com.Euspacetech.bakery.viewHolders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.Euspacetech.bakery.R;

public class stockViewholder extends RecyclerView.ViewHolder {
    public TextView textView1;
    public TextView textView2;
    public  TextView textView3;

    public stockViewholder(@NonNull View itemView) {
        super(itemView);
        textView1 =itemView.findViewById(R.id.itemname);
        textView2 =itemView.findViewById(R.id.itemprice);
        textView3 =itemView.findViewById(R.id.itemquantity);
    }
}
