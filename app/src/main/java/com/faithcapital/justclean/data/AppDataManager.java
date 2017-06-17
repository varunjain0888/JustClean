
package com.faithcapital.justclean.data;


import android.content.Context;

import com.faithcapital.justclean.data.db.DbHelper;
import com.faithcapital.justclean.data.db.model.Items;
import com.faithcapital.justclean.data.db.model.MyOrders;
import com.faithcapital.justclean.data.db.model.MyOrdersDetails;
import com.faithcapital.justclean.data.db.model.MyOrdersList;
import com.faithcapital.justclean.data.network.ApiHeader;
import com.faithcapital.justclean.data.network.ApiHelper;
import com.faithcapital.justclean.data.network.model.GetOrdersResponse;
import com.faithcapital.justclean.data.prefs.PreferencesHelper;
import com.faithcapital.justclean.di.ApplicationContext;
import com.faithcapital.justclean.util.AppConstants;
import com.faithcapital.justclean.util.CommonUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.$Gson$Types;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

/**
 * Created by Varun Jain on 10/02/17.
 */

@Singleton
public class AppDataManager implements DataManager {

    private static final String TAG = "AppDataManager";

    private final Context mContext;
    private final DbHelper mDbHelper;
    private final PreferencesHelper mPreferencesHelper;
    private final ApiHelper mApiHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context,
                          DbHelper dbHelper,
                          PreferencesHelper preferencesHelper,
                          ApiHelper apiHelper) {
        mContext = context;
        mDbHelper = dbHelper;
        mPreferencesHelper = preferencesHelper;
        mApiHelper = apiHelper;
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHelper.getApiHeader();
    }

    @Override
    public Observable<GetOrdersResponse> doGetAllOrdersApiCall() {
        return mApiHelper.doGetAllOrdersApiCall();
    }

    @Override
    public String getAccessToken() {
        return mPreferencesHelper.getAccessToken();
    }

    @Override
    public void setAccessToken(String accessToken) {
        mPreferencesHelper.setAccessToken(accessToken);
        mApiHelper.getApiHeader().getProtectedApiHeader().setAccessToken(accessToken);
    }

    @Override
    public String getCurrentUserId() {
        return mPreferencesHelper.getCurrentUserId();
    }

    @Override
    public void setCurrentUserId(String userId) {
         mPreferencesHelper.setCurrentUserId(userId);
    }

    @Override
    public String getCurrentUserName() {
        return mPreferencesHelper.getCurrentUserName();
    }

    @Override
    public void setCurrentUserName(String username) {
        mPreferencesHelper.setCurrentUserName(username);
    }


    @Override
    public void updateApiHeader(String userId, String accessToken) {
        mApiHelper.getApiHeader().getProtectedApiHeader().setUserId(userId);
        mApiHelper.getApiHeader().getProtectedApiHeader().setAccessToken(accessToken);
    }

    @Override
    public Observable<Boolean> seedDatabaseOrderList() {
        GsonBuilder builder = new GsonBuilder().excludeFieldsWithoutExposeAnnotation();
        final Gson gson = builder.create();

        return mDbHelper.isOrdersEmpty()
                .concatMap(new Function<Boolean, ObservableSource<? extends Boolean>>() {
                    @Override
                    public ObservableSource<? extends Boolean> apply(Boolean isEmpty)
                            throws Exception {
                        if (isEmpty) {
                            Type type = $Gson$Types
                                    .newParameterizedTypeWithOwner(null, List.class,
                                            MyOrders.class);
                            List<MyOrders> questionList = gson.fromJson(
                                    mApiHelper.doGetAllOrdersApiCall().toString(),
                                    type);

                            return insertAllOrders(new ArrayList<MyOrdersList>());
                        }
                        return Observable.just(false);
                    }
                });
    }

    @Override
    public Observable<Boolean> insertAllOrders(List<MyOrdersList> myOrders) {
        return mDbHelper.insertAllOrders(myOrders);
    }

    @Override
    public Observable<Boolean> insertOrders(MyOrdersDetails myOrders) {
        return mDbHelper.insertOrders(myOrders);
    }

    @Override
    public Observable<Boolean> insertItems(Items items) {
        return mDbHelper.insertItems(items);
    }

    @Override
    public Observable<List<MyOrdersDetails>> getAllOrders() {
        return mDbHelper.getAllOrders();
    }

    @Override
    public Observable<List<Items>> getAllItems() {
        return mDbHelper.getAllItems();
    }

    @Override
    public Observable<Boolean> isOrdersEmpty() {
        return mDbHelper.isOrdersEmpty();
    }

    @Override
    public Observable<Boolean> saveOrder(MyOrdersDetails myOrders) {
        return mDbHelper.saveOrder(myOrders);
    }

    @Override
    public Observable<Boolean> deleteItems() {
        return mDbHelper.deleteItems();
    }
}
