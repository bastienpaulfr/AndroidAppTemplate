package fr.bipi.template.di.modules

import fr.bipi.template.ui.common.components.Toaster
import org.koin.dsl.module

val uiModule by lazy {
    module {
        // --- Toaster ---
        single { Toaster(get()) }
    }
}
