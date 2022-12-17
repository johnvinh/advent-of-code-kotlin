package aoc2015.day5

import dev.johnvinh.getInput

fun isANiceString(s: String): Boolean {
    val vowels = HashSet<Char>()
    vowels.add('a')
    vowels.add('e')
    vowels.add('i')
    vowels.add('o')
    vowels.add('u')

    if (s.contains("ab") || s.contains("cd") || s.contains("pq") || s.contains("xy")) {
        return false
    }
    var vowelCount = 0
    var hasDoubleLetter = false
    for (i in s.indices) {
        val c = s[i]
        if (i != s.length-1 && c == s[i + 1]) {
            hasDoubleLetter = true
        }
        if (vowels.contains(c)) {
            vowelCount++
        }
    }
    if (vowelCount < 3) {
        return false
    }
    return hasDoubleLetter
}

fun main() {
    val lines = getInput()
    var niceCounter = 0
    for (line in lines) {
        if (isANiceString(line)) {
            niceCounter++
        }
    }
    println("Number of nice strings: $niceCounter")
}