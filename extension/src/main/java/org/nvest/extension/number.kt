package org.nvest.extension

import org.nvest.extension.core.NvestInternalApi
import kotlin.math.roundToLong

@NvestInternalApi
fun Double.round(precision: Int): Double {
    var precisionVal = 1.0
    for (i in 1..precision) {
        precisionVal *= 10.0
    }
    return (this * precisionVal).roundToLong() / precisionVal
}

@NvestInternalApi
fun String?.isNumber(): Boolean {
    return !this.isNullOrEmpty() && !this.isNullOrBlank() && this.matches("-?\\d+(\\.\\d+)?(E-?\\d+)?(E\\+?\\d+)?(E?\\d+)?(e-?\\d+)?(e\\+?\\d+)?(e?\\d+)?".toRegex())
}

@NvestInternalApi
fun String?.isNotNumber() = !isNumber()