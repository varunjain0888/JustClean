package com.faithcapital.justclean.data.network;


import com.faithcapital.justclean.BuildConfig;

/**
 * Created by Varun Jain on 16/06/17.
 */

public final class ApiEndPoint {

    public static final String ENDPOINT_GET_ALL_ORDERS = BuildConfig.BASE_URL + "test.json";

    private ApiEndPoint() {
        // This class is not publicly instantiable
    }

}
