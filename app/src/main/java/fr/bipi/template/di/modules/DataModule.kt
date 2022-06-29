package fr.bipi.template.di.modules

import fr.bipi.template.data.repository.applog.LogProviderImpl
import fr.bipi.template.data.sources.ExternalStorageDataSource
import fr.bipi.template.data.sources.storage.ExternalFileStorageDataSource
import fr.bipi.template.domain.usecase.logs.LogProvider
import org.koin.dsl.module

val dataModule by lazy {
    module {
        // Data sources
        single<ExternalStorageDataSource> { ExternalFileStorageDataSource() }

        // Repositories
        single<LogProvider> { LogProviderImpl() }
    }
}
