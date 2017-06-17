package com.faithcapital.justclean.data.network.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by varunjain on 6/16/17.
 */

public class Items implements Parcelable{

    public String getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public float getItemPrice() {
        return itemPrice;
    }

    public int getItemQty() {
        return itemQty;
    }

    public String getItemTask() {
        return itemTask;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemPrice(float itemPrice) {
        this.itemPrice = itemPrice;
    }

    public void setItemQty(int itemQty) {
        this.itemQty = itemQty;
    }

    public void setItemTask(String itemTask) {
        this.itemTask = itemTask;
    }

    @Expose
    @SerializedName("itemid")
    private String itemId;

    @Expose
    @SerializedName("itemname")
    private String itemName;

    @Expose
    @SerializedName("itemprice")
    private float itemPrice;

    @Expose
    @SerializedName("itemqty")
    private int itemQty;

    @Expose
    @SerializedName("itemtask")
    private String itemTask;
    @SerializedName("orderid")
    public String orderid;
    public Items(){

    }

    public Items(String itemId, String itemName, float itemPrice, int itemQty, String itemTask) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemQty = itemQty;
        this.itemTask = itemTask;
    }

    protected Items(Parcel in) {
        itemId = in.readString();
        itemName = in.readString();
        itemPrice = in.readFloat();
        itemQty = in.readInt();
        itemTask = in.readString();
    }

    public static final Creator<Items> CREATOR = new Creator<Items>() {
        @Override
        public Items createFromParcel(Parcel in) {
            return new Items(in);
        }

        @Override
        public Items[] newArray(int size) {
            return new Items[size];
        }
    };

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(itemId);
        dest.writeString(itemName);
        dest.writeFloat(itemPrice);
        dest.writeInt(itemQty);
        dest.writeString(itemTask);
    }
}
