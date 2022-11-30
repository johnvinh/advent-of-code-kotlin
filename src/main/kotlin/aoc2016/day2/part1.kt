package aoc2016.day2

import dev.johnvinh.getInput
import java.lang.IllegalArgumentException

fun getNewPosition(currentPosition: IntArray, direction: String, buttons: Array<IntArray>): IntArray {
    val row = currentPosition[0]
    val col = currentPosition[1]

    if (direction == "U") {
        if (row - 1 < 0) {
            return intArrayOf(row, col)
        }
        return intArrayOf(row - 1, col)
    } else if (direction == "D") {
        if (row + 1 == buttons.size) {
            return intArrayOf(row, col)
        }
        return intArrayOf(row + 1, col)
    } else if (direction == "L") {
        if (col - 1 < 0) {
            return intArrayOf(row, col)
        }
        return intArrayOf(row, col - 1)
    } else if (direction == "R") {
        if (col + 1 == buttons.size) {
            return intArrayOf(row, col)
        }
        return intArrayOf(row, col + 1)
    } else {
        throw IllegalArgumentException()
    }
}

fun printKeypadNumber(lines: List<String>, buttons: Array<IntArray>) {
    var currentRow = 0
    var currentCol = 0
    for (i in lines.indices) {
        val line = lines[i]
        for (c in line.indices) {
            if (i == 0 && c == 0) {
                val row_col = getNewPosition(intArrayOf(0, 0), line[c].toString(), buttons)
                currentRow = row_col[0]
                currentCol = row_col[1]
            } else {
                val row_col = getNewPosition(intArrayOf(currentRow, currentCol), line[c].toString(), buttons)
                currentRow = row_col[0]
                currentCol = row_col[1]
            }
        }
        print(buttons[currentRow][currentCol])
    }
}

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

    printKeypadNumber(lines, buttons)
}