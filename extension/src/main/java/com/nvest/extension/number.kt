package com.nvest.extension

import kotlin.math.roundToLong

fun Double.round(precision: Int): Double {
    var precisionVal = 1.0
    for (i in 1..precision) {
        precisionVal *= 10.0
    }
    return (this * precisionVal).roundToLong() / precisionVal
}