package id.kelompokbeta.wisato.view.home

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import id.kelompokbeta.wisato.R
import id.kelompokbeta.wisato.view.culinary.FragmentCulinary
import id.kelompokbeta.wisato.view.account.FragmentAccount
import id.kelompokbeta.wisato.view.coffee.FragmentCoffee
import id.kelompokbeta.wisato.view.shopping.FragmentShopping
import id.kelompokbeta.wisato.view.wisato.FragmentAlam


enum class MainScreen(@IdRes val menuItemId: Int, val fragment: Fragment) {
    CULINARY(R.id.culinary, FragmentCulinary()),
    ALAM(R.id.alam_raya, FragmentAlam()),
    SHOP(R.id.shopping, FragmentShopping()),
    COFFE(R.id.coffe, FragmentCoffee()),
    ACCOUNT(R.id.beafavorite, FragmentAccount()),
}

fun getMainScreenForMenuItem(menuItemId: Int): MainScreen? {
    for (mainScreen in MainScreen.values()) {
        if (mainScreen.menuItemId == menuItemId) {
            return mainScreen
        }
    }
    return null
}