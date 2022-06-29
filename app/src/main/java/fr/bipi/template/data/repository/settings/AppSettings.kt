package fr.bipi.template.data.repository.settings

import fr.bipi.template.BuildConfig

const val KEY_VERSION = "key_version"
const val KEY_VERBOSE_DEBUG = "key_verbose_debug"
const val KEY_EXPORT_LOG = "key_export_log"
const val KEY_CLEAR_LOG = "key_clear_log"

interface AppSettings {

    val version: String
        get() = "${BuildConfig.VERSION_NAME} ${if (BuildConfig.DEBUG) "debug" else ""}"

    val preference: Double
}
