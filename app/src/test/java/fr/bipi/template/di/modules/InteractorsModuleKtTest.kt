package fr.bipi.template.di.modules

import fr.bipi.template.interactors.rx.AppSchedulers
import fr.bipi.template.interactors.rx.SchedulersInteractor
import fr.bipi.test.robolectric.RobolectricTest
import org.amshove.kluent.shouldBeInstanceOf
import org.junit.Test
import org.koin.core.component.get

class InteractorsModuleKtTest : RobolectricTest() {

    @Test
    fun appSchedulers() {
        get<AppSchedulers>() shouldBeInstanceOf SchedulersInteractor::class
    }
}
