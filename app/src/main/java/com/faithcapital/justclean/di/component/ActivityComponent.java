package com.faithcapital.justclean.di.component;


import com.faithcapital.justclean.data.db.model.MyOrdersDetails;
import com.faithcapital.justclean.di.PerActivity;
import com.faithcapital.justclean.di.module.ActivityModule;
import com.faithcapital.justclean.ui.main.MainActivity;
import com.faithcapital.justclean.ui.myorders.MyOrdersDetailFragment;
import com.faithcapital.justclean.ui.myorders.MyOrdersFragment;
import com.faithcapital.justclean.ui.splash.SplashActivity;

import dagger.Component;

/**
 * Created by Varun on 16/06/17.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(SplashActivity activity);

    void inject(MainActivity activity);

    void inject(MyOrdersFragment fragment);

    void inject(MyOrdersDetailFragment fragment);

}
