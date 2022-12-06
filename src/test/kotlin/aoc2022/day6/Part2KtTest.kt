package aoc2022.day6

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Part2KtTest {

    @Test
    fun getStartOfMessageMarkerTest() {
        assertEquals(19, getStartOfMessageMarker("mjqjpqmgbljsphdztnvjfqwrcgsmlb"))
        assertEquals(23, getStartOfMessageMarker("bvwbjplbgvbhsrlpgdmjqwftvncz"))
        assertEquals(23, getStartOfMessageMarker("nppdvjthqldpwncqszvftbrmjlhg"))
        assertEquals(29, getStartOfMessageMarker("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"))
        assertEquals(26, getStartOfMessageMarker("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"))
    }
}