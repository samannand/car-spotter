package sga111.seng440.carspotter

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import sga111.seng440.carspotter.dao.CarDao
import sga111.seng440.carspotter.entities.Car

@Database(entities = arrayOf(Car::class), version = 1, exportSchema = false)
public abstract class CarSpotterDatabase : RoomDatabase() {

    abstract fun carDao(): CarDao

    companion object {

        @Volatile
        private var INSTANCE: CarSpotterDatabase? = null

        fun getDatabase(context: Context): CarSpotterDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CarSpotterDatabase::class.java,
                    "car_spotter_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }

    }

}