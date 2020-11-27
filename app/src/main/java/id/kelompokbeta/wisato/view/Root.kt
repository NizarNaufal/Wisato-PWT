package id.kelompokbeta.wisato.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.greenfrvr.rubberloader.RubberLoaderView
import id.kelompokbeta.wisato.R
import id.kelompokbeta.wisato.support.showActivity
import id.kelompokbeta.wisato.view.intro.WelcomeSlider
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
}
