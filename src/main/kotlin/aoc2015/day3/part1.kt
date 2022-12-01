package aoc2015.day3

import dev.johnvinh.getInput

fun main() {
    val lines = getInput()
    val housesVisited = HashMap<Int, HashSet<Int>>()
    var numHousesVisited = 1
    var x = 0
    var y = 0
    val input = lines[0]

    for (direction in input) {
        when (direction) {
            '^' -> y += 1
            'v' -> y -= 1
            '>' -> x += 1
            '<' -> x -= 1
        }
        if (housesVisited.containsKey(x)) {
            val houseX = housesVisited[x]
            if (houseX != null) {
                if (!houseX.contains(y)) {
                    houseX.add(y)
                    numHousesVisited++
                }
            }
        } else {
            housesVisited[x] = HashSet()
            housesVisited[x]?.add(y)
            numHousesVisited++
        }
    }
    println(numHousesVisited)
}