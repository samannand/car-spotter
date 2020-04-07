package sga111.seng440.carspotter.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SpottingViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is spotting Fragment"
    }
    val text: LiveData<String> = _text
}