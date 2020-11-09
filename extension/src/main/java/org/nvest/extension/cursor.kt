package org.nvest.extension

import android.database.Cursor
import androidx.core.database.getDoubleOrNull
import androidx.core.database.getIntOrNull
import androidx.core.database.getStringOrNull

fun Cursor.getBoolean(columnName: String): Boolean = this.getInt(columnName) == 1

fun Cursor.getBoolean(columnIndex: Int): Boolean = this.getInt(columnIndex) == 1

fun Cursor.getInt(columnName: String): Int = this.getInt(this.getColumnIndex(columnName.trim()))

fun Cursor.getIntOrNull(columnName: String): Int? = this.getIntOrNull(this.getColumnIndex(columnName.trim()))

fun Cursor.getDouble(columnName: String): Double = this.getDouble(this.getColumnIndex(columnName.trim()))

fun Cursor.getDoubleOrNull(columnName: String): Double? = this.getDoubleOrNull(this.getColumnIndex(columnName.trim()))

fun Cursor.getStringOrNull(columnName: String): String? = this.getStringOrNull(this.getColumnIndex(columnName.trim()))

fun Cursor.getString(columnName: String): String = this.getString(this.getColumnIndex(columnName.trim()))

fun Cursor.getIntegerList(columnName: String): List<Int> {
    val commaSeparatedValue = getStringOrNull(columnName)
    val commaSeparatedValueStrList = commaSeparatedValue
        ?.split(',')
    val valueList = mutableListOf<Int>()
    commaSeparatedValueStrList?.forEach { value ->
        if (!value.isBlank() && value.isNotEmpty()) {
            valueList.add(value.toInt())
        }
    }
    return valueList
}

fun Cursor?.isNullOrEmpty() = this == null || this.count == 0

fun Cursor?.isEmpty() =  this?.count == 0

fun Cursor?.isNotEmpty() =  !this.isEmpty()