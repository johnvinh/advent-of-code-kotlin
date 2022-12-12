package day12

fun getNextLocation(row: Int, col: Int): Array<Int> {
    return arrayOf(row, col)
}

fun getStartLocation(grid: Array<Array<Char>>, row: Int, col: Int): Array<Int> {
    for (i in grid.indices) {
        for (j in grid[i].indices) {
            if (grid[i][j] == 'S') {
                return arrayOf(i, j)
            }
        }
    }
    return arrayOf(-1, -1)
}