package pl.paziewski.mobileapp

import android.widget.Button
import android.widget.TextView

class Randomizer(
    private val colorButtons: MutableList<Button>,
    private val colorToPickLabel: TextView,
    private val colorsToChoose: MutableList<Color>
) {

    private fun getRandomColors(colors: List<Color>, size: Int) = colors.shuffled().subList(0, size)
    private fun getRandomColor(colors: List<Color>) = colors.shuffled()[0]

    fun drawColors() {
        val colors = getRandomColors(colorsToChoose, colorButtons.size)
        for (i in 0 until colorButtons.size) {
            colorButtons[i].setBackgroundColor(colors[i].color)
            colorButtons[i].tag = colors[i].name
        }
        colorToPickLabel.setTextColor(getRandomColor(colors).color)
        colorToPickLabel.text = getRandomColor(colors).name
    }
}