package com.faithcapital.justclean.data.db;

import com.faithcapital.justclean.data.db.model.Items;
import com.faithcapital.justclean.data.db.model.MyOrders;
import com.faithcapital.justclean.data.db.model.MyOrdersDetails;
import com.faithcapital.justclean.data.db.model.MyOrdersList;


import java.util.List;

import io.reactivex.Observable;


/**
 * Created by Varun Jain on 08/12/16.
 */

public interface DbHelper {


    Observable<Boolean> insertAllOrders(final List<MyOrdersList> myOrders);

    Observable<Boolean> insertOrders(final MyOrdersDetails myOrders);

    Observable<Boolean> insertItems(final Items items);

    Observable<List<MyOrdersDetails>> getAllOrders();

    Observable<List<Items>> getAllItems();

    Observable<Boolean> isOrdersEmpty();

    Observable<Boolean> saveOrder(MyOrdersDetails myOrders);

    Observable<Boolean> deleteItems();



}
