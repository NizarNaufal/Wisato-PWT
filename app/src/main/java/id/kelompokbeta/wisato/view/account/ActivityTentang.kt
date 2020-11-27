package id.kelompokbeta.wisato.view.account

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.kelompokbeta.wisato.R
import kotlinx.android.synthetic.main.activity_tentang.*

class ActivityTentang : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tentang)
        initView()
    }
    fun initView(){
       back_btn_tentang?.setOnClickListener {
           onBackPressed()
       }
    }
}
