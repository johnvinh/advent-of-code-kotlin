package aoc2022.day9

import dev.johnvinh.getInput
import kotlin.math.abs

class Part1 {
    private var positionsVisited = HashMap<Int, HashSet<Int>>()

    /**
     * Move the head to a new position.
     * Returns the grid after the movements
     * are made
     */
    fun moveHead(direction: Char, magnitude: Int, headX: Int, headY: Int, tailX: Int, tailY: Int): ArrayList<ArrayList<Int>> {
        var outHeadX = headX
        var outHeadY = headY
        var outTailX = tailX
        var outTailY = tailY

        when (direction) {
            'R' -> {
                val finalHeadX = outHeadX + magnitude
                while (outHeadX != finalHeadX) {
                    if (abs(outHeadX - outTailX) == 2 && (outHeadY - outTailY) == 1) {
                        outTailX += 1
                        outTailY += 1
                    } else if (abs(outHeadX - outTailX) == 2 && (outTailY - outHeadY) == 1) {
                        outTailX += 1
                        outTailY -= 1
                    }
                    else if (abs(outHeadX - outTailX) == 2) {
                        outTailX += 1
                    }

                    // Keep track of position
                    if (positionsVisited.containsKey(outTailX)) {
                        positionsVisited[outTailX]?.add(outTailY)
                    } else {
                        positionsVisited[outTailX] = HashSet()
                        positionsVisited[outTailX]?.add(outTailY)
                    }

                    outHeadX++
                    // Check one last time
                    if ((outHeadX == finalHeadX) && abs(outHeadX - outTailX) == 2) {
                        outTailX++
                    }

                    // Keep track of position
                    if (positionsVisited.containsKey(outTailX)) {
                        positionsVisited[outTailX]?.add(outTailY)
                    } else {
                        positionsVisited[outTailX] = HashSet()
                        positionsVisited[outTailX]?.add(outTailY)
                    }
                }
            }
            'U' -> {
                val finalHeadY = outHeadY + magnitude
                while (outHeadY != finalHeadY) {
                    if ((outHeadX - outTailX) == 1 && (outHeadY - outTailY) == 2) {
                        outTailX++
                        outTailY++
                    } else if ((outHeadX - outTailX) == 1 && (outTailY - outHeadY) == 2) {
                        outTailX++
                        outTailY--
                    }
                    else if ((outHeadY - outTailY) == 2) {
                        outTailY++
                    }

                    // Keep track of position
                    if (positionsVisited.containsKey(outTailX)) {
                        positionsVisited[outTailX]?.add(outTailY)
                    } else {
                        positionsVisited[outTailX] = HashSet()
                        positionsVisited[outTailX]?.add(outTailY)
                    }

                    outHeadY++
                    // Check one last time
                    if ((outHeadY == finalHeadY) && (outHeadY - outTailY) == 2) {
                        outTailY++
                    }

                    // Keep track of position
                    if (positionsVisited.containsKey(outTailX)) {
                        positionsVisited[outTailX]?.add(outTailY)
                    } else {
                        positionsVisited[outTailX] = HashSet()
                        positionsVisited[outTailX]?.add(outTailY)
                    }
                }
            }
            'L' -> {
                val finalHeadX = outHeadX - magnitude
                while (outHeadX != finalHeadX) {
                    if (abs(outHeadX - outTailX) == 2 && (outHeadY - outTailY) == 1) {
                        outTailX -= 1
                        outTailY += 1
                    } else if (abs(outHeadX - outTailX) == 2 && (outTailY - outHeadY) == 1) {
                        outTailX -= 1
                        outTailY -= 1
                    }
                    else if (abs(outHeadX - outTailX) == 2) {
                        outTailX -= 1
                    }

                    // Keep track of position
                    if (positionsVisited.containsKey(outTailX)) {
                        positionsVisited[outTailX]?.add(outTailY)
                    } else {
                        positionsVisited[outTailX] = HashSet()
                        positionsVisited[outTailX]?.add(outTailY)
                    }

                    outHeadX--
                    if ((outHeadX == finalHeadX) && abs(outHeadX - outTailX) == 2) {
                        outTailX--
                    }

                    // Keep track of position
                    if (positionsVisited.containsKey(outTailX)) {
                        positionsVisited[outTailX]?.add(outTailY)
                    } else {
                        positionsVisited[outTailX] = HashSet()
                        positionsVisited[outTailX]?.add(outTailY)
                    }
                }
            }
            'D' -> {
                val finalHeadY = outHeadY - magnitude
                while (outHeadY != finalHeadY) {
                    if ((outTailX - outHeadX) == 1 && (outHeadY - outTailY) == 2) {
                        outTailX--
                        outTailY++
                    } else if ((outTailX - outHeadX) == 1 && (outTailY - outHeadY) == 2) {
                        outTailX--
                        outTailY--
                    }
                    else if ((outTailY - outHeadY) == 2) {
                        outTailY--
                    }
                    outHeadY--

                    // Keep track of position
                    if (positionsVisited.containsKey(outTailX)) {
                        positionsVisited[outTailX]?.add(outTailY)
                    } else {
                        positionsVisited[outTailX] = HashSet()
                        positionsVisited[outTailX]?.add(outTailY)
                    }

                    // Check one last time
                    if ((outHeadY == finalHeadY) && (outTailY - outHeadY) == 2) {
                        outTailY++
                    }

                    // Keep track of position
                    if (positionsVisited.containsKey(outTailX)) {
                        positionsVisited[outTailX]?.add(outTailY)
                    } else {
                        positionsVisited[outTailX] = HashSet()
                        positionsVisited[outTailX]?.add(outTailY)
                    }
                }
            }
        }
        return arrayListOf(arrayListOf(outHeadX, outHeadY), arrayListOf(outTailX, outTailY))
    }

    /**
     * Execute the list of instructions
     * and return the number of positions the tail
     * visited at least once
     */
    fun executeDirections(input: List<String>): Int {
        // Keeps track of each (X, Y) position the tail has visited
        var currentHeadX = 0
        var currentHeadY = 0
        var currentTailX = 0
        var currentTailY = 0
        for (line in input) {
            val parts = line.split(" ")
            val direction = parts[0][0]
            val magnitude = parts[1].toInt()

            val newPositions = moveHead(direction, magnitude, currentHeadX, currentHeadY, currentTailX, currentTailY)
            currentHeadX = newPositions[0][0]
            currentHeadY = newPositions[0][1]
            currentTailX = newPositions[1][0]
            currentTailY = newPositions[1][1]
        }
        var numTailPositions = 0
        for (xValue in positionsVisited.keys) {
            numTailPositions += positionsVisited[xValue]?.size ?: 0
        }
        println("Final Tail Position: ($currentTailX, $currentTailY)")
        println("Final Head Position: ($currentHeadX, $currentHeadY)")
        return numTailPositions
    }
}

fun main() {
    val input = getInput()
    val part1 = Part1()
    println(part1.executeDirections(input))
}