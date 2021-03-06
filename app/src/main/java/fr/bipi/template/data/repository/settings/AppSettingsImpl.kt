package fr.bipi.template.data.repository.settings

import android.content.SharedPreferences

private const val KEY_PREFERENCE = "key_preference"

private const val PREFERENCE_DEF = 1.1

class AppSettingsImpl(private val pref: SharedPreferences) : AppSettings {

    override val preference: Double
        get() = pref.getString(KEY_PREFERENCE, null)?.toDouble() ?: PREFERENCE_DEF
}
