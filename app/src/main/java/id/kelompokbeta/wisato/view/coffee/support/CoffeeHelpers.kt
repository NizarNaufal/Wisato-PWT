package id.kelompokbeta.wisato.view.coffee.support

import id.kelompokbeta.wisato.R

class CoffeeHelpers{
    companion object {
        fun <ArrayList> getVersionsList(): ArrayList {
            var androidVersionList = ArrayList<CoffeeModels>()
            androidVersionList.add(
                CoffeeModels(
                    R.drawable.hangout_cafe_images,
                    "Hangout Cafe",
                    "Cafe dengan suasane nyaman dan kekinian. Cocok untuk berkumpul dengan teman atau keluarga",
                        "-7.676190",
                        "109.663699"
                )
            )
            return androidVersionList as ArrayList
        }
    }
}