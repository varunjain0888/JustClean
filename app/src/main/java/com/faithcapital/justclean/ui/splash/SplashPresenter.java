package com.faithcapital.justclean.ui.splash;

import android.os.Handler;
import android.util.Log;


import com.faithcapital.justclean.data.DataManager;
import com.faithcapital.justclean.data.db.model.MyOrders;
import com.faithcapital.justclean.data.db.model.MyOrdersDetails;
import com.faithcapital.justclean.data.db.model.MyOrdersList;
import com.faithcapital.justclean.data.network.model.GetOrdersResponse;

import com.faithcapital.justclean.ui.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Varun on 2/10/17.
 */

public class SplashPresenter <V extends SplashMvpView> extends BasePresenter<V> implements SplashMvpPresenter<V>{

    @Inject
    public SplashPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
       /* getCompositeDisposable().add(getDataManager()
                .doGetAllOrdersApiCall()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.newThread())
                .subscribe(new Consumer<MyOrders>() {
                    @Override
                    public void accept(MyOrders getOrdersResponse) throws Exception {

                        getCompositeDisposable().add(getDataManager()
                                .insertAllOrders(getOrdersResponse.getOrders())
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
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e("","Ooooonnooooo"+throwable.getMessage());
                    }
                }));*/
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                decideNextActivity();
            }
        },3000);
    }
    private void decideNextActivity(){
        getMvpView().openMyOrderActivity();

    }
    }

