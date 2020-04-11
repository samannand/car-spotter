package sga111.seng440.carspotter.repositories

import androidx.lifecycle.LiveData
import sga111.seng440.carspotter.dao.CarDao
import sga111.seng440.carspotter.entities.Car

class CarRepository(private val carDao: CarDao) {

    val allCars: LiveData<List<Car>> = carDao.getAllCars()

    suspend fun insert(car: Car) {
        carDao.insert(car)
    }
}