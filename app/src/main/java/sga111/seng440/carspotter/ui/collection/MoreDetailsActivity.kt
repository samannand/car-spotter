package sga111.seng440.carspotter.ui.collection

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.more_details.*
import sga111.seng440.carspotter.R

class MoreDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val make = intent.getStringExtra("make")
        val model = intent.getStringExtra("model")
        val uriString: String? = intent.getStringExtra("image")
        title = "More Details"
        setContentView(R.layout.more_details)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val modelTextView = findViewById<TextView>(R.id.more_details_make)
        val makeTextView = findViewById<TextView>(R.id.more_details_model)
        val imageView = findViewById<ImageView>(R.id.more_details_image)

        makeTextView.text = make
        modelTextView.text = model

        if (uriString != null) {
            val uri = Uri.parse(uriString)
            imageView.setImageURI(uri)
        }

        val findOutMoreButton: Button = findViewById(R.id.find_out_more_button);

        findOutMoreButton.setOnClickListener {
            val uriString = "https://en.wikipedia.org/wiki/Special:Search?search=$make+$model&go=Go"
            val intent: Intent = Intent(Intent.ACTION_VIEW, Uri.parse(uriString))
            startActivity(intent)
        }



    }
}
