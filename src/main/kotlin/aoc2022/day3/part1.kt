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
    for (line in lines) {
        println(getCommonItem(line))
    }
}