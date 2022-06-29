package fr.bipi.template.data.sources

import java.io.File

interface ExternalStorageDataSource {
    fun getAppFolder(): File

    fun getLogsFolder(): File
}
