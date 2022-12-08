package aoc2022.day8

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class Part1KtTest {
    lateinit var input: List<String>
    lateinit var grid: Array<IntArray>

    @BeforeAll
    fun initializeInput() {
        input = arrayListOf("30373" +
                "25512" +
                "65332" +
                "33549" +
                "35390")
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
    fun getNumVisible_21() {
        assertEquals(21, getNumVisible(grid))
    }
}