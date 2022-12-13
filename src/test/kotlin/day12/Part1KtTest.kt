package day12

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Part1KtTest {
    private val exampleGrid = listOf(
        "Sabqponm",
        "abcryxxl",
        "accszExk",
        "acctuvwj",
        "abdefghi",
    )
    @Test
    fun getShortestPathDistance_ExampleInput_31() {
        assertEquals(31.0, getShortestPathDistance(exampleGrid))
    }
}