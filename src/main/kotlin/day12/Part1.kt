package day12

fun getStartOrEndLocation(start: Boolean, grid: Array<Array<Char>>, row: Int, col: Int): Array<Int> {
    val searchTarget = if (start) {
        'S'
    } else {
        'E'
    }
    for (i in grid.indices) {
        for (j in grid[i].indices) {
            if (grid[i][j] == searchTarget) {
                return arrayOf(i, j)
            }
        }
    }
    return arrayOf(-1, -1)
}