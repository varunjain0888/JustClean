package com.faithcapital.justclean.ui.main;



import com.faithcapital.justclean.data.network.model.Items;
import com.faithcapital.justclean.data.network.model.MyOrdersList;
import com.faithcapital.justclean.ui.base.MvpView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Varun on 2/12/17.
 */

public interface MainMvpView extends MvpView {

    void loadDataInAdapter(List<MyOrdersList> myOrdersList);

    void showMyOrdersFragment();

    void showMyOrderDetailFragment(ArrayList<Items> feedList,String status);

    void setUserDetails(String userName, String userId);

}
