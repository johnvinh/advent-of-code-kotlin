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

fun main() {
    val lines = getInput()
    val lights = Array(1000){BooleanArray(1000){false} }
    for (line in lines) {
        val range = parseRange(line)
        println("Range: (${range[0][0]}, ${range[0][1]}) to (${range[1][0]}, ${range[1][1]})")
    }

}