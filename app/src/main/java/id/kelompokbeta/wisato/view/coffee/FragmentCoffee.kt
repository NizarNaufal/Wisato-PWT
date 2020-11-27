package id.kelompokbeta.wisato.view.coffee

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.kelompokbeta.wisato.R
import id.kelompokbeta.wisato.view.coffee.support.CoffeeAdapter
import id.kelompokbeta.wisato.view.coffee.support.CoffeeHelpers
import id.kelompokbeta.wisato.view.wisato.support.WisatoAdapter
import id.kelompokbeta.wisato.view.wisato.support.WisatoHelper

class FragmentCoffee : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_coffe, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        val rvRecyclerView2 = view?.findViewById<RecyclerView>(R.id.rvCoffe)
        rvRecyclerView2?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val adapter2 = CoffeeAdapter(
                context!!,
                CoffeeHelpers.getVersionsList()
        )
        rvRecyclerView2?.adapter = adapter2
    }
}