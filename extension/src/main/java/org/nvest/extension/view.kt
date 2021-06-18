package org.nvest.extension

import android.os.Build
import android.webkit.WebView
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.KITKAT)
fun WebView.evaluateJavascript(script: String) {
    evaluateJavascript(script, null)
}