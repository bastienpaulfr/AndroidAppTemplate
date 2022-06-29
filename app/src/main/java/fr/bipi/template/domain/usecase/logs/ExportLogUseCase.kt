package fr.bipi.template.domain.usecase.logs

import fr.bipi.template.data.sources.ExternalStorageDataSource
import timber.log.Timber

class ExportLogUseCase(
    private val storage: ExternalStorageDataSource,
    private val logProvider: LogProvider,
) {
    fun exportLogs() {
        storage.getLogsFolder().also { folder ->
            logProvider.getLogFiles().forEach { log ->
                folder.resolve("${log.name}.logcat").apply {
                    Timber.v("Copying ${log.absolutePath} to $absolutePath")
                    if (exists()) {
                        delete()
                    }
                    log.copyTo(this)
                }
            }
        }
    }

    fun clearLogs() {
        logProvider.clearFileLog()
    }
}
