package pl.paziewski.mobileapp

import android.graphics.Color

val colorsToChoose = mutableListOf(
    Color("green", Color.rgb(34, 139, 34)),
    Color("red", Color.rgb(178, 34, 34)),
    Color("black", Color.rgb(0, 0, 0)),
    Color("gray", Color.rgb(105, 105, 105)),
    Color("blue", Color.rgb(0, 191, 255)),
    Color("brown", Color.rgb(139, 69, 19)),
    Color("orange", Color.rgb(255, 160, 122)),
    Color("pink", Color.rgb(255, 105, 180)),
    Color("purple", Color.rgb(160, 32, 240)),
)

const val WRONG_ANSWER_POINT = -2
const val CORRECT_ANSWER_POINT = 1
const val NO_ANSWER_POINT = -5

const val ONE_SECOND_MILLIS = 1000L
const val GAME_TIME_MILLIS = 60 * ONE_SECOND_MILLIS
const val TIME_TO_ANSWER_SILVER_MILLIS = (ONE_SECOND_MILLIS * 1.5).toLong()

const val POINTS_TEXT = "Gained points: %s"
const val SECONDS_REMAINING = "Seconds to game end: %s"

data class Color(val name: String, val color: Int)