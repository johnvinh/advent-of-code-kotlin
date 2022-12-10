package aoc2022.day9attempt2

fun moveHead(headPos: ArrayList<Int>, direction: Char) {
    headPos[0] = if (direction == 'R') headPos[0] + 1 else if (direction == 'L') headPos[0] - 1 else headPos[0]
    headPos[1] = if (direction == 'U') headPos[1] + 1 else if (direction == 'D') headPos[1] - 1 else headPos[1]
}

fun moveTail(headPos: ArrayList<Int>, tailPos: ArrayList<Int>) {
    
}

fun moveInstruction(headPos: ArrayList<Int>, tailPos: ArrayList<Int>, direction: Char, magnitude: Int):
        ArrayList<ArrayList<Int>> {
    for (n in 1..magnitude) {
        moveHead(headPos, direction)
    }
    return ArrayList()
}