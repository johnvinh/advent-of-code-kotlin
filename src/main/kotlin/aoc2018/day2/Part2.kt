package aoc2018.day2

import dev.johnvinh.getInput

fun main() {
    val lines = getInput()
    for ((i, line) in lines.withIndex()) {

        for ((j, nextLine) in lines.subList(i+1, lines.size).withIndex()) {
            var numSame = 0
            // Each char in line
            for (k in line.indices) {
                if (line[k] == nextLine[k]) {
                    numSame++
                }
            }
            // Found the 2 lines
            if (numSame == line.length-1) {
                // Find what letters they have in common
                for (k in line.indices) {
                    if (line[k] == nextLine[k]) {
                        print(line[k])
                    }
                }
                return
            }
        }
    }
}