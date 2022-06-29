package fr.bipi.test.robolectric

import fr.bipi.template.di.TestDiUtils
import fr.bipi.template.interactors.rx.AppSchedulers
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.rules.TemporaryFolder
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.mock.MockProviderRule
import org.mockito.Mockito
import timber.log.Timber

abstract class BaseTest : KoinTest {

    @Rule
    @JvmField
    var tempFolder = TemporaryFolder()

    @get:Rule
    val mockProvider = MockProviderRule.create { clazz ->
        Timber.v("Mocking ${clazz.qualifiedName}")
        Mockito.mock(clazz.java)
    }

    lateinit var testDiUtils: TestDiUtils

    private val scheduler = object : AppSchedulers {
        override val mainThread: Scheduler
            get() = Schedulers.newThread()
        override val io: Scheduler
            get() = Schedulers.io()
    }

    @Before
    fun baseKoinSetUp() {
        testDiUtils = TestDiUtils()
    }

    @After
    fun baseKoinTearDown() {
        stopKoin()
    }
}
