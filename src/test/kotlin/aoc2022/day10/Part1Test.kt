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
    fun firstExample() {
        part1.noop()
        part1.addx(3)
        part1.addx(-5)
        assertEquals(1, part1.valuesOfXPerTick[1])
        assertEquals(1, part1.valuesOfXPerTick[2])
        assertEquals(1, part1.valuesOfXPerTick[3])
        assertEquals(4, part1.valuesOfXPerTick[4])
        assertEquals(4, part1.valuesOfXPerTick[5])
    }
}