package sga111.seng440.carspotter.ui.collection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import sga111.seng440.carspotter.R

class MoreDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val make = intent.getStringExtra("make")
        val model = intent.getStringExtra("model")
        setContentView(R.layout.more_details)

        Log.d("model", model)
        Log.d("make", make)
        val modelTextView = findViewById<TextView>(R.id.more_details_make)
        val makeTextView = findViewById<TextView>(R.id.more_details_model)

        makeTextView.text = make
        modelTextView.text = model


    }
}
