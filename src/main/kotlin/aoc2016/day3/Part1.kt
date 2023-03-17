package aoc2016.day3

import dev.johnvinh.getInput

fun parseInput(lines: List<String>): List<List<Int>> {
    val regex = Regex("^ *([0-9]+?) +([0-9]+?) +([0-9]+)$")
    val outList: MutableList<MutableList<Int>> = mutableListOf()
    for (line in lines) {
        val match = regex.matchEntire(line)
        if (match != null) {
            val num1 = match.groups[1]?.value?.toInt()
            val num2 = match.groups[2]?.value?.toInt()
            val num3 = match.groups[3]?.value?.toInt()
            if (num1 != null && num2 != null && num3 != null) {
                outList.add(mutableListOf(num1, num2, num3))
            }
        }
    }
    return outList
}

fun isValidTriangle(sides: List<Int>): Boolean {
    return (sides[1] + sides[2]) > sides[3]
}

fun main() {
    val lines = getInput()
    val numbers = parseInput(lines)
    println(numbers)
}