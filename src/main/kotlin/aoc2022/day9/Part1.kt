package aoc2022.day9

/**
 * Move the head to a new position.
 * Returns the grid after the movements
 * are made
 */
fun moveHead(direction: Char, magnitude: Int, headX: Int, headY: Int, tailX: Int, tailY: Int): Array<IntArray> {
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
    }
    return arrayOf(intArrayOf(outHeadX, outHeadY), intArrayOf(outTailX, outTailY))
}