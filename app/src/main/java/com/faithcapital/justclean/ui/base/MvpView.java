package com.faithcapital.justclean.ui.base;

import android.support.annotation.StringRes;

/**
 * Created by Varun on 2/10/17.
 */

public interface MvpView {

    void showLoading();

    void hideLoading();

    void onError(@StringRes int resId);

    void onError(String message);

    void openActivityOnTokenExpire();

    boolean isNetworkConnected();

    void hideKeyboard();


}
