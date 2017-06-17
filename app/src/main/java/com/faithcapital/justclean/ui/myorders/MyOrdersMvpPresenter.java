package com.faithcapital.justclean.ui.myorders;


import com.faithcapital.justclean.di.PerActivity;
import com.faithcapital.justclean.ui.base.MvpPresenter;

/**
 * Created by Varun on 2/22/17.
 */
@PerActivity
public interface MyOrdersMvpPresenter<V extends MyOrdersMvpView> extends MvpPresenter<V> {

    void getServerData();

    void getLocalData();

    void getOrderDetailData();
}
