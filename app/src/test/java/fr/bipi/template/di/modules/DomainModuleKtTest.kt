package fr.bipi.template.di.modules

import fr.bipi.template.domain.usecase.logs.ExportLogUseCase
import fr.bipi.test.robolectric.RobolectricTest
import org.amshove.kluent.shouldBeInstanceOf
import org.junit.Test
import org.koin.core.component.get

class DomainModuleKtTest : RobolectricTest() {

    @Test
    fun exportLogUseCase() {
        get<ExportLogUseCase>() shouldBeInstanceOf ExportLogUseCase::class
    }
}
