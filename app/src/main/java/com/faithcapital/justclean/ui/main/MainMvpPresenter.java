package com.faithcapital.justclean.ui.main;

import com.faithcapital.justclean.data.network.model.Items;
import com.faithcapital.justclean.di.PerActivity;
import com.faithcapital.justclean.ui.base.MvpPresenter;

import java.util.ArrayList;

/**
 * Created by Varun on 2/12/17.
 */
@PerActivity
public interface MainMvpPresenter<V extends MainMvpView> extends MvpPresenter<V> {

    void setAdapter();

    void OpenMyOrdersFragment();

    void openMyOrderDetailFragment(ArrayList<Items> feedList,String status);

    void setDrawerData();

}
