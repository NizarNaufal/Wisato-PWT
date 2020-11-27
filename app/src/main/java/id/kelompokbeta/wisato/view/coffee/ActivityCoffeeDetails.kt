package id.kelompokbeta.wisato.view.coffee

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.kelompokbeta.wisato.R
import id.kelompokbeta.wisato.support.MapsActivity
import id.kelompokbeta.wisato.view.coffee.support.CoffeeModels
import kotlinx.android.synthetic.main.activity_details_alam.*


class ActivityCoffeeDetails : AppCompatActivity() {


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

        val data = intent?.getParcelableExtra<CoffeeModels>("data")
        data?.image_coffee?.let { image_coupon_details?.setImageResource(it) }
        text_title?.text = data?.coffee_title
        title_details?.text = data?.coffee_title
        body_alam?.text = data?.coffee_body
        ic_maps?.setOnClickListener {
            val i = Intent(this, MapsActivity::class.java)
            i.putExtra("lat", data?.latitude)
            i.putExtra("lon", data?.longitude)
            i.putExtra("name", data?.coffee_title)
            startActivity(i)
        }
    }
}