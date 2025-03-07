package com.fajar.common.preferences

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.fajar.common.util.Constants

class PreferencesManager(context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(Constants.APP_PREFERENCES, Context.MODE_PRIVATE)

    var isOnboardingCompleted: Boolean
        get() = sharedPreferences.getBoolean(Constants.ONBOARDING_KEY_PREFS, false)
        set(value) = sharedPreferences.edit {
            putBoolean(Constants.ONBOARDING_KEY_PREFS, value)
        }
}