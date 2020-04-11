package sga111.seng440.carspotter.ui.collection

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import sga111.seng440.carspotter.R

class CollectionFragment : Fragment() {

    private lateinit var collectionViewModel: CollectionViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        collectionViewModel =
            ViewModelProviders.of(this).get(CollectionViewModel::class.java)
        val view = inflater.inflate(R.layout.fragment_collection, container, false)


        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = CarListAdapter(context!!)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context!!)

        return view
    }
}
