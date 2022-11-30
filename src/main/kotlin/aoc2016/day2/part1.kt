package aoc2016.day2

import dev.johnvinh.getInput

fun main() {
    val lines = getInput()
    val buttons = Array(3){IntArray(3) {0} }
    var current = 1
    for (i in buttons.indices) {
        for (j in buttons[i].indices) {
            buttons[i][j] = current
            current++
        }
    }
}