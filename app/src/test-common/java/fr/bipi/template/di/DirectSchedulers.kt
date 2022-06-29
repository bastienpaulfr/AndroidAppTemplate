package fr.bipi.template.di

import fr.bipi.template.interactors.rx.AppSchedulers
import fr.bipi.test.rx.RxImmediateScheduler
import io.reactivex.Scheduler

object DirectSchedulers : AppSchedulers {
    override val mainThread: Scheduler
        get() = RxImmediateScheduler
    override val io: Scheduler
        get() = RxImmediateScheduler
}
