package com.sushantc.lohono;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.sushantc.customtheme.ApplyTheme;
import com.sushantc.lohono.databinding.ActivityProfileScreenBinding;

public class ProfileScreen extends AppCompatActivity {
    private ActivityProfileScreenBinding binding;
    private String themeParam = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_profile_screen);
        binding.setLifecycleOwner(this);
        setSupportActionBar(binding.toolbarProfile.customToolbar);
        getSupportActionBar().setTitle("Profile");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        binding.btgTheme.addOnButtonCheckedListener((group, checkedId, isChecked) -> {
            if (isChecked) {
                switch (checkedId) {
                    case R.id.btn1:
                        themeParam = "DEFAULT";
                        break;
                    case R.id.btn2:
                        themeParam = "DARK";
                        break;
                    case R.id.btn3:
                        themeParam = "LIGHT";
                        break;
                }

                ApplyTheme.applyThemeByString(themeParam);
            }
        });
    }
}