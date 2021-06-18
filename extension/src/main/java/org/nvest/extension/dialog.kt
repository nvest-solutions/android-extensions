package org.nvest.extension

import android.app.ProgressDialog
import androidx.appcompat.app.AlertDialog
import org.nvest.extension.core.NvestInternalApi

@NvestInternalApi
fun AlertDialog.hide() {
    if (this.isShowing) {
        this.dismiss()
    }
}

@NvestInternalApi
fun ProgressDialog.hide() {
    if (this.isShowing) {
        this.dismiss()
    }
}

@NvestInternalApi
fun ProgressDialog.show(message: String) {
    this.setMessage(message)
    if (!this.isShowing) {
        this.show()
    }
}