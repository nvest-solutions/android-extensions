package com.nvest.extension

import android.os.Looper
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData

fun <T> MutableLiveData<T>.setData(t: T) {
    val isUiThread = Looper.myLooper() == Looper.getMainLooper()
    if (isUiThread) {
        this.value = t
    } else {
        this.postValue(t)
    }
}


fun <T> MutableLiveData<T>.clear() {
    val isUiThread = Looper.myLooper() == Looper.getMainLooper()
    if (isUiThread) {
        this.value = null
    } else {
        this.postValue(null)
    }
}

@Deprecated("Avoid using this method. Will probably be removed soon.")
fun <T> MutableLiveData<T>.removeObserversIfAny(owner: LifecycleOwner) {
    if (this.hasObservers()) {
        this.hasActiveObservers()
        this.removeObservers(owner)
    }
}