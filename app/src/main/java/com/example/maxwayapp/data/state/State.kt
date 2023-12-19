package com.example.maxwayapp.data.state

sealed class State {
    data class Success<T>(val data: T? = null) : State()
    data class Error(val code: Int, val message: String? = null, val throwable: Throwable? = null) : State()
    object NoNetwork : State()
}
