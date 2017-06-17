package com.faithcapital.justclean.data.network;

import com.faithcapital.justclean.data.db.model.MyOrders;
import com.faithcapital.justclean.data.network.model.GetOrdersResponse;
import com.faithcapital.justclean.data.network.model.MyOrdersList;
import com.rx2androidnetworking.Rx2AndroidNetworking;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by Varun on 2/10/17.
 */

public class AppApiHelper implements ApiHelper{
    private ApiHeader mApiHeader;

    @Inject
    public AppApiHelper(ApiHeader apiHeader) {
        mApiHeader = apiHeader;
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHeader;
    }

    @Override
    public Observable<GetOrdersResponse> doGetAllOrdersApiCall() {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_GET_ALL_ORDERS)
                .addHeaders(mApiHeader.getPublicApiHeader())
                .build()
                .getObjectObservable(GetOrdersResponse.class);
    }
}
