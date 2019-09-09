package com.kursivee.udf

import androidx.lifecycle.ViewModel

abstract class UdfViewModel<A, R, S> constructor(
    val store: UdfStore<A, R, S>
): ViewModel() where R : UdfReducer<A, S> {
    val state: S
        get() { return store.state.value!! }

    fun dispatch(action: A) {
        store.dispatch(action)
    }
}