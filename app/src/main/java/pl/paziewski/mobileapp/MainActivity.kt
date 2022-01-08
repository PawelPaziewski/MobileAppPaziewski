package pl.paziewski.mobileapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.playButton)
            .setOnClickListener { startActivity(Intent(this, Game::class.java)) }
        findViewById<Button>(R.id.resultsButton)
            .setOnClickListener { startActivity(Intent(this, Results::class.java)) }
    }
}