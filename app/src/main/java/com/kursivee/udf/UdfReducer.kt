package com.kursivee.udf

abstract class UdfReducer<A, S> {
    abstract fun reduce(state: S, action: A): S
}