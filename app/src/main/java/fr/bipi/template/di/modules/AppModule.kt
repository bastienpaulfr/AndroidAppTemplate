package fr.bipi.template.di.modules

import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import fr.bipi.template.data.repository.settings.AppSettings
import fr.bipi.template.data.repository.settings.AppSettingsImpl
import org.koin.dsl.module

val appModule by lazy {
    module {
        // --- Android ---
        single<SharedPreferences> { PreferenceManager.getDefaultSharedPreferences(get()) }

        // --- Settings ---
        single<AppSettings> { AppSettingsImpl(get()) }
    }
}
