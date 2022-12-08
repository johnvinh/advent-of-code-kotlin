package aoc2022.day8

import dev.johnvinh.getInput

/**
 * Get one specific tree's scenic score
 */
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

/**
 * Get the highest scenic score of the whole grid
 */
fun getMaxScenicScore(grid: Array<IntArray>): Int {
    var max = 0
    for (i in grid.indices) {
        for (j in grid[i].indices) {
            val scenicScore = getScenicScore(grid, i, j)
            if (scenicScore > max) {
                max = scenicScore
            }
        }
    }
    return max
}

fun main() {
    val input = getInput()
    val grid = convertToIntArray(input)
    println(getMaxScenicScore(grid))
}