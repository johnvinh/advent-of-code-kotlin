package aoc2022.day4

import dev.johnvinh.getInput
import kotlin.math.max

fun fullyContainsOtherSection(sectionPair: String): Boolean {
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
            if (sectionAllocation[i] == ".") {
                return false
            }
        }
    } else {
        for (i in (sections[1][0] - 1) until sections[1][1]) {
            sectionAllocation[i] = (i + 1).toString()
        }
        // Then, check to see if the smaller section is completely within the first one
        for (i in (sections[0][0] - 1) until sections[0][1]) {
            if (sectionAllocation[i] == ".") {
                return false
            }
        }
    }
    return true
}

/**
 * An alternative solution to part 1
 */
fun fullyContainsOtherSection2(sectionPair: String): Boolean {
    val regex = Regex("([0-9]+?)-([0-9]+)")
    val sections = regex.findAll(sectionPair).map{listOf(it.groupValues[1].toInt(), it.groupValues[2].toInt())}.toList()
    if ((sections[0][0] >= sections[1][0]) && (sections[0][1] <= sections[1][1])) {
        return true
    } else if ((sections[1][0] >= sections[0][0]) && (sections[1][1] <= sections[0][1])) {
        return true
    }
    return false
}

fun main() {
    val lines = getInput()
    var num = 0
    for (line in lines) {
        /*if (fullyContainsOtherSection(line)) {
            num++
        }*/
        if (fullyContainsOtherSection2(line)) {
            num++
        }
    }
    println(num)
}