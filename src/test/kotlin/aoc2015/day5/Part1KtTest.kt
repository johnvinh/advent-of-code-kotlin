package aoc2015.day5

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Part1KtTest {
    @Test
    fun isANiceString_example1() {
        assertTrue(isANiceString("ugknbfddgicrmopn"))
    }

    @Test
    fun isANiceString_example2() {
        assertTrue(isANiceString("aaa"))
    }

    @Test
    fun isANiceString_example3() {
        assertFalse(isANiceString("jchzalrnumimnmhp"))
    }

    @Test
    fun isANiceString_example4() {
        assertFalse(isANiceString("haegwjzuvuyypxyu"))
    }

    @Test
    fun isANiceString_example5() {
        assertFalse(isANiceString("dvszwmarrgswjxmb"))
    }
}