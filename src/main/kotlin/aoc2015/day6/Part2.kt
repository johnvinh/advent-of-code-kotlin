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