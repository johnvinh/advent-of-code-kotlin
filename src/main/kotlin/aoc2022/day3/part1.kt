package aoc2022.day3

import dev.johnvinh.getInput

fun getCommonItem(rucksack: String): Char {
    val firstCompartmentEnd = (rucksack.length / 2) - 1;
    val firstCompartmentItems = HashSet<Char>()
    for (i in rucksack.indices) {
        // First half
        if (i <= firstCompartmentEnd) {
            firstCompartmentItems.add(rucksack[i])
            continue
        } else { // Second half
            if (firstCompartmentItems.contains(rucksack[i])) {
                return rucksack[i]
            }
        }
    }
    return '0'
}

fun main() {
    val lines = getInput()
    var priority = 1
    val priorities = HashMap<Char, Int>()
    for (itemType in 'a'..'z') {
        priorities[itemType] = priority
        priority++
    }
    priority = 27
    for (itemType in 'A'..'Z') {
        priorities[itemType] = priority
        priority++
    }
}