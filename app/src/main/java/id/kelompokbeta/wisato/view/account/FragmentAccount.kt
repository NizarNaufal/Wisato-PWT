package id.kelompokbeta.wisato.view.account

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import id.kelompokbeta.wisato.R
import id.kelompokbeta.wisato.support.showActivity
import kotlinx.android.synthetic.main.fragment_account.*

class FragmentAccount : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_account, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        card_tentang?.setOnClickListener {
            activity?.showActivity(ActivityTentang::class.java)
        }
        card_kritik_saran?.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:18102075@ittelkom-pwt.ac.id")
            }
            startActivity(Intent.createChooser(emailIntent, "Send feedback"))
        }
    }
}