package aoc2015.day6

import dev.johnvinh.getInput

fun parseInstruction2(line: String, range: Array<IntArray>, lights: Array<IntArray>, row: Int, col: Int) {
    if (line.contains("turn on")) {
        lights[row][col]++
    } else if (line.contains("turn off")) {
        if (lights[row][col] > 0) {
            lights[row][col]--
        }
    } else {
        lights[row][col] += 2
    }
}

fun main() {
    val lines = getInput()
    val lights = Array(1000){IntArray(1000){0} }
    for (line in lines) {
        val range = parseRange(line)
        // Row
        for (i in range[0][0]..range[1][0]) {
            // Col
            for (j in range[0][1]..range[1][1]) {
                parseInstruction2(line, range, lights, i, j)
            }
        }
    }

    // Get number of lights still on
    var brightnessSum = 0
    for (i in lights.indices) {
        for (j in lights[i].indices) {
            brightnessSum += lights[i][j]
        }
    }
    println("Brightness: $brightnessSum")
}