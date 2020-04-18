package sga111.seng440.carspotter.ui.collection

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import sga111.seng440.carspotter.R

class MoreDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val make = intent.getStringExtra("make")
        val model = intent.getStringExtra("model")
        title = "More Details"
        setContentView(R.layout.more_details)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val modelTextView = findViewById<TextView>(R.id.more_details_make)
        val makeTextView = findViewById<TextView>(R.id.more_details_model)

        makeTextView.text = make
        modelTextView.text = model

        val findOutMoreButton: Button = findViewById(R.id.find_out_more_button);

        findOutMoreButton.setOnClickListener {
            val uriString = "https://en.wikipedia.org/wiki/Special:Search?search=$make+$model&go=Go"
            val intent: Intent = Intent(Intent.ACTION_VIEW, Uri.parse(uriString))
            startActivity(intent)
        }



    }
}
