package com.sushantc.lohono;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class BaseActivity extends AppCompatActivity {
    private Locale mCurrentLocale;

    @Override
    protected void onStart() {
        super.onStart();

        mCurrentLocale = getResources().getConfiguration().locale;
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Locale locale = getLocale(this);

        if (!locale.equals(mCurrentLocale)) {

            mCurrentLocale = locale;
            recreate();
        }
    }

    public static Locale getLocale(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

        String lang = "Spanish";

        switch (lang) {
            case "English":
                lang = "en";
                break;
            case "Spanish":
                lang = "hi";
                break;
        }
        return new Locale(lang);
    }

}
