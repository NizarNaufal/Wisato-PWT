package id.kelompokbeta.wisato.view.culinary.support

import id.kelompokbeta.wisato.R
import id.kelompokbeta.wisato.view.shopping.support.ShoppingModels
import id.kelompokbeta.wisato.view.wisato.support.WisatoModels


class CulinaryHelpers{
    companion object {
        fun <ArrayList> getVersionsList(): ArrayList {
            var androidVersionList = ArrayList<CulinaryModels>()
            androidVersionList.add(
                CulinaryModels(
                    R.drawable.getuk_sokaraja_images,
                    "Getuk Goreng",
                    "Jajanan tradisional dengan citarasa manis terbuat dari olahan singkong yang dilembutkan dan dicampung dengan gula jawa lalu digoreng",
                        "-7.676190",
                        "109.663699"
                )
            )
            androidVersionList.add(
                CulinaryModels(
                    R.drawable.soto_sokaraja_images,
                    "Soto Sokaraja",
                    "Soto berkuah bening yang segar dengan perpaduan daging ayam atau sapi. Uniknya diberi taburan kacang yang menambah nikmat",
                        "-7.676190",
                        "109.663699"
                )
            )
            androidVersionList.add(
                CulinaryModels(
                    R.drawable.tempe_mendoan_images,
                    "Tempe Mendoan",
                    "Tempe yang dibalut tepung dan digoreng setengah matang, sensai gurih dan lembut berpadu dengan sambal kecap yang menambah kenikmatan",
                        "-7.676190",
                        "109.663699"
                )
            )

            return androidVersionList as ArrayList
        }
    }
}