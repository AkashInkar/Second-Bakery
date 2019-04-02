package com.Euspacetech.bakery.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.Euspacetech.bakery.R;
import com.Euspacetech.bakery.database.DBHelper;
import com.Euspacetech.bakery.model.ItemDetail;
import com.Euspacetech.bakery.viewHolders.stockViewholder;

import java.util.List;

public class StockAdapter extends RecyclerView.Adapter<stockViewholder> {

    List<ItemDetail> itemDetailList;
    DBHelper dbHelper;

    public StockAdapter(List<ItemDetail> itemDetailList, DBHelper dbHelper) {
        this.itemDetailList = itemDetailList;
        this.dbHelper = dbHelper;
    }

    @NonNull
    @Override
    public stockViewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.itemlist,viewGroup,false);

        return new stockViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull stockViewholder holder, int position) {
        ItemDetail itemDetail = itemDetailList.get(position);
        holder.textView1.setText(itemDetail.getName());
        holder.textView2.setText(itemDetail.getPrice());
        holder.textView3.setText(itemDetail.getQuantity());

    }

    @Override
    public int getItemCount() {
        return itemDetailList.size();
    }
}
