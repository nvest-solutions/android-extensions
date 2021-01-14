package org.nvest.extension

fun String?.dbValue(): String? {
    return if (this == null) {
        this
    } else {
        "'$this'"
    }
}