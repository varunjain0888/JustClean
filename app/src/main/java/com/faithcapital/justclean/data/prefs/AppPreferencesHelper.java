
package com.faithcapital.justclean.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;


import com.faithcapital.justclean.di.ApplicationContext;
import com.faithcapital.justclean.di.PreferenceInfo;
import com.faithcapital.justclean.util.AppConstants;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Varun Jain on 10/02/17.
 */

@Singleton
public class AppPreferencesHelper implements PreferencesHelper {

    private static final String PREF_KEY_USER_LOGGED_IN_MODE = "PREF_KEY_USER_LOGGED_IN_MODE";
    private static final String PREF_KEY_CURRENT_USER_ID = "PREF_KEY_CURRENT_USER_ID";
    private static final String PREF_KEY_CURRENT_USER_NAME = "PREF_KEY_CURRENT_USER_NAME";
    private static final String PREF_KEY_CURRENT_USER_EMAIL = "PREF_KEY_CURRENT_USER_EMAIL";
    private static final String PREF_KEY_CURRENT_USER_PROFILE_PIC_URL = "PREF_KEY_CURRENT_USER_PROFILE_PIC_URL";
    private static final String PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN";

    private final SharedPreferences mPrefs;

    @Inject
    public AppPreferencesHelper(@ApplicationContext Context context, @PreferenceInfo String prefFileName) {
        mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
    }

    @Override
    public String getAccessToken() {
        return mPrefs.getString(PREF_KEY_ACCESS_TOKEN, null);
    }

    @Override
    public void setAccessToken(String accessToken) {
        mPrefs.edit().putString(PREF_KEY_ACCESS_TOKEN, accessToken).apply();
    }
    @Override
    public String getCurrentUserId() {
        String userId = mPrefs.getString(PREF_KEY_CURRENT_USER_ID, "");
        return userId;
    }

    @Override
    public String getCurrentUserName() {
        String userName = mPrefs.getString(PREF_KEY_CURRENT_USER_NAME, "");
        return userName;
    }

    @Override
    public void setCurrentUserName(String username) {
        mPrefs.edit().putString(PREF_KEY_CURRENT_USER_NAME, username).apply();
    }

    @Override
    public void setCurrentUserId(String userId) {
        mPrefs.edit().putString(PREF_KEY_CURRENT_USER_ID, userId).apply();
    }
}
