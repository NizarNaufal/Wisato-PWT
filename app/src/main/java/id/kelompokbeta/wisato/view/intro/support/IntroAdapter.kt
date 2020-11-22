package id.kelompokbeta.wisato.view.intro.support

import android.content.Context
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import id.kelompokbeta.wisato.R
import java.util.*


class IntroAdapter(mContext: Context, stringList: List<Int>) :
    PagerAdapter() {
    private var pagerList: List<Int> = ArrayList()
    private val mContext: Context
    override fun getCount(): Int {
        return pagerList.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layoutInflater =
            mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var view: View = layoutInflater.inflate(R.layout.item_slide_1, container, false)
        when (pagerList[position]) {
            1 -> view = layoutInflater.inflate(R.layout.item_slide_1, container, false)
            2 -> view = layoutInflater.inflate(R.layout.item_slide_2, container, false)
            3 -> view = layoutInflater.inflate(R.layout.item_slide_3, container, false)
        }
        container.addView(view)
        return view
    }

    override fun destroyItem(collection: ViewGroup, position: Int, view: Any) {
        collection.removeView(view as View)
    }

    override fun getPageWidth(position: Int): Float {
        return 1f
    }

    override fun destroyItem(arg0: View, arg1: Int, arg2: Any) {
        (arg0 as ViewPager).removeView(arg2 as View)
    }

    override fun isViewFromObject(arg0: View, arg1: Any): Boolean {
        return arg0 === arg1 as View
    }

    override fun saveState(): Parcelable? {
        return null
    }

    override fun getItemPosition(`object`: Any): Int {
        return POSITION_NONE
    }

    init {
        pagerList = stringList
        this.mContext = mContext
    }
}