package org.nvest.extension

fun String.remove(removeValue: String): String {
    return this.replace(removeValue, "")
}