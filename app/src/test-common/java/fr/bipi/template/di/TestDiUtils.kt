package fr.bipi.template.di

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import androidx.test.core.app.ApplicationProvider

class TestDiUtils {
    fun provideContext(): Context = ApplicationProvider.getApplicationContext()

    fun provideSharedPreferences(): SharedPreferences =
        PreferenceManager.getDefaultSharedPreferences(provideContext())
}
