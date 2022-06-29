package fr.bipi.template.data.sources.storage

import fr.bipi.template.BuildConfig
import fr.bipi.test.robolectric.RobolectricTest
import org.amshove.kluent.shouldContain
import org.junit.Before
import org.junit.Test

class ExternalFileStorageDataSourceTest : RobolectricTest() {

    private lateinit var sut: ExternalFileStorageDataSource

    @Before
    fun setUp() {
        sut = ExternalFileStorageDataSource()
    }

    @Test
    fun getAppFolder() {
        sut.getLogsFolder().apply {
            absolutePath shouldContain BuildConfig.APPLICATION_ID
        }
    }

    @Test
    fun getLogsFolder() {
        sut.getLogsFolder().apply {
            absolutePath shouldContain "${BuildConfig.APPLICATION_ID}/logs"
        }
    }
}
