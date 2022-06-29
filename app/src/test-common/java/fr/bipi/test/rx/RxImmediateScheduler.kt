package fr.bipi.test.rx

import io.reactivex.Scheduler
import io.reactivex.disposables.Disposable
import io.reactivex.internal.schedulers.ExecutorScheduler
import java.util.concurrent.Executor
import java.util.concurrent.TimeUnit

object RxImmediateScheduler : Scheduler() {
    override fun scheduleDirect(run: Runnable, delay: Long, unit: TimeUnit): Disposable {
        return super.scheduleDirect(run, 0, unit)
    }

    override fun createWorker(): Worker {
        return ExecutorScheduler.ExecutorWorker(Executor(Runnable::run), true)
    }
}
