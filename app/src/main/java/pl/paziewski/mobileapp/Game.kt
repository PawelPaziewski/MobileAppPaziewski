package pl.paziewski.mobileapp

import android.content.Intent
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.children

class Game : AppCompatActivity() {

    private lateinit var randomizer: Randomizer

    private var colorButtons = mutableListOf<Button>()
    private lateinit var colorToPickLabel: TextView
    private lateinit var timeRemainingLabel: TextView
    private lateinit var pointsLabel: TextView

    private var points = 0
    private lateinit var answerTimer: CountDownTimer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        loadButtons()
        loadLabels()
        randomizer = Randomizer(colorButtons, colorToPickLabel)
        randomizer.drawColors()
        startGameTimer()
        startAnswerTimer()
    }

    private fun loadLabels() {
        colorToPickLabel = findViewById(R.id.colorToPickLabel)
        timeRemainingLabel = findViewById(R.id.timeRemainingLabel)
        pointsLabel = findViewById(R.id.obtainedPoints)
    }

    private fun loadButtons() {
        val buttonsBox = findViewById<LinearLayout>(R.id.buttonsLayout)
        val children = buttonsBox.children
        val squareSize = Resources.getSystem().displayMetrics.heightPixels / 8
        children.forEach { it ->
            if (it is Button) {
                colorButtons.add(it)
                it.layoutParams = LinearLayout.LayoutParams(squareSize, squareSize)
                it.setOnClickListener { colorClicked(it as Button) }
            }
        }
    }

    private fun colorClicked(button: Button) {
        changePoints(if (correctColorClicked(button)) CORRECT_ANSWER_POINT else WRONG_ANSWER_POINT)
        randomizer.drawColors()
        restartAnswerTimer()
    }

    private fun correctColorClicked(button: Button) = colorToPickLabel.text == button.tag

    private fun restartAnswerTimer() {
        answerTimer.cancel()
        answerTimer.start()
    }

    private fun startGameTimer() {
        object : CountDownTimer(GAME_TIME_MILLIS, ONE_SECOND_MILLIS) {
            override fun onTick(millisUntilFinished: Long) {
                timeRemainingLabel.text =
                    String.format(
                        getString(R.string.seconds_remaining),
                        millisUntilFinished / ONE_SECOND_MILLIS
                    )
            }

            override fun onFinish() {
                timeRemainingLabel.text =
                    String.format(getString(R.string.seconds_remaining), 0)
                answerTimer.cancel()
                val intent = Intent(applicationContext, GameEnd::class.java)
                intent.putExtra(SCORE_EXTRA, points)
                startActivity(intent)
            }

        }.start()
    }

    private fun startAnswerTimer() {
        answerTimer =
            object : CountDownTimer(TIME_TO_ANSWER, TIME_TO_ANSWER) {
                override fun onTick(millisUntilFinished: Long) {
                    //do nothing
                }

                override fun onFinish() {
                    changePoints(NO_ANSWER_POINT)
                    randomizer.drawColors()
                    this.start()
                }

            }.start()
    }

    private fun changePoints(pointsAmount: Int) {
        points += pointsAmount
        pointsLabel.text = String.format(getString(R.string.score), points)
    }
}
