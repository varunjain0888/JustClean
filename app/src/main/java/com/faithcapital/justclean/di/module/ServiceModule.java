
package com.faithcapital.justclean.di.module;

import android.app.Service;

import dagger.Module;

/**
 * Created by Varun Jain on 01/02/17.
 */

@Module
public class ServiceModule {

    private final Service mService;

    public ServiceModule(Service service) {
        mService = service;
    }
}
