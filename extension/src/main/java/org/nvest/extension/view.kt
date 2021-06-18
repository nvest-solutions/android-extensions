package org.nvest.extension

import android.os.Build
import android.webkit.WebView
import androidx.annotation.RequiresApi
import org.nvest.extension.core.NvestInternalApi

@NvestInternalApi
@RequiresApi(Build.VERSION_CODES.KITKAT)
fun WebView.evaluateJavascript(script: String) {
    evaluateJavascript(script, null)
}