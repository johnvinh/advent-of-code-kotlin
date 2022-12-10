package aoc2022.day9attempt2

import aoc2022.day5.executeInstructions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import kotlin.test.BeforeTest

class Part1KtTest {
    lateinit var part1: Part1
    private val input = arrayListOf(
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
        part1 = Part1()
    }

    @Test
    fun moveInstruction_Origin_R4() {
        val expected = arrayListOf(arrayListOf(4, 0), arrayListOf(3, 0))
        val actual = part1.moveInstruction(arrayListOf(0, 0), arrayListOf(0, 0), 'R', 4)
        assertEquals(expected, actual)
    }

    @Test
    fun moveHead_Examples() {
        val head = arrayListOf(0, 0)
        part1.moveHead(head, 'R')
        assertEquals(arrayListOf(1, 0), head)
        part1.moveHead(head, 'U')
        assertEquals(arrayListOf(1, 1), head)
        part1.moveHead(head, 'L')
        assertEquals(arrayListOf(0, 1), head)
        part1.moveHead(head, 'D')
        assertEquals(arrayListOf(0, 0), head)
    }

    @Test
    fun moveInstruction_R4_head40_tail30() {
        val expected = arrayListOf(arrayListOf(4, 0), arrayListOf(3, 0))
        val actual = part1.moveInstruction(arrayListOf(0, 0), arrayListOf(0, 0), 'R', 4)
        assertEquals(expected, actual)
    }

    @Test
    fun moveInstruction_U4_head44_tail_43() {
        val expected = arrayListOf(arrayListOf(4, 4), arrayListOf(4, 3))
        val actual = part1.moveInstruction(arrayListOf(4, 0), arrayListOf(3, 0), 'U', 4)
        assertEquals(expected, actual)
    }

    @Test
    fun moveInstruction_L3_head14_tail24() {
        val expected = arrayListOf(arrayListOf(1, 4), arrayListOf(2, 4))
        val actual = part1.moveInstruction(arrayListOf(4, 4), arrayListOf(4, 3), 'L', 3)
        assertEquals(expected, actual)
    }

    @Test
    fun moveInstruction_D1_head13_tail24() {
        val expected = arrayListOf(arrayListOf(1, 3), arrayListOf(2, 4))
        val actual = part1.moveInstruction(arrayListOf(1, 4), arrayListOf(2, 4), 'D', 1)
        assertEquals(expected, actual)
    }

    @Test
    fun moveInstruction_R4_head53_tail43() {
        val expected = arrayListOf(arrayListOf(5, 3), arrayListOf(4, 3))
        val actual = part1.moveInstruction(arrayListOf(1, 3), arrayListOf(2, 4), 'R', 4)
        assertEquals(expected, actual)
    }

    @Test
    fun moveInstruction_D1_head52_tail43() {
        val expected = arrayListOf(arrayListOf(5, 2), arrayListOf(4, 3))
        val actual = part1.moveInstruction(arrayListOf(5, 3), arrayListOf(4, 3), 'D', 1)
        assertEquals(expected, actual)
    }

    @Test
    fun moveInstruction_L5_head02_tail12() {
        val expected = arrayListOf(arrayListOf(0, 2), arrayListOf(1, 2))
        val actual = part1.moveInstruction(arrayListOf(5, 2), arrayListOf(4, 3), 'L', 5)
        assertEquals(expected, actual)
    }

    @Test
    fun moveInstruction_R2_head22_tail12() {
        val expected = arrayListOf(arrayListOf(2, 2), arrayListOf(1, 2))
        val actual = part1.moveInstruction(arrayListOf(0, 2), arrayListOf(1, 2), 'R', 2)
        assertEquals(expected, actual)
    }

    @Test
    fun numTailPositions_13() {
        part1.executeInstructions(input)
        val expected = 13
        val actual = part1.getNumTailPositions()
        assertEquals(expected, actual)
    }
}