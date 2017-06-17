package com.faithcapital.justclean.ui.base;

/**
 * Created by Varun on 2/10/17.
 */

public interface MvpSubView extends MvpView {
    void onCreate();

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void onDestroy();

    void attachParentMvpView(MvpView mvpView);
}
