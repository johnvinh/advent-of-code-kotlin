package aoc2018.day5

import dev.johnvinh.getInput

fun isReaction(first: Char, second: Char): Boolean {
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
    for (i in polymer.indices) {
        if (i == polymer.length - 1) {
            break
        }
        val currentCharacter = polymer[i]
        val nextCharacter = polymer[i + 1]
    }
    return sb.toString()
}

fun main() {
    val input = getInput()
}