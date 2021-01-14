package org.nvest.extension

import android.annotation.SuppressLint
import android.text.Editable
import java.text.SimpleDateFormat
import java.util.*

fun String.remove(removeValue: String): String {
    return this.replace(removeValue, "")
}

fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)

@SuppressLint("SimpleDateFormat")
fun String.toCalendar(pattern: String = "d MMM yyyy"): Calendar {
    val calendar = Calendar.getInstance()
    val sdf = SimpleDateFormat(pattern)
    val date = sdf.parse(this)
    calendar.time = date
    return calendar
}