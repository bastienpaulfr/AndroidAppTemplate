package fr.bipi.template.data.repository.applog

import android.content.Context
import android.util.Log
import fr.bipi.tressence.base.PriorityTree
import fr.bipi.tressence.common.filters.TagFilter
import fr.bipi.tressence.file.FileLoggerTree
import fr.bipi.tressence.sentry.SentryBreadcrumbTree
import fr.bipi.tressence.sentry.SentryEventTree
import fr.bipi.template.BuildConfig
import fr.bipi.template.domain.usecase.logs.LogProvider
import io.sentry.Sentry
import io.sentry.SentryUncaughtExceptionHandler
import io.sentry.android.AndroidSentryClientFactory
import io.sentry.connection.EventSendCallback
import io.sentry.event.Event
import timber.log.Timber
import java.io.File

class LogProviderImpl : LogProvider {

    companion object {
        private const val SENTRY_DSN = ""
    }

    private var fileTree: FileLoggerTree? = null

    override fun getLogFiles(): Collection<File> {
        return fileTree?.files ?: emptyList()
    }

    override fun clearFileLog() {
        fileTree?.let {
            it.files.forEach { file ->
                file.writeText("")
                Timber.v("${file.absolutePath} deleted")
            }
        }
    }

    override fun plant(context: Context) {

        when {
            BuildConfig.DEBUG -> Timber.plant(Timber.DebugTree())
            else -> Timber.plant(PriorityTree(Log.WARN))
        }

        // File Log
        plantFileTree(context)

        // Sentry
        if (!BuildConfig.DEBUG && SENTRY_DSN.isNotEmpty()) {
            Sentry.init(SENTRY_DSN, AndroidSentryClientFactory(context))
            Sentry.getStoredClient().addEventSendCallback(object : EventSendCallback {
                override fun onFailure(event: Event, exception: Exception) {
                    if (BuildConfig.DEBUG) {
                        Timber.e(exception, "Event : $event, e : $exception")
                    } else {
                        Timber.v("Event : $event, e : $exception")
                    }
                }

                override fun onSuccess(event: Event?) {
                }
            })
            SentryUncaughtExceptionHandler.setup()

            // Do not send log to itself
            Timber.plant(SentryBreadcrumbTree(Log.VERBOSE, filter = TagFilter("^(?!.*(Sentry|App)).*")))
            Timber.plant(SentryEventTree(Log.ASSERT, filter = TagFilter("^(?!.*(Sentry|App)).*")))
        }
    }

    private fun plantFileTree(context: Context) {
        provideFileTree(context)?.also {
            Timber.plant(it)
        }
    }

    private fun provideFileTree(context: Context): FileLoggerTree? {
        return try {
            FileLoggerTree.Builder()
                .withDirName(context.filesDir.absolutePath)
                .withMinPriority(Log.VERBOSE).build().also {
                    fileTree = it
                }
        } catch (e: Exception) {
            Timber.w(e)
            null
        }
    }
}
