package com.faithcapital.justclean.ui.myorders;


import android.util.Log;

import com.faithcapital.justclean.data.DataManager;
import com.faithcapital.justclean.data.db.model.MyOrders;
import com.faithcapital.justclean.data.db.model.MyOrdersDetails;
import com.faithcapital.justclean.data.network.model.GetOrdersResponse;
import com.faithcapital.justclean.data.network.model.Items;
import com.faithcapital.justclean.data.network.model.MyOrdersList;
import com.faithcapital.justclean.data.network.model.OrderDetails;
import com.faithcapital.justclean.ui.base.BasePresenter;
import com.faithcapital.justclean.util.NetworkUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Varun on 2/22/17.
 */

public class MyOrdersPresenter<V extends MyOrdersMvpView> extends BasePresenter<V> implements MyOrdersMvpPresenter<V> {

    @Inject
    public MyOrdersPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }


    @Override
    public void getServerData() {
        getCompositeDisposable().add(getDataManager()
                .doGetAllOrdersApiCall()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<GetOrdersResponse>() {
                    @Override
                    public void accept(GetOrdersResponse getOrdersResponse) throws Exception {
                        getDataManager().setCurrentUserName(getOrdersResponse.getUserName());
                        getDataManager().setCurrentUserId(getOrdersResponse.getUserId());
                        getCompositeDisposable().add(getDataManager().deleteItems().subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<Boolean>() {
                                    @Override
                                    public void accept(Boolean aBoolean) throws Exception {
                                    }
                                }, new Consumer<Throwable>() {
                                    @Override
                                    public void accept(Throwable throwable) throws Exception {
                                    }
                                }));
                        for (MyOrdersList orderList : getOrdersResponse.getMyOrdersList()) {
                            MyOrdersDetails myOrdersDetails = new MyOrdersDetails();
                            myOrdersDetails.setOrderId(orderList.getOrderId());
                            myOrdersDetails.setOrderAcceptedBy(orderList.getOrderDetails().getOrderAcceptedBy());
                            myOrdersDetails.setisFastService(orderList.getOrderDetails().isFastService());
                            myOrdersDetails.setOrderDateAdded(orderList.getOrderDetails().getOrderDateAdded());
                            myOrdersDetails.setOrderDeliveryDate(orderList.getOrderDetails().getOrderDeliveryDate());
                            myOrdersDetails.setOrderPickUpDate(orderList.getOrderDetails().getOrderPickUpDate());
                            myOrdersDetails.setOrderStatus(orderList.getOrderDetails().getStatus());
                            myOrdersDetails.setPaymentStatus(orderList.getOrderDetails().getPaymentStatus());
                            for (Items items :orderList.getOrderDetails().getItems()) {
                                com.faithcapital.justclean.data.db.model.Items items1 = new com.faithcapital.justclean.data.db.model.Items();
                                items1.setItemid(items.getItemId());
                                items1.setItemname(items.getItemName());
                                items1.setItemprice(items.getItemPrice());
                                items1.setItemqty(items.getItemQty());
                                items1.setItemtask(items.getItemTask());
                                items1.setOrderId(orderList.getOrderId());
                                getCompositeDisposable().add(getDataManager()
                                        .insertItems(items1)
                                        .subscribeOn(Schedulers.io())
                                        .observeOn(AndroidSchedulers.mainThread())
                                        .subscribe(new Consumer<Boolean>() {
                                            @Override
                                            public void accept(Boolean aBoolean) throws Exception {
                                            }
                                        }, new Consumer<Throwable>() {
                                            @Override
                                            public void accept(Throwable throwable) throws Exception {
                                            }
                                        }));
                                    }

                                    getCompositeDisposable().add(getDataManager()
                                            .insertOrders(myOrdersDetails)
                                            .subscribeOn(Schedulers.io())
                                            .observeOn(AndroidSchedulers.mainThread())
                                            .subscribe(new Consumer<Boolean>() {
                                                @Override
                                                public void accept(Boolean aBoolean) throws Exception {
                                                }
                                            }, new Consumer<Throwable>() {
                                                @Override
                                                public void accept(Throwable throwable) throws Exception {
                                                }
                                            }));
                                        }

                                    getMvpView().setAdapter(getOrdersResponse.getMyOrdersList(),null);

                                }
                            }, new Consumer<Throwable>() {
                                @Override
                                public void accept(Throwable throwable) throws Exception {
                                }
                            }));

    }

    @Override
    public void getLocalData() {
        final List<MyOrdersList> myOrdersLists = new ArrayList<>();
        getCompositeDisposable().add(getDataManager()
                    .getAllOrders()
                    .subscribeOn(Schedulers.io())
                    .observeOn(Schedulers.newThread())
                    .subscribe(new Consumer<List<MyOrdersDetails>>() {
                        @Override
                        public void accept(List<MyOrdersDetails> myOrdersDetailses) throws Exception {
                            Log.e("",""+myOrdersDetailses.get(0).getOrderId());
                            for (int i = 0; i < myOrdersDetailses.size(); i++) {
                                MyOrdersList myOrders = new MyOrdersList();
                                myOrders.setOrderId(myOrdersDetailses.get(i).getOrderId());
                                OrderDetails orderDetails = new OrderDetails();
                                orderDetails.setStatus(myOrdersDetailses.get(i).getStatus());
                                orderDetails.setOrderPickUpDate(myOrdersDetailses.get(i).getOrderpickupdate());
                                orderDetails.setOrderDeliveryDate(myOrdersDetailses.get(i).getOrderDeliveryDate());
                                orderDetails.setOrderDateAdded(myOrdersDetailses.get(i).getOrderDateAdded());
                                orderDetails.setOrderAcceptedBy(myOrdersDetailses.get(i).getOrderAcceptedBy());
                                orderDetails.setFastService(myOrdersDetailses.get(i).getisFastService());
                                orderDetails.setPaymentStatus(myOrdersDetailses.get(i).getPaymentStatus());
                                myOrders.setOrderDetails(orderDetails);
                                myOrdersLists.add(myOrders);
                            }
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {

                        }
                    }));

        getCompositeDisposable().add(getDataManager()
                .getAllItems()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.newThread())
                .subscribe(new Consumer<List<com.faithcapital.justclean.data.db.model.Items>>() {
                    @Override
                    public void accept(List<com.faithcapital.justclean.data.db.model.Items> itemList) throws Exception {
                        ArrayList<Items> itemses = new ArrayList<Items>();

                        for (com.faithcapital.justclean.data.db.model.Items items1 : itemList) {
                            Items items = new Items();
                            items.setItemId(items1.getItemid());
                            items.setItemName(items1.getItemname());
                            items.setItemPrice(items1.getItemprice());
                            items.setItemQty(items1.getItemqty());
                            items.setItemTask(items1.getItemtask());
                            items.orderid= String.valueOf(items1.getOrderid());
                            itemses.add(items);
                        }
                        getMvpView().setAdapter(myOrdersLists,itemses);
                    }

                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                }));

    }

    @Override
    public void getOrderDetailData() {
        getMvpView().setAdapter(null,null);
    }
}
