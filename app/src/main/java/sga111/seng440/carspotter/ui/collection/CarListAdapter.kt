package sga111.seng440.carspotter.ui.collection

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import sga111.seng440.carspotter.R
import sga111.seng440.carspotter.entities.Car

class CarListAdapter internal constructor(
    context: Context,
    val clickListener: (Car) -> Unit
) : RecyclerView.Adapter<CarListAdapter.CarViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var cars = emptyList<Car>()

    inner class CarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val carItemView: TextView = itemView.findViewById(R.id.makeText)
        val carModelView: TextView = itemView.findViewById(R.id.modelText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val view = inflater.inflate(R.layout.recyclerview_item, parent, false)
        val holder = CarViewHolder(view)

        view.setOnClickListener {
            Log.d("sizeOfCars", cars.size.toString());
            Log.d("attemptingToIndex", holder.adapterPosition.toString());
            clickListener(cars[holder.adapterPosition])
        }

        return CarViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val current = cars[position]
        holder.carItemView.text = current.make
        holder.carModelView.text = current.model

        holder.itemView.setOnClickListener {
            Log.d("sizeOfCars", cars.size.toString());
            Log.d("attemptingToIndex", holder.adapterPosition.toString());
            clickListener(cars[holder.adapterPosition])
        }
    }

    internal fun setCars(cars: List<Car>) {
        this.cars = cars
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return cars.size
    }
}