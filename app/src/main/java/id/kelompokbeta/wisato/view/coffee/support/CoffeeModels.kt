package id.kelompokbeta.wisato.view.coffee.support

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CoffeeModels(
    val image_coffee: Int,
    val coffee_title: String,
    val coffee_body:String,
    val latitude:String,
    val longitude:String
) : Parcelable