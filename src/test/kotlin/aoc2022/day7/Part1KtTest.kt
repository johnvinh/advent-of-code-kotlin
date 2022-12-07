package aoc2022.day7

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Part1KtTest {

    @Test
    fun getDirTotalSizeTest1() {
        assertEquals(584, getDirTotalSize("e"));
    }

    @Test
    fun getDirTotalSizeTest2() {
        assertEquals(94853, getDirTotalSize("a"));
    }

    @Test
    fun getDirTotalSizeTest3() {
        assertEquals(24933642, getDirTotalSize("d"));
    }
}