package com.sushantc.lohono;

import static com.sushantc.lohono.BaseActivity.getLocale;

import android.app.Application;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDelegate;

import com.pixplicity.easyprefs.library.Prefs;
import com.sushantc.customtheme.ApplyTheme;
import com.test.customlanguage.LocaleManager;

import java.util.Locale;

public class LohonoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        new Prefs.Builder()
                .setContext(getApplicationContext())
                .setMode(MODE_PRIVATE)
                .setPrefsName(getPackageName())
                .setUseDefaultSharedPreference(true)
                .build();


        String selectedTheme = Prefs.getString(AppEnums.THEME_SELECTED.toString(), "");
        if (selectedTheme == null || selectedTheme.isEmpty()) {
            selectedTheme = "DEFAULT";
            Prefs.putString(AppEnums.THEME_SELECTED.toString(), selectedTheme);
            Prefs.putInt(AppEnums.SWITCH_CHECKED_ID.toString(),R.id.btn1);
        }
        ApplyTheme.applyThemeByString(selectedTheme);

        String selectedLanguage = Prefs.getString(AppEnums.LANGUAGE_SELECTED.toString(), "");
        if (selectedLanguage == null || selectedLanguage.isEmpty()) {
            selectedLanguage = "en";
            Prefs.putString(AppEnums.LANGUAGE_SELECTED.toString(), selectedLanguage);
            Prefs.putInt(AppEnums.SWITCH_CHECKED_LANGUAGE_ID.toString(),R.id.lg_btn1);
        }
        LocaleManager.setAppLocale(this, selectedLanguage);

    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        String selectedLanguage = Prefs.getString(AppEnums.LANGUAGE_SELECTED.toString(), "");
        LocaleManager.setAppLocale(this, selectedLanguage);
    }



}
