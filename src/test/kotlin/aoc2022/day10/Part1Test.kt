package aoc2022.day10

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.BeforeTest

class Part1Test {
    private lateinit var part1: Part1

    @BeforeTest
    fun init() {
        part1 = Part1()
    }

    @Test
    fun firstExample_Tick2_X1() {
        val expected = 2
        val actual = part1.valuesOfXPerTick[1]
        assertEquals(expected, actual)
    }
}