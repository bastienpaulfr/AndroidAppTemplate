package fr.bipi.template.data.sources.storage

import android.os.Environment
import fr.bipi.template.BuildConfig
import fr.bipi.template.data.sources.ExternalStorageDataSource
import java.io.File

/**
 * This class gives all folders to store internal data.
 *
 * Directories are organized as followed for citizens :
 * - {internal/external storage root}/citizen/{citizenId}/{type : (picture/fp/pdf/etc.}/
 */
class ExternalFileStorageDataSource : ExternalStorageDataSource {

    companion object {
        const val FOLDER_APP = BuildConfig.APPLICATION_ID
        private const val FOLDER_LOGS = "logs"
    }

    override fun getAppFolder(): File {
        return Environment.getExternalStorageDirectory()
            .resolve(FOLDER_APP)
    }

    override fun getLogsFolder(): File {
        return getAppFolder()
            .resolve(FOLDER_LOGS)
            .apply {
                if (!exists()) {
                    mkdirs()
                }
            }
    }
}
