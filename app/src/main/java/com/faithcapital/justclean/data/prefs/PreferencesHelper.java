
package com.faithcapital.justclean.data.prefs;


import com.faithcapital.justclean.data.DataManager;

/**
 * Created by Varun Jain on 27/01/17.
 */

public interface PreferencesHelper {

    String getAccessToken();

    void setAccessToken(String accessToken);

    String getCurrentUserId();

    void setCurrentUserId(String userId);

    String getCurrentUserName();

    void setCurrentUserName(String username);
}
