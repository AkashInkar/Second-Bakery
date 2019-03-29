package com.Euspacetech.bakery.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.Euspacetech.bakery.model.AddShop;
import com.Euspacetech.bakery.model.Billing_Details;
import com.Euspacetech.bakery.model.Cart;
import com.Euspacetech.bakery.model.ItemDetail;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class DBHelper extends SQLiteOpenHelper {

Context context;

    //database is created
    private static final String DB_NAME ="bakery";
    private static final int DB_VERSION = 1;


    //this table for Shop
    public static final String TABLE_SHOP_NAMES = "shop_name";
   public static final String SHOP_ID = "s_id";
    public static final String SHOP_NAME = "s_name";
    public static final String SHOP_ADDRESS = "s_address";
    public static final String SHOP_NUMBER = "s_number";
   // private static final String



    //Bill Details Table
    //Table name for the bill tables
    private static final String BILL_Details ="bill_details";
    //Coloum name of this tables
    private static final String B_ID = "id";
    public static final String B_SHOP_ID = "b_s_id";
    public static final String B_ITEM_NAME ="item_name";
    public static final String B_COUNT ="count";
    private static final String B_ORDER_NO ="order_no";
    private static final String B_TOTALS_ITEM ="totals_item";
    private static  final String B_GRAND_TOTALS ="grand_totals";
    private static final String B_CREATED_AT ="created_at";


// this table for item details
    private static final String ITEM_DETAILS = "item_details";
    private static final String ID = "id";
    public static final String NAME = "name";
    public static final String PRICE = "price";
    public static final String QUANTITY = "quantity";
    public static final String DATE = "date";


    public DBHelper( Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table "+ ITEM_DETAILS + "( "+ ID +" integer primary key autoincrement, "
                +NAME + " text, "+PRICE + " text, "+ QUANTITY + " text, "+ DATE +" text )";

        Log.e("DBQuery","========"+query);
        db.execSQL(query);


        String query1 = "create table "+ TABLE_SHOP_NAMES + "( "+ SHOP_ID +" integer primary key autoincrement, "
                + SHOP_NAME + " text, "+ SHOP_ADDRESS + " text, "+ SHOP_NUMBER + " text )";

        Log.e("DBQuery","========"+query1);
        db.execSQL(query1);



        String query2 = "create table "+ BILL_Details + " ( "+ B_ID +" integer primary key autoincrement, "+ B_ORDER_NO + " integer, "+ B_TOTALS_ITEM + " text, "+ B_GRAND_TOTALS + " text, "+B_CREATED_AT + " text, "+ B_COUNT + " integer, "+ B_ITEM_NAME + " text, "+SHOP_ID + " integer, FOREIGN KEY(s_id) REFERENCES TABLE_SHOP_NAMES (s_id))";
        Log.e("DBQuery","========"+query2);
        db.execSQL(query2);
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        db.setForeignKeyConstraintsEnabled(true);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        db.execSQL("PRAGMA foreign_keys = ON;");
    }

    // add the list of the items
    public boolean addItem(ItemDetail itemDetail)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(NAME,itemDetail.getName());
        values.put(PRICE,itemDetail.getPrice());
        values.put(QUANTITY,itemDetail.getQuantity());
        values.put(DATE, new Date().getTime());

        long no = db.insert(ITEM_DETAILS,null,values);
        db.close();
        return no>0;
    }


    // add the data for billing
    public void forBilling(Cart cart,Context context)
    {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(B_ITEM_NAME,cart.getItemname());
        values.put(B_COUNT,cart.getItemquantity());

        long add = database.insert(BILL_Details,null,values);
        Toast.makeText(context,"Data is Stored", Toast.LENGTH_SHORT).show();
        database.close();
      /*  return add>0;*/

    }



    public long getCount()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select count(" + QUANTITY + ") from " + ITEM_DETAILS,null);
        int count = 0;
        if (cursor!=null && cursor.getCount()>0)
        {
            cursor.moveToFirst();
            count = cursor.getInt(0);
        }
        cursor.close();
        db.close();
        return count;
    }


    public void getvalue()
    {
        long count = getCount();
    }





    //count for item details table in hiw many record are stord in android studio
    public long getProfilesCount() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select count(" + ID + ") from " + ITEM_DETAILS,null);
        int count =0;
        if(c!=null && c.getCount() > 0){
            c.moveToFirst();
            count = c.getInt(0);
        }
        c.close();
        db.close();
        return count;
    }


    //view the data
    public List<ItemDetail> getAllItem()
    {
        List<ItemDetail> itemDetails = new ArrayList<ItemDetail>();
        SQLiteDatabase db = getReadableDatabase();
        String query = "Select * from "+ITEM_DETAILS;
        Cursor cursor = db.rawQuery(query,null);
        if (cursor.getCount() > 0)
        {
           while(cursor.moveToNext()) {
               String name = cursor.getString(cursor.getColumnIndex(NAME));
               String price = cursor.getString(cursor.getColumnIndex(PRICE));
               String quqntity = cursor.getString(cursor.getColumnIndex(QUANTITY));
               String id = cursor.getString(cursor.getColumnIndex(ID));

               ItemDetail itemDetail = new ItemDetail(name, price, quqntity);
               itemDetail.setId(id);
               itemDetails.add(itemDetail);
           }
        }
        if (cursor!=null && !cursor.isClosed())
        {
            cursor.close();
        }
        return itemDetails;
    }


    //add shop from heres
    public boolean addShop(AddShop addShop)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(SHOP_NAME,addShop.getSname());
        values.put(SHOP_NUMBER,addShop.getSnuber());
        values.put(SHOP_ADDRESS,addShop.getSaddress());

        long number = db.insert(TABLE_SHOP_NAMES,null,values);
        db.close();
        return number>0;
    }

    //getcount for the shops
    public  long allShopCount()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c  = db.rawQuery( "select count(" + SHOP_ID + ") from " + TABLE_SHOP_NAMES,null);
        int count = 0;
        if (c!=null && c.getCount() > 0)
        {
            c.moveToFirst();
            count = c.getInt(0);
        }
        c.close();
        db.close();
        return count;
    }
    // view the all shop
    public List<AddShop> getAllShop()
    {
        List<AddShop> addShops = new ArrayList<AddShop>();
        SQLiteDatabase db = getReadableDatabase();
        String qry = " Select * from "+TABLE_SHOP_NAMES;
        Cursor cursor = db.rawQuery(qry,null);
        if (cursor.getCount()>=0)
        {
            while(cursor.moveToNext())
            {
                String name = cursor.getString(cursor.getColumnIndex(SHOP_NAME));
                String number = cursor.getString(cursor.getColumnIndex(SHOP_NUMBER));
                String address = cursor.getString(cursor.getColumnIndex(SHOP_ADDRESS));
                String id = cursor.getString(cursor.getColumnIndex(SHOP_ID));
                AddShop addShop = new AddShop(name,number,address);
                addShop.setId(Integer.parseInt(id));
                addShops.add(addShop);
            }
        }
        if (cursor!=null && !cursor.isClosed())
        {
            cursor.close();
        }
        return addShops;
    }

    //delete the shops
    public  boolean deleteShop(int id)
    {
        SQLiteDatabase db = getWritableDatabase();
        long deleterow = db.delete(TABLE_SHOP_NAMES,SHOP_ID + " = "+ id,null);
        if (deleterow>0)
        {
            return true;
        } else
        {
            return false;
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }

    public  ItemDetail getItem( String name)
    {
        ItemDetail itemDetail = null;
        SQLiteDatabase db =  getReadableDatabase();
        String query = "select * from "+ITEM_DETAILS+ " where "+NAME+ " = '"+name+ "'";
        //check in logcat{e means ckeck in error}
        Log.e("check Query","#############"+query);

        Cursor cursor=db.rawQuery(query,null);
        if(cursor.moveToFirst())
        {
            int id = cursor.getInt(cursor.getColumnIndex(ID));
            String itemname = cursor.getString(cursor.getColumnIndex(NAME));
            String price = cursor.getString(cursor.getColumnIndex(PRICE));
            String quqntity = cursor.getString(cursor.getColumnIndex(QUANTITY));
            itemDetail = new ItemDetail(itemname,price,quqntity);
            itemDetail.setId(String.valueOf(id));
        }
return itemDetail;
    }


}
