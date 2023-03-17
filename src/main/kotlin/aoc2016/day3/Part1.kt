package aoc2016.day3

import dev.johnvinh.getInput

fun main() {
    val lines = getInput()
    val regex = Regex("^ *([0-9]+?) +([0-9]+?) +([0-9]+)$")
    for (line in lines) {
        val match = regex.matchEntire(line)
        if (match != null) {
            val num1 = match.groups[1]?.value
            val num2 = match.groups[2]?.value
            val num3 = match.groups[3]?.value
            println("$num1 $num2 $num3")
        }
    }
}