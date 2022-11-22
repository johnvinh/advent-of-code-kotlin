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
            i = 0
            continue
        }
        i++
    }
    return polymerSb.toString()
}

fun main() {
    val input = getInput()
    var min = Int.MAX_VALUE
    for (alphabet in 'a'..'z') {
        val newPolymer = removeSpecificType(alphabet, input[0])
        val outPolymer = scanPolymer(newPolymer)
        if (outPolymer.length < min) {
            min = outPolymer.length
        }
    }
    println(min)
}