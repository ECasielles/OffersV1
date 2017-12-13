package com.mercacortex.offersv1.ui.preferences;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import com.mercacortex.offersv1.R;

public class GeneralSettingsActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings_general);
    }
}
