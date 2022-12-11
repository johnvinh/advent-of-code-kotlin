package aoc2022.day9attempt2

import dev.johnvinh.getInput
import kotlin.math.abs


/**
 * Class for 2022 day 1 part 1.
 * Used for easily tracking the positions
 * the tail has been in.
 */
class Part2 {
    /**
     * A HashMap with an X value as the key and a Y value as
     * the value.
     */
    val tailPositions = HashMap<Int, HashSet<Int>>()

    /**
     * Move the head one unit.
     * @param   headPos the x and y positions of the head
     * @param   direction   a character ('U', 'D', 'R', 'L') determing the direction to move in
     */
    fun moveHead(headPos: ArrayList<Int>, direction: Char) {
        headPos[0] = if (direction == 'R') headPos[0] + 1 else if (direction == 'L') headPos[0] - 1 else headPos[0]
        headPos[1] = if (direction == 'U') headPos[1] + 1 else if (direction == 'D') headPos[1] - 1 else headPos[1]
    }

    /**
     * Moves the tail based on the position of the head.
     * @param   headPos the x and y positions of the head
     * @param   tailPos     the x and y positions of the tail
     */
    fun moveTail(headPos: ArrayList<Int>, tailPos: ArrayList<Int>) {
        val xDifference = headPos[0] - tailPos[0]
        val yDifference = headPos[1] - tailPos[1]
        // Not touching and not in same row or column
        // Move diagonally
        if ((abs(xDifference) == 2 || abs(yDifference) == 2) && (headPos[0] != tailPos[0] && headPos[1] != tailPos[1])) {
            if (yDifference > 0 && xDifference > 0) {
                tailPos[0]++
                tailPos[1]++
            } else if (yDifference > 0 && xDifference < 0) {
                tailPos[0]--
                tailPos[1]++
            } else if (yDifference < 0 && xDifference > 0) {
                tailPos[0]++
                tailPos[1]--
            } else if (yDifference < 0 && xDifference < 0) {
                tailPos[0]--
                tailPos[1]--
            }
        } else if (abs(xDifference) == 2) {
            if (xDifference > 0) {
                tailPos[0]++
            } else {
                tailPos[0]--
            }
        } else if (abs(yDifference) == 2) {
            if (yDifference > 0) {
                tailPos[1]++
            } else {
                tailPos[1]--
            }
        }
    }

    fun moveInstruction(rope: ArrayList<ArrayList<Int>>, direction: Char, magnitude: Int):
            ArrayList<ArrayList<Int>> {

        for (m in 1..magnitude) {
            moveHead(rope[0], direction)
            for (i in 1 until rope.size) {
                moveTail(rope[i-1], rope[i])
            }

            if (tailPositions.containsKey(rope[rope.size - 1][0])) {
                tailPositions[rope[rope.size - 1][0]]?.add(rope[rope.size - 1][1])
            } else {
                tailPositions[rope[rope.size - 1][0]] = HashSet()
                tailPositions[rope[rope.size - 1][0]]?.add(rope[rope.size - 1][1])
            }
        }
        return rope
    }

    /**
     * Executes a list of instructions.
     * @param   lines   the list of instructions
     */
    fun executeInstructions(lines: List<String>, ropeSize: Int) {
        val rope = ArrayList<ArrayList<Int>>()
        for (i in 1..ropeSize) {
            rope.add(arrayListOf(0, 0))
        }
        for (line in lines) {
            val parts = line.split(" ")
            val direction = parts[0][0]
            val magnitude = parts[1].toInt()
            moveInstruction(rope, direction, magnitude)
        }
    }

    /**
     * Gets the number of unique positions the tail has visited.
     * @return  the number of positions visited by the tail
     */
    fun getNumTailPositions(): Int {
        var numPositions = 0
        for (xValue in tailPositions.keys) {
            numPositions += tailPositions[xValue]?.size ?: 0
        }
        return numPositions
    }
}

fun main() {
    val input = getInput()
    val part2 = Part2()
    part2.executeInstructions(input, 10)
    println(part2.getNumTailPositions())
}