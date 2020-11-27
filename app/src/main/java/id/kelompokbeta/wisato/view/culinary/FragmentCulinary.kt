package id.kelompokbeta.wisato.view.culinary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.kelompokbeta.wisato.R
import id.kelompokbeta.wisato.view.culinary.support.CulinaryAdapter
import id.kelompokbeta.wisato.view.culinary.support.CulinaryHelpers
import id.kelompokbeta.wisato.view.wisato.support.WisatoAdapter
import id.kelompokbeta.wisato.view.wisato.support.WisatoHelper

class FragmentCulinary : Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_culinary, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }
    private fun initView() {
        val rvRecyclerView2 = view?.findViewById<RecyclerView>(R.id.rvCulinary)
        rvRecyclerView2?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val adapter2 = CulinaryAdapter(context!!, CulinaryHelpers.getVersionsList())
        rvRecyclerView2?.adapter = adapter2
    }
}