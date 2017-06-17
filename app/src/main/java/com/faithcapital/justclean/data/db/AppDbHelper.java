

package com.faithcapital.justclean.data.db;


import android.util.Log;

import com.faithcapital.justclean.data.db.model.DaoMaster;
import com.faithcapital.justclean.data.db.model.DaoSession;
import com.faithcapital.justclean.data.db.model.Items;
import com.faithcapital.justclean.data.db.model.MyOrders;
import com.faithcapital.justclean.data.db.model.MyOrdersDetails;
import com.faithcapital.justclean.data.db.model.MyOrdersList;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;


/**
 * Created by VarunJain on 10/02/17.
 */

@Singleton
public class AppDbHelper implements DbHelper {

    private final DaoSession mDaoSession;

    @Inject
    public AppDbHelper(DbOpenHelper dbOpenHelper) {
        mDaoSession = new DaoMaster(dbOpenHelper.getWritableDb()).newSession();
    }

    @Override
    public Observable<Boolean> insertAllOrders(final List<MyOrdersList> myOrders) {
        Log.e("APPDBHELPER","App db helper called");
        //mDaoSession.getMyOrdersDao().insertInTx(questionList);
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                Log.e("APPDBHELPER","App db helper called>>>>>>>>>>");
                mDaoSession.getMyOrdersListDao().insertInTx(myOrders);
                return true;
            }
        });
    }

    @Override
    public Observable<Boolean> insertOrders(final MyOrdersDetails myOrders) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mDaoSession.getMyOrdersDetailsDao().insertOrReplace(myOrders);
                return true;
            }
        });
    }

    @Override
    public Observable<Boolean> insertItems(final Items items) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mDaoSession.getItemsDao().insertOrReplace(items);
                return true;
            }
        });
    }

    @Override
    public Observable<Boolean> saveOrder(final MyOrdersDetails orders) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mDaoSession.getMyOrdersDetailsDao().insertOrReplace(orders);
                return true;
            }
        });
    }

    @Override
    public Observable<Boolean> deleteItems() {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mDaoSession.getItemsDao().deleteAll();
                return true;
            }
        });
    }


    @Override
    public Observable<List<MyOrdersDetails>> getAllOrders() {
        return Observable.fromCallable(new Callable<List<MyOrdersDetails>>() {
            @Override
            public List<MyOrdersDetails> call() throws Exception {
                return mDaoSession.getMyOrdersDetailsDao().loadAll();
            }
        });
    }

    @Override
    public Observable<List<Items>> getAllItems() {
        return Observable.fromCallable(new Callable<List<Items>>() {
            @Override
            public List<Items> call() throws Exception {
                return mDaoSession.getItemsDao().loadAll();
            }
        });
    }

    @Override
    public Observable<Boolean> isOrdersEmpty() {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return !(mDaoSession.getMyOrdersDetailsDao().count() > 0);
            }
        });
    }
}
