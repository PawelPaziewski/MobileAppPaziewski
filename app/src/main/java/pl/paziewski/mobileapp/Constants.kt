package pl.paziewski.mobileapp

import android.content.Context
import java.util.*

class Colors(context: Context) {


    var colorsToChoose = LinkedList<Color>()
    init {
        colorsToChoose.add(Color(context.getString(R.string.greenColorName), context.getColor(R.color.green)))
        colorsToChoose.add(Color(context.getString(R.string.redColorName), context.getColor(R.color.red)))
        colorsToChoose.add(Color(context.getString(R.string.blackColorName), context.getColor(R.color.black)))
        colorsToChoose.add(Color(context.getString(R.string.grayColorName), context.getColor(R.color.gray)))
        colorsToChoose.add(Color(context.getString(R.string.blueColorName), context.getColor(R.color.blue)))
        colorsToChoose.add(Color(context.getString(R.string.brownColorName), context.getColor(R.color.brown)))
        colorsToChoose.add(Color(context.getString(R.string.orangeColorName),context.getColor(R.color.orange)))
        colorsToChoose.add(Color(context.getString(R.string.pinkColorName), context.getColor(R.color.pink)))
        colorsToChoose.add(Color(context.getString(R.string.purpleColorName), context.getColor(R.color.purple)))
        colorsToChoose.add(Color(context.getString(R.string.yellowColorName), context.getColor(R.color.yellow)))
    }
}

const val WRONG_ANSWER_POINT = -2
const val CORRECT_ANSWER_POINT = 1
const val NO_ANSWER_POINT = -5

const val ONE_SECOND_MILLIS = 1000L
const val GAME_TIME_MILLIS = 30 * ONE_SECOND_MILLIS
const val TIME_TO_ANSWER = (ONE_SECOND_MILLIS * 1.5).toLong()

const val SCORE_EXTRA = "SCORE"

data class Color(val name: String, val color: Int)