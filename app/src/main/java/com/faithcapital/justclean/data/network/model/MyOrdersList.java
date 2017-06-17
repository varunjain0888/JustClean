package com.faithcapital.justclean.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by varunjain on 6/16/17.
 */

public class MyOrdersList {

    @Expose
    @SerializedName("orderid")
    private String orderId;

    @Expose
    @SerializedName("orderdetails")
    private OrderDetails orderDetails;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public OrderDetails getOrderDetails() {
        return orderDetails;
    }



    public void setOrderDetails(OrderDetails orderDetails) {
        this.orderDetails = orderDetails;
    }

}
