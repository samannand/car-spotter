package sga111.seng440.carspotter.ui.spotting

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import sga111.seng440.carspotter.AppNavigation
import sga111.seng440.carspotter.R
import sga111.seng440.carspotter.entities.Car

class SpottingFragment : Fragment() {

    private lateinit var spottingViewModel: SpottingViewModel
    private lateinit var editMakeView: EditText
    private lateinit var editModelView: EditText
    private lateinit var editYearView: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_spotting, container, false)
        spottingViewModel = ViewModelProvider(this).get(SpottingViewModel::class.java)

        editMakeView = view.findViewById(R.id.edit_make)
        editModelView = view.findViewById(R.id.edit_model)
        editYearView = view.findViewById(R.id.edit_year)

        val button = view.findViewById<Button>(R.id.add_to_collection)

        button.setOnClickListener {
            if (TextUtils.isEmpty(editMakeView.text) || TextUtils.isEmpty(editModelView.text) || TextUtils.isEmpty(editYearView.text)) {
                Toast.makeText(
                    context!!,
                    R.string.empty_fields,
                    Toast.LENGTH_LONG).show()
            } else {
                val car = Car(editMakeView.text.toString(), editModelView.text.toString(), editYearView.text.toString().toInt(), null)
                spottingViewModel.insert(car)
                clearValues()
                view.findNavController().navigate(R.id.navigation_collection)
            }
        }

        return view
    }

    private fun clearValues() {
        editMakeView.setText("")
        editYearView.setText("")
        editModelView.setText("")
    }
}
