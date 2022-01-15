package pl.paziewski.mobileapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.properties.Delegates

class GameEnd : AppCompatActivity() {

    private lateinit var earnedPoints: TextView
    private lateinit var nickname: EditText

    private var score by Delegates.notNull<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_end)

        earnedPoints = findViewById(R.id.earnedPointLabel)
        nickname = findViewById(R.id.nicknameEditText)
        score = intent.getIntExtra(SCORE_EXTRA, 0)
        earnedPoints.text = score.toString()
        findViewById<Button>(R.id.saveButton).setOnClickListener {
            onSaveClick()
        }
    }

    private fun onSaveClick() {
        val validNickname = validateNick(nickname.text.toString())
        if (validNickname) {
            saveResultToDb(nickname.text.toString(), score)
            Toast.makeText(
                applicationContext,
                getString(R.string.successfully_saved),
                Toast.LENGTH_SHORT
            ).show()
            startActivity(Intent(this, Results::class.java))
        } else {
            Toast.makeText(
                applicationContext,
                getString(R.string.empty_nickname_toast_text),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun validateNick(text: String) = text.isNotEmpty()

    private fun saveResultToDb(nickname: String, score: Int) {

    }
}