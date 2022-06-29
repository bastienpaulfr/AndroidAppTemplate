package fr.bipi.template.ui.common

import io.reactivex.disposables.CompositeDisposable

/**
 * Base interface for all presenters
 */
interface Presenter {
    /**
     * Common var for all presenters
     */
    val disposables: CompositeDisposable

    fun dispose()
}
