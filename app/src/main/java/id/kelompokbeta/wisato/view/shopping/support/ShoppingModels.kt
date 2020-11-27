package id.kelompokbeta.wisato.view.shopping.support

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ShoppingModels(
    val image_shoppping: Int,
    val shopping_title: String,
    val shopping_body:String,
    val latitude:String,
    val longitude:String
) : Parcelable