package com.faithcapital.justclean.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.faithcapital.justclean.R;
import com.faithcapital.justclean.ui.base.BaseActivity;
import com.faithcapital.justclean.ui.main.MainActivity;


import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by Varun on 2/10/17.
 */

public class SplashActivity extends BaseActivity implements SplashMvpView {
    @Inject
    SplashMvpPresenter<SplashMvpView> mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        mPresenter.onAttach(this);
    }

    @Override
    public void openMyOrderActivity() {
        Intent intent = MainActivity.getStartIntent(this);
        startActivity(intent);
        finish();
    }

    @Override
    protected void setUp() {

    }

    @Override
    public void onFragmentAttached() {

    }

    @Override
    public void onFragmentDetached(String tag) {

    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }
}
