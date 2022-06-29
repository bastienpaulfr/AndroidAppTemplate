package fr.bipi.template.di.modules

import fr.bipi.template.data.repository.applog.LogProviderImpl
import fr.bipi.template.data.sources.ExternalStorageDataSource
import fr.bipi.template.data.sources.storage.ExternalFileStorageDataSource
import fr.bipi.template.domain.usecase.logs.LogProvider
import fr.bipi.test.robolectric.RobolectricTest
import org.amshove.kluent.shouldBeInstanceOf
import org.junit.Test
import org.koin.core.component.get

class DataModuleKtTest : RobolectricTest() {

    @Test
    fun externalStorageDataSource() {
        get<ExternalStorageDataSource>() shouldBeInstanceOf ExternalFileStorageDataSource::class
    }

    @Test
    fun logProvider() {
        get<LogProvider>() shouldBeInstanceOf LogProviderImpl::class
    }
}
