package aoc2015.day3

import dev.johnvinh.getInput

fun getNumHousesVisited2(lines: List<String>): Int {
    var numHousesVisited = 1
    val housesVisited = HashMap<Int, HashSet<Int>>()
    var x = 0
    var y = 0
    var robotX = 0
    var robotY = 0
    val input = lines[0]

    housesVisited[0] = HashSet()
    housesVisited[0]?.add(0)

    for (i in input.indices) {
        val direction = input[i]
        // Keep track of each house as a position on a grid
        when (direction) {
            '^' -> if (i % 2 == 0) y += 1 else robotY += 1
            'v' -> if (i % 2 == 0) y -= 1 else robotY -= 1
            '>' -> if (i % 2 == 0) x += 1 else robotX += 1
            '<' -> if (i % 2 == 0) x -= 1 else robotX -= 1
        }
        if (i % 2 == 0) {
            // Each X value is the key in the hashmap
            if (housesVisited.containsKey(x)) {
                val houseX = housesVisited[x]
                if (houseX != null) {
                    // If the HashSet for this X value doesn't contain the Y value,
                    // then it hasn't been visited yet
                    if (!houseX.contains(y)) {
                        houseX.add(y)
                        numHousesVisited++
                    }
                }
            } else {
                // If this X value hasn't been visited at all, then this house
                // also hasn't been visited
                housesVisited[x] = HashSet()
                housesVisited[x]?.add(y)
                numHousesVisited++
            }
        } else {
            // Each X value is the key in the hashmap
            if (housesVisited.containsKey(robotX)) {
                val houseX = housesVisited[robotX]
                if (houseX != null) {
                    // If the HashSet for this X value doesn't contain the Y value,
                    // then it hasn't been visited yet
                    if (!houseX.contains(robotY)) {
                        houseX.add(robotY)
                        numHousesVisited++
                    }
                }
            } else {
                // If this X value hasn't been visited at all, then this house
                // also hasn't been visited
                housesVisited[robotX] = HashSet()
                housesVisited[robotX]?.add(robotY)
                numHousesVisited++
            }
        }
    }
    return numHousesVisited
}

fun main() {
    val lines = getInput()
    println(getNumHousesVisited2(lines))
}