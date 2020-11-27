package id.kelompokbeta.wisato.view.wisato.support

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class WisatoModels(
    val image_wisato: Int,
    val wisato_title: String,
    val wisato_body:String,
    val latitude:String,
    val longitude:String
) : Parcelable