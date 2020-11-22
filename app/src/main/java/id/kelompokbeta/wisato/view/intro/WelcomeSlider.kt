package id.kelompokbeta.wisato.view.intro

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.github.vivchar.viewpagerindicator.ViewPagerIndicator
import id.kelompokbeta.wisato.R
import id.kelompokbeta.wisato.support.ClickableViewPager
import id.kelompokbeta.wisato.view.home.HomeActivity
import id.kelompokbeta.wisato.view.intro.support.IntroAdapter
import java.util.*


class WelcomeSlider : AppCompatActivity() {
    private var viewpager: ClickableViewPager? = null
    private var slide_adapter: IntroAdapter? = null
    private val slideList: MutableList<Int> = ArrayList()
    private var view_pager_indicator: ViewPagerIndicator? = null
    private var relative_layout_slide: RelativeLayout? = null
    private var linear_layout_skip: LinearLayout? = null
    private var linear_layout_next: LinearLayout? = null
    private var text_view_next_done: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        slideList.add(1)
        slideList.add(2)
        slideList.add(3)
        slideList.add(4)
        slideList.add(5)
        text_view_next_done = findViewById<View>(R.id.text_view_next_done) as TextView
        linear_layout_next = findViewById<View>(R.id.linear_layout_next) as LinearLayout
        linear_layout_skip = findViewById<View>(R.id.linear_layout_skip) as LinearLayout
        view_pager_indicator = findViewById<View>(R.id.view_pager_indicator) as ViewPagerIndicator
        viewpager = findViewById<View>(R.id.view_pager_slide) as ClickableViewPager
        relative_layout_slide = findViewById<View>(R.id.relative_layout_slide) as RelativeLayout
        slide_adapter = IntroAdapter(applicationContext, slideList)
        viewpager?.adapter = slide_adapter
        viewpager?.offscreenPageLimit = 1
        //view_pager_slide.setPageTransformer(false, new CarouselEffectTransformer(IntroActivity.this)); // Set transformer
        viewpager?.setOnItemClickListener { position ->
            if (position < 3) {
                viewpager?.currentItem = position + 1
            } else {
                val intent = Intent(this@WelcomeSlider, HomeActivity::class.java)
                startActivity(intent)
                overridePendingTransition(R.anim.enter, R.anim.exit)
                finish()
            }
        }
        linear_layout_next!!.setOnClickListener(View.OnClickListener {
            if (text_view_next_done!!.text == "DONE") {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                overridePendingTransition(R.anim.enter, R.anim.exit)
                finish()
            }
            if (viewpager?.currentItem!! < slideList.size) {
                viewpager?.currentItem = viewpager?.currentItem!! + 1
                return@OnClickListener
            }
        })
        viewpager?.setOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                if (position + 1 == slideList.size) {
                    text_view_next_done!!.text = "DONE"
                } else {
                    text_view_next_done!!.text = "NEXT"
                }
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })
        linear_layout_skip!!.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.enter, R.anim.exit)
            finish()
        }
        viewpager?.clipToPadding = false
        viewpager?.pageMargin = 0
        view_pager_indicator?.setupWithViewPager(viewpager!!)
    }
}
