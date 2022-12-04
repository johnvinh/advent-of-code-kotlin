package aoc2022.day4

import dev.johnvinh.getInput
import kotlin.math.max

/**
 * This is almost the same as part 1's solution,
 * just slightly adjusted
 */
fun hasAnyOverlappingSections(sectionPair: String): Boolean {
    val regex = Regex("([0-9]+?)-([0-9]+)")
    val sections = regex.findAll(sectionPair).map{listOf(it.groupValues[1].toInt(), it.groupValues[2].toInt())}.toList()
    val max = max(sections[0][1], sections[1][1])
    val firstSectionSize = sections[0][1] - sections[0][0]
    val secondSectionSize = sections[1][1] - sections[1][0]
    val sectionAllocation = Array(max + 1){"."}
    // Allocate the larger section first
    if (firstSectionSize > secondSectionSize) {
        for (i in (sections[0][0] - 1) until sections[0][1]) {
            sectionAllocation[i] = (i + 1).toString()
        }
        // Then, check to see if the smaller section is completely within the first one
        for (i in (sections[1][0] - 1) until sections[1][1]) {
            if (sectionAllocation[i] != ".") {
                return true
            }
        }
    } else {
        for (i in (sections[1][0] - 1) until sections[1][1]) {
            sectionAllocation[i] = (i + 1).toString()
        }
        // Then, check to see if the smaller section is completely within the first one
        for (i in (sections[0][0] - 1) until sections[0][1]) {
            if (sectionAllocation[i] != ".") {
                return true
            }
        }
    }
    return false
}

fun main() {
    val lines = getInput()
    var numOverlapping = 0
    for (line in lines) {
        if (hasAnyOverlappingSections(line)) {
            numOverlapping++
        }
    }
    println("Number of any overlapping: $numOverlapping")
}