package aoc2018.day6

import dev.johnvinh.getInput

fun createGrid(lines: List<String>): Array<IntArray> {
    val regex = Regex("^([0-9]+?), ([0-9]+?)$")
    val grid = Array(1000) { IntArray(1000) }
    for ((i, line) in lines.withIndex()) {
        val match = regex.matchEntire(line)
        if (match != null) {
            val column = match.groups[1]?.value?.toInt() ?: -1
            val row = match.groups[2]?.value?.toInt() ?: -1
            grid[column][row] = i
        }
    }
    return grid
}

fun main() {
    val input = getInput()
    val grid = createGrid(input)
}