package aoc2018.day2

import dev.johnvinh.getInput

fun main() {
    var num3 = 0
    var num2 = 0
    val lines = getInput()
    for (line in lines) {
        val occurrences = HashMap<Char, Int>()
        val charsAdded = HashSet<Char>()
        var countedForTwo = false
        var countedForThree = false

        for (char in line) {
            occurrences[char] = occurrences.getOrDefault(char, 0) + 1
        }
        for (char in line) {
            if (!countedForTwo && occurrences.getOrDefault(char, 0) == 2 && !charsAdded.contains(char)) {
                num2++
                charsAdded.add(char)
                countedForTwo = true
            }
            if (!countedForThree && occurrences.getOrDefault(char, 0) == 3 && !charsAdded.contains(char)) {
                num3++
                charsAdded.add(char)
                countedForThree = true
            }
        }
    }
    println(num2 * num3)
}