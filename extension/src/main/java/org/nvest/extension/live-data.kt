package org.nvest.extension

import android.os.Looper
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