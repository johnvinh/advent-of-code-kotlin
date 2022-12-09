package aoc2022.day9

import kotlin.math.abs

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
                outHeadX += 1
                if (outHeadX != finalHeadX) {
                    outTailX += 1
                }
            }
        }
        'U' -> {
            val finalHeadY = outHeadY + magnitude
            while (outHeadY != finalHeadY) {
                if ((outHeadX - outTailX) == 1 && (outHeadY - outTailY) == 2) {
                    outTailX++
                    outTailY++
                } else if ((outHeadY - outTailY) == 2) {
                    outTailY++
                }
                outHeadY++
                // Check one last time
                if ((outHeadY == finalHeadY) && (outHeadY - outTailY) == 2) {
                    outTailY++
                }
            }
        }
        'L' -> {
            val finalHeadX = outHeadX - magnitude
            while (outHeadX != finalHeadX) {
                if ((outTailX - outHeadX) == 2 && (outHeadY - outTailY) == 1) {
                    outTailX -= 1
                    outTailY += 1
                } else if ((outTailX - outHeadX) == 2) {
                    outTailX -= 1
                }
                outHeadX--
                // Check one last time
                if ((outHeadX == finalHeadX) && (outTailX - outHeadX) == 2) {
                    outTailX--
                }
            }
        }
    }
    return arrayListOf(arrayListOf(outHeadX, outHeadY), arrayListOf(outTailX, outTailY))
}