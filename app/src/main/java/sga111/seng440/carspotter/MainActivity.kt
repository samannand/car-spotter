package sga111.seng440.carspotter

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val goButton : Button = findViewById(R.id.goButton)
        goButton.setOnClickListener {
            val intent = Intent(this, AppNavigation::class.java)
            startActivity(intent)
        }
    }
}
