package aoc2022.day6

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Part2KtTest {

    @Test
    fun getStartOfMessageMarkerTest() {
        assertEquals(19, getStartOfMessageMarker("mjqjpqmgbljsphdztnvjfqwrcgsmlb"))
    }
}