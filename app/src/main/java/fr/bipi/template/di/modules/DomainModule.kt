package fr.bipi.template.di.modules

import fr.bipi.template.domain.usecase.logs.ExportLogUseCase
import org.koin.dsl.module

val domainModule by lazy {
    module {
        single { ExportLogUseCase(get(), get()) }
    }
}
