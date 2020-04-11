package sga111.seng440.carspotter.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "car_table")
class Car (
    @PrimaryKey(autoGenerate = true) val id: Int,
    val make: String,
    val model: String,
    val year: Int,
    val comments: String
    ){
}