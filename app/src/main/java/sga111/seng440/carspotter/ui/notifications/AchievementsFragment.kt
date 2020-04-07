package sga111.seng440.carspotter.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import sga111.seng440.carspotter.R

class AchievementsFragment : Fragment() {

    private lateinit var achievementsViewModel: AchievementsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        achievementsViewModel =
            ViewModelProviders.of(this).get(AchievementsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_achievements, container, false)
        val textView: TextView = root.findViewById(R.id.text_notifications)
        achievementsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}
