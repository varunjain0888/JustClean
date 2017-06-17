package com.faithcapital.justclean.di.module;

import android.app.Activity;
import android.content.Context;

import com.faithcapital.justclean.di.ActivityContext;
import com.faithcapital.justclean.di.PerActivity;
import com.faithcapital.justclean.ui.main.MainMvpPresenter;
import com.faithcapital.justclean.ui.main.MainMvpView;
import com.faithcapital.justclean.ui.main.MainPresenter;
import com.faithcapital.justclean.ui.myorders.MyOrdersMvpPresenter;
import com.faithcapital.justclean.ui.myorders.MyOrdersMvpView;
import com.faithcapital.justclean.ui.myorders.MyOrdersPresenter;
import com.faithcapital.justclean.ui.splash.SplashMvpPresenter;
import com.faithcapital.justclean.ui.splash.SplashMvpView;
import com.faithcapital.justclean.ui.splash.SplashPresenter;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Varun on 2/10/17.
 */


@Module
public class ActivityModule {
    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return activity;
    }

    @Provides
    Activity provideActivity() {
        return activity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    @PerActivity
    SplashMvpPresenter<SplashMvpView> provideSplashPresenter(SplashPresenter<SplashMvpView> presenter) {
        return presenter;
    }
    @Provides
    @PerActivity
    MainMvpPresenter<MainMvpView> provideMainPresenter(MainPresenter<MainMvpView> presenter) {
        return presenter;
    }
    @Provides
    @PerActivity
    MyOrdersMvpPresenter<MyOrdersMvpView> provideMyOrdersPresenter(MyOrdersPresenter<MyOrdersMvpView> presenter) {
        return presenter;
    }

}
