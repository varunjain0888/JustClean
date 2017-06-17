package com.faithcapital.justclean.ui.main;


import com.faithcapital.justclean.data.DataManager;
import com.faithcapital.justclean.data.network.model.Items;
import com.faithcapital.justclean.ui.base.BasePresenter;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Varun on 2/12/17.
 */

public class MainPresenter<V extends MainMvpView> extends BasePresenter<V> implements MainMvpPresenter<V>{

    @Inject
    public MainPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }
    @Override
    public void setAdapter() {
    }
    @Override
    public void OpenMyOrdersFragment() {
        getMvpView().showMyOrdersFragment();
    }
    @Override
    public void openMyOrderDetailFragment(ArrayList<Items> feedList,String status) {
        getMvpView().showMyOrderDetailFragment(feedList,status);
    }

    @Override
    public void setDrawerData() {
        getMvpView().setUserDetails(getDataManager().getCurrentUserName(),getDataManager().getCurrentUserId());
    }
}
