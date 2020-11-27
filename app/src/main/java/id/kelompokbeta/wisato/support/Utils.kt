package id.kelompokbeta.wisato.support

import android.app.Activity
import android.content.*
import android.net.Uri
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory
import com.google.android.material.snackbar.Snackbar
import id.kelompokbeta.wisato.R

fun <C> Activity.showActivityWithClearTop(classDestination: Class<C>) {
    startActivity(Intent(this, classDestination).apply {
        flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or
                Intent.FLAG_ACTIVITY_CLEAR_TASK or
                Intent.FLAG_ACTIVITY_NEW_TASK
    })
}

fun <C> Activity.showActivityWithClearTop(
    classDestination: Class<C>,
    param: String,
    value: Boolean
) {
    startActivity(Intent(this, classDestination).apply {
        putExtra(param, value)
        flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or
                Intent.FLAG_ACTIVITY_CLEAR_TASK or
                Intent.FLAG_ACTIVITY_NEW_TASK
    })
}

fun <C> Activity.showActivity(classDestination: Class<C>, isFinish: Boolean = false) {
    startActivity(Intent(this, classDestination))
    if (isFinish) {
        finish()
    }
}

fun <C> Activity.showActivity(
    classDestination: Class<C>, param: String, value: String,
    isFinish: Boolean = false
) {
    startActivity(Intent(this, classDestination).apply {
        putExtra(param, value)
    })

    if (isFinish) {
        finish()
    }
}

fun <C> Activity.showActivity(
    classDestination: Class<C>, param1: String, value1: String,
    param2: String, value2: String,
    isFinish: Boolean = false
) {
    startActivity(Intent(this, classDestination).apply {
        putExtra(param1, value1)
        putExtra(param2, value2)
    })

    if (isFinish) {
        finish()
    }
}

fun <C> Activity.showActivity(
    classDestination: Class<C>, param1: String, value1: String,
    param2: String, value2: String,
    param3: String, value3: String,
    isFinish: Boolean = false
) {
    startActivity(Intent(this, classDestination).apply {
        putExtra(param1, value1)
        putExtra(param2, value2)
        putExtra(param3, value3)
    })

    if (isFinish) {
        finish()
    }
}
fun Activity.showToast(message: String?, isLongDuration: Boolean = false) {
    runOnUiThread {
        val duration = if (isLongDuration) Toast.LENGTH_LONG else Toast.LENGTH_SHORT
        Toast.makeText(this, message, duration).show()
    }
}
fun showLog(message: String) {
}
fun Activity.showSnackBar(view: View, message: String, isLongDuration: Boolean = false) {
    runOnUiThread {
        val duration = if (isLongDuration) Snackbar.LENGTH_LONG else Snackbar.LENGTH_SHORT
        val snack = Snackbar.make(view, message, duration)
        val text = snack.view.findViewById<TextView>(R.id.snackbar_text)
        text.setTextColor(ContextCompat.getColor(this, R.color.colorRed))
        snack.show()
    }
}
