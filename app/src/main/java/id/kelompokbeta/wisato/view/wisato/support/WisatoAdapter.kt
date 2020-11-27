package id.kelompokbeta.wisato.view.wisato.support

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import id.kelompokbeta.wisato.R
import id.kelompokbeta.wisato.view.culinary.ActivityCulinaryDetails
import id.kelompokbeta.wisato.view.wisato.ActivityWisatoDetails

class WisatoAdapter(val context : Context, private val androidVersionList: ArrayList<WisatoModels>) : RecyclerView.Adapter<WisatoAdapter.ViewHolder>() {

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.txtTitleWisato?.text = androidVersionList[p1].wisato_title
        p0.txtBodyWisato?.text = androidVersionList[p1].wisato_body
        p0.image.setImageResource(androidVersionList[p1].image_wisato)
        p0.lytPosition.setOnClickListener { view1: View ->
            val intent = Intent(view1.context, ActivityWisatoDetails::class.java)
            intent.putExtra("data", androidVersionList[p1])
            context.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(p0.context).inflate(R.layout.item_rv, p0, false)
        return ViewHolder(
            v
        )
    }

    override fun getItemCount(): Int {
        return androidVersionList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtTitleWisato = itemView.findViewById<TextView>(R.id.text_title_rv)
        val txtBodyWisato = itemView.findViewById<TextView>(R.id.text_point_rv)
        val lytPosition = itemView.findViewById<MaterialCardView>(R.id.material_body)
        val image = itemView.findViewById<ImageView>(R.id.image_coupon_rv)
    }
}