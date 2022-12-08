package aoc2022.day8

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import kotlin.test.BeforeTest

class Part2KtTest {
    private var input: List<String> = arrayListOf("30373",
        "25512",
        "65332",
        "33549",
        "35390")
    private lateinit var grid: Array<IntArray>

    @BeforeTest
    fun init() {
        val columns = input[0].length
        val rows = input.size
        grid = Array(rows){IntArray(columns)}
        for (i in input.indices) {
            for (j in input[i].indices) {
                val num = (input[i][j]).toString().toInt()
                grid[i][j] = num
            }
        }
    }

    @Test
    fun getScenicScore_FirstExample_4() {
        assertEquals(4, getScenicScore(grid, 1, 2))
    }
}