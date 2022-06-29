package fr.bipi.template.di.modules

import fr.bipi.template.ui.settings.AppSettingsViewModel
import fr.bipi.test.robolectric.RobolectricTest
import org.junit.Test
import org.koin.core.component.get

class ViewModelModuleKtTest : RobolectricTest() {

    @Test
    fun appSettingsViewModel() {
        get<AppSettingsViewModel>()
    }
}
