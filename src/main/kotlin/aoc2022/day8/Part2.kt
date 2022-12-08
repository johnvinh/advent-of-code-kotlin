package aoc2022.day8

fun getScenicScore(grid: Array<IntArray>, row: Int, col: Int): Int {
    val thisNumber = grid[row][col]

    var topViewDistance = 0
    var bottomViewDistance = 0
    var leftViewDistance = 0
    var rightViewDistance = 0

    // Top
    for (i in row-1 downTo 0) {
        if (grid[i][col] >= thisNumber) {
            topViewDistance++
            break
        }
        topViewDistance++
    }
    // Bottom
    for (i in row+1 until grid.size) {
        if (grid[i][col] >= thisNumber) {
            bottomViewDistance++
            break
        }
        bottomViewDistance++
    }
    // Left
    for (i in col-1 downTo 0) {
        if (grid[row][i] >= thisNumber) {
            leftViewDistance++
            break
        }
        leftViewDistance++
    }
    // Right
    for (i in col+1 until grid[0].size) {
        if (grid[row][i] >= thisNumber) {
            rightViewDistance++
            break
        }
        rightViewDistance++
    }
    return topViewDistance * bottomViewDistance * leftViewDistance * rightViewDistance
}