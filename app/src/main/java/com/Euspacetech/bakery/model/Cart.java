package com.Euspacetech.bakery.model;

public class Cart {
    String itemname;
    String Shopid;
    String order_no;
    String itemquantity;
    String createdat;
    String shop_id;

    public Cart(String itemname, String itemquantity,String Shopid) {
        this.itemname = itemname;
        this.itemquantity = itemquantity;
        this.Shopid=Shopid;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getId() {
        return Shopid;
    }

    public void setId(String id) {
        this.Shopid = id;
    }

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public String getItemquantity() {
        return itemquantity;
    }

    public void setItemquantity(String itemquantity) {
        this.itemquantity = itemquantity;
    }

    public String getCreatedat() {
        return createdat;
    }

    public void setCreatedat(String createdat) {
        this.createdat = createdat;
    }
}
