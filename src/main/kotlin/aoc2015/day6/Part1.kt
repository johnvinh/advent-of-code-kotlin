package aoc2015.day6

import dev.johnvinh.getInput

fun parseRange(line: String): Array<IntArray> {
    val regex = Regex("([0-9]+?),([0-9]+?) through ([0-9]+?),([0-9]+)")
    val match = regex.find(line)
    val lowerRow = match!!.groups[1]?.value?.toInt()!!
    val lowerCol = match.groups[2]?.value?.toInt()!!
    val upperRow = match.groups[3]?.value?.toInt()!!
    val upperCol = match.groups[4]?.value?.toInt()!!
    return arrayOf(intArrayOf(lowerRow, lowerCol), intArrayOf(upperRow, upperCol))
}

fun parseInstruction(line: String, range: Array<IntArray>, lights: Array<BooleanArray>, row: Int, col: Int) {
    if (line.contains("turn on")) {
        lights[row][col] = true
    } else if (line.contains("turn off")) {
        lights[row][col] = false
    } else {
        lights[row][col] = !(lights[row][col])
    }
}

fun main() {
    val lines = getInput()
    val lights = Array(1000){BooleanArray(1000){false} }
    for (line in lines) {
        val range = parseRange(line)
        // Row
        for (i in range[0][0]..range[1][0]) {
            // Col
            for (j in range[0][1]..range[1][1]) {
                parseInstruction(line, range, lights, i, j)
            }
        }
    }

    // Get number of lights still on
    var numLit = 0
    for (i in lights.indices) {
        for (j in lights[i].indices) {
            if (lights[i][j]) {
                numLit++
            }
        }
    }
    println("$numLit lights still lit")
}