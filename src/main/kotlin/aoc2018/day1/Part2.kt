package aoc2018.day1

import dev.johnvinh.getInput

fun main() {
    val valuesSeen = HashSet<Int>()
    val regex = Regex("^([+-])([0-9]+)$")
    val input = getInput()
    var frequency = 0
    var duplicate = false
    while (!duplicate) {
        for (line in input) {
            val result = regex.matchEntire(line)
            if (result != null) {
                val operator = result.groups[1]?.value
                val value = result.groups[2]?.value
                var number = 0
                try {
                    if (value != null) {
                        number = value.toInt()
                    }
                } catch (e: NumberFormatException) {
                    e.printStackTrace()
                }
                if (operator != null) {
                    if (operator == "+") {
                        frequency += number
                    } else {
                        frequency -= number
                    }
                }
            }
            if (valuesSeen.contains(frequency)) {
                println(frequency)
                duplicate = true
                return
            } else {
                valuesSeen.add(frequency)
            }
        }
    }
}