package aoc2022.day6

import dev.johnvinh.getInput

fun getStartOfMessageMarker(input: String): Int {
    for (i in input.indices) {
        // For each character, check if this charavter and the 13 afterwards
        // are all unique with a set
        val seenCharacters = HashSet<Char>()
        for (j in i..i+13) {
            seenCharacters.add(input[j])
        }
        // If no duplicates were added, we know this was the start of the marker
        val numCharacters = (i + 13) + 1
        if (seenCharacters.size == 14) {
            return numCharacters
        }
    }
    return -1
}

fun main() {
    val lines = getInput()
    val input = lines[0]
    println(getStartOfMessageMarker(input))
}