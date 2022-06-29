package fr.bipi.template.interactors.os

import android.annotation.SuppressLint
import android.content.Context
import android.os.Environment
import android.provider.Settings
import fr.bipi.template.BuildConfig
import timber.log.Timber
import java.io.File
import java.util.Calendar
import java.util.Date

const val FOLDER_LOGS = "logs"

interface OsInteractor {
    val currentDate: Date

    val calendar: Calendar

    fun getLogExportFolder(): File
}

class OsInteractorImpl(
    private val context: Context
) : OsInteractor {
    override val currentDate: Date
        get() = Calendar.getInstance().time

    override val calendar: Calendar
        get() = Calendar.getInstance()

    override fun getLogExportFolder(): File {
        return Environment.getExternalStorageDirectory().resolve(BuildConfig.APPLICATION_ID).resolve(FOLDER_LOGS).apply {
            if (isFile) {
                delete()
            }
            if (!isDirectory) {
                mkdirs()
            }
        }
    }
}
