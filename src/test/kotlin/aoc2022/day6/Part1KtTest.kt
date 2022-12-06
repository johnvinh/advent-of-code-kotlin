package aoc2022.day6

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Part1KtTest {

    @Test
    fun getEndOfMarkerCharacterTest() {
        assertEquals(7, getEndOfMarkerCharacter("mjqjpqmgbljsphdztnvjfqwrcgsmlb"))
        assertEquals(5, getEndOfMarkerCharacter("bvwbjplbgvbhsrlpgdmjqwftvncz"))
        assertEquals(6, getEndOfMarkerCharacter("nppdvjthqldpwncqszvftbrmjlhg"))
        assertEquals(10, getEndOfMarkerCharacter("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"))
        assertEquals(11, getEndOfMarkerCharacter("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"))
    }

    @Test
    fun getStartOfMessageMarkerTest() {
        assertEquals(19, getStartOfMessageMarker("mjqjpqmgbljsphdztnvjfqwrcgsmlb"))
    }
}