package id.kelompokbeta.wisato.view.culinary.support

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

class CulinaryAdapter(
    val context: Context,
    private val androidVersionList: ArrayList<CulinaryModels>
) : RecyclerView.Adapter<CulinaryAdapter.ViewHolder>() {

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.txtTitleCulinary?.text = androidVersionList[p1].culinary_title
        p0.txtBodyCulinary?.text = androidVersionList[p1].culinary_body
        p0.image.setImageResource(androidVersionList[p1].image_culinary)
        p0.lytPosition.setOnClickListener { view1: View ->
            val intent = Intent(view1.context,ActivityCulinaryDetails::class.java)
            intent.putExtra("data", androidVersionList[p1])
            //ini ngirim satu data
//            intent.putExtra("body",androidVersionList[p1].culinary_body)
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
        val txtTitleCulinary = itemView.findViewById<TextView>(R.id.text_title_rv)
        val txtBodyCulinary = itemView.findViewById<TextView>(R.id.text_point_rv)
        val lytPosition = itemView.findViewById<MaterialCardView>(R.id.material_body)
        val image = itemView.findViewById<ImageView>(R.id.image_coupon_rv)
    }
}