package com.faithcapital.justclean.di.component;

import android.app.Application;
import android.content.Context;


import com.faithcapital.justclean.JustCleanApp;
import com.faithcapital.justclean.data.DataManager;
import com.faithcapital.justclean.di.ApplicationContext;
import com.faithcapital.justclean.di.module.ApplicationModule;
import com.faithcapital.justclean.service.SyncService;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Varun on 2/10/17.
 */
@Singleton
@Component(modules = ApplicationModule.class)

public interface ApplicationComponent {

    void inject(JustCleanApp app);

    void inject(SyncService service);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();

}
