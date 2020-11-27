package id.kelompokbeta.wisato.view.wisato.support

import id.kelompokbeta.wisato.R


class WisatoHelper{
    companion object {
        fun <ArrayList> getVersionsList(): ArrayList {
            var androidVersionList = ArrayList<WisatoModels>()
            androidVersionList.add(
                WisatoModels(
                    R.drawable.baturaden_images,
                    "Baturaden",
                    "Tempat wisata dengan suasana sejuk dikaki gunung slamet, berbagai wahana dapat anda coba disini.",
                        "-7.676190",
                        "109.663699"
                )
            )
            androidVersionList.add(
                WisatoModels(
                    R.drawable.limpakuwus_images,
                    "Limpakuwus",
                    "Hutan Pinus dengan suasana sejuk dan rindang, cocok untuk bersantai bersama keluarga",
                        "-7.676190",
                        "109.663699"
                )
            )
            androidVersionList.add(
                WisatoModels(
                    R.drawable.curug_jenggala_images,
                    "Curug",
                    "Air terjun yang masih asri ditambah pemandangan yang indah. Berbagai spot foto bisa anda coba",
                        "-7.676190",
                        "109.663699"
                )
            )

            return androidVersionList as ArrayList
        }
    }
}