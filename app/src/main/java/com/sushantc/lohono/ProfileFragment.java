package com.sushantc.lohono;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButtonToggleGroup;
import com.pixplicity.easyprefs.library.Prefs;
import com.sushantc.customtheme.ApplyTheme;
import com.sushantc.lohono.databinding.ProfileLayoutBinding;
import com.test.customlanguage.LocaleManager;

public class ProfileFragment extends Fragment {
    private static final String TAG = "ProfileFragment";
    private ProfileLayoutBinding binding;
    private String themeParam = "";
    private String languageParam = "";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.profile_layout, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int previous_selection = Prefs.getInt(AppEnums.SWITCH_CHECKED_ID.toString(),0);
        binding.btgTheme.check(previous_selection);
        binding.btgLanguage.check(Prefs.getInt(AppEnums.SWITCH_CHECKED_LANGUAGE_ID.toString(),0));
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
                Prefs.putString(AppEnums.THEME_SELECTED.toString(),themeParam);
                Prefs.putInt(AppEnums.SWITCH_CHECKED_ID.toString(),checkedId);
            }
        });

        binding.btgLanguage.addOnButtonCheckedListener((group, checkedId, isChecked) -> {

            if (isChecked) {
                switch (checkedId) {
                    case R.id.lg_btn1:
                        languageParam = "en";
                        break;
                    case R.id.lg_btn2:
                        languageParam = "hi";
                        break;
                    case R.id.lg_btn3:
                        languageParam = "mr";
                        break;
                }

                LocaleManager.setAppLocale(getContext(),languageParam);
                Prefs.putString(AppEnums.LANGUAGE_SELECTED.toString(),languageParam);
                Prefs.putInt(AppEnums.SWITCH_CHECKED_LANGUAGE_ID.toString(),checkedId);
                getActivity().recreate();
                Log.i(TAG,languageParam);
            }
        });
    }


}
