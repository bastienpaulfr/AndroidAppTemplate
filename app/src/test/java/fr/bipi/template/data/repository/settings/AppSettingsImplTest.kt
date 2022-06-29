package fr.bipi.template.data.repository.settings

import fr.bipi.template.BuildConfig
import fr.bipi.template.BuildConfig.DEBUG
import fr.bipi.test.robolectric.RobolectricTest
import org.amshove.kluent.shouldBeEqualTo
import org.junit.Before
import org.junit.Test

class AppSettingsImplTest : RobolectricTest() {

    lateinit var appSettingsImpl: AppSettingsImpl

    @Before
    fun setUp() {
        appSettingsImpl = AppSettingsImpl(
            testDiUtils.provideSharedPreferences(),
        )
    }

    @Test
    fun getVersion() {
        appSettingsImpl.version.shouldBeEqualTo(BuildConfig.VERSION_NAME + (if (DEBUG) " debug" else ""))
    }
}
