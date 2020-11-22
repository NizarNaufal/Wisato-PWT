package id.kelompokbeta.wisato.view



import android.content.*
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.os.IBinder
import android.view.View
import android.util.Base64
import android.os.Handler
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.greenfrvr.rubberloader.RubberLoaderView
import id.kelompokbeta.wisato.R
import id.kelompokbeta.wisato.support.showActivity
import id.kelompokbeta.wisato.support.showLog
import id.kelompokbeta.wisato.view.intro.WelcomeSlider
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.util.*


class Root : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        (findViewById<View>(R.id.loader1) as RubberLoaderView).startLoading()
        val myTimer = Timer()
        myTimer.schedule(object : TimerTask() {
            override fun run() {
                // If you want to modify a view in your Activity
                runOnUiThread {
                    showActivity(WelcomeSlider::class.java)
                }
            }
        }, 500)
    }


    private fun printKeyHash() {
        try {
            val info =
                packageManager.getPackageInfo("id.kelompokbeta.wisato", PackageManager.GET_SIGNATURES)
            for (signature in info.signatures) {
                val md = MessageDigest.getInstance("SHA")
                md.update(signature.toByteArray())
                showLog("KeyHashEncrypt : ${Base64.encodeToString(md.digest(), Base64.DEFAULT)}")
            }
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        }

        val sha1 = byteArrayOf(
            0x25,
            0xCE.toByte(),
            0x29.toByte(),
            0x27,
            0xB9.toByte(),
            0x27,
            0xE6.toByte(),
            0xFB.toByte(),
            0x74,
            0x20,
            0xE3.toByte(),
            0xED.toByte(),
            0xE7.toByte(),
            0x56.toByte(),
            0xD4.toByte(),
            0x83.toByte(),
            0x63,
            0x59.toByte(),
            0x94.toByte(),
            0x64.toByte()
        )
        showLog("keyhash : ${Base64.encodeToString(sha1, Base64.NO_WRAP)}")
    }

}
