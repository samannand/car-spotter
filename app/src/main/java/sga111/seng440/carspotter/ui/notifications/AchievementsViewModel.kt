package sga111.seng440.carspotter.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AchievementsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is achievements Fragment"
    }
    val text: LiveData<String> = _text
}