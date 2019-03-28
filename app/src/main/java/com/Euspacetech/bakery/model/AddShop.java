package com.Euspacetech.bakery.model;

public class AddShop
{
    public String sname;
    public String snuber;
    public String saddress;
    public int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AddShop(String sname, String snuber, String saddress) {
        this.sname = sname;
        this.snuber = snuber;
        this.saddress = saddress;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSnuber() {
        return snuber;
    }

    public void setSnuber(String snuber) {
        this.snuber = snuber;
    }

    public String getSaddress() {
        return saddress;
    }

    public void setSaddress(String saddress) {
        this.saddress = saddress;
    }


}
