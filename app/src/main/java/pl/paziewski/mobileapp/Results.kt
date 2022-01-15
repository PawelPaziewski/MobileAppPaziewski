package pl.paziewski.mobileapp

import android.os.Bundle
import android.view.Gravity
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room

class Results : AppCompatActivity() {

    private lateinit var database: AppDb
    private lateinit var tableOfResults: TableLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)

        tableOfResults = findViewById(R.id.tableOfResults)

        database = Room.databaseBuilder(applicationContext, AppDb::class.java, "result")
            .allowMainThreadQueries().build()

        val results = database.resultDao().getAllOrderedByScore()

        addResultsToTable(results)
    }

    private fun addResultsToTable(results: List<Result>) {
        for (result in results) {

            val nickname = TextView(applicationContext)
            nickname.gravity = Gravity.CENTER
            nickname.text = result.nickname

            val score = TextView(applicationContext)
            score.gravity = Gravity.CENTER
            score.text = result.score.toString()

            val tableRow = TableRow(applicationContext)
            tableRow.addView(nickname)
            tableRow.addView(score)

            tableOfResults.addView(tableRow)
        }
    }
}