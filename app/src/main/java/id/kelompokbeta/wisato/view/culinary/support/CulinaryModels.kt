package id.kelompokbeta.wisato.view.culinary.support

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CulinaryModels(
    val image_culinary: Int,
    val culinary_title: String,
    val culinary_body:String,
    val latitude:String,
    val longitude:String
) : Parcelable