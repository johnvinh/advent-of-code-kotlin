package aoc2016.day3

import dev.johnvinh.getInput

fun parseInput2(sideSets: List<List<Int>>): MutableList<List<Int>> {
    val outList: MutableList<List<Int>> = mutableListOf()

    for (i in sideSets.indices step 3) {
        for (j in 0..2) {
            outList.add(mutableListOf(sideSets[i][j], sideSets[i + 1][j], sideSets[i + 2][j]))
        }
    }
    return outList
}

fun main() {
    val lines = getInput()
    val numbers = parseInput(lines)
    val newSides = parseInput2(numbers)
    var numPossible = 0
    for (sides in newSides) {
        if (isValidTriangle(sides)) {
            numPossible++
        }
    }
    println(numPossible)
}