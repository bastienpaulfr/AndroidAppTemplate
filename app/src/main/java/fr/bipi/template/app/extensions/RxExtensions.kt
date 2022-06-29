package fr.bipi.template.app.extensions

import io.reactivex.CompletableEmitter
import io.reactivex.FlowableEmitter
import io.reactivex.ObservableEmitter
import io.reactivex.SingleEmitter
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import timber.log.Timber

fun CompletableEmitter?.complete() {
    if (this != null && !isDisposed) {
        onComplete()
    } else {
        Timber.w("Emitter is disposed, cannot do onSuccess")
    }
}

fun CompletableEmitter?.error(obj: Throwable) {
    if (this != null && !isDisposed) {
        onError(obj)
    } else {
        Timber.w("Emitter is disposed, cannot do onError $obj")
    }
}

fun <T : Any> SingleEmitter<T>?.success(obj: T) {
    if (this != null && !isDisposed) {
        onSuccess(obj)
    } else {
        Timber.w("Emitter is disposed, cannot do onSuccess")
    }
}

fun <T : Any> SingleEmitter<T>?.error(obj: Throwable) {
    if (this != null && !isDisposed) {
        onError(obj)
    } else {
        Timber.w("Emitter is disposed, cannot do onError $obj")
    }
}

fun <T : Any> ObservableEmitter<T>?.next(obj: T) {
    if (this != null && !isDisposed) {
        onNext(obj)
    } else {
        Timber.w("Emitter is disposed, cannot do onSuccess")
    }
}

fun <T : Any> ObservableEmitter<T>?.complete() {
    if (this != null && !isDisposed) {
        onComplete()
    } else {
        Timber.w("Emitter is disposed, cannot do onSuccess")
    }
}

fun <T : Any> ObservableEmitter<T>?.error(obj: Throwable) {
    if (this != null && !isDisposed) {
        onError(obj)
    } else {
        Timber.w("Emitter is disposed, cannot do onError $obj")
    }
}

fun <T : Any> FlowableEmitter<T>?.next(obj: T) {
    if (this != null && !isCancelled) {
        onNext(obj)
    } else {
        Timber.w("Emitter is disposed, cannot do onSuccess")
    }
}

fun <T : Any> FlowableEmitter<T>?.complete() {
    if (this != null && !isCancelled) {
        onComplete()
    } else {
        Timber.w("Emitter is disposed, cannot do onSuccess")
    }
}

fun <T : Any> FlowableEmitter<T>?.error(obj: Throwable) {
    if (this != null && !isCancelled) {
        onError(obj)
    } else {
        Timber.w("Emitter is disposed, cannot do onError $obj")
    }
}

fun Disposable.addTo(d: CompositeDisposable) {
    d.add(this)
}
