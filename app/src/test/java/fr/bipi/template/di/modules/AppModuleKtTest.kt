package fr.bipi.template.di.modules

import android.content.SharedPreferences
import fr.bipi.template.data.repository.settings.AppSettings
import fr.bipi.template.data.repository.settings.AppSettingsImpl
import fr.bipi.test.robolectric.RobolectricTest
import org.amshove.kluent.shouldBeInstanceOf
import org.junit.Test
import org.koin.core.component.get

class AppModuleKtTest : RobolectricTest() {

    @Test
    fun sharedPreferences() {
        get<SharedPreferences>()
    }

    @Test
    fun appSettings() {
        get<AppSettings>() shouldBeInstanceOf AppSettingsImpl::class
    }
}
