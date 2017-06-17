
package com.faithcapital.justclean.data;


import com.faithcapital.justclean.data.db.DbHelper;
import com.faithcapital.justclean.data.network.ApiHelper;
import com.faithcapital.justclean.data.prefs.PreferencesHelper;

import io.reactivex.Observable;

/**
 * Created by Varun Jain on 10/02/17.
 */

public interface DataManager extends DbHelper, PreferencesHelper, ApiHelper {

    void updateApiHeader(String userId, String accessToken);

    Observable<Boolean> seedDatabaseOrderList();

}
