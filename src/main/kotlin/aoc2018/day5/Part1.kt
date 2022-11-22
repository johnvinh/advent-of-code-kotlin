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

fun main() {
    val input = getInput()
}