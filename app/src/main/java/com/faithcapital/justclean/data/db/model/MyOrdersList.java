
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
import org.greenrobot.greendao.annotation.ToOne;

/**
 * Created by Varun Jain on 16/06/17.
 */
@Entity(nameInDb = "Orders")
public class MyOrdersList {
    @Id(autoincrement = true)
    private Long id;

    @Expose
    @SerializedName("orderid")
    @Property(nameInDb = "order_id")
    private Long orderid;

    @Expose
    @SerializedName("orderdetails")
    @ToOne(joinProperty = "orderid")
    private MyOrdersDetails orderdetails;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 2007032478)
    private transient MyOrdersListDao myDao;

    @Generated(hash = 1285864134)
    public MyOrdersList(Long id, Long orderid) {
        this.id = id;
        this.orderid = orderid;
    }

    @Generated(hash = 1738765161)
    public MyOrdersList() {
    }

    @Generated(hash = 589629054)
    private transient Long orderdetails__resolvedKey;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderid() {
        return this.orderid;
    }

    public void setOrderid(Long orderid) {
        this.orderid = orderid;
    }

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 387618674)
    public MyOrdersDetails getOrderdetails() {
        Long __key = this.orderid;
        if (orderdetails__resolvedKey == null
                || !orderdetails__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            MyOrdersDetailsDao targetDao = daoSession.getMyOrdersDetailsDao();
            MyOrdersDetails orderdetailsNew = targetDao.load(__key);
            synchronized (this) {
                orderdetails = orderdetailsNew;
                orderdetails__resolvedKey = __key;
            }
        }
        return orderdetails;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1126998639)
    public void setOrderdetails(MyOrdersDetails orderdetails) {
        synchronized (this) {
            this.orderdetails = orderdetails;
            orderid = orderdetails == null ? null : orderdetails.getId();
            orderdetails__resolvedKey = orderid;
        }
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1275527158)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getMyOrdersListDao() : null;
    }



}