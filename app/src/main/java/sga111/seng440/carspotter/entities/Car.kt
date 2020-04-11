package sga111.seng440.carspotter.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "car_table")
class Car (
    val make: String,
    val model: String,
    val year: Int,
    val comments: String?
    ){
        @PrimaryKey(autoGenerate = true)
        var id: Int = 0 // Using val causes error

        override fun toString(): String {
            return "${year.toString()}, ${make.capitalize()} ${model.capitalize()}"
        }
}