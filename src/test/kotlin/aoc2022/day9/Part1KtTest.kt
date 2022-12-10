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
    private lateinit var part1Object: Part1

    @BeforeTest
    fun init() {
        part1Object = Part1()
    }

    @Test
    fun moveHead_R4_40_30() {
        val expected = arrayListOf(arrayListOf(4, 0), arrayListOf(3, 0))
        val actual = part1Object.moveHead('R', 4, 0, 0, 0, 0)
        assertEquals(expected, actual)
    }

    @Test
    fun moveHead_U4_44_43() {
        val expected = arrayListOf(arrayListOf(4, 4), arrayListOf(4, 3))
        val actual = part1Object.moveHead('U', 4, 4, 0, 3, 0)
        assertEquals(expected, actual)
    }

    @Test
    fun moveHead_L3_14_24() {
        val expected = arrayListOf(arrayListOf(1, 4), arrayListOf(2, 4))
        val actual = part1Object.moveHead('L', 3, 4, 4, 4, 3)
        assertEquals(expected, actual)
    }

    @Test
    fun moveHead_D1_13_24() {
        val expected = arrayListOf(arrayListOf(1, 3), arrayListOf(2, 4))
        val actual = part1Object.moveHead('D', 1, 1, 4, 2, 4)
        assertEquals(expected, actual)
    }

    @Test
    fun moveHead_R4_53_43() {
        val expected = arrayListOf(arrayListOf(5, 3), arrayListOf(4, 3))
        val actual = part1Object.moveHead('R', 4, 1, 3, 2, 4)
        assertEquals(expected, actual)
    }

    @Test
    fun moveHead_D1_52_43() {
        val expected = arrayListOf(arrayListOf(5, 2), arrayListOf(4, 3))
        val actual = part1Object.moveHead('D', 1, 5, 3, 4, 3)
        assertEquals(expected, actual)
    }

    @Test
    fun moveHead_L5_02_12() {
        val expected = arrayListOf(arrayListOf(0, 2), arrayListOf(1, 2))
        val actual = part1Object.moveHead('L', 5, 5, 2, 4, 3)
        assertEquals(expected, actual)
    }

    @Test
    fun moveHead_R2_22_12() {
        val expected = arrayListOf(arrayListOf(2, 2), arrayListOf(1, 2))
        val actual = part1Object.moveHead('R', 2, 0, 2, 1, 2)
        assertEquals(expected, actual)
    }

    @Test
    fun executeDirections_13() {
        assertEquals(13, part1Object.executeDirections(input))
    }
}