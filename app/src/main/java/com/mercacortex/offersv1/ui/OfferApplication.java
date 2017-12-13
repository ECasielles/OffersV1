package com.mercacortex.offersv1.ui;

import android.app.Application;
import android.content.Context;

import com.mercacortex.offersv1.data.prefs.AppPreferencesHelper;



public class OfferApplication extends Application {

    public static final String PREF_NAME = "PREF_NAME";
    public static final long NULL_INDEX = -1L;
    private static OfferApplication offerApplication;
    private static AppPreferencesHelper appPreferencesHelper;

    private OfferApplication() {
        offerApplication = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appPreferencesHelper = AppPreferencesHelper.getInstance();
    }

    public static Context getContext() {
        return offerApplication;
    }

    public AppPreferencesHelper getAppPreferencesHelper() {
        return appPreferencesHelper;
    }

}
