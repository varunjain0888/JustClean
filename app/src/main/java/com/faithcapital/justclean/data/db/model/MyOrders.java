
package com.faithcapital.justclean.data.db.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;
import org.greenrobot.greendao.DaoException;

/**
 * Created by Varun Jain on 16/06/17.
 */

public class MyOrders {



    @Expose
    @SerializedName("userid")
    private Long userid;

    @Expose
    @SerializedName("name")
    private String name;

    @Expose
    @SerializedName("orders")
    private List<MyOrdersList> orders;

    public void setOrders(List<MyOrdersList> orders) {
        this.orders = orders;
    }

    public List<MyOrdersList> getOrders() {
        return orders;
    }
}