package sga111.seng440.carspotter.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import sga111.seng440.carspotter.entities.Car

@Dao
interface CarDao {

    @Query("SELECT * FROM car_table")
    fun getAllCars(): LiveData<List<Car>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(car: Car)

    @Query("DELETE FROM car_table")
    suspend fun deleteAll()

}