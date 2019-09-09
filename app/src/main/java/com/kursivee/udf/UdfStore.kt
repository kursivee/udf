package com.kursivee.udf

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

abstract class UdfStore<A, R, S> constructor(
    private val reducer: R
) where R : UdfReducer<A, S> {
    protected abstract val mutableState: MutableLiveData<S>
    abstract val state: LiveData<S>

    fun dispatch(action: A) {
        reducer.reduce(mutableState.value!!, action).run {
            mutableState.postValue(this)
        }
    }
}