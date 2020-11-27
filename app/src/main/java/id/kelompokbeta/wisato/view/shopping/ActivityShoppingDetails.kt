package id.kelompokbeta.wisato.view.shopping

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
import id.kelompokbeta.wisato.view.shopping.support.ShoppingModels
import id.kelompokbeta.wisato.view.wisato.support.WisatoModels
import kotlinx.android.synthetic.main.activity_details_alam.*


class ActivityShoppingDetails : AppCompatActivity() {


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

        val data = intent?.getParcelableExtra<ShoppingModels>("data")
        data?.image_shoppping?.let { image_coupon_details?.setImageResource(it) }
        text_title?.text = data?.shopping_title
        title_details?.text = data?.shopping_title
        body_alam?.text = data?.shopping_body
        ic_maps?.setOnClickListener {
            val i = Intent(this, MapsActivity::class.java)
            i.putExtra("lat", data?.latitude)
            i.putExtra("lon", data?.longitude)
            i.putExtra("name", data?.shopping_title)
            startActivity(i)
        }
    }
}