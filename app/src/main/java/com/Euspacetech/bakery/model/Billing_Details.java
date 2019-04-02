package com.Euspacetech.bakery.model;

public class Billing_Details {
;
    public String item_name;
    public String quantity;
    public String price;
    public String created_at;

    public Billing_Details( String item_name, String quantity, String price, String created_at) {


        this.item_name = item_name;
        this.quantity = quantity;
        this.price = price;
        this.created_at = created_at;
    }



    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}


