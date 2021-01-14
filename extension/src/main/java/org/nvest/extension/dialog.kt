package org.nvest.extension

import android.app.ProgressDialog
import androidx.appcompat.app.AlertDialog

fun AlertDialog.hide() {
    if (this.isShowing) {
        this.dismiss()
    }
}

fun ProgressDialog.hide() {
    if (this.isShowing) {
        this.dismiss()
    }
}

fun ProgressDialog.show(message: String) {
    this.setMessage(message)
    if (!this.isShowing) {
        this.show()
    }
}