package aoc2022.day6

import dev.johnvinh.getInput

fun getEndOfMarkerCharacter(input: String): Int {
    for (i in input.indices) {
        // For each character, check if this charavter and the three afterwards
        // are all unique with a set
        val seenCharacters = HashSet<Char>()
        seenCharacters.add(input[i])
        seenCharacters.add(input[i+1])
        seenCharacters.add(input[i+2])
        seenCharacters.add(input[i+3])
        // If no duplicates were added, we know this was the start of the marker
        val numCharacters = (i + 3) + 1
        if (seenCharacters.size == 4) {
            return numCharacters
        }
    }
    return -1
}

fun main() {
    val lines = getInput()
    val input = lines[0]
    println(getEndOfMarkerCharacter(input))
}