package fr.bipi.template

import android.app.Application
import fr.bipi.template.di.log.timberLogger
import fr.bipi.template.di.modules.appModule
import fr.bipi.template.di.modules.dataModule
import fr.bipi.template.di.modules.domainModule
import fr.bipi.template.di.modules.interactorsModule
import fr.bipi.template.di.modules.scopesModule
import fr.bipi.template.di.modules.uiModule
import fr.bipi.template.di.modules.viewModelModule
import fr.bipi.template.domain.usecase.logs.LogProvider
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        setupDi()
        setupLog()
    }

    private fun setupDi() {
        startKoin {
            timberLogger()
            androidContext(this@App)
            modules(appModule)
            modules(dataModule)
            modules(domainModule)
            modules(interactorsModule)
            modules(scopesModule)
            modules(uiModule)
            modules(viewModelModule)
        }
    }

    private fun setupLog() {
        val logProvider: LogProvider = GlobalContext.get().get()
        logProvider.plant(this)
    }
}
