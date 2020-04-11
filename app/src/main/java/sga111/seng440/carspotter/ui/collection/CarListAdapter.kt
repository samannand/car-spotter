package sga111.seng440.carspotter.ui.collection

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recyclerview_item.view.*
import sga111.seng440.carspotter.R
import sga111.seng440.carspotter.entities.Car

class CarListAdapter internal constructor(
    context: Context
) : RecyclerView.Adapter<CarListAdapter.CarViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var cars = emptyList<Car>()

    inner class CarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val carItemView: TextView = itemView.findViewById(R.id.carItemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return CarViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val current = cars[position]
        holder.carItemView.text = current.toString()
    }

    internal fun setCars(cars: List<Car>) {
        this.cars = cars
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return cars.size
    }
}