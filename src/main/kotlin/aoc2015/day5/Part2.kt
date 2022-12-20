package aoc2015.day5

import dev.johnvinh.getInput

fun isANiceString2(s: String): Boolean {
    var hasRepeatingPair = false
    var repeatingLetterOneInbetween = false
    val repeatingIndices = HashSet<Int>()
    var numRepeats = 0

    for (i in s.indices) {
        if ((i != s.length-1) && (s[i] == s[i + 1]) && !hasRepeatingPair) {
            numRepeats++
            hasRepeatingPair = true
            repeatingIndices.add(i)
            repeatingIndices.add(i + 1)
        } else if ((i != s.length-1) && (s[i] == s[i + 1]) && hasRepeatingPair) {
            numRepeats++
            if (repeatingIndices.contains(i) || repeatingIndices.contains(i + 1)) {
                return false
            }
        }

        if (((i + 2) < s.length) && (s[i] == s[i + 2])) {
            repeatingLetterOneInbetween = true
        }
    }
    return (numRepeats >= 2) && repeatingLetterOneInbetween
}

fun main() {
    val lines = getInput()
    var niceStrings = 0
    for (line in lines) {
        if (isANiceString2(line)) {
            niceStrings++
        }
    }
    println(niceStrings)
}