package com.faithcapital.justclean.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by varunjain on 6/16/17.
 */

public class OrderDetails{

    @Expose
    @SerializedName("status")
    private String status;

    @Expose
    @SerializedName("orderdateadded")
    private String orderDateAdded;

    @Expose
    @SerializedName("orderacceptedby")
    private String orderAcceptedBy;

    @Expose
    @SerializedName("orderpickupdate")
    private String orderPickUpDate;

    @Expose
    @SerializedName("orderdeliverydate")
    private String orderDeliveryDate;

    @Expose
    @SerializedName("isfastservice")
    private boolean isFastService;

    @Expose
    @SerializedName("paymentstatus")
    private String paymentStatus;

    @Expose
    @SerializedName("items")
    private ArrayList<Items> items;

    public void setStatus(String status) {
        this.status = status;
    }

    public void setOrderDateAdded(String orderDateAdded) {
        this.orderDateAdded = orderDateAdded;
    }

    public void setOrderAcceptedBy(String orderAcceptedBy) {
        this.orderAcceptedBy = orderAcceptedBy;
    }

    public void setOrderPickUpDate(String orderPickUpDate) {
        this.orderPickUpDate = orderPickUpDate;
    }

    public void setOrderDeliveryDate(String orderDeliveryDate) {
        this.orderDeliveryDate = orderDeliveryDate;
    }

    public void setFastService(boolean fastService) {
        isFastService = fastService;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void setItems(ArrayList<Items> items) {
        this.items = items;
    }

    public String getStatus() {
        return status;
    }

    public String getOrderDateAdded() {
        return orderDateAdded;
    }

    public String getOrderAcceptedBy() {
        return orderAcceptedBy;
    }

    public String getOrderPickUpDate() {
        return orderPickUpDate;
    }

    public String getOrderDeliveryDate() {
        return orderDeliveryDate;
    }

    public boolean isFastService() {
        return isFastService;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public ArrayList<Items> getItems() {
        return items;
    }

    public OrderDetails(String status, String orderDateAdded, String orderAcceptedBy, String orderPickUpDate, String orderDeliveryDate, boolean isFastService, String paymentStatus, ArrayList<Items> items) {
        this.status = status;
        this.orderDateAdded = orderDateAdded;
        this.orderAcceptedBy = orderAcceptedBy;
        this.orderPickUpDate = orderPickUpDate;
        this.orderDeliveryDate = orderDeliveryDate;
        this.isFastService = isFastService;
        this.paymentStatus = paymentStatus;
        this.items = items;
    }
    public OrderDetails(){

    }
}
