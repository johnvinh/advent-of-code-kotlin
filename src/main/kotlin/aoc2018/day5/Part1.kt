package aoc2018.day5

import dev.johnvinh.getInput

fun checkIfReaction(first: Char, second: Char): Boolean {
    // First check if same letter
    if (first.lowercase() != second.lowercase()) {
        return false
    } else if (first.isLowerCase() && second.isUpperCase()) {
        return true
    } else if (first.isUpperCase() && second.isLowerCase()) {
        return true
    }
    return false
}

fun scanPolymer(polymer: String): String {
    val sb = StringBuilder(polymer)
    return sb.toString()
}

fun main() {
    val input = getInput()
}