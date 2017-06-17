
package com.faithcapital.justclean.data.network;

import com.faithcapital.justclean.data.db.model.MyOrders;
import com.faithcapital.justclean.data.network.model.GetOrdersResponse;

import io.reactivex.Observable;

/**
 * Created by Varun Jain on 27/01/17.
 */

public interface ApiHelper {

    ApiHeader getApiHeader();

    Observable<GetOrdersResponse> doGetAllOrdersApiCall();

}
