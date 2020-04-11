package sga111.seng440.carspotter.ui.collection

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import sga111.seng440.carspotter.CarSpotterDatabase
import sga111.seng440.carspotter.entities.Car
import sga111.seng440.carspotter.repositories.CarRepository

class CollectionViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: CarRepository

    val allCars: LiveData<List<Car>>

    init {
        val carDao = CarSpotterDatabase.getDatabase(application, viewModelScope).carDao()
        repository = CarRepository(carDao)
        allCars = repository.allCars
    }

    fun insert(car: Car) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(car)
    }


}