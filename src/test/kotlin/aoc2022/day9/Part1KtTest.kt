package aoc2022.day9

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import kotlin.math.exp
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
    fun moveHead_R4_40_30() {
        val expected = arrayListOf(arrayListOf(4, 0), arrayListOf(3, 0))
        val actual = moveHead('R', 4, 0, 0, 0, 0)
        assertEquals(expected, actual)
    }

    @Test
    fun moveHead_U4_44_43() {
        val expected = arrayListOf(arrayListOf(4, 4), arrayListOf(4, 3))
        val actual = moveHead('U', 4, 4, 0, 3, 0)
        assertEquals(expected, actual)
    }
}