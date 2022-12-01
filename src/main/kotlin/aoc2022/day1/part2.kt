package aoc2022.day1

import dev.johnvinh.getInput

fun main() {
    val lines = getInput()
    val caloriesPerElf = getCaloriesPerElf(lines)
    caloriesPerElf.sortDescending()
    // Output requires the sum of the 3 elves with the most calories
    println(caloriesPerElf[0] + caloriesPerElf[1] + caloriesPerElf[2])
}