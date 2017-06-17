package com.faithcapital.justclean.di.module;

import android.app.Application;
import android.content.Context;


import com.faithcapital.justclean.BuildConfig;
import com.faithcapital.justclean.R;
import com.faithcapital.justclean.data.AppDataManager;
import com.faithcapital.justclean.data.DataManager;
import com.faithcapital.justclean.data.db.AppDbHelper;
import com.faithcapital.justclean.data.db.DbHelper;
import com.faithcapital.justclean.data.network.ApiHeader;
import com.faithcapital.justclean.data.network.ApiHelper;
import com.faithcapital.justclean.data.network.AppApiHelper;
import com.faithcapital.justclean.data.prefs.AppPreferencesHelper;
import com.faithcapital.justclean.data.prefs.PreferencesHelper;
import com.faithcapital.justclean.di.ApiInfo;
import com.faithcapital.justclean.di.ApplicationContext;
import com.faithcapital.justclean.di.DatabaseInfo;
import com.faithcapital.justclean.di.PreferenceInfo;
import com.faithcapital.justclean.util.AppConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by Varun on 2/10/17.
 */
@Module
public class ApplicationModule {
    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @ApiInfo
    String provideApiKey() {
        return BuildConfig.API_KEY;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @Singleton
    ApiHeader.ProtectedApiHeader provideProtectedApiHeader(@ApiInfo String apiKey, PreferencesHelper preferencesHelper) {
        return new ApiHeader.ProtectedApiHeader(
                apiKey,
                preferencesHelper.getCurrentUserId(),
                preferencesHelper.getAccessToken());
    }

    @Provides
    @Singleton
    CalligraphyConfig provideCalligraphyDefaultConfig() {
        return new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/source-sans-pro/SourceSansPro-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build();
    }
}
