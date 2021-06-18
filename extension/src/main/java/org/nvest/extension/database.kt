package org.nvest.extension

import org.nvest.extension.core.NvestInternalApi

@NvestInternalApi
fun String?.dbValue(): String? {
    return if (this == null) {
        this
    } else {
        "'$this'"
    }
}