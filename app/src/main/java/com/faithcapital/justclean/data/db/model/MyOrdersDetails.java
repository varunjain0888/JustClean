
package com.faithcapital.justclean.data.db.model;

import com.faithcapital.justclean.data.network.model.*;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.ArrayList;
import java.util.List;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Unique;

/**
 * Created by Varun Jain on 16/06/17.
 */

@Entity(nameInDb = "ordersdetails")
public class MyOrdersDetails {

    @Id(autoincrement = true)
    private Long id;

    @Expose
    @SerializedName("userid")
    @Property(nameInDb = "user_id")
    private Long userid;

    @Expose
    @Unique
    @SerializedName("orderid")
    @Property(nameInDb = "order_id")
    private String orderid;

    @Expose
    @SerializedName("status")
    @Property(nameInDb = "order_status")
    private String status;

    @Expose
    @SerializedName("orderdateadded")
    @Property(nameInDb = "order_date_added")
    private String orderdateadded;

    @Expose
    @SerializedName("orderacceptedby")
    @Property(nameInDb = "order_accepted_by")
    private String orderacceptedby;

    @Expose
    @SerializedName("orderpickupdate")
    @Property(nameInDb = "order_pickup_date")
    private String orderpickupdate;

    @Expose
    @SerializedName("orderdeliverydate")
    @Property(nameInDb = "order_delivery_date")
    private String orderdeliverydate;

    @Expose
    @SerializedName("isfastservice")
    @Property(nameInDb = "is_fastservice")
    private boolean isfastservice;

    @Expose
    @SerializedName("paymentstatus")
    @Property(nameInDb = "payment_status")
    private String paymentstatus;

    @Property(nameInDb = "updated_at")

    private String updatedAt;

    @Generated(hash = 883932135)
    public MyOrdersDetails(Long id, Long userid, String orderid, String status,
            String orderdateadded, String orderacceptedby, String orderpickupdate,
            String orderdeliverydate, boolean isfastservice, String paymentstatus,
            String updatedAt) {
        this.id = id;
        this.userid = userid;
        this.orderid = orderid;
        this.status = status;
        this.orderdateadded = orderdateadded;
        this.orderacceptedby = orderacceptedby;
        this.orderpickupdate = orderpickupdate;
        this.orderdeliverydate = orderdeliverydate;
        this.isfastservice = isfastservice;
        this.paymentstatus = paymentstatus;
        this.updatedAt = updatedAt;
    }

    @Generated(hash = 874153912)
    public MyOrdersDetails() {
    }

   /* @Expose
    @SerializedName("items")
    @ToMany(referencedJoinProperty = "orderid")
    private List<Items> items;
*/

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderId() {
        return this.orderid;
    }

    public void setOrderId(String orderId) {
        this.orderid = orderId;
    }

    public String getOrderStatus() {
        return this.status;
    }

    public void setOrderStatus(String orderStatus) {
        this.status = orderStatus;
    }

    public String getOrderDateAdded() {
        return this.orderdateadded;
    }

    public void setOrderDateAdded(String orderDateAdded) {
        this.orderdateadded = orderDateAdded;
    }
    public String getOrderAcceptedBy() {
        return this.orderacceptedby;
    }

    public void setOrderAcceptedBy(String orderAcceptedBy) {
        this.orderacceptedby = orderAcceptedBy;
    }
    public String getOrderPickUpDate() {
        return this.orderpickupdate;
    }

    public void setOrderPickUpDate(String orderPickUpDate) {
        this.orderpickupdate = orderPickUpDate;
    }
    public String getOrderDeliveryDate() {
        return this.orderdeliverydate;
    }

    public void setOrderDeliveryDate(String orderDeliveryDate) {
        this.orderdeliverydate = orderDeliveryDate;
    }
    public boolean getisFastService() {
        return this.isfastservice;
    }

    public void setisFastService(boolean isFastService) {
        this.isfastservice = isFastService;
    }
    public String getPaymentStatus() {
        return this.paymentstatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentstatus = paymentStatus;
    }

    public String getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getUserid() {
        return this.userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getOrderid() {
        return this.orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrderdateadded() {
        return this.orderdateadded;
    }

    public void setOrderdateadded(String orderdateadded) {
        this.orderdateadded = orderdateadded;
    }

    public String getOrderacceptedby() {
        return this.orderacceptedby;
    }

    public void setOrderacceptedby(String orderacceptedby) {
        this.orderacceptedby = orderacceptedby;
    }

    public String getOrderpickupdate() {
        return this.orderpickupdate;
    }

    public void setOrderpickupdate(String orderpickupdate) {
        this.orderpickupdate = orderpickupdate;
    }

    public String getOrderdeliverydate() {
        return this.orderdeliverydate;
    }

    public void setOrderdeliverydate(String orderdeliverydate) {
        this.orderdeliverydate = orderdeliverydate;
    }

    public boolean getIsfastservice() {
        return this.isfastservice;
    }

    public void setIsfastservice(boolean isfastservice) {
        this.isfastservice = isfastservice;
    }

    public String getPaymentstatus() {
        return this.paymentstatus;
    }

    public void setPaymentstatus(String paymentstatus) {
        this.paymentstatus = paymentstatus;
    }



}