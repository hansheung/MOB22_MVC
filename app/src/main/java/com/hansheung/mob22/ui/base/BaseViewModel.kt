package com.hansheung.mob22.ui.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

abstract class BaseViewModel: ViewModel() {

    //One regardless of other receive, Mutable State flow
    protected val _error = MutableSharedFlow<String>()
    val error = _error.asSharedFlow()

    //First T is a generic type
    suspend fun <T>errorHandler(func: suspend()->T?):T?{
        return try{
            func.invoke()
        } catch (e:Exception) {
            _error.emit("Something went wrong")
            null //There is a return type T? So I need to return null
        }
    }
}