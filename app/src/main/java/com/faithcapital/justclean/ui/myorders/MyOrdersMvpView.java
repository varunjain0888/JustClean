package com.faithcapital.justclean.ui.myorders;

import com.faithcapital.justclean.data.db.model.MyOrders;
import com.faithcapital.justclean.data.network.model.Items;
import com.faithcapital.justclean.data.network.model.MyOrdersList;
import com.faithcapital.justclean.ui.base.MvpView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Varun on 2/22/17.
 */

public interface MyOrdersMvpView extends MvpView {

    void setAdapter(List<MyOrdersList> seekerFeedResponseList , ArrayList<Items> itemsArrayList);

}
