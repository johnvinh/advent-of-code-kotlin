package aoc2016.day2

import dev.johnvinh.getInput

fun main() {
    val lines = getInput()
    val buttons = Array(5) {Array<String>(5) {""} }
    buttons[0][2] = "1"
    buttons[1][1] = "2"
    buttons[1][2] = "3"
    buttons[1][3] = "4"
    buttons[2][0] = "5"
    buttons[2][1] = "6"
    buttons[2][2] = "7"
    buttons[2][3] = "8"
    buttons[2][4] = "9"
    buttons[3][1] = "A"
    buttons[3][2] = "B"
    buttons[3][3] = "C"
    buttons[4][2] = "D"

    printKeypadNumber(lines, buttons, intArrayOf(2, 0))
}