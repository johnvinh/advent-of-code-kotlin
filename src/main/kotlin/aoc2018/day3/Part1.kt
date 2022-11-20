package aoc2018.day3

import dev.johnvinh.getInput

fun getNumOverlapping(fabric: Array<Array<Int>>): Int {
    var numOverlapping = 0
    for (row in 0..999) {
        for (column in 0..999) {
            if (fabric[row][column] > 1) {
                numOverlapping++
            }
        }
    }
    return numOverlapping
}

fun allocateSpace(regex: Regex, fabric: Array<Array<Int>>, line: String): Array<Array<Int>> {
    val match = regex.matchEntire(line)
    if (match != null) {
        val inchesFromLeft = match.groups[2]?.value?.toInt() ?: -1
        val inchesFromTop = match.groups[3]?.value?.toInt() ?: -1
        val width = match.groups[4]?.value?.toInt() ?: -1
        val height = match.groups[5]?.value?.toInt() ?: -1

        // Inches from left represents column
        // Inches from top represents row
        for (i in inchesFromTop until inchesFromTop + height) {
            for (j in inchesFromLeft until inchesFromLeft + width) {
                fabric[i][j] += 1
            }
        }
    }
    return fabric
}

fun main() {
    // Claim ID, inches from left, inches from top, width, height
    val regex = Regex("^#([0-9]+?) @ ([0-9]+?),([0-9]+?): ([0-9]+?)x([0-9]+?)$")
    val input = getInput()
    // 1000*1000 array representing number the number of claims that claim each inch
    var fabric = Array(1000) { Array(1000) { 0 } }
    for (line in input) fabric = allocateSpace(regex, fabric, line)
    // Now, check the number of overlapping claims
    println(getNumOverlapping(fabric))
}