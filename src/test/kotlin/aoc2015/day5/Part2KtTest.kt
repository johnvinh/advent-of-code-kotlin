package aoc2015.day5

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Part2KtTest {
    @Test
    fun isANiceString2_Example1() {
        assertTrue(isANiceString2("qjhvhtzxzqqjkmpb"))
    }

    @Test
    fun isANiceString2_Example2() {
        assertTrue(isANiceString2("xxyxx"))
    }

    @Test
    fun isANiceString2_Example3() {
        assertFalse(isANiceString2("uurcxstgmygtbstg"))
    }

    @Test
    fun isANiceString2_Example4() {
        assertFalse(isANiceString2("ieodomkazucvgmuy"))
    }
}