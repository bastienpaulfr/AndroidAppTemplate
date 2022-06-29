package fr.bipi.template.ui.settings

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.jraska.livedata.test
import fr.bipi.template.di.DirectSchedulers
import fr.bipi.template.domain.usecase.logs.ExportLogUseCase
import fr.bipi.template.ui.settings.AppSettingsViewModel.ExportLogState.Done
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.koin.core.component.get
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule
import org.mockito.kotlin.verify

class AppSettingsViewModelTest {

    private lateinit var sut: AppSettingsViewModel

    // We need this when dealing with livedata
    @get:Rule
    val rule = InstantTaskExecutorRule()

    //region Mock
    @get:Rule
    val mockitoRule: MockitoRule = MockitoJUnit.rule()

    @Mock
    private lateinit var exportLogUseCase: ExportLogUseCase
    //endregion

    @Before
    fun setUp() {
        // We are using the koin definition initialized by App, running by Robolectric
        sut = AppSettingsViewModel(
            exportLogUseCase,
            DirectSchedulers
        )
    }

    @Test
    fun exportLogs() {
        sut.exportLogs().test().apply {
            assertHistorySize(2)
            assertValueHistory(
                AppSettingsViewModel.ExportLogState.Running,
                Done
            )
        }

        verify(exportLogUseCase).exportLogs()
    }

    @Test
    fun clearLogs() {
        sut.clearLogs()
        verify(exportLogUseCase).clearLogs()
    }
}
