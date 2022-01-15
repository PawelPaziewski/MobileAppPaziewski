package pl.paziewski.mobileapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room

class Results : AppCompatActivity() {

    private lateinit var database: AppDb

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)

        database = Room.databaseBuilder(applicationContext, AppDb::class.java, "result")
            .allowMainThreadQueries().build()

        val results = database.resultDao().getAllOrderedByScore()
    }
}