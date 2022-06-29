package fr.bipi.template.interactors.rx

import io.reactivex.disposables.CompositeDisposable

/**
 * Base class for all class that need to dispose Rx chain
 */
abstract class RxDisposable {
    /**
     * Backing field for public var. Always provides a disposable that can be disposed.
     */
    private var _disposables = CompositeDisposable()
        get() {
            if (field.isDisposed) {
                field = CompositeDisposable()
            }
            return field
        }

    /**
     * All presenters can be disposed. Provide a var for it
     */
    val disposables: CompositeDisposable
        get() = _disposables

    /**
     * Obviously dispose disposables
     */
    open fun dispose() {
        _disposables.dispose()
    }
}
