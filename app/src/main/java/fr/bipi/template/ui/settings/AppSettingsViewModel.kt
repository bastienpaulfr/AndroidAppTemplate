package fr.bipi.template.ui.settings

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import fr.bipi.template.domain.usecase.logs.ExportLogUseCase
import fr.bipi.template.interactors.rx.AppSchedulers
import io.reactivex.Flowable

class AppSettingsViewModel(
    private val exportLogUseCase: ExportLogUseCase,
    private val appSchedulers: AppSchedulers
) : ViewModel() {

    fun exportLogs(): LiveData<ExportLogState> {
        return LiveDataReactiveStreams.fromPublisher(
            Flowable.fromCallable<ExportLogState> {
                exportLogUseCase.exportLogs()
                return@fromCallable ExportLogState.Done
            }.startWith(ExportLogState.Running)
                .subscribeOn(appSchedulers.io)
        )
    }

    fun clearLogs() {
        exportLogUseCase.clearLogs()
    }

    sealed class ExportLogState {
        object Running : ExportLogState()
        object Done : ExportLogState()
    }
}
