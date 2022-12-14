package aoc2022.day1

import dev.johnvinh.getInput

fun getCaloriesPerElf(lines: List<String>): ArrayList<Int> {
    val caloriesPerElf = ArrayList<Int>()
    var currentCalories = 0
    for (i in lines.indices) {
        // Make sure the final line of input gets added
        if (i == lines.size - 1) {
            currentCalories += lines[i].toInt()
            caloriesPerElf.add(currentCalories)
        } else if (lines[i] == "") { // An empty line indicates the start of a new elf
            caloriesPerElf.add(currentCalories)
            currentCalories = 0
            continue
        }
        try {
            val calories = lines[i].toInt()
            currentCalories += calories
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("Bad input")
        }
    }
    return caloriesPerElf
}

fun main() {
    val lines = getInput()
    val caloriesPerElf = getCaloriesPerElf(lines)
    println(caloriesPerElf.maxBy{it})
}