package id.kelompokbeta.wisato.view.shopping.support

import id.kelompokbeta.wisato.R


class ShoppingHelper{
    companion object {
        fun <ArrayList> getVersionsList(): ArrayList {
            var androidVersionList = ArrayList<ShoppingModels>()
            androidVersionList.add(
                ShoppingModels(
                    R.drawable.duta_mode_images,
                    "Duta Mode",
                    "Tempat grosir baju dengan harga murah dan model yang trendi",
                        "-7.676190",
                        "109.663699"
                )
            )
            androidVersionList.add(
                ShoppingModels(
                    R.drawable.rita_supermall,
                    "Rita Supermall",
                    "Mall terbesar diPurwokerto yang menjadi salah satu tujuan belanja keluarga. Menyediakan berbagai macam kebutuhan keluarga",
                        "-7.676190",
                        "109.663699"
                )
            )

            return androidVersionList as ArrayList
        }
    }
}