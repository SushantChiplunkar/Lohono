package com.sushantc.lohono;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.text.BidiFormatter;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;
import com.pixplicity.easyprefs.library.Prefs;
import com.sushantc.lohono.databinding.ActivityHomeScreenBinding;
import com.test.customlanguage.LocaleManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class HomeScreen extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = "HomeScreen";
    private ActivityHomeScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LocaleManager.setAppLocale(this, Prefs.getString(AppEnums.LANGUAGE_SELECTED.toString(),"en"));
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home_screen);
        binding.setLifecycleOwner(this);

        setSupportActionBar(binding.toolbarHome.customToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(HomeScreen.this, binding.drl, binding.toolbarHome.customToolbar
                , R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        binding.drl.addDrawerListener(toggle);
        toggle.syncState();
        binding.nv.setNavigationItemSelectedListener(HomeScreen.this);
        setTitle(getString(R.string.hs_home));
        if (savedInstanceState==null) {
            getSupportFragmentManager().beginTransaction().add(binding.fl.getId(),new HomeFragment()).commit();
        }

    }



    @Override
    public void onBackPressed() {
        if (binding.drl.isDrawerOpen(GravityCompat.START)) {
            binding.drl.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId() ;
        Fragment selectedFragment = null;
        switch (id){
            case R.id.nv_home: setTitle(getString(R.string.hs_home));
                selectedFragment = new HomeFragment();
            break;
            case R.id.nv_about: setTitle(getString(R.string.hs_about));
                selectedFragment = new AboutFragment();
            break;
            case R.id.nv_profile: setTitle(getString(R.string.hs_profile));
                selectedFragment = new ProfileFragment();
            break;
        }

        if (selectedFragment!=null) {
            getSupportFragmentManager().beginTransaction().replace(binding.fl.getId(),selectedFragment).commit();
        }
        if (binding.drl.isDrawerOpen(GravityCompat.START)) {
            binding.drl.closeDrawer(GravityCompat.START);
        }
        return false;
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (binding.drl.isDrawerOpen(GravityCompat.START)) {
            binding.drl.closeDrawer(GravityCompat.START);
        }
    }
}