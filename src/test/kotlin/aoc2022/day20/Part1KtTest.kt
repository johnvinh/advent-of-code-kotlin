package aoc2022.day20

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Part1KtTest {
    private val exampleInput = arrayListOf("1", "2", "-3", "3", "-2", "0", "4")
    @Test
    fun createList_Example() {
        val expected = intArrayOf(1, 2, -3, 3, -2, 0, 4)
        val actual = createList(exampleInput)
        assertArrayEquals(expected, actual)
    }
}