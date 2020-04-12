package sga111.seng440.carspotter

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import sga111.seng440.carspotter.dao.CarDao
import sga111.seng440.carspotter.entities.Car

@Database(entities = arrayOf(Car::class), version = 1, exportSchema = false)
public abstract class CarSpotterDatabase : RoomDatabase() {

    abstract fun carDao(): CarDao

    private class CarDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {
        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.carDao())
                }
            }
        }

        suspend fun populateDatabase(carDao: CarDao) {

            // Uncomment to clear DB each time the app is loaded
            //carDao.deleteAll()

//            var car = Car("Ford","Escort",1966, null)
//            carDao.insert(car);
//
//            car = Car("Nissan","Skyline",1991, null)
//            carDao.insert(car)
        }
    }

    companion object {

        @Volatile
        private var INSTANCE: CarSpotterDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): CarSpotterDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CarSpotterDatabase::class.java,
                    "car_spotter_database"
                ).addCallback(CarDatabaseCallback(scope)).build()
                INSTANCE = instance
                return instance
            }
        }

    }

}