package sga111.seng440.carspotter.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import sga111.seng440.carspotter.R

class SpottingFragment : Fragment() {

    private lateinit var spottingViewModel: SpottingViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        spottingViewModel =
            ViewModelProviders.of(this).get(SpottingViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_spotting, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        spottingViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}
