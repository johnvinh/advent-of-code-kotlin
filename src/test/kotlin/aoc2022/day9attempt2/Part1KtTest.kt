package aoc2022.day9attempt2

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Part1KtTest {

    @Test
    fun moveInstruction_Origin_R4() {
        val expected = arrayListOf(arrayListOf(4, 0), arrayListOf(3, 0))
        val actual = moveInstruction(arrayListOf(0, 0), arrayListOf(0, 0), 'R', 4)
        assertEquals(expected, actual)
    }

    @Test
    fun moveHead_R_40() {
        val head = arrayListOf(0, 0)
        moveHead(head, 'R')
        assertEquals(arrayListOf(1, 0), head)
    }
}