package aoc2015.day3

import dev.johnvinh.getInput

fun getNumHousesVisited(lines: List<String>): Int {
    var numHousesVisited = 1
    val housesVisited = HashMap<Int, HashSet<Int>>()
    var x = 0
    var y = 0
    val input = lines[0]

    for (direction in input) {
        // Keep track of each house as a position on a grid
        when (direction) {
            '^' -> y += 1
            'v' -> y -= 1
            '>' -> x += 1
            '<' -> x -= 1
        }
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
    }

    return numHousesVisited
}

fun main() {
    val lines = getInput()
    println(getNumHousesVisited(lines))
}