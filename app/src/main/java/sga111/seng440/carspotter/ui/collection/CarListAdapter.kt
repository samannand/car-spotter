package sga111.seng440.carspotter.ui.collection

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import sga111.seng440.carspotter.R
import sga111.seng440.carspotter.entities.Car

class CarListAdapter internal constructor(
    context: Context
) : RecyclerView.Adapter<CarListAdapter.CarViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var cars = emptyList<Car>()

    inner class CarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val carItemView: TextView = itemView.findViewById(R.id.makeText)
        val carModelView: TextView = itemView.findViewById(R.id.modelText)
        val carYearView: TextView = itemView.findViewById(R.id.yearText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return CarViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val current = cars[position]
        holder.carItemView.text = current.model
        holder.carModelView.text = current.make
        holder.carYearView.text = current.year.toString()
    }

    internal fun setCars(cars: List<Car>) {
        this.cars = cars
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return cars.size
    }
}