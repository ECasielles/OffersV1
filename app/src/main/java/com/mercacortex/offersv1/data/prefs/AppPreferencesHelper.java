package com.mercacortex.offersv1.data.prefs;


import android.content.Context;
import android.content.SharedPreferences;

import com.mercacortex.offersv1.ui.OfferApplication;

public class AppPreferencesHelper implements GeneralPreferencesHelper {

    //1.- Se definen (en la interfaz) todas las claves posibles del fichero preferencias

    //2.- Objeto para editar las preferencias
    private final SharedPreferences sharedPreferences;
    private static AppPreferencesHelper appPreferencesHelper;

    private AppPreferencesHelper() {
        sharedPreferences = OfferApplication.getContext().getSharedPreferences(OfferApplication.PREF_NAME, Context.MODE_PRIVATE);
    }

    public static AppPreferencesHelper getInstance() {
        if (appPreferencesHelper == null)
            appPreferencesHelper = new AppPreferencesHelper();
        return appPreferencesHelper;
    }

    /**
     * ID SQLite
     * @return
     */
    public long getCurrentUserId() {
        return sharedPreferences.getLong(PREF_KEY_CURRENT_USER_ID, OfferApplication.NULL_INDEX);
    }
    public String getCurrentUserName() {
        return sharedPreferences.getString(PREF_KEY_CURRENT_USER_NAME, null);
    }
    public String getCurrentUserPassword() {
        return sharedPreferences.getString(PREF_KEY_CURRENT_USER_PASSWORD, null);
    }
    public boolean getCurrentUserRemember() {
        return  sharedPreferences.getBoolean(PREF_KEY_CURRENT_USER_REMEMBER, false);
    }
    public void setCurrentUserId(long id) {
        sharedPreferences.edit().putLong(PREF_KEY_CURRENT_USER_ID, id).apply();
    }
    public void setCurrentUserName(String name) {
        sharedPreferences.edit().putString(PREF_KEY_CURRENT_USER_NAME, name).apply();
    }
    public void setCurrentUserPassword(String password) {
        sharedPreferences.edit().putString(PREF_KEY_CURRENT_USER_PASSWORD, password).apply();
    }
    public void setCurrentUserRemember(boolean remember) {
        sharedPreferences.edit().putBoolean(PREF_KEY_CURRENT_USER_REMEMBER, remember).apply();
    }

}
