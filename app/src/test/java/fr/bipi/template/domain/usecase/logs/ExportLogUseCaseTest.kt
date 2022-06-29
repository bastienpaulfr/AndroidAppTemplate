package fr.bipi.template.domain.usecase.logs

import fr.bipi.template.data.sources.ExternalStorageDataSource
import org.amshove.kluent.`should be empty`
import org.amshove.kluent.shouldHaveSize
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import java.io.File

class ExportLogUseCaseTest {

    private lateinit var sut: ExportLogUseCase

    @get:Rule
    val temporaryFolder = TemporaryFolder()

    //region Mock
    @get:Rule
    val mockitoRule: MockitoRule = MockitoJUnit.rule()

    @Mock
    private lateinit var storageMock: ExternalStorageDataSource

    @Mock
    private lateinit var logProviderMock: LogProvider
    //endregion

    @Before
    fun setup() {
        sut = ExportLogUseCase(storageMock, logProviderMock)
    }

    @Test
    fun clear() {
        sut.clearLogs()

        verify(logProviderMock).clearFileLog()
    }

    @Test
    fun exportLogs() {
        val folder = `with a storage provider that returns a folder`()
        `with a log provider that returns log files`()

        folder.listFiles()!!.`should be empty`()

        sut.exportLogs()

        folder.listFiles()!!.shouldHaveSize(3)
    }

    //region Helper functions
    private fun `with a storage provider that returns a folder`(): File {
        return temporaryFolder.newFolder().also {
            whenever(storageMock.getLogsFolder()).thenReturn(it)
        }
    }

    private fun `with a log provider that returns log files`() {
        whenever(logProviderMock.getLogFiles()).thenReturn(
            listOf(
                temporaryFolder.newFile("log1"),
                temporaryFolder.newFile("log2"),
                temporaryFolder.newFile("log3")
            )
        )
    }
    //endregion

    //region Constants

    //endregion
}
