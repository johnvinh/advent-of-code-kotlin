package aoc2022.day8

fun isVisible(grid: Array<IntArray>, row: Int, col: Int): Boolean {
    return false
}

fun getNumVisible(grid: Array<IntArray>): Int {
    return 0
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