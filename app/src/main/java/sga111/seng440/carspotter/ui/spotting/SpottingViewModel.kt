package sga111.seng440.carspotter.ui.spotting

import android.app.Application
import android.net.Uri
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import sga111.seng440.carspotter.CarSpotterDatabase
import sga111.seng440.carspotter.entities.Car
import sga111.seng440.carspotter.repositories.CarRepository

class SpottingViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: CarRepository
    var imageUri: Uri?

    init {
        val carDao = CarSpotterDatabase.getDatabase(application, viewModelScope).carDao()
        repository = CarRepository(carDao)
        imageUri = null
    }

    fun insert(car: Car) = viewModelScope.launch(Dispatchers.IO) {
        if (imageUri != null) {
            car.image = imageUri.toString()
        }
        repository.insert(car)
    }
}