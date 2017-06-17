
package com.faithcapital.justclean.di.component;

import com.faithcapital.justclean.di.PerService;
import com.faithcapital.justclean.di.module.ServiceModule;
import com.faithcapital.justclean.service.SyncService;

import dagger.Component;

/**
 * Created by Varun Jain on 16/06/17.
 */

@PerService
@Component(dependencies = ApplicationComponent.class, modules = ServiceModule.class)
public interface ServiceComponent {

    void inject(SyncService service);

}
