package aoc2018.day5

import dev.johnvinh.getInput

fun isReaction(first: Char, second: Char): Boolean {
    // First check if same letter
    if (first.lowercaseChar() != second.lowercaseChar()) {
        return false
    } else if (first.isLowerCase() && second.isUpperCase()) {
        return true
    } else if (first.isUpperCase() && second.isLowerCase()) {
        return true
    }
    return false
}

fun scanPolymer(polymer: String): String {
    val polymerSb = StringBuilder(polymer)
    var i = 0
    while (true) {
        if (i == polymerSb.length-1 || polymerSb.isEmpty()) {
            break
        }
        val currentCharacter = polymerSb[i]
        val nextCharacter = polymerSb[i+1]
        if (isReaction(currentCharacter, nextCharacter)) {
            polymerSb.deleteCharAt(i)
            polymerSb.deleteCharAt(i)
            i = 0
        } else {
            i++
        }
    }
    return polymerSb.toString()
}

fun main() {
    val input = getInput()
    val outputPolymer = scanPolymer(input[0])
    println(outputPolymer.length)
}