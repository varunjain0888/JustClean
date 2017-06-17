package com.faithcapital.justclean.data.db.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Unique;

/**
 * Created by varunjain on 6/16/17.
 */

@Entity(nameInDb = "items")
public class Items {

    @Id(autoincrement = true)
    private Long id;

    @Expose
    @SerializedName("orderid")
    @Property(nameInDb = "order_id")
    private String orderid;

    @Expose
    @SerializedName("itemid")
    @Property(nameInDb = "itemid")
    private String itemid;

    @Expose
    @SerializedName("itemname")
    @Property(nameInDb = "itemname")
    private String itemname;

    @Expose
    @SerializedName("itemprice")
    @Property(nameInDb = "itemprice")
    private float itemprice;

    @Expose
    @SerializedName("itemqty")
    @Property(nameInDb = "itemqty")
    private int itemqty;

    @Expose
    @SerializedName("itemtask")
    @Property(nameInDb = "itemtask")
    private String itemtask;


    @Generated(hash = 779011781)
    public Items(Long id, String orderid, String itemid, String itemname,
            float itemprice, int itemqty, String itemtask) {
        this.id = id;
        this.orderid = orderid;
        this.itemid = itemid;
        this.itemname = itemname;
        this.itemprice = itemprice;
        this.itemqty = itemqty;
        this.itemtask = itemtask;
    }

    @Generated(hash = 1040818858)
    public Items() {
    }


    public Long getId() {
        return id;
    }

    public String getOrderId() {
        return orderid;
    }

    public String getItemid() {
        return itemid;
    }

    public String getItemname() {
        return itemname;
    }

    public float getItemprice() {
        return itemprice;
    }

    public int getItemqty() {
        return itemqty;
    }

    public String getItemtask() {
        return itemtask;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public void setOrderId(String orderId) {
        this.orderid = orderId;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public void setItemprice(float itemprice) {
        this.itemprice = itemprice;
    }

    public void setItemqty(int itemqty) {
        this.itemqty = itemqty;
    }

    public void setItemtask(String itemtask) {
        this.itemtask = itemtask;
    }

    public String getOrderid() {
        return this.orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

}
