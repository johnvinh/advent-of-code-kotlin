package aoc2022.day9attempt2

import kotlin.math.abs

fun moveHead(headPos: ArrayList<Int>, direction: Char) {
    headPos[0] = if (direction == 'R') headPos[0] + 1 else if (direction == 'L') headPos[0] - 1 else headPos[0]
    headPos[1] = if (direction == 'U') headPos[1] + 1 else if (direction == 'D') headPos[1] - 1 else headPos[1]
}

fun moveTail(headPos: ArrayList<Int>, tailPos: ArrayList<Int>) {
    val xDifference = headPos[0] - tailPos[0]
    val yDifference = headPos[1] - tailPos[1]
    // Not touching and not in same row or column
    // Move diagonally
    println("X Difference: $xDifference, Y Difference: $yDifference")
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

fun moveInstruction(headPos: ArrayList<Int>, tailPos: ArrayList<Int>, direction: Char, magnitude: Int):
        ArrayList<ArrayList<Int>> {
    for (n in 1..magnitude) {
        moveHead(headPos, direction)
        moveTail(headPos, tailPos)
    }
    return arrayListOf(headPos, tailPos)
}