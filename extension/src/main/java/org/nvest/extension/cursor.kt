package org.nvest.extension

import android.database.Cursor
import androidx.core.database.getDoubleOrNull
import androidx.core.database.getIntOrNull
import androidx.core.database.getStringOrNull
import org.nvest.extension.core.NvestInternalApi

@NvestInternalApi
fun Cursor.getBoolean(columnName: String): Boolean = this.getInt(columnName) == 1

@NvestInternalApi
fun Cursor.getBoolean(columnIndex: Int): Boolean = this.getInt(columnIndex) == 1

@NvestInternalApi
fun Cursor.getInt(columnName: String): Int = this.getInt(this.getColumnIndex(columnName.trim()))

@NvestInternalApi
fun Cursor.getIntOrNull(columnName: String): Int? = this.getIntOrNull(this.getColumnIndex(columnName.trim()))

@NvestInternalApi
fun Cursor.getDouble(columnName: String): Double = this.getDouble(this.getColumnIndex(columnName.trim()))

@NvestInternalApi
fun Cursor.getDoubleOrNull(columnName: String): Double? = this.getDoubleOrNull(this.getColumnIndex(columnName.trim()))

@NvestInternalApi
fun Cursor.getStringOrNull(columnName: String): String? = this.getStringOrNull(this.getColumnIndex(columnName.trim()))

@NvestInternalApi
fun Cursor.getString(columnName: String): String = this.getString(this.getColumnIndex(columnName.trim()))

@NvestInternalApi
fun Cursor.getIntegerList(columnName: String): List<Int> {
    val commaSeparatedValue = getStringOrNull(columnName)
    val commaSeparatedValueStrList = commaSeparatedValue
        ?.split(',')
    val valueList = mutableListOf<Int>()
    commaSeparatedValueStrList?.forEach { value ->
        if (value.isNotBlank() && value.isNotEmpty()) {
            valueList.add(value.toInt())
        }
    }
    return valueList
}

@NvestInternalApi
fun Cursor?.isNullOrEmpty() = this == null || this.count == 0

@NvestInternalApi
fun Cursor?.isEmpty() =  this?.count == 0

@NvestInternalApi
fun Cursor?.isNotEmpty() =  !this.isEmpty()