package aoc2018.day3

import dev.johnvinh.getInput

fun allocateSpaceWithIdClaim(regex: Regex, fabric: Array<Array<ArrayList<Int>>>, line: String): Array<Array<ArrayList<Int>>> {
    val match = regex.matchEntire(line)
    if (match != null) {
        val id = match.groups[1]?.value?.toInt() ?: -1
        val inchesFromLeft = match.groups[2]?.value?.toInt() ?: -1
        val inchesFromTop = match.groups[3]?.value?.toInt() ?: -1
        val width = match.groups[4]?.value?.toInt() ?: -1
        val height = match.groups[5]?.value?.toInt() ?: -1

        // Inches from left represents column
        // Inches from top represents row
        for (i in inchesFromTop until inchesFromTop + height) {
            for (j in inchesFromLeft until inchesFromLeft + width) {
                fabric[i][j].add(id)
            }
        }
    }
    return fabric
}

fun main() {
    // Claim ID, inches from left, inches from top, width, height
    val regex = Regex("^#([0-9]+?) @ ([0-9]+?),([0-9]+?): ([0-9]+?)x([0-9]+?)$")
    val input = getInput()

    // Get output fabric from part 1
    var fabric = Array(1000) { Array(1000) { ArrayList<Int>() } }
    for (line in input) fabric = allocateSpaceWithIdClaim(regex, fabric, line)

    // A HashSet containing the ids of conflicting inches (more than one overlapping)
    val moreThanOneOccupying = HashSet<Int>()
    for (row in 0..999) {
        for (column in 0..999) {
            if (fabric[row][column].size > 1) {
                moreThanOneOccupying.addAll(fabric[row][column])
            }
        }
    }

    // One last iteration to find the only ID that doesn't conflict
    var found = false
    for (row in 0..999) {
        if (found) break
        for (column in 0..999) {
            if (fabric[row][column].size == 1) {
                if (fabric[row][column][0] !in moreThanOneOccupying) {
                    println(fabric[row][column][0])
                    found = true
                    break
                }
            }
        }
    }
}