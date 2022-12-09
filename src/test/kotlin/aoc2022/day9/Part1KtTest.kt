package aoc2022.day9

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import kotlin.test.BeforeTest

class Part1KtTest {
    private var input = listOf(
        "R 4",
        "U 4",
        "L 3",
        "D 1",
        "R 4",
        "D 1",
        "L 5",
        "R 2"
    )

    @BeforeTest
    fun init() {

    }

    @Test
    fun moveHead_R4_() {
        val expected = arrayOf(intArrayOf(4, 0), intArrayOf(3, 0))
        val actual = moveHead('R', 4, 0, 0, 0, 0)
        assertEquals(expected, actual)
    }
}