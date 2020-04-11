package sga111.seng440.carspotter.ui.spotting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import sga111.seng440.carspotter.R

class SpottingFragment : Fragment() {

    private lateinit var spottingViewModel: SpottingViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_spotting, container, false)
        spottingViewModel = ViewModelProvider(this).get(SpottingViewModel::class.java)



        return view
    }
}
