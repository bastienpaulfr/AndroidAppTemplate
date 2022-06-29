package fr.bipi.template.di.modules

import fr.bipi.template.ui.common.components.Toaster
import fr.bipi.test.robolectric.RobolectricTest
import org.amshove.kluent.shouldBeInstanceOf
import org.junit.Test
import org.koin.core.component.get

class UiModuleKtTest : RobolectricTest() {

    @Test
    fun toaster() {
        get<Toaster>() shouldBeInstanceOf Toaster::class
    }
}
