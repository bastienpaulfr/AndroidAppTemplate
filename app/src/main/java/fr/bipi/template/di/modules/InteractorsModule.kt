package fr.bipi.template.di.modules

import fr.bipi.template.interactors.rx.AppSchedulers
import fr.bipi.template.interactors.rx.SchedulersInteractor
import org.koin.dsl.module

val interactorsModule by lazy {
    module {
        // --- Rx ---
        single<AppSchedulers> { SchedulersInteractor() }
    }
}
