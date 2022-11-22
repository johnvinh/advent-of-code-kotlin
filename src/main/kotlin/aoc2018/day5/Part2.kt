package aoc2018.day5

import dev.johnvinh.getInput
import java.lang.IndexOutOfBoundsException

fun removeSpecificType(type: Char, polymer: String): String {
    val polymerSb = StringBuilder(polymer)
    var i = 0
    while (true) {
        if ( polymerSb.isEmpty()) {
            break
        }
        var currentCharacter = '0'
        try {
            currentCharacter = polymerSb[i]
        } catch (e: IndexOutOfBoundsException) {
            break
        }
        if (currentCharacter.lowercaseChar() == type.lowercaseChar()) {
            polymerSb.deleteCharAt(i)
        }
        i++
    }
    return polymerSb.toString()
}

fun main() {
    val input = getInput()
    println(removeSpecificType('B', input[0]))
}