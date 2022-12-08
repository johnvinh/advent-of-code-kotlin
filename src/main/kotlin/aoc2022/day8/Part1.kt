package aoc2022.day8

import dev.johnvinh.getInput

fun isVisible(grid: Array<IntArray>, row: Int, col: Int): Boolean {
    val thisNumber = grid[row][col]
    // Top Edge
    if (row == 0) {
        return true
    } else if (col == 0) { // Left Edge
        return true
    } else if (row == grid.size-1) { // Bottom Edge
        return true
    } else if (col == grid[0].size-1) { // Right Edge
        return true
    }

    var visibleFromTop = true
    var visibleFromBottom = true
    var visibleFromLeft = true
    var visibleFromRight = true

    // Visible from top
    for (i in 0 until row) {
        if (grid[i][col] >= thisNumber) {
            visibleFromTop = false
            break
        }
    }
    // Visible from bottom
    for (i in row+1 until grid.size) {
        if (grid[i][col] >= thisNumber) {
            visibleFromBottom = false
            break
        }
    }
    // Visible from left
    for (i in 0 until col) {
        if (grid[row][i] >= thisNumber) {
            visibleFromLeft = false
            break
        }
    }
    // Visible from right
    for (i in col+1 until grid[0].size) {
        if (grid[row][i] >= thisNumber) {
            visibleFromRight = false
            break
        }
    }
    // It's considered visible if it's visible from any side
    if (visibleFromTop || visibleFromBottom || visibleFromRight || visibleFromLeft) {
        return true
    }
    return false
}

fun getNumVisible(grid: Array<IntArray>): Int {
    var numVisible = 0
    for (i in grid.indices) {
        for (j in grid[0].indices) {
            if (isVisible(grid, i, j)) {
                numVisible++
            }
        }
    }
    return numVisible
}

fun convertToIntArray(lines: List<String>): Array<IntArray> {
    val columns = lines[0].length
    val rows = lines.size
    val grid = Array(rows){IntArray(columns)}
    for (i in lines.indices) {
        for (j in lines[i].indices) {
            val num = (lines[i][j]).toString().toInt()
            grid[i][j] = num
        }
    }
    return grid
}

fun main() {
    val lines = getInput()
    val grid = convertToIntArray(lines)
    println(getNumVisible(grid))
}