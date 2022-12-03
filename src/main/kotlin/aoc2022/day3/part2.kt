package aoc2022.day3

import dev.johnvinh.getInput
import java.lang.IllegalArgumentException

fun getCommonOfThree(lines: List<String>): Char {
    if (lines.size != 3) {
        throw IllegalArgumentException()
    }
    val items = HashMap<Int, HashSet<Char>>()
    // Add items for the first 2 elves only
    for (i in 0..2) {
        items[i] = HashSet()
        for (j in lines[i].indices) {
            items[i]?.add(lines[i][j])
        }
    }
    // The common item is the item that the third elf and the last two elves have
    for (i in lines[2].indices) {
        val currentItem = lines[2][i]
        val firstElfItems = items[0] ?: HashSet()
        val secondElfItems = items[1] ?: HashSet()
        if (firstElfItems.contains(currentItem) && secondElfItems.contains(currentItem)) {
            return currentItem
        }
    }
    return '0'
}

fun main() {
    val lines = getInput()
    val priorities = getItemPriorities()

    var sum = 0
    for (i in 0..lines.size-3 step 3) {
        val elfInventories = listOf(lines[i], lines[i + 1], lines[i + 2])
        sum += priorities[getCommonOfThree(elfInventories)] ?: 0
    }
    println("Part 2 solution: $sum")
}