package aoc2022.day8

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import kotlin.test.BeforeTest

class Part1KtTest {
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
    fun isVisible_topLeft_True() {
        assertTrue(isVisible(grid, 1, 1))
    }

    @Test
    fun isVisible_topMiddle_True() {
        assertTrue(isVisible(grid, 1, 2))
    }

    @Test
    fun isVisible_center_False() {
        assertFalse(isVisible(grid, 2, 2))
    }

    @Test
    fun getNumVisible_21() {
        assertEquals(21, getNumVisible(grid))
    }
}