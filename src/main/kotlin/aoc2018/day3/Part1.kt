package aoc2018.day3

import dev.johnvinh.getInput

fun main() {
    val regex = Regex("^#([0-9]+?) @ ([0-9]+?),([0-9]+?): ([0-9]+?)x([0-9]+?)$")
    val input = getInput()
    var fabric = Array(1000) {Array(1000) {0} }
    for (line in input) {
        val match = regex.matchEntire(line)
        if (match != null) {
            val id = match.groups[1]?.value?.toInt()
            val inchesFromLeft = match.groups[2]?.value?.toInt()
            val inchesFromTop = match.groups[3]?.value?.toInt()
            val width = match.groups[4]?.value?.toInt()
            val height = match.groups[5]?.value?.toInt()
        }
    }
}