package fr.bipi.template.interactors.rx

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

interface AppSchedulers {
    val mainThread: Scheduler
    val io: Scheduler
}

class SchedulersInteractor : AppSchedulers {
    override val mainThread: Scheduler = AndroidSchedulers.mainThread()
    override val io: Scheduler = Schedulers.io()
}
