package com.example.raji.tensorflow;

/**
 * Created by sudhakar on 12/18/2017.
 */

public class CustomerProduct {
    String pname;
    int price;
    String ptype;
    int qty;
    public CustomerProduct() {
    }
    public CustomerProduct(String pname, int price,int qty,String ptype) {
        this.ptype=ptype;
        this.qty=qty;
        this.pname = pname;
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getPtype() {
        return ptype;
    }

    public void setPtype(String ptype) {
        this.ptype = ptype;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
