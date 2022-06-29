package fr.bipi.template.data.repository.applog

import androidx.test.ext.junit.runners.AndroidJUnit4
import fr.bipi.template.domain.usecase.logs.LogProvider
import fr.bipi.test.robolectric.BaseTest
import org.amshove.kluent.`should be empty`
import org.amshove.kluent.`should not be blank`
import org.amshove.kluent.`should not be empty`
import org.amshove.kluent.shouldMatch
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.component.get
import timber.log.Timber
import java.io.File

@RunWith(AndroidJUnit4::class)
class LogProviderImplTest : BaseTest() {

    private lateinit var sut: LogProviderImpl

    @Before
    fun setUp() {
        sut = LogProviderImpl()
    }

    @After
    fun after() {
        Timber.uprootAll()
    }

    @Test
    fun koin() {
        get<LogProvider>()
    }

    @Test
    fun `getting log files without init should be empty`() {
        sut.getLogFiles().`should be empty`()
    }

    @Test
    fun `getting log files with init should not be empty`() {
        sut.plant(testDiUtils.provideContext())
        sut.getLogFiles().`should not be empty`()
    }

    @Test
    fun clearFileLog() {
        sut.plant(testDiUtils.provideContext())
        Timber.i("Log message")
        val list = ArrayList<File>().apply {
            addAll(sut.getLogFiles())
        }
        list[0].readText().`should not be blank`()
        sut.clearFileLog()
        list[0].readText().shouldMatch(".*LogProviderImpl.* deleted\n".toRegex())
        Timber.v("yoyoyoyo")
        list[0].readText().shouldMatch(".*LogProviderImpl.* deleted\n.*yoyoyoyo\n".toRegex())
    }

    @Test
    fun plant() {
        sut.plant(testDiUtils.provideContext())
        Timber.forest().`should not be empty`()
    }
}
