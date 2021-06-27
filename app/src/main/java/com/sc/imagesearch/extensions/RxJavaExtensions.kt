package com.sc.imagesearch.extensions

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

fun Disposable.add(disposable: CompositeDisposable) = disposable.add(this)