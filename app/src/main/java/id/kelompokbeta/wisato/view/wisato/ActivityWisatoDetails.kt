package id.kelompokbeta.wisato.view.wisato

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import id.kelompokbeta.wisato.R
import id.kelompokbeta.wisato.support.MapsActivity
import id.kelompokbeta.wisato.view.coffee.support.CoffeeModels
import id.kelompokbeta.wisato.view.wisato.support.WisatoModels
import kotlinx.android.synthetic.main.activity_details_alam.*


class ActivityWisatoDetails : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_alam)
        initView()
    }

    @SuppressLint("SetTextI18n")
    fun initView() {
        ic_back.setOnClickListener {
            finish()
        }

        val data = intent?.getParcelableExtra<WisatoModels>("data")
        data?.image_wisato?.let { image_coupon_details?.setImageResource(it) }
        text_title?.text = data?.wisato_title
        title_details?.text = data?.wisato_title
        body_alam?.text = data?.wisato_body
        ic_maps?.setOnClickListener {
            val i = Intent(this, MapsActivity::class.java)
            i.putExtra("lat", data?.latitude)
            i.putExtra("lon", data?.longitude)
            i.putExtra("name", data?.wisato_title)
            startActivity(i)
        }
    }
}